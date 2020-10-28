package com.tmall.pojo;

/**
 * @ClassName: ProduceCat
 * @Author: Xlu
 * @Date: 2020/10/25 14:17
 * @Version 11
 **/
public class ProduceCat {
    /**
     * 商品类型Id
     */
    int id;
    /**
     * 商品类型符类Id
     */
    int parentId;
    /**
     * 商品类型名称
     */
    String name;
    /**
     * 该类型是否为父类
     */
    boolean isParent;

    @Override
    public String toString() {
        return "ProduceCat{" + "id=" + id + ", parentId=" + parentId + ", name='" + name + '\'' + ", isParent=" + isParent + '}';
    }

    public ProduceCat() {
    }

    public ProduceCat(int id , int parentId , String name , boolean isParent) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.isParent = isParent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }
}
