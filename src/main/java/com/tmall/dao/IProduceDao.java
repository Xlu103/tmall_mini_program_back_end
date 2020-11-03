package com.tmall.dao;

import com.tmall.pojo.Produce;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 商品Dao接口
 *
 * @Author Xlu
 * @Date 2020/10/25 14:19
 * @InterfaceName IProduceDao
 * @Version 11
 **/
@Repository("produceDao")
public interface IProduceDao {


    /**
     * 查询所有商品
     *
     * @return java.util.List<com.tmall.pojo.Produce> 商品列表
     * @Author Xlu
     * @Date 14:26 2020/10/25
     */
    List<Produce> findAllProduce();


    /**
     * 根据商品类别查询所有商品
     *
     * @param catId 商品类别id
     * @return java.util.List<com.tmall.pojo.Produce>
     * @Author Xlu
     * @Date 14:27 2020/10/25
     */
    List<Produce> findAllProduceByCat(@Param("catId") int catId);


    /**
     * 模糊搜索商品
     *
     * @param name 商品名称
     * @return java.util.List<com.tmall.pojo.Produce>
     * @Author Xlu
     * @Date 11:06 2020/11/2
     */
    List<Produce> findProducesByName(@Param("name") String name);

    /**
     * 根据商品id查找商品
     *
     * @param id 商品id
     * @return com.tmall.pojo.Produce
     * @Author Xlu
     * @Date 15:10 2020/11/3
     */
    Produce findProduceById(@Param("id") int id);

}
