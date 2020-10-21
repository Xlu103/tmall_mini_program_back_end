package com.tmall.controller;

import com.tmall.pojo.User;
import com.tmall.service.IUserService;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

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
        return JsonUtil.getJson(user);
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
        return JsonUtil.getJson(map);
    }


}



































































































































































































































































































































