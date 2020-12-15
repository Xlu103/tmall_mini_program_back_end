package com.tmall.pojo;

import java.util.List;

/**
 * 分页类
 *
 * @Author Xlu
 * @Date 2020/12/14 19:02
 * @ClassName Page
 * @Version 11
 **/
public class Page <T> {
    /**
     * 当前页数
     */
    private int pageNo;
    /**
     * 总页数
     */
    private int pageTotal;
    /**
     * 总条数
     */
    private int pageTotalCount;
    /**
     * 每一页中的每一项，这是一个泛型，才可以用过来匹配种类型的分页
     */
    private List<T> items;
    /**
     *
     */
    private String url;

    /**
     * 每一页的多少项
     */
    private int pageSize;

    @Override
    public String toString() {
        return "Page{" + "pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageTotalCount=" + pageTotalCount + ", items=" + items + ", url='" + url + '\'' + ", pageSize=" + pageSize + '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(int pageNo , int pageTotal , int pageTotalCount , List<T> items , String url) {
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
        this.url = url;

        if (pageNo < 1) {
            this.pageNo = 1;
        } else if (pageNo > pageTotal) {
            this.pageNo = pageTotal;
        } else {
            this.pageNo = pageNo;
        }

    }

    public Page() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else if (pageNo > pageTotal) {
            this.pageNo = pageTotal;
        } else {
            this.pageNo = pageNo;
        }
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Page(int pageNo , int pageTotal , int pageTotalCount , List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
