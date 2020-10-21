package com.tmall.service.impl;

import com.tmall.dao.IHomeChunkDataDao;
import com.tmall.pojo.HomeChunkData;
import com.tmall.service.IHomeChunkDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: HomeChunkDataImpl
 * @Author: Xlu
 *
 * @Date: 2020/10/16 19:54
 * @Version 11
 **/
@Service("homeChunkDataService")
public class HomeChunkDataServiceImpl implements IHomeChunkDataService {
    @Resource(name = "homeChunkDataDao")
    IHomeChunkDataDao chunkDataDao;

    @Override
    public List<HomeChunkData> getAllChunkData() {
        return chunkDataDao.getHomeChunkAllData();
    }
}
