package com.gec.bean;

import java.util.List;

/**
 * @author Brice
 * @title: PageBean
 * @projectName homework02
 * @description: 分页类
 * @date 2020/10/2718:41
 */
public class PageBean <T>{
    private int pageNow;
    private int pageSize;
    private int pageCount;
    private int rowCount;
    private java.util.List<T> List;

    public PageBean(int pageNow) {
        this.pageNow = pageNow;
    }

    public PageBean(int pageNow, int pageSize, int pageCount, int rowCount, java.util.List<T> list) {
        this.pageNow = pageNow;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.rowCount = rowCount;
        List = list;
    }

    public PageBean() {
    }

    public int getPageNow() {
        return pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        setPageCount();
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount() {
        this.pageCount = (rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize)+1;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
        setPageCount();
    }

    public java.util.List<T> getList() {
        return List;
    }

    public void setList(java.util.List<T> list) {
        List = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNow=" + pageNow +
                ", pageCount=" + pageCount +
                ", rowCount=" + rowCount +
                ", List=" + List +
                '}';
    }
}
