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
    private double price;
    /**
     * 商品销量
     */
    private long sales;
    /**
     * 商品库存
     */
    private long stock;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        this.sales = sales;
    }

    public long getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     * @return void
     * @Author Xlu
     * @Date 10:19 2020/12/14
     */
    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getImg() {
        if (img == null) {
            img = "/tmall/static/img/default.jpg";
        }
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
        return "Produce{" + "id=" + id + ", title='" + title + '\'' + ", detail='" + detail + '\'' + ", price=" + price + ", " + "sales=" + sales + ", stock=" + stock + ", img='" + img + '\'' + ", CatId=" + CatId + '}';
    }

    public Produce() {
    }

    public Produce(int id , String title , String detail , double price , long sales , long stock , String img , int catId) {
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
