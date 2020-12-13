package com.tmall.controller;

import com.tmall.pojo.Address;
import com.tmall.pojo.StaticConst;
import com.tmall.service.IAddressService;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 地址控制类
 * 主要功能:
 * 新增地址，删除地址，修改地址
 *
 * @ClassName: AddressController
 * @Author: Xlu
 * @Date: 2020/12/13 16:12
 * @Version 11
 **/
@Controller
@ResponseBody
@RequestMapping("/address")
public class AddressController {
    @Resource(name = "addressService")
    IAddressService addressService;

    @RequestMapping("/add")
    public String add(Address address) {
        HashMap<String, Object> map = new HashMap<>();
        if (address == null || address.getAddress() == null || address.getMobile() == null || address.getName() == null || address.getStreet() == null || address.getUserId() == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        addressService.addAddress(address);
        map.put("message" , "success");
        map.put("address" , address);
        return JsonUtil.getJsonStr(map);
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        if (id == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        addressService.deleteById(id);
        map.put("message" , "success");
        return JsonUtil.getJsonStr(map);
    }

    @RequestMapping("/update")
    public String update(Address address) {
        HashMap<String, Object> map = new HashMap<>();
        if (address == null || address.getId() == null || address.getAddress() == null || address.getMobile() == null || address.getName() == null || address.getStreet() == null || address.getUserId() == null || address.getDefault() == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        addressService.update(address);
        map.put("message" , "success");
        map.put("address" , address);
        return JsonUtil.getJsonStr(map);
    }


    /**
     * 查询所有地址，根据用户id
     *
     * @param userId 用户id
     * @return java.lang.String
     * @Author Xlu
     * @Date 17:48 2020/12/13
     */
    @RequestMapping("/all")
    public String findAll(Integer userId) {
        HashMap<String, Object> map = new HashMap<>();
        if (userId == null) {
            // 如果参数不对，就返回一个参数错误
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        List<Address> addressList = addressService.findAlByUserId(userId);
        map.put("message" , "success");
        map.put("addressList" , addressList);
        return JsonUtil.getJsonStr(map);
    }

    @RequestMapping("/setDefault")
    public String setDefault(Integer addressId , Integer userId) {
        HashMap<Object, Object> map = new HashMap<>();
        if (addressId == null || userId == null) {
            return StaticConst.PARAMETER_NULL_MESSAGE;
        }
        addressService.setDefault(addressId , userId);
        return JsonUtil.getJsonStr(map);
    }


}
