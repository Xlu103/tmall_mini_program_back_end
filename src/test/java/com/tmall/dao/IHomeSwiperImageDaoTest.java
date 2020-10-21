package com.tmall.dao;

import com.tmall.pojo.HomeSwiperImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IHomeSwiperImageDaoTest {

    @Resource(name = "homeSwiperImageDao")
    IHomeSwiperImageDao swiperImageDao;

    @Test
    public void getAllSwiperImages() {

        List<HomeSwiperImage> images = swiperImageDao.getAllSwiperImages();
        for (HomeSwiperImage image : images) {
            System.out.println(image);
        }
    }
}