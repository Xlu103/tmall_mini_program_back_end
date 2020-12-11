package com.tmall.service.impl;

import com.tmall.dao.IUserDao;
import com.tmall.pojo.User;
import com.tmall.service.IUserService;
import com.tmall.utils.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Author: Xlu
 * @Date: 2020/9/23 19:30
 * @Version 11
 **/
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Override
    public User findUserById(int userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.finAllUsers();
    }

    @Override
    public int addUsers(User user) {
        // 使用md5加密后的作为密码
        user.setPassword(Md5Util.getMD5(user.getPassword() , user.getUsername()));
       return  userDao.addUser(user);
    }

    @Override
    public void deleteUserById(int userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        // 使用md5加密后的做为密码
        user.setPassword(Md5Util.getMD5(user.getPassword() , user.getUsername()));
        userDao.updateUser(user);
    }

    @Override
    public Boolean findUserByName(String username) {
        int count = userDao.findUserByName(username);

        // 如果是等于0就可用
        return count == 0;
    }


    @Override
    public User findUserByNameAndPassword(String username , String password) {
        password = Md5Util.getMD5(password , username);
        return userDao.findUserByNameAndPassword(username , password);
    }

    @Override
    public User findUserByOpenId(String openId) {
        return userDao.findUserByWxId(openId);
    }
}
