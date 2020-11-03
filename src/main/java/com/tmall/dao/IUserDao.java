package com.tmall.dao;

import com.tmall.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao层接口
 *
 * @Author Xlu
 * @Date 2020/9/24 10:11
 * @InterfaceName IUserDao
 * @Version 11
 **/
@Repository("userDao")
public interface IUserDao {
    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return com.tmall.pojo.User 返回一个用户实例
     * @Author Xlu
     * @Date 23:26 2020/9/26
     */
    User findUserById(@Param("userId") int userId);

    /**
     * 根据用户id删除用户
     *
     * @param userId 用户id
     * @return int
     * @Author Xlu
     * @Date 20:59 2020/10/11
     */
    int deleteUserById(@Param("usedId") int userId);

    /**
     * 添加用户
     *
     * @param user 用户实例
     * @return int
     * @Author Xlu
     * @Date 21:12 2020/10/11
     */
    int addUser(User user);

    /**
     * 更改用户信息
     *
     * @param user 用户实例
     * @return int
     * @Author Xlu
     * @Date 21:00 2020/10/11
     */
    int updateUser(User user);

    /**
     * 查询所有用户
     *
     * @return java.util.List<com.tmall.pojo.User> 返回一个用户实例列表
     * @Author Xlu
     * @Date 21:04 2020/10/11
     */
    List<User> finAllUsers();

    /**
     * 根据用户名和密码查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return com.tmall.pojo.User
     * @Author Xlu
     * @Date 14:17 2020/10/13
     */
    User findUserByNameAndPassword(@Param("username") String username , @Param("password") String password);

    /**
     * 查询用户名称是否存在数据库
     *
     * @param username 用户名称
     * @return int 返回符合该用户名称的条数
     * @Author Xlu
     * @Date 14:33 2020/10/13
     */
    int findUserByName(@Param("username") String username);

    /**
     * 根据微信id查询用户
     *
     * @param wxId 微信id
     * @return com.tmall.pojo.User
     * @Author Xlu
     * @Date 11:16 2020/10/30
     */
    User findUserByWxId(@Param("wxId") String wxId);

}
