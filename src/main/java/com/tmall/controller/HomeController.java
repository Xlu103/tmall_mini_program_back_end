package com.tmall.controller;

import com.tmall.pojo.HomeChunkData;
import com.tmall.pojo.HomeSwiperImage;
import com.tmall.service.IHomeChunkDataService;
import com.tmall.service.IHomeSwiperImageService;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 首页资源控制类，用于获取首页资源
 *
 * @ClassName: HomeController
 * @Author: Xlu
 * @Date: 2020/9/30 19:01
 * @Version 11
 **/
@Controller
@ResponseBody
@RequestMapping("/home")
public class HomeController {
    @Resource(name = "homeSwiperImageService")
    IHomeSwiperImageService swiperImageService;

    @Resource(name = "homeChunkDataService")
    IHomeChunkDataService chunkDataService;

    /**
     * 获取首页轮播图的数据，也就是图片链接
     *
     * @return java.lang.String
     * @Author Xlu
     * @Date 19:03 2020/9/30
     */
    @RequestMapping("/swiper/img")
    public String getSwiperData(HttpServletRequest req) {
        String serverName = req.getServerName();
        ArrayList<HomeSwiperImage> imageList = new ArrayList<>();
        List<HomeSwiperImage> allImages = swiperImageService.getAllImages();
        // 遍历结果，加上需要的头，添加到列表中
        for (HomeSwiperImage image : allImages) {
            image.setSrc("http://" + serverName + ":8080" + image.getSrc());
            imageList.add(image);
        }
        return JsonUtil.getJsonStr(imageList);
    }

    /**
     * 获取首页中块的数据
     *
     * @param req 用来获取服务器名称
     * @return java.lang.String
     * @Author Xlu
     * @Date 17:09 2020/10/14
     */
    @RequestMapping("/chunk/data")
    public String getChunkData(HttpServletRequest req) {
        // 服务器链接
        String serverName = req.getServerName();
        ArrayList<HomeChunkData> list = new ArrayList<>();
        List<HomeChunkData> allChunkData = chunkDataService.getAllChunkData();
        for (HomeChunkData datum : allChunkData) {
            datum.setImgSrc("http://" + serverName + ":8080" + datum.getImgSrc());
            list.add(datum);
        }
        return JsonUtil.getJsonStr(list);
    }

    @RequestMapping("/video")
    public String getVideo(HttpServletRequest req) {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>();
        HashMap<String, String> map4 = new HashMap<>();

        map1.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/1.mp4");
        map1.put("name" , "野牛历史");

        map2.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/2.mp4");
        map2.put("name" , "有些狼性只有狗才向往，我们要当人，不要做畜生");

        map3.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/3.mp4");
        map3.put("name" , "罗翔说刑法：抓别人鸭子肯定是盗窃行为，那么是否构成犯罪？");

        map4.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/4.mp4");
        map4.put("name" , "超简单！两分钟学会知乎「图文转视频」工具");

        ArrayList list = new ArrayList<HashMap>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        return JsonUtil.getJsonStr(list);
    }


    @ResponseBody
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request , @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        System.out.println("执行图片上传");
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        System.out.println("title:" + title);
        System.out.println("price:" + price);
        if (!file.isEmpty()) {
            System.out.println("成功获取照片");
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1 , fileName.length()) : null;
            System.out.println("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = "G:" + "/uploads/" + trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                } else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            } else {
                System.out.println("文件类型为空");
                return "error";
            }
        } else {
            System.out.println("没有找到相对应的文件");
            return "error";
        }
        return "success";
    }
}
