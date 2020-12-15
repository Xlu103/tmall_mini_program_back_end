package com.tmall.dao;

import com.tmall.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public interface IAdminDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectByUsernameAndPassword(Admin admin);

}