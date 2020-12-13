package com.tmall.service;

import com.tmall.pojo.OrderItem;

import java.util.List;

/**
 * 订单项服务类
 * 主要方法:
 * 查询：根据订单号查询该订单下的所有订单项。
 * 删除：根据订单号，删除所有订单项。
 * 添加:在购物车结算的时候，生成订单，添加购物车项。
 *
 * @Author Xlu
 * @Date 2020/12/12 10:28
 * @InterfaceName IOrderItemService
 * @Version 11
 **/

public interface IOrderItemService {

    /**
     * 根据订单号查询该订单下的所有订单
     *
     * @param orderId 订单号
     * @return java.util.List<com.tmall.pojo.OrderItem>
     * @Author Xlu
     * @Date 10:32 2020/12/12
     */
    List<OrderItem> findAllByOrderId(String orderId);

    /**
     * 根据订单号删除该订单下的所有订单项
     *
     * @param orderId 订单号
     * @return int
     * @Author Xlu
     * @Date 10:32 2020/12/12
     */
    int deleteByOrderId(String orderId);


    /**
     * 添加订单
     *
     * @param orderItem 订单项
     * @return int
     * @Author Xlu
     * @Date 10:33 2020/12/12
     */
    int add(OrderItem orderItem);

}
