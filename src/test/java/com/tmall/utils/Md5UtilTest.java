package com.tmall.utils;

import org.junit.Test;

/**
 * @ClassName: Md5UtilTest
 * @Author: Xlu
 * @Date: 2020/10/13 13:53
 * @Version 11
 **/
public class Md5UtilTest {
    @Test
    public void getMD5Test() {
        String md5 = Md5Util.getMD5("admin");
        String md51 = Md5Util.getMD5("admin");

        System.out.println(md5);
        System.out.println(md51);
    }
}
