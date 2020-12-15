package com.tmall.service;

import com.tmall.pojo.Admin;

/**
 * 管理员服务类
 *
 * @Author Xlu
 * @Date 2020/12/13 22:22
 * @ClassName IAdminService
 * @Version 11
 **/
public interface IAdminService {
    /**
     * 管理员登录方法
     *
     * @param admin 管理员
     * @return com.tmall.pojo.Admin
     * @Author Xlu
     * @Date 22:22 2020/12/13
     */
    public Admin login(Admin admin);
}
