package com.tmall.controller;

import com.tmall.pojo.Admin;
import com.tmall.pojo.Page;
import com.tmall.pojo.Produce;
import com.tmall.service.IAdminService;
import com.tmall.service.IProduceService;
import com.tmall.utils.JsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * 由于后台管理功能比较薄弱，代码量较少
 * 所以将所有后端操作的方法，都放到这个管理类里面,没有系分开
 *
 * @ClassName: ManagerController
 * @Author: Xlu
 * @Date: 2020/12/12 16:57
 * @Version 11
 **/
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Resource(name = "adminService")
    IAdminService adminService;

    @Resource(name = "produceService")
    IProduceService produceService;

    @RequestMapping("/login")
    public ModelAndView login(String username , String password , HttpSession session) {
        ModelAndView modelAndView;
        System.out.println("login req");
        Admin admin = new Admin(username , password);
        System.out.println(admin);
        Admin resultAdmin = adminService.login(admin);
        if (resultAdmin != null) {
            modelAndView = new ModelAndView("redirect:/pages/manager/manager.jsp");

            // 将管理员放进去
            session.setAttribute("admin" , admin);

            // 将商品列表放进去
            Page<Produce> page = produceService.findPageSizeAndPageNo(0 , 5);
            session.setAttribute("page" , page);

        } else {
            // 如果密码错误，就重新去登录界面
            modelAndView = new ModelAndView("redirect:/pages/login/login.jsp");
        }

        return modelAndView;
    }

    /**
     * 添加商品的图片
     * 返回：
     * fileName - 随机生成的图片名称
     * code - 状态码 0 :成功
     * message - 成功
     *
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Xlu
     * @Date 11:26 2020/12/14
     */
    @RequestMapping(path = "/addProduceImage", method = RequestMethod.POST)
    @ResponseBody
    public String addProduce(HttpSession session , HttpServletRequest request , @Param("file") MultipartFile file) throws IOException {
        String name = request.getParameter("name");
        System.out.println(name);
        System.out.println("SpringMVC方式的文件上传...");
        // 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/static/img");
        // 创建File对象，一会向该路径下上传文件
        File myFile = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if (!myFile.exists()) {
            myFile.mkdirs();
        }
        // 获取到上传文件的名称
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-" , "").toUpperCase();
        // 把文件的名称唯一化
        filename = uuid + "_" + filename;
        // 上传文件
        file.transferTo(new File(myFile , filename));


        HashMap<Object, Object> map = new HashMap<>();
        map.put("fileName" , filename);
        map.put("message" , "success");
        map.put("code" , 0);

        return JsonUtil.getJsonStr(map);
    }

    /**
     * 添加商品详细信息，也就是添加视频
     *
     * @param session  会话对象，将增加后的商品放到session里面
     * @param title    商品的标题
     * @param detail   商品的详细
     * @param price    价格
     * @param stock    库存
     * @param fileName 文件的名称
     * @return java.lang.String
     * @Author Xlu
     * @Date 20:01 2020/12/14
     */
    @RequestMapping("/addProduceDetail")
    public String addProduceDetail(HttpSession session , String title , String detail , Double price , Long stock ,
                                   String fileName) {

        Produce produce = new Produce();
        produce.setTitle(title);
        produce.setStock(stock);
        produce.setPrice(price);
        produce.setDetail(detail);

        System.out.println("fileName" + fileName);

        System.out.println(fileName);
        produce.setImg("/tmall/static/img/" + fileName);

        // 
        produceService.add(produce);

        // 将商品列表放进去
        Page<Produce> page = produceService.findPageSizeAndPageNo(0 , 5);
        session.setAttribute("page" , page);

        return "redirect:/pages/manager/goodsManage/goods_list.jsp";
    }

    /**
     * 选择页面，分页中的跳转
     *
     * @param pageNo
     * @param pageSize
     * @param session
     * @return java.lang.String
     * @Author Xlu
     * @Date 16:00 2020/12/15
     */
    @RequestMapping("/selectPage")
    public String selectPage(int pageNo , int pageSize , HttpSession session) {
        // 将商品列表放进去
        Page<Produce> page = produceService.findPageSizeAndPageNo(pageNo , pageSize);
        session.setAttribute("page" , page);

        return "redirect:/pages/manager/goodsManage/goods_list.jsp";
    }


    /**
     * 选择商品的id，这里跳转到修改页面
     *
     * @param produceId
     * @param session
     * @param req
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:59 2020/12/15
     */
    @RequestMapping("/selectProduceById")
    public String selectProduceById(Integer produceId , HttpSession session , HttpServletRequest req) {
        Produce produce = produceService.findProduceById(produceId);

        produce.setImg("http://" + req.getServerName() + ":8080" + produce.getImg());
        session.setAttribute("produce" , produce);

        return "redirect:/pages/manager/goodsManage/goods_update.jsp";
    }

    /**
     * 更改商品信息的跳转
     *
     * @param produce
     * @param session
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:59 2020/12/15
     */
    @RequestMapping("/updateProduce")
    public String updateProduce(Produce produce , HttpSession session) {
        produceService.update(produce);

        Page<Produce> page = produceService.findPageSizeAndPageNo(0 , 5);
        session.setAttribute("page" , page);

        return "redirect:/pages/manager/goodsManage/goods_list.jsp";
    }

    /**
     * 关闭修改的跳转
     *
     * @param session
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:59 2020/12/15
     */
    @RequestMapping("/cancelUpdateProduce")
    public String cancelUpdateProduce(HttpSession session) {
        Page<Produce> page = produceService.findPageSizeAndPageNo(0 , 5);
        session.setAttribute("page" , page);

        return "redirect:/pages/manager/goodsManage/goods_list.jsp";
    }

    /**
     * 根据id删除商品
     *
     * @param session 会话
     * @param id      商品id
     * @return java.lang.String
     * @Author Xlu
     * @Date 19:23 2020/12/15
     */
    @RequestMapping("/deleteProduce")
    public String deleteProduce(HttpSession session , Integer id,Integer pageNo) {

        produceService.deleteById(id);

        Page<Produce> page = produceService.findPageSizeAndPageNo(0 , 5);
        session.setAttribute("page" , page);

        return "redirect:/pages/manager/goodsManage/goods_list.jsp";
    }

}
