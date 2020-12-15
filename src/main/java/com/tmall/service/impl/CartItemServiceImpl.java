package com.tmall.service.impl;

import com.tmall.dao.ICartItemDao;
import com.tmall.dao.IProduceDao;
import com.tmall.pojo.CartItem;
import com.tmall.pojo.Produce;
import com.tmall.service.ICartItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: CartItemServiceImpl
 * @Author: Xlu
 * @Date: 2020/12/8 15:07
 * @Version 11
 **/
@Service("cartItemService")
public class CartItemServiceImpl implements ICartItemService {
    @Resource(name = "cartItemDao")
    ICartItemDao cartItemDao;

    @Resource(name = "produceDao")
    IProduceDao produceDao;

    @Override
    public int deleteItemById(Integer id) {
        return cartItemDao.deleteByPrimaryKey(id);
    }


    /**
     * 结账的时候删除购物车项，将该商品的销量增加
     *
     * @return int
     * @Author Xlu
     * @Date 16:37 2020/12/15
     */
    @Override
    public int deleteItemByIdSettle(Integer id) {
        CartItem cartItem = cartItemDao.selectByPrimaryKey(id);
        Integer produceId = cartItem.getProduceId();
        Produce produce = produceDao.findProduceById(produceId);
        produce.setSales(produce.getSales() + cartItem.getCount());
        // 删除购物车项的时候顺便将销量增加
        produceDao.updateById(produce);
        return cartItemDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateItem(CartItem item) {
        return cartItemDao.updateByPrimaryKey(item);
    }

    @Override
    public List<CartItem> findItemsByUserId(Integer userId) {
        return cartItemDao.selectCartItemsByUserId(userId);
    }

    @Override
    public int addItem(CartItem item) {
        CartItem cartItem = cartItemDao.selectCartByUserIdAndProduceId(item.getUserId() , item.getProduceId());
        if (cartItem != null) {
            cartItem.setCount(cartItem.getCount() + 1);
            return updateItem(cartItem);
        }

        return cartItemDao.insert(item);
    }

    @Override
    public int deleteAllItemsByUserId(Integer userId) {
        return cartItemDao.deleteAllCartItemsByUserId(userId);
    }
}
