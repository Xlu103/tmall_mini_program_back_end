package com.tmall.service.impl;

import com.tmall.dao.IProduceDao;
import com.tmall.pojo.Produce;
import com.tmall.service.IProduceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ProduceServiceImpl
 * @Author: Xlu
 * @Date: 2020/10/28 17:20
 * @Version 11
 **/
@Service("produceService")
public class ProduceServiceImpl implements IProduceService {
    @Resource(name = "produceDao")
    IProduceDao produceDao;

    @Override
    public List<Produce> findAllProduce() {
        return produceDao.findAllProduce();
    }

    @Override
    public List<Produce> findProduceByCatId(int catId) {
        return produceDao.findAllProduceByCat(catId);
    }

    @Override
    public List<Produce> findProducesByName(String name) {
        name = "%" + name + "%";
        return produceDao.findProducesByName(name);
    }

    @Override
    public Produce findProduceById(int id) {
        return produceDao.findProduceById(id);
    }
}
