package com.tmall.controller;

import com.tmall.pojo.Produce;
import com.tmall.pojo.StaticConst;
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
 * 商品控制类
 *
 * @ClassName: ProduceController
 * @Author: Xlu
 * @Date: 2020/10/28 17:25
 * @Version 11
 **/
@Controller("produceController")
@ResponseBody
@RequestMapping("/produce")
public class ProduceController {


    @Resource(name = "produceService")
    IProduceService produceService;

    /**
     * 查询所有商品数据
     *
     * @return java.lang.String
     * @Author Xlu
     * @Date 21:27 2020/10/28
     */
    @RequestMapping("/all")
    String getAllProduces(HttpServletRequest req) {
        List<Produce> produces = produceService.findAllProduce();
        for (Produce produce : produces) {
            produce.setImg("http://" + req.getServerName() + ":8080" + produce.getImg());
        }
        List<Produce> pLeft = new ArrayList<>();
        List<Produce> pRight = new ArrayList<>();

        for (int i = 0 ; i < produces.size() ; i++) {
            if (i < produces.size() / 2) {
                pLeft.add(produces.get(i));
            } else {
                pRight.add(produces.get(i));
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("left" , pLeft);
        map.put("right" , pRight);
        return JsonUtil.getJsonStr(map);
    }

    /**
     * 根据商品类别id查询商品
     *
     * @param id 商品类别的id
     * @return java.lang.String
     * @Author Xlu
     * @Date 21:03 2020/10/28
     */
    @RequestMapping("/cat")
    String getProduceByCatId(Integer id , HttpServletRequest req) {
        // 如果没有传递参数进来
        System.out.println(id);
        if (id == null) {
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        List<Produce> produces = produceService.findProduceByCatId(id);
        for (Produce produce : produces) {
            produce.setImg("http://" + req.getServerName() + ":8080" + produce.getImg());
        }
        return JsonUtil.getJsonStr(produces);
    }

    /**
     * 根据商品名称模糊搜索商品
     *
     * @param name 商品名称
     * @return java.lang.String
     * @Author Xlu
     * @Date 11:25 2020/11/2
     */
    @RequestMapping("/searchName")
    String searchProduceByName(String name , HttpServletRequest req) {
        // 如果没有请求参数 name，就返回一个错误信息
        if (name == null) {
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        List<Produce> produces = produceService.findProducesByName(name);
        for (Produce produce : produces) {
            produce.setImg("http://" + req.getServerName() + ":8080" + produce.getImg());
        }
        return JsonUtil.getJsonStr(produces);
    }


    /**
     * 根据商品id寻找商品
     *
     * @param id  商品id
     * @param req 请求
     * @return java.lang.String
     * @Author Xlu
     * @Date 15:43 2020/11/3
     */
    @RequestMapping("/searchId")
    String findProduceById(Integer id , HttpServletRequest req) {
        // 如果没有参数就返回错无信息
        if (id == null) {
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }

        Produce produce = produceService.findProduceById(id);
        produce.setImg("http://" + req.getServerName() + ":8080" + produce.getImg());

        return JsonUtil.getJsonStr(produce);
    }




}
