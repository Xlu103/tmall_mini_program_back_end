package com.tmall.pojo;

import java.io.Serializable;

/**
 * t_admin
 *
 * @author
 */

public class Admin implements Serializable {
    /**
     * 没有意义的自增id
     */
    private Integer id;

    /**
     * 管理员名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private static final long serialVersionUID = 1L;

    public Admin(String username , String password) {
        this.username = username;
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }

    public Admin() {
    }

    public Admin(Integer id , String username , String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}