package com.tmall.dao;

import com.tmall.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IOrderDaoTest {

    @Resource(name = "orderDao")
    IOrderDao orderDao;

    @Test
    public void selectListByUserId() {
        List<Order> orders = orderDao.selectListByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void deleteByPrimaryKey() {
        orderDao.deleteByPrimaryKey(2+"");
    }

    @Test
    public void insert() {
        Order order = new Order();
        order.setOrderId("2");
        order.setCreateTime(new Date(System.currentTimeMillis()));
        order.setPrice(0.0);
        order.setUserId(1);
        orderDao.insert(order);

    }

    @Test
    public void selectByPrimaryKey() {
        Order order = orderDao.selectByPrimaryKey(2+"");
        System.out.println(order);
    }

    @Test
    public void updateByPrimaryKey() {
        Order order = new Order();
        order.setOrderId("2");
        order.setCreateTime(new Date(System.currentTimeMillis()));
        order.setPrice(0.0);
        order.setUserId(1);
        order.setStatus(2);
        orderDao.updateByPrimaryKey(order);
    }
}