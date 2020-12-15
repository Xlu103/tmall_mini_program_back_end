package com.tmall.service;

import com.tmall.pojo.CartItem;

import java.util.List;

/**
 * 购物车服务类接口，使用这个接口来对购物车项的操作进行规范
 *
 * @Author Xlu
 * @Date 2020/12/8 14:34
 * @InterfaceName ICartItemService
 * @Version 11
 **/
public interface ICartItemService {
    /**
     * 删除购物车项
     *
     * @param id
     * @return int
     * @Author Xlu
     * @Date 15:07 2020/12/8
     */
    int deleteItemById(Integer id);


    /**
     *
     * 在结账的时候删除购物车项
     * @Author Xlu
     * @Date 16:43 2020/12/15
     * @param id 购物车项id
     * @return int
    */
    public int deleteItemByIdSettle(Integer id) ;


    /**
     * 更改购物车项，一般这里就是更改购物车项的count
     *
     * @param item
     * @return int
     * @Author Xlu
     * @Date 15:06 2020/12/8
     */
    int updateItem(CartItem item);

    /**
     * 根据用户的id查询购物车列表
     *
     * @param userId
     * @return java.util.List<com.tmall.pojo.CartItem>
     * @Author Xlu
     * @Date 15:06 2020/12/8
     */



    List<CartItem> findItemsByUserId(Integer userId);

    /**
     * 添加购物车
     * 在添加购物车项的时候，判断该购物车项是否已经存在，如果已经存在，就在原有的购物车上添加1
     *
     * @param item 购物车项
     * @return int
     * @Author Xlu
     * @Date 15:05 2020/12/8
     */
    int addItem(CartItem item);


    /**
     * 根据用户id删除所有购物车项
     *
     * @param userId 用户id
     * @return int
     * @Author Xlu
     * @Date 15:39 2020/12/8
     */
    int deleteAllItemsByUserId(Integer userId);
}
