package com.tmall.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 处理Json数据工具类
 *
 * @ClassName: JsonUtil
 * @Author: Xlu
 * @Date: 2020/9/30 19:05
 * @Version 11
 **/
public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();



    /**
     * 准换为Json字符串
     *
     * @param obj List Map Bean
     * @return java.lang.String json字符串
     * @Author Xlu
     * @Date 20:04 2020/10/2
     */
    public static String getJsonStr(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;

        }
    }

    /**
     * 解析json字符串
     *
     * @param jsonStr 字符串
     * @param clazz   类型
     * @return T
     * @Author Xlu
     * @Date 22:09 2020/11/3
     */
    public static <T> T getString(String jsonStr , Class<T> clazz) {

        try {
            return mapper.readValue(jsonStr , clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }



}
