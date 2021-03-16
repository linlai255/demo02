package com.cll.admin.pojo;

import com.cll.mbg.model.TProduct;

import java.util.List;

public class Page {
    private int pageNum;//第几页
    private int pageSize;//每页大小
    private int totalPages;//总页数
    private long total;//数据总条数
    private List<ProductAndCategory> productList;

    public Page() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<ProductAndCategory> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductAndCategory> productList) {
        this.productList = productList;
    }
}
