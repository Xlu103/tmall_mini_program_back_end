package com.tmall.service;

import com.tmall.pojo.Order;

import java.util.List;

/**
 * 订单的服务类
 * 主要方法：
 * 查询订单，添加订单，删除订单，修改订单（修改订单状态）
 *
 * @Author Xlu
 * @Date 2020/12/11 23:09
 * @ClassName IOrderService
 * @Version 11
 **/
public interface IOrderService {


    /**
     * 根据用户id查询该用户的订单
     *
     * @param userId 用户id
     * @return java.util.List<com.tmall.pojo.Order>
     * @Author Xlu
     * @Date 23:39 2020/12/11
     */
    List<Order> findListByUserId(Integer userId);

    /**
     * 根据订单id查询订单，这个正常是用不到的
     *
     * @param orderId 订单id
     * @return com.tmall.pojo.Order
     * @Author Xlu
     * @Date 23:40 2020/12/11
     */
    Order findById(String orderId);

    /**
     * 添加订单
     *
     * @param order 订单
     * @return int
     * @Author Xlu
     * @Date 23:40 2020/12/11
     */
    int add(Order order);

    /**
     * 根据订单id删除大地你
     *
     * @param orderId 订单id
     * @return int
     * @Author Xlu
     * @Date 23:41 2020/12/11
     */
    int deleteById(String orderId);

    /**
     * 更改订单，主要是更改订单的状态
     * 这里是根据订单的id来查询订单，然后修改状态
     *
     * @param order 订单
     * @return int
     * @Author Xlu
     * @Date 23:42 2020/12/11
     */
    int update(Order order);
}
