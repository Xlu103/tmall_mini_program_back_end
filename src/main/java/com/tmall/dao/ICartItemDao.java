package com.tmall.dao;

import com.tmall.pojo.CartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物车项Dao
 *
 * @Author Xlu
 * @Date 2020/12/6 14:56
 * @InterfaceName ICartItemDao
 * @Version 11
 **/
@Repository("cartItemDao")
public interface ICartItemDao {
    /**
     * 根据id删除购物车项
     *
     * @param id id
     * @return int
     * @Author Xlu
     * @Date 14:56 2020/12/6
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入购物车项
     *
     * @param cartItem 购物车项
     * @return int
     * @Author Xlu
     * @Date 14:57 2020/12/6
     */
    int insert(CartItem cartItem);


    /**
     * 根据购物车项id 查询购物车
     *
     * @param id id
     * @return com.tmall.pojo.CartItem
     * @Author Xlu
     * @Date 14:59 2020/12/6
     */
    CartItem selectByPrimaryKey(Integer id);


    /**
     * 更新购物车项记录
     *
     * @param cartItem 购物车项
     * @return int
     * @Author Xlu
     * @Date 14:59 2020/12/6
     */
    int updateByPrimaryKey(CartItem cartItem);

    /**
     * 根据用户id清空所有购物车
     *
     * @param userId 用户id
     * @return int
     * @Author Xlu
     * @Date 14:36 2020/12/8
     */
    int deleteAllCartItemsByUserId(@Param("userId") int userId);


    /**
     * 根据用户id查询所有购物车项
     *
     * @param userId 用户id
     * @return java.util.List<com.tmall.pojo.CartItem>
     * @Author Xlu
     * @Date 14:43 2020/12/8
     */
    List<CartItem> selectCartItemsByUserId(@Param("userId") int userId);


    /**
     * 根据用户id，和商品id查询项是否存在
     *
     * @param userId     用户id
     * @param producerId 商品id
     * @return com.tmall.pojo.CartItem
     * @Author Xlu
     * @Date 15:24 2020/12/8
     */
    CartItem selectCartByUserIdAndProduceId(@Param("userId") int userId , @Param("produceId") int producerId);
}
