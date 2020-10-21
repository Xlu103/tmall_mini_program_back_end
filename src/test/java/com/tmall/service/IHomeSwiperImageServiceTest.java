package com.tmall.service;

import com.tmall.pojo.HomeSwiperImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IHomeSwiperImageServiceTest {
    @Resource(name = "homeSwiperImageService")
    IHomeSwiperImageService swiperImageService;
    @Test
    public void getAllImages() {
        List<HomeSwiperImage> images = swiperImageService.getAllImages();
        for (HomeSwiperImage image : images) {
            System.out.println(image);
        }
    }
}