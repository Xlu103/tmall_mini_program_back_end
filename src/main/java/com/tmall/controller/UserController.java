package com.tmall.controller;

import com.tmall.pojo.StaticConst;
import com.tmall.pojo.User;
import com.tmall.service.IUserService;
import com.tmall.utils.HttpUtil;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制层类
 *
 * @ClassName: UserController
 * @Author: Xlu
 * @Date: 2020/9/26 23:50
 * @Version 11
 **/
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;

    /**
     * 根据用户id查询用户
     *
     * @param id 用户id
     * @return java.lang.String
     * @Author Xlu
     * @Date 16:34 2020/10/13
     */
    @RequestMapping("/findUser")
    public String findUserById(int id) {
        User user = userService.findUserById(id);
        return JsonUtil.getJsonStr(user);
    }

    /**
     * 判断用户名称是否可用
     *
     * @param name 名称
     * @return java.lang.String
     * @Author Xlu
     * @Date 16:35 2020/10/13
     */
    @RequestMapping("/existName")
    public String existName(String name) {
        Boolean result = userService.findUserByName(name);
        HashMap<String, Boolean> map = new HashMap<>();

        map.put("result" , result);
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 通过微信openid和微信名注册用户
     *
     * @param username 微信名
     * @param openid   微信中的openid
     * @return java.lang.String
     * @Author Xlu
     * @Date 16:50 2020/10/24
     */
    @RequestMapping(value = "/addWxUser",method = RequestMethod.POST)
    public String addWxUser(String username , String openid) {
        Map map = new HashMap(1);
        try {
            if ("".equals(username) || "".equals(openid)) {
                throw new Exception("注册微信用户需要用户名和用户openid");
            }
            userService.addUsers(new User(username , openid));
            map.put("message" , "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message" , "success");

        }

        return JsonUtil.getJsonStr(map);
    }

    @RequestMapping("/getOpenId")
    public String getOpenId(String code) {

        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            Map map = new HashMap(2);
            map.put("status" , 0);
            map.put("message" , "code 不能为空");
            return JsonUtil.getJsonStr(map);
        }


        String wxspAppid = StaticConst.WX_APPID;

        String wxspSecret = StaticConst.WX_SECRET;

        String grant_type = StaticConst.GRANT_TYPE;

        //1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpUtil.sendGet("https://api.weixin.qq.com/sns/jscode2session" , params);

        System.out.println(sr);
        return sr;
    }


}



































































































































































































































































































































