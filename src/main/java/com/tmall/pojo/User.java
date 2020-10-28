package com.tmall.pojo;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @ClassName: User
 * @Author: Xlu
 * @Date: 2020/9/26 23:22
 * @Version 11
 **/
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String wxId;

    public User(String username , String openid) {
        this.username = username;
        this.wxId = openid;
        this.password = "";
        this.phone = "";
        this.email = "";
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' + ", wxId='" + wxId + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public User() {
    }

    public User(String wxId) {
        this.wxId = wxId;
        this.username = "";
        this.password = "";
        this.phone = "";
        this.email = "";
    }

    public User(int id , String username , String password , String phone , String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.wxId = null;
    }

    public User(int id , String username , String password , String phone , String email , String wxId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.wxId = wxId;
    }
}
