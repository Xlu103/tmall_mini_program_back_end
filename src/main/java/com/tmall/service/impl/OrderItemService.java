package com.tmall.service.impl;

import com.tmall.dao.IOrderItemDao;
import com.tmall.pojo.OrderItem;
import com.tmall.service.IOrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: OrderItemService
 * @Author: Xlu
 * @Date: 2020/12/12 10:35
 * @Version 11
 **/
@Service("orderItemService")
public class OrderItemService implements IOrderItemService {
    @Resource(name = "orderItemDao")
    IOrderItemDao orderItemDao;

    @Override
    public List<OrderItem> findAllByOrderId(String orderId) {
        return orderItemDao.selectAllByOrderId(orderId);
    }

    @Override
    public int deleteByOrderId(String orderId) {
        return orderItemDao.deleteAllByOrderId(orderId);
    }

    @Override
    public int add(OrderItem orderItem) {
        return orderItemDao.insert(orderItem);
    }
}
