package com.tmall.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: Md5Util
 * @Author: Xlu
 * @Date: 2020/10/13 13:50
 * @Version 11
 **/
public class Md5Util {
    /**
     * 获取md5加密后的密码
     *
     * @param pws 密码
     * @return java.lang.String 加密后的密码
     * @Author Xlu
     * @Date 13:51 2020/10/13
     */
    public static String getMD5(String pws) {
        // 使用默认盐值进行加密
        return getMD5(pws , "xlu");
    }

    /**
     * 获取md5加密后的字符串
     *
     * @param pws  密码
     * @param salt 盐值
     * @return java.lang.String 加密后的
     * @Author Xlu
     * @Date 13:59 2020/10/13
     */
    public static String getMD5(String pws , String salt) {
        MessageDigest mdTemp = null;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(( pws + salt ).getBytes());
            byte[] digest = mdTemp.digest();
            return new String(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
