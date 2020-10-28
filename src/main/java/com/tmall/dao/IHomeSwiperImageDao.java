package com.tmall.dao;

import com.tmall.pojo.HomeSwiperImage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 主页轮播图类
 *
 * @Author Xlu
 * @Date 2020/10/16 19:43
 * @InterfaceName IHomeSwiperImageDao
 * @Version 11
 **/
@Repository("homeSwiperImageDao")
public interface IHomeSwiperImageDao {

    /**
     * 获取首页所有轮播图
     *
     * @param
     * @return java.util.List<com.tmall.pojo.HomeSwiperImage>
     * @Author Xlu
     * @Date 19:47 2020/10/16
     */
    List<HomeSwiperImage> getAllSwiperImages();
}
