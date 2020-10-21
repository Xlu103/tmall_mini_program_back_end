package com.tmall.service;

import com.tmall.pojo.HomeChunkData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IHomeChunkDataServiceTest {
    @Resource(name = "homeChunkDataService")
    IHomeChunkDataService dataService;

    @Test
    public void getAllChunkData() {
        List<HomeChunkData> allData = dataService.getAllChunkData();
        for (HomeChunkData datum : allData) {
            System.out.println(datum);
        }
    }
}