package com.tmall.service;

import com.tmall.pojo.HomeSwiperImage;

import java.util.List;

/**
 * 首页轮播图数据
 *
 * @Author Xlu
 * @Date 2020/10/16 19:53
 * @Interface IHomeSwiperImageService
 * @Version 11
 **/
public interface IHomeSwiperImageService {

    /**
     * 获取所有轮播图
     *
     * @return java.util.List<com.tmall.pojo.HomeSwiperImage>
     * @Author Xlu
     * @Date 19:53 2020/10/16
     */
    List<HomeSwiperImage> getAllImages();
}
