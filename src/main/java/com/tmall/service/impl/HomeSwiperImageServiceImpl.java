package com.tmall.service.impl;

import com.tmall.dao.IHomeSwiperImageDao;
import com.tmall.pojo.HomeSwiperImage;
import com.tmall.service.IHomeSwiperImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: HomeSwiperImageServiceImpl
 * @Author: Xlu
 * @Date: 2020/10/16 19:56
 * @Version 11
 **/
@Service("homeSwiperImageService")
public class HomeSwiperImageServiceImpl implements IHomeSwiperImageService {
    @Resource(name = "homeSwiperImageDao")
    IHomeSwiperImageDao swiperImageDao;

    @Override
    public List<HomeSwiperImage> getAllImages() {
        return swiperImageDao.getAllSwiperImages();
    }
}
