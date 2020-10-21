package com.tmall.pojo;

/**
 * 轮播图的实体类，主要用于封装数据
 *
 * @ClassName: HomeSwiperImage
 * @Author: Xlu
 * @Date: 2020/9/30 19:09
 * @Version 11
 **/
public class HomeSwiperImage {
    int id;
    /** 从数据库获取到的数据只有端口号后面的路径 */
    public String src;
    public int productId;

    @Override
    public String toString() {
        return "HomeSwiperImage{" + "id=" + id + ", src='" + src + '\'' + ", productId=" + productId + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public HomeSwiperImage() {
    }

    public HomeSwiperImage(int id , String src , int productId) {
        this.id = id;
        this.src = src;
        this.productId = productId;
    }
}
