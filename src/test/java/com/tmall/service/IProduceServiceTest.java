package com.tmall.service;

import com.tmall.pojo.Produce;
import com.tmall.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IProduceServiceTest {
    @Resource(name = "produceService")
    IProduceService produceService;

    @Test
    public void findAllProduce() {
        List<Produce> produces = produceService.findAllProduce();
        for (Produce produce : produces) {
            System.out.println(produce);
        }
    }

    @Test
    public void findProduceByCatId() {
        List<Produce> allProduceByCat = produceService.findProduceByCatId(5);

        System.out.println(JsonUtil.getJsonStr(allProduceByCat));
    }

    @Test
    public void findProducesByNameTest() {

        List<Produce> produces = produceService.findProducesByName("盘");
        for (Produce produce : produces) {
            System.out.println(produce);
        }
    }
}