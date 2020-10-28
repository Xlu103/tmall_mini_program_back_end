package com.tmall.pojo;

/**
 * 商品类
 *
 * @ClassName: Produce
 * @Author: Xlu
 * @Date: 2020/10/25 14:13
 * @Version 11
 **/
public class Produce {
    /**
     * 商品id
     */
    private int id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品描述
     */
    private String detail;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 商品销量
     */
    private String sales;
    /**
     * 商品库存
     */
    private String stock;
    /**
     * 商品图片，目前只支持一张图片
     */
    private String img;
    /**
     * 商品所属类型Id
     */
    private int CatId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }

    @Override
    public String toString() {
        return "Produce{" + "id=" + id + ", title='" + title + '\'' + ", detail='" + detail + '\'' + ", price='" + price + '\'' + ", sales='" + sales + '\'' + ", stock='" + stock + '\'' + ", img='" + img + '\'' + ", CatId=" + CatId + '}';
    }

    public Produce() {
    }

    public Produce(int id , String title , String detail , String price , String sales , String stock , String img , int catId) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.img = img;
        CatId = catId;
    }
}
