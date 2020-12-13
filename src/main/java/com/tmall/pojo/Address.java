package com.tmall.pojo;

import java.io.Serializable;

/**
 * 用户地址表模型
 *
 * @Author Xlu
 * @Date 2020/12/13 15:53
 * @ClassName Address
 * @Version 11
 **/
public class Address implements Serializable {
    /**
     * 没有意义的自增id
     */
    private Integer id;

    /**
     * 归属于哪个用户
     */
    private Integer userId;

    /**
     * 省份
     */
    private String address;

    /**
     * 是否为默认地址
     */
    private Boolean isDefault;

    /**
     * 收获人姓名
     */
    private String name;

    /**
     * 街道
     */
    private String street;

    /**
     * 移动号码
     */
    private String mobile;

    private static final long serialVersionUID = 1L;

    public Address() {
    }

    public Address(Integer id , Integer userId , String address , Boolean isDefault , String name , String street ,
                   String mobile) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.isDefault = isDefault;
        this.name = name;
        this.street = street;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", userId=" + userId + ", address='" + address + '\'' + ", isDefault=" + isDefault +
                ", name='" + name + '\'' + ", street='" + street + '\'' + ", mobile='" + mobile + '\'' + '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDefault() {
        if (isDefault == null) {
            isDefault = false;
        }
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}