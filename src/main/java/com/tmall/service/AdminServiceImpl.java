package com.tmall.service;

import com.tmall.dao.IAdminDao;
import com.tmall.pojo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: AdminServiceImpl
 * @Author: Xlu
 * @Date: 2020/12/13 22:23
 * @Version 11
 **/
@Service("adminService")
public class AdminServiceImpl implements IAdminService {
    @Resource(name = "adminDao")
    IAdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        return adminDao.selectByUsernameAndPassword(admin);
    }
}
