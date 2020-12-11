package com.tmall.service.impl;

import com.tmall.dao.IOrderDao;
import com.tmall.pojo.Order;
import com.tmall.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: OrderServiceImpl
 * @Author: Xlu
 * @Date: 2020/12/11 23:43
 * @Version 11
 **/
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Resource(name = "orderDao")
    IOrderDao orderDao;

    @Override
    public List<Order> findListByUserId(Integer userId) {
        return orderDao.selectListByUserId(userId);
    }

    @Override
    public Order findById(String orderId) {
        return orderDao.selectByPrimaryKey(orderId);
    }

    @Override
    public int add(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public int deleteById(String orderId) {
        return orderDao.deleteByPrimaryKey(orderId);
    }

    @Override
    public int update(Order order) {
        return orderDao.updateByPrimaryKey(order);
    }
}
