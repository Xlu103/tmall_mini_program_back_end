package com.tmall.dao;

import com.tmall.pojo.Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IProduceDaoTest {
    @Resource(name = "produceDao")
    IProduceDao produceDao;

    @Test
    public void findAllProduce() {
        List<Produce> produces = produceDao.findAllProduce();
        for (Produce produce : produces) {
            System.out.println(produce);
        }
    }

    @Test
    public void findAllProduceByCat() {
        List<Produce> produces = produceDao.findAllProduceByCat(1);
        for (Produce produce : produces) {
            System.out.println(produce);
        }
    }

    @Test
    public void findProducesByNameTest() {
        List<Produce> produces = produceDao.findProducesByName("%盘%");
        for (Produce produce : produces) {
            System.out.println(produce);
        }
    }
}