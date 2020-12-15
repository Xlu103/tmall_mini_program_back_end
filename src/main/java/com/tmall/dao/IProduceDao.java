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

    /**
     * 添加商品
     *
     * @param produce 商品
     * @return int
     * @Author Xlu
     * @Date 10:10 2020/12/14
     */
    int insert(Produce produce);

    /**
     * 根据每一页大小，第几页查询到当前的第几页
     *
     * @param jump     跳过多少
     * @param pageSize 每一页多长
     * @return java.util.List<com.tmall.pojo.Produce> 返回这一页的商品列表
     * @Author Xlu
     * @Date 10:12 2020-07-27
     */
    List<Produce> selectByPage(@Param("jump") int jump , @Param("pageSize") int pageSize);

    /**
     * 查询总条数
     *
     * @return int
     * @Author Xlu
     * @Date 19:19 2020/12/14
     */
    int selectTotalCount();

    /**
     * 根据商品id修改商品信息
     *
     * @param produce 商品
     * @return void
     * @Author Xlu
     * @Date 20:08 2020/12/14
     */
    void updateById(Produce produce);

    /**
     * 得到推荐的商品
     *
     * @return java.util.List<com.tmall.pojo.Produce>
     * @Author Xlu
     * @Date 16:06 2020/12/15
     */
    List<Produce> selectCommend();

    /**
     *
     * 根据商品的id删除商品
     *
     * @Author Xlu
     * @Date 19:24 2020/12/15
     * @param id
     * @return void
    */
    void deleteById(Integer id);
}
