package com.tmall.controller;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;
import com.tmall.pojo.StaticConst;
import com.tmall.service.IOrderItemService;
import com.tmall.service.IOrderService;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 订单控制类
 * 主要方法：
 * 添加订单：新增订单的时候添加订单项。
 * 删除订单：删除订单的时候随便将改订单内的所有订单项删除。
 * 更改订单：更改订单状态
 * 0：待付款，1：待发货，2：待签收，3：待评价
 *
 * @ClassName: OrderController
 * @Author: Xlu
 * @Date: 2020/12/12 10:45
 * @Version 11
 **/
@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    IOrderService orderService;

    @Resource(name = "orderItemService")
    IOrderItemService orderItemService;

    /**
     * 新增订单
     *
     * @param order 自动封装为订单模型
     * @return java.lang.String
     * @Author Xlu
     * @Date 10:57 2020/12/12
     */
    @RequestMapping("/addOrder")
    public String addOrder(Order order) {
        HashMap<String, Object> map = new HashMap<>();
        if (order.getUserId() == null || order.getPrice() == null) {
            // 如果参数不对，就返回一个参数错误的信息
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }

        orderService.add(order);
        map.put("message" , "success");
        map.put("order" , order);
        return JsonUtil.getJsonStr(map);

    }

    /**
     * 添加订单项
     *
     * @param orderItem 封装为订单项模型
     * @return java.lang.String
     * @Author Xlu
     * @Date 11:08 2020/12/12
     */
    @RequestMapping("/addOrderItem")
    public String addOrderItem(OrderItem orderItem) {
        //Integer count , String orderId , Double price , Integer produceId , String imgPath

        HashMap<String, Object> map = new HashMap<>();
        if (orderItem.getCount() == null || orderItem.getOrderId() == null || orderItem.getPrice() == null || orderItem.getProduceId() == null || orderItem.getImgPath() == null) {
            // 如果参数不对，就返回一个参数错误的信息
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        orderItemService.add(orderItem);
        map.put("message" , "success");
        map.put("orderItem" , orderItem);
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 根据订单id删除订单
     *
     * @param orderId 订单id
     * @return java.lang.String
     * @Author Xlu
     * @Date 14:26 2020/12/12
     */
    @RequestMapping("/delete")
    public String deleteOrder(String orderId) {
        HashMap<String, Object> map = new HashMap<>();
        if (orderId == null) {
            // 如果参数不对，就返回一个参数错误的信息
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }

        orderService.deleteById(orderId);
        map.put("message" , "success");
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 修改订单，主要是修改状态
     * 需要参数：
     * 订单号、状态
     *
     * @param order 订单
     * @return java.lang.String
     * @Author Xlu
     * @Date 14:28 2020/12/12
     */
    @RequestMapping("/update")
    public String updateOrder(Order order) {
        HashMap<String, Object> map = new HashMap<>();
        if (order.getOrderId() == null || order.getStatus() == null) {

            // 如果参数不对，就返回一个参数错误的信息
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }

        orderService.update(order);
        map.put("message" , "success");
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 根据用户id查询用户的所有订单
     *
     * @param userId 用户id
     * @return java.lang.String
     * @Author Xlu
     * @Date 14:52 2020/12/12
     */
    @RequestMapping("/find")
    public String findOrder(Integer userId) {
        HashMap<String, Object> map = new HashMap<>();
        if (userId == null) {

            // 如果参数不对，就返回一个参数错误的信息
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }

        List<Order> orders = orderService.findListByUserId(userId);
        map.put("message" , "success");
        map.put("orders" , orders);

        return JsonUtil.getJsonStr(map);
    }

}
