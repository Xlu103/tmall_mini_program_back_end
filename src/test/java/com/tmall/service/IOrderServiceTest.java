package com.tmall.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IOrderServiceTest {

    @Resource(name = "orderService")
    IOrderService orderService;

    @Test
    public void findListByUserId() {

    }

    @Test
    public void findById() {
    }

    @Test
    public void add() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
    }
}