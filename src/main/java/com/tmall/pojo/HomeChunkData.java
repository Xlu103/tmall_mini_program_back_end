package com.tmall.pojo;

import java.io.Serializable;

/**
 * 首页中的块数据，天猫新品那一块
 *
 * @ClassName: HomeChunkData
 * @Author: Xlu
 * @Date: 2020/10/14 17:11
 * @Version 11
 **/
public class HomeChunkData implements Serializable {
    private int id;
    private String url;
    private String imgSrc;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HomeChunkData{" + "id=" + id + ", url='" + url + '\'' + ", imgSrc='" + imgSrc + '\'' + ", title='" + title + '\'' + '}';
    }

    public HomeChunkData() {
    }

    public HomeChunkData(int id , String url , String imgSrc , String title) {
        this.id = id;
        this.url = url;
        this.imgSrc = imgSrc;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



