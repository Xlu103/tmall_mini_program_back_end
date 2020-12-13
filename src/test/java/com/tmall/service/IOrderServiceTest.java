package com.tmall.service;

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
public class IOrderServiceTest {

    @Resource(name = "orderService")
    IOrderService orderService;

    @Test
    public void findListByUserId() {
        List<Order> orders = orderService.findListByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void findById() {
        Order order = orderService.findById(1 + "");
        System.out.println(order);
    }

    @Test
    public void add() {
        Order order = new Order();
        order.setPrice(0.0);
        order.setUserId(1);
        orderService.add(order);
    }

    @Test
    public void deleteById() {
        orderService.deleteById(2+"");
    }

    @Test
    public void update() {
        Order order = new Order();
        order.setOrderId("2");
        order.setCreateTime(new Date(System.currentTimeMillis()));
        order.setPrice(0.0);
        order.setUserId(1);
        order.setStatus(2);
        orderService.update(order);
    }
}