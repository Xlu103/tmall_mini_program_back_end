package com.tmall.dao;

import com.tmall.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单Dao层
 *
 * @Author Xlu
 * @Date 2020/12/11 22:55
 * @InterfaceName IOrderDao
 * @Version 11
 **/
@Repository("orderDao")
public interface IOrderDao {


    /**
     *
     * 根据用户查询所有订单
     * @Author Xlu
     * @Date 23:10 2020/12/11
     * @param userId
     * @return java.util.List<com.tmall.pojo.Order>
    */
    List<Order> selectListByUserId(Integer userId);

    /**
     * 根据订单id删除订单
     *
     * @param orderId
     * @return int
     * @Author Xlu
     * @Date 18:11 2020/12/11
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 新增订单
     *
     * @param order 订单项
     * @return int
     * @Author Xlu
     * @Date 18:12 2020/12/11
     */
    int insert(Order order);


    /**
     * 根据订单id查询订单
     *
     * @param orderId 订单id
     * @return com.tmall.pojo.Order
     * @Author Xlu
     * @Date 18:12 2020/12/11
     */
    Order selectByPrimaryKey(String orderId);

    /**
     * 更改订单,这里主要是更改订单的状态
     * 订单状态
     * 0 ：未付款
     * 1 : 未发货
     * 2 : 未签收
     * 3 : 未评价
     *
     * @param order 订单
     * @return int
     * @Author Xlu
     * @Date 18:12 2020/12/11
     */
    int updateByPrimaryKey(Order order);
/**
 *
 * 根据订单的状态查询订单列表
 * @Author Xlu
 * @Date 16:39 2020/12/12
 * @param  status 订单状态
 * @param userId 用户id
 * @return java.util.List<com.tmall.pojo.Order>
*/
    List<Order> selectListByStatus(@Param("status") Integer status, @Param("userId") Integer userId);
}