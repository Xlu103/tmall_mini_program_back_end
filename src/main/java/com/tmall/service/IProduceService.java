package com.tmall.service;

import com.tmall.pojo.Produce;

import java.util.List;

/**
 * 商品Service接口
 *
 * @Author Xlu
 * @Date 2020/10/28 17:08
 * @InterfaceName IProduceService
 * @Version 11
 **/
public interface IProduceService {
    /**
     * 获取所有图片
     *
     * @return java.util.List<com.tmall.pojo.Produce> 商品结果集
     * @Author Xlu
     * @Date 17:18 2020/10/28
     */
    List<Produce> findAllProduce();

    /**
     * 根据商品类别id查询图片
     *
     * @param catId 商品类别id
     * @return java.util.List<com.tmall.pojo.Produce> 商品结果集
     * @Author Xlu
     * @Date 17:19 2020/10/28
     */
    List<Produce> findProduceByCatId(int catId);
}
