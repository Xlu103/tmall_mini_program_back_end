package com.tmall.dao;

import com.tmall.pojo.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IOrderItemDaoTest {

    @Resource(name = "orderItemDao")
    IOrderItemDao orderItemDao;

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
        OrderItem item = new OrderItem();
        item.setCount(2);
        item.setOrderId("1607742781052");
        item.setPrice(1.0);
        item.setTotalPrice(1.0);
        item.setProduceId(1);
        orderItemDao.insert(item);
        System.out.println(item);

    }

    @Test
    public void selectByPrimaryKey() {
        OrderItem item = orderItemDao.selectByPrimaryKey(1);
        System.out.println(item);
    }

    @Test
    public void updateByPrimaryKey() {
        OrderItem item = new OrderItem();
        item.setCount(2);
        item.setOrderId(1+"");
        item.setPrice(1.0);
        item.setTotalPrice(1.0);
        item.setProduceId(1);
        item.setId(1);
        orderItemDao.updateByPrimaryKey(item);
    }

    @Test
    public void selectAllByOrderId() {
        List<OrderItem> items = orderItemDao.selectAllByOrderId(1 + "");
        System.out.println(items);
    }

    @Test
    public void deleteAllByOrderId() {
        int i = orderItemDao.deleteAllByOrderId("1");
        System.out.println(i);
    }
}