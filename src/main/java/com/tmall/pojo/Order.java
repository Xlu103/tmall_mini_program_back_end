package com.tmall.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 订单模型
 *
 * @Author Xlu
 * @Date 2020/12/11 18:14
 * @ClassName Order
 * @Version 11
 **/
public class Order implements Serializable {
    /**
     * 订单号，这里使用了事件戳和每个用户的盐值作为订单号
     */
    private String orderId;

    /**
     * 用户id
     */
    private Integer userId;

    private Date createTime;

    /**
     * 订单状态  0:未发货
     */
    private Integer status = 0;

    /**
     * 订单价格
     */
    private Double price;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * 订单项
     */
    private List<OrderItem> orderItems;

    @Override
    public String toString() {
        return "Order{" + "order_id='" + getOrderId() + '\'' + ", user_id=" + userId + ", create_time=" + getCreateTimeStr() + ", "
                + "status" + "=" + status + ", price=" + price + '}';
    }

    public String getOrderId() {
        if (orderId == null) {
            orderId = String.valueOf(System.currentTimeMillis() + userId);
        }
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        if (createTime == null) {
            createTime = new Date(System.currentTimeMillis());
        }
        return createTime;
    }


    public String getCreateTimeStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(getCreateTime());
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}