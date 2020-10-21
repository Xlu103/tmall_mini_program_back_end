package com.tmall.dao;

import com.tmall.pojo.HomeChunkData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IHomeChunkDataDaoTest {

    @Resource(name = "homeChunkDataDao")
    IHomeChunkDataDao chunkDataDao;

    @Test
    public void getHomeChunkAllData() {
        List<HomeChunkData> chunkAllData = chunkDataDao.getHomeChunkAllData();
        for (HomeChunkData datum : chunkAllData) {
            System.out.println(datum);
        }
    }
}