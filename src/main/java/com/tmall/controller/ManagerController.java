package com.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: ManagerController
 * @Author: Xlu
 * @Date: 2020/12/12 16:57
 * @Version 11
 **/
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping("/login")
    public String login(String username , String password) {
        // 如果密码正确，就去管理界面
        // 这里偷懒定死了!!!
        if ("admin".equals(username) && "admin".equals(password)) {
            return "manager/manager";

        }

        // 如果密码错误，就重新去登录界面
        return "login/login";
    }


}
