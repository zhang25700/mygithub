package com.zzy.pojo;

import java.util.List;

//分页查询返回数据
public class PageBean<T> {
    //总体数量
    private int total;
    //一页的数据
    private List<T> rows;

    public PageBean() {
    }

    public PageBean(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
