package com.tmall.service.impl;

import com.tmall.dao.IProduceDao;
import com.tmall.pojo.Page;
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

    @Override
    public Page<Produce> findPageSizeAndPageNo(int pageNo , int pageSize) {
        Page<Produce> page = new Page<>();

        // 得到所有商品的条数
        int totalCount = produceDao.selectTotalCount();

        int totalPages = totalCount / pageSize;

        if (totalCount % pageSize != 0) {
            totalPages++;
        }

        // 总页面数
        page.setPageTotal(totalPages);
        // 当前页数
        page.setPageNo(pageNo);
        // 设置总条数
        page.setPageTotalCount(totalCount);

        // 查询到的
        List<Produce> produceList = produceDao.selectByPage(( page.getPageNo() - 1 ) * pageSize , pageSize);

        // 该页的所有项
        page.setItems(produceList);

        // 设置每一页的条数
        page.setPageSize(pageSize);

        return page;
    }

    @Override
    public int add(Produce produce) {
        return produceDao.insert(produce);
    }

    @Override
    public void update(Produce produce) {
        produceDao.updateById(produce);
    }
}
