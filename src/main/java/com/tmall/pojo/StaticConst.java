package com.tmall.pojo;

import com.tmall.utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于存放静态常量类
 *
 * @ClassName: StaticConst
 * @Author: Xlu
 * @Date: 2020/10/21 22:19
 * @Version 11
 **/
public class StaticConst {

    /** 小程序id */
    public final static String WX_APPID = "wx477f97beaf258e1e";
    /** 小程序密钥 */
    public final static String WX_SECRET = "3304153e1ca37853bc485087030bc9e3";
    /** 授权类型 */
    public final static String GRANT_TYPE = "authorization_code";
    /** 缺少请求参数的请求返回消息 */
    public static String PARAMETER_NULL_MESSAGE = "";

    static {
        // 错误消息初始化
        Map map = new HashMap(2);
        map.put("status" , 0);
        map.put("message" , "参数不正确，请查阅文档！");
        PARAMETER_NULL_MESSAGE = JsonUtil.getJsonStr(map);
    }
}
