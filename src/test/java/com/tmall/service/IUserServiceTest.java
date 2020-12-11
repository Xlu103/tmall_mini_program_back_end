package com.tmall.service;

import com.tmall.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IUserServiceTest {
    @Resource(name = "userService")
    IUserService userService;

    @Test
    public void findUserById() {
        User user = userService.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findAllUser() {
        List<User> users = userService.findAllUser();
        for (User user : users) {

            System.out.println(user);
        }
    }

    @Test
    public void addUsers() {
        User user = new User(-1 , "admin" , "admin" , "123456789" , "zhangsan@11.com");
        userService.addUsers(user);
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(3);
    }

    @Test
    public void updateUser() {
        User user = new User(3 , "张三" , "11" , "123456789" , "zhangsan@11.com");
        userService.updateUser(user);
    }

    @Test
    public void findUserByNameAndPassword() {
        User user = userService.findUserByNameAndPassword("admin" , "admin");
        System.out.println(user);
    }

    @Test
    public void findUserByName() {
        Boolean result = userService.findUserByName("admin");
        System.out.println(result);
    }

    @Test
    public void testAddUsers() {
        User user = new User();
        user.setUsername("admin3");
        user.setPassword("admin3");
        user.setWxId("121212211");
        int result = userService.addUsers(user);
        System.out.println(user.getId());
    }

}