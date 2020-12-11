package com.tmall.dao;

import com.tmall.pojo.CartItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ICartItemDaoTest {

    @Autowired
    ICartItemDao cartItemDao;

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
        CartItem item = new CartItem();
        item.setUserId(1);
        item.setProduceId(2);
        item.setCount(10);
        cartItemDao.insert(item);
        System.out.println(item);
    }

    @Test
    public void selectByPrimaryKey() {
        CartItem cartItem = cartItemDao.selectByPrimaryKey(1);
        System.out.println(cartItem);
    }

    @Test
    public void updateByPrimaryKey() {
        CartItem item = new CartItem();
        item.setId(1);
        item.setUserId(1);
        item.setProduceId(10);
        item.setCount(10);
        cartItemDao.updateByPrimaryKey(item);
    }

    @Test
    public void deleteAllCartItemsByUserId() {
        cartItemDao.deleteAllCartItemsByUserId(1);
    }

    @Test
    public void selectCartItemsByUserId() {
        List<CartItem> cartItems = cartItemDao.selectCartItemsByUserId(1);
        for (CartItem item : cartItems) {
            System.out.println(item);
        }
    }

    @Test
    public void selectCartByUserIdAndProduceId() {
        CartItem cartItem = cartItemDao.selectCartByUserIdAndProduceId(1 , 1);
        System.out.println(cartItem);
    }
}