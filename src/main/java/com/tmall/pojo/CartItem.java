package com.tmall.pojo;

import java.io.Serializable;

/**
 * 购物车项的实体类
 *
 * @Author Xlu
 * @Date 2020/12/6 14:55
 * @ClassName CartItem
 * @Version 11
 **/
public class CartItem implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer produceId;

    private Integer count;

    private static final long serialVersionUID = 1L;

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" + "id=" + id + ", userId=" + userId + ", produceId=" + produceId + ", count=" + count + '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProduceId() {
        return produceId;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CartItem(Integer id , Integer userId , Integer produceId , Integer count) {
        this.id = id;
        this.userId = userId;
        this.produceId = produceId;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}