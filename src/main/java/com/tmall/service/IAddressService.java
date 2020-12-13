package com.tmall.service;

import com.tmall.pojo.Address;

import java.util.List;

/**
 * 地址服务类
 * 增删改查地址
 *
 * @Author Xlu
 * @Date 2020/12/13 16:06
 * @InterfaceName IAddressService
 * @Version 11
 **/
public interface IAddressService {
    /**
     * 根据用户id查询所有地址
     *
     * @param userId 用户id
     * @return java.util.List<com.tmall.pojo.Address>
     * @Author Xlu
     * @Date 16:07 2020/12/13
     */
    public List<Address> findAlByUserId(Integer userId);


    /**
     * 根据id删除地址记录
     *
     * @param id 地址id
     * @return int
     * @Author Xlu
     * @Date 16:08 2020/12/13
     */
    public int deleteById(Integer id);

    /**
     * 修改地址，这里是根据地址记录的id来更改
     *
     * @param address 地址
     * @return int
     * @Author Xlu
     * @Date 16:09 2020/12/13
     */
    public int update(Address address);


    /**
     * 新增地址记录
     *
     * @param address 地址
     * @return int
     * @Author Xlu
     * @Date 16:16 2020/12/13
     */
    public int addAddress(Address address);
    /**
     *
     * 根据用户id和地址id，设置该用户的这个地址为默认地址
     * @Author Xlu
     * @Date 17:52 2020/12/13
     * @param addressId 地址id
     * @param userId  用户id
     * @return int
    */
    public int setDefault(Integer addressId,Integer userId);

}
