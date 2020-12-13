package com.tmall.pojo;

import java.io.Serializable;

/**
 * 订单项模型
 *
 * @Author Xlu
 * @Date 2020/12/12 10:00
 * @ClassName OrderItem
 * @Version 11
 **/
public class OrderItem implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 归属的订单id
     */
    private String orderId;

    /**
     * 该项的价格
     */
    private Double price;

    /**
     * 这个订单项有几个，就是商品有几个数量
     */
    private Integer count;

    /**
     * 这个订单项的总价格
     */
    private Double totalPrice;

    /**
     * 该项的图片
     */
    private String imgPath;

    /**
     * 该项的商品id
     */
    private Integer produceId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 商品标题
     */
    private String title;

    public OrderItem() {
    }

    public OrderItem(Integer id , String orderId , Double price , Integer count , Double totalPrice , String imgPath ,
                     Integer produceId) {
        this.id = id;
        this.orderId = orderId;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
        this.imgPath = imgPath;
        this.produceId = produceId;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", orderId='" + orderId + '\'' + ", price=" + price + ", count=" + count + ", " +
                "totalPrice=" + totalPrice + ", imgPath='" + imgPath + '\'' + ", produceId=" + produceId + ", title='" + title + '\'' + '}';
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Double getTotalPrice() {
        if (totalPrice == null) {
            totalPrice = count * price;
        }
        return totalPrice;
    }



    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getProduceId() {
        return produceId;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}