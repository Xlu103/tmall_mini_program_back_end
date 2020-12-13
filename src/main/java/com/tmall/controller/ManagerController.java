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

        return "manager/manager";
    }

}
