package com.tmall.dao;

import com.tmall.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IUserDaoTest {

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Test
    public void findUserById() {
        User user = userDao.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(2);
    }

    @Test
    public void updateUser() {


        // 使用动态加密盐的只需要在注册用户的时候将第二个参数换成用户名即可
        User user = new User(-1 , "张三" , "admin" , "123456789" , "zhangsan@11.com");
        userDao.updateUser(user);

    }

    @Test
    public void addUser() {
        //User user = new User(-1 , "张三" , "admin" , "123456789" , "zhangsan@11.com");
        // 通过wxId来注册
        User user = new User("test_wx_id");
        userDao.addUser(user);
    }

    @Test
    public void finAllUsers() {
        List<User> users = userDao.finAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByNameAndPassword() {
        User user = userDao.findUserByNameAndPassword("admin" , "admin");
        System.out.println(user);
    }

    @Test
    public void findUserByNameTest() {
        int i = userDao.findUserByName("admin");
        System.out.println(i);
    }

    @Test
    public void findUserByWxIdTest() {
        User user = userDao.findUserByWxId("zhangsan1");
        System.out.println(user);
    }


}