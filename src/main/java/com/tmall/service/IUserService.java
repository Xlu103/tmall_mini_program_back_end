package com.tmall.service;

import com.tmall.pojo.User;

import java.util.List;

/**
 * @Author Xlu
 * @Date 2020/9/26 23:33
 * @InterfaceName IUserService
 * @Version 11
 **/
public interface IUserService {
    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return com.tmall.pojo.User 结果用户实例
     * @Author Xlu
     * @Date 23:35 2020/9/26
     */
    User findUserById(int userId);

    /**
     * 查询所有用户
     *
     * @return com.tmall.pojo.User 所有用户的列表
     * @Author Xlu
     * @Date 14:02 2020/10/13
     */
    List<User> findAllUser();

    /**
     * 添加用户
     *
     * @param user 用户实例
     * @return int 返回最新的id
     * @Author Xlu
     * @Date 14:03 2020/10/13
     */
    int addUsers(User user);

    /**
     * 根据用户id删除用户
     *
     * @param userId 用户id
     * @Author Xlu
     * @Date 14:04 2020/10/13
     */
    void deleteUserById(int userId);

    /**
     * 更改用户信息
     *
     * @param user 用户实例
     * @Author Xlu
     * @Date 14:05 2020/10/13
     */
    void updateUser(User user);

    /**
     * 根据用户名称查看用户名称是否可用
     *
     * @param username 用户名称
     * @return Boolean 是否存在 存在为true 不存在为false
     * @Author Xlu
     * @Date 14:36 2020/10/13
     */
    Boolean findUserByName(String username);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return com.tmall.pojo.User
     * @Author Xlu
     * @Date 14:44 2020/10/13
     */
    User findUserByNameAndPassword(String username , String password);

    /**
     * 根据微信id查询用户
     *
     * @param openId 微信id
     * @return com.tmall.pojo.User
     * @Author Xlu
     * @Date 14:17 2020/12/8
     */
    User findUserByOpenId(String openId);

}
