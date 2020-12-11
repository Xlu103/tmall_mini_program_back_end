package com.tmall.service.impl;

import com.tmall.dao.ICartItemDao;
import com.tmall.pojo.CartItem;
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

    @Override
    public int deleteItemById(Integer id) {
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
