package com.tmall.dao;

import com.tmall.pojo.HomeChunkData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 首页数据块的Dao层
 *
 * @Author Xlu
 * @Date 2020/10/16 12:49
 * @Interface IHomeChunkDataDao
 * @Version 11
 **/
@Repository("homeChunkDataDao")
public interface IHomeChunkDataDao {
    /**
     * 得到首页数据块中所有的数据
     *
     * @param
     * @return void
     * @Author Xlu
     * @Date 17:28 2020/10/16
     */
    List<HomeChunkData> getHomeChunkAllData();
}
