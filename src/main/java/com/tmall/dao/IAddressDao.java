package com.tmall.dao;

import com.tmall.pojo.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地址表的dao操作类
 *
 * @Author Xlu
 * @Date 2020/12/13 15:55
 * @ClassName IAddressDao
 * @Version 11
 **/
@Repository("addressDao")
public interface IAddressDao {

    /**
     * 根据记录的id删除表数据
     *
     * @param id id
     * @return int
     * @Author Xlu
     * @Date 15:55 2020/12/13
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增地址记录
     *
     * @param address
     * @return int
     * @Author Xlu
     * @Date 15:55 2020/12/13
     */
    int insert(Address address);


    /**
     * 根据id查询地址
     *
     * @param id id
     * @return com.tmall.pojo.Address
     * @Author Xlu
     * @Date 15:55 2020/12/13
     */
    Address selectByPrimaryKey(Integer id);

    /**
     * 修改地址信息，根据id
     *
     * @param address 地址
     * @return int
     * @Author Xlu
     * @Date 15:56 2020/12/13
     */
    int updateByPrimaryKey(Address address);

    /**
     * 根据用户id查询该用户的所有地址列表
     *
     * @param userId 用户id
     * @return java.util.List<com.tmall.pojo.Address>
     * @Author Xlu
     * @Date 15:57 2020/12/13
     */
    List<Address> selectListByUserId(Integer userId);

    /**
     * 根据用户id设置他的默认值
     *
     * @param userId    用户的id
     * @param isDefault 标志
     * @return void
     * @Author Xlu
     * @Date 17:55 2020/12/13
     */
    void setDefaultByUserId(@Param("userId") Integer userId , @Param("isDefault") boolean isDefault);

    /**
     * 设置地址是否为默认地址
     *
     * @param id        地址id
     * @param isDefault 是否默认
     * @return void
     * @Author Xlu
     * @Date 19:53 2020/12/13
     */
    void setDefaultById(@Param("id") Integer id ,@Param("isDefault") boolean isDefault);
}