package com.tmall.service;

import com.tmall.pojo.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IOrderItemServiceTest {

    @Resource(name = "orderItemService")
    IOrderItemService orderItemService;

    @Test
    public void findAllByOrderId() {
        orderItemService.findAllByOrderId("1");
    }

    @Test
    public void deleteByOrderId() {
        orderItemService.deleteByOrderId("1");
    }

    @Test
    public void add() {
        OrderItem item = new OrderItem();
        item.setCount(2);
        item.setOrderId(1+"");
        item.setPrice(1.0);
        item.setTotalPrice(1.0);
        item.setProduceId(1);
        orderItemService.add(item);
    }
}