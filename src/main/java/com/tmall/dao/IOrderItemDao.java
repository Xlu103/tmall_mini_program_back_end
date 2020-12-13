package com.tmall.dao;

import com.tmall.pojo.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单项dao接口
 *
 * @Author Xlu
 * @Date 2020/12/12 10:01
 * @InterfaceName IOrderItemDao
 * @Version 11
 **/
@Repository("orderItemDao")
public interface IOrderItemDao {
    /**
     * 根据id删除记录
     *
     * @param id id
     * @return int
     * @Author Xlu
     * @Date 10:02 2020/12/12
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据订单id删除订单项，
     * 这里是在删除订单的时候，顺带把他们都删除
     *
     * @param orderId 订单id
     * @return int
     * @Author Xlu
     * @Date 10:26 2020/12/12
     */
    int deleteAllByOrderId(String orderId);

    /**
     * 添加订单项
     *
     * @param orderItem 订单项
     * @return int
     * @Author Xlu
     * @Date 10:02 2020/12/12
     */
    int insert(OrderItem orderItem);

    /**
     * 根据订单项id查询订单项
     *
     * @param id 订单项
     * @return com.tmall.pojo.OrderItem
     * @Author Xlu
     * @Date 10:03 2020/12/12
     */
    OrderItem selectByPrimaryKey(Integer id);

    /**
     * 更改订单项，这里一般用不着
     *
     * @param record 订单项
     * @return int
     * @Author Xlu
     * @Date 10:03 2020/12/12
     */
    int updateByPrimaryKey(OrderItem record);

    /**
     * 根据订单id查询该订单的所有订单项
     *
     * @param orderId 订单id
     * @return java.util.List<com.tmall.pojo.OrderItem>
     * @Author Xlu
     * @Date 10:08 2020/12/12
     */
    List<OrderItem> selectAllByOrderId(String orderId);
}