package com.tmall.controller;

import com.tmall.pojo.Produce;
import com.tmall.service.IProduceService;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @RequestMapping("/all")
    String getAllProduces() {
        List<Produce> produces = produceService.findAllProduce();
        return JsonUtil.getJsonStr(produces);
    }

    /**
     * @param id
     * @return java.lang.String
     * @Author Xlu
     * @Date 21:03 2020/10/28
     */
    @RequestMapping("/cat")
    String getProduceByCatId(int id) {
        return JsonUtil.getJsonStr(produceService.findProduceByCatId(id));
    }

}
