package com.tmall.service;

import com.tmall.pojo.HomeChunkData;

import java.util.List;

/**
 * 获取首页块数据
 *
 * @Author Xlu
 * @Date 2020/10/16 19:51
 * @Interface IHomeChunkDataService
 * @Version 11
 **/
public interface IHomeChunkDataService {
    /**
     * 获取首页块数据
     *
     * @param
     * @return java.util.List<com.tmall.pojo.HomeChunkData>
     * @Author Xlu
     * @Date 19:52 2020/10/16
     */
    List<HomeChunkData> getAllChunkData();

}
