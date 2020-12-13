package com.tmall.dao;

import com.tmall.pojo.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IAddressDaoTest {

    @Resource(name = "addressDao")
    IAddressDao addressDao;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Address address = new Address();
        address.setAddress("广东省广州市太平区");
        address.setUserId(60);
        address.setMobile("1234445");
        address.setName("大哥");
        address.setStreet("从化华软");
        address.setDefault(false);
        addressDao.insert(address);
        System.out.println(address);
    }

    @Test
    public void selectByPrimaryKey() {
        Address address = addressDao.selectByPrimaryKey(1);
        System.out.println(address);
    }

    @Test
    public void updateByPrimaryKey() {

    }

    @Test
    public void selectListByUserId() {
        List<Address> addresses = addressDao.selectListByUserId(60);
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

    @Test
    public void setDefaultById() {
        addressDao.setDefaultById(2,false );
    }
}