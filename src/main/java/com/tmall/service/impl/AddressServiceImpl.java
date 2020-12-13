package com.tmall.service.impl;

import com.tmall.dao.IAddressDao;
import com.tmall.pojo.Address;
import com.tmall.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: AddressServiceImpl
 * @Author: Xlu
 * @Date: 2020/12/13 16:10
 * @Version 11
 **/
@Service("addressService")
public class AddressServiceImpl implements IAddressService {
    @Resource(name = "addressDao")
    IAddressDao addressDao;

    @Override
    public List<Address> findAlByUserId(Integer userId) {
        return addressDao.selectListByUserId(userId);
    }

    @Override
    public int deleteById(Integer id) {
        return addressDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Address address) {
        return addressDao.updateByPrimaryKey(address);
    }

    @Override
    public int addAddress(Address address) {
        return addressDao.insert(address);
    }

    @Override
    public int setDefault(Integer addressId , Integer userId) {
        // 设置所有地址为不默认地址
        addressDao.setDefaultByUserId(userId,false);
        // 设置当前订单为默认

        return 0;
    }


}
