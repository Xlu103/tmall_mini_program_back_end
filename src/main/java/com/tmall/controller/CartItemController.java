package com.tmall.controller;

import com.tmall.pojo.CartItem;
import com.tmall.pojo.Produce;
import com.tmall.pojo.StaticConst;
import com.tmall.service.ICartItemService;
import com.tmall.service.IProduceService;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: CartItemController
 * @Author: Xlu
 * @Date: 2020/12/8 15:09
 * @Version 11
 **/
@Controller
@ResponseBody
@RequestMapping("/cart")
public class CartItemController {
    @Resource(name = "cartItemService")
    ICartItemService cartItemService;
    @Resource(name = "produceService")
    IProduceService produceService;

    /**
     * 添加购物车项
     *
     * @param item 购物车项
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:13 2020/12/8
     */
    @RequestMapping("/add")
    public String addItem(CartItem item) {
        HashMap<String, Object> map = new HashMap<>();
        if (item.getCount() == null) {
            item.setCount(1);
        }
        if (item == null || item.getUserId() == null || item.getProduceId() == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        cartItemService.addItem(item);
        map.put("message" , "success");
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 更改购物车的项的数量，一般都是更改数量
     *
     * @param item 购物车项，自动封装了
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:32 2020/12/8
     */
    @RequestMapping("/update")
    public String updateItem(CartItem item) {
        HashMap<String, Object> map = new HashMap<>();
        if (item == null || item.getCount() == null || item.getId() == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        cartItemService.updateItem(item);
        map.put("message" , "success");
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 根据购物车项的id删除购物车
     *
     * @param item 购物车项
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:36 2020/12/8
     */
    @RequestMapping("/delete")
    public String deleteItemById(CartItem item) {
        HashMap<String, Object> map = new HashMap<>();
        if (item == null || item.getId() == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        cartItemService.deleteItemById(item.getId());
        map.put("message" , "success");
        return JsonUtil.getJsonStr(map);
    }


    /**
     * 删除所有项
     *
     * @param
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:37 2020/12/8
     */
    @RequestMapping("/deleteAll")
    public String deleteAllItems(Integer userId) {
        HashMap<String, Object> map = new HashMap<>();
        if (userId == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        // 删除所有购物车项
        cartItemService.deleteAllItemsByUserId(userId);
        map.put("message" , "success");
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 根据用户id得到购物车项
     *
     * @param userId 用户id
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:54 2020/12/8
     */
    @RequestMapping("all")
    public String getListItems(Integer userId , HttpServletRequest req) {
        HashMap<String, Object> map = new HashMap<>();
        if (userId == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        // 得到所有购物车项
        List<CartItem> cartItems = cartItemService.findItemsByUserId(userId);
        List<Produce> produces = new ArrayList<>();

        // 遍历所有购物车项，将每一个商品都加载出来，用于在前端加载商品信息的时候可以显示
        for (CartItem item : cartItems) {
            Produce produce = produceService.findProduceById(item.getProduceId());
            produce.setImg("http://" + req.getServerName() + ":8080" + produce.getImg());
            produces.add(produce);
        }
        map.put("message" , "success");
        map.put("items" , cartItems);
        map.put("produces" , produces);
        return JsonUtil.getJsonStr(map);
    }

}
