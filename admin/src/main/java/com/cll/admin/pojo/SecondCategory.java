package com.cll.admin.pojo;

import com.cll.mbg.model.TProductCategory;

import java.util.List;

public class SecondCategory {
    private TProductCategory tProductCategorySecond;
    private List<TProductCategory> thirdCategoryList;

    public SecondCategory() {
    }

    public SecondCategory(TProductCategory tProductCategorySecond, List<TProductCategory> thirdCategoryList) {
        this.tProductCategorySecond = tProductCategorySecond;
        this.thirdCategoryList = thirdCategoryList;
    }

    public SecondCategory(TProductCategory tProductCategorySecond) {
        this.tProductCategorySecond = tProductCategorySecond;
    }

    public SecondCategory(List<TProductCategory> thirdCategoryList) {
        this.thirdCategoryList = thirdCategoryList;
    }

    @Override
    public String toString() {
        return "SecondCategory{" +
                "tProductCategorySecond=" + tProductCategorySecond +
                ", Category=" + thirdCategoryList +
                '}';
    }

    public TProductCategory gettProductCategorySecond() {
        return tProductCategorySecond;
    }

    public void settProductCategorySecond(TProductCategory tProductCategorySecond) {
        this.tProductCategorySecond = tProductCategorySecond;
    }

    public List<TProductCategory> getThirdCategoryList() {
        return thirdCategoryList;
    }

    public void setThirdCategoryList(List<TProductCategory> thirdCategoryList) {
        this.thirdCategoryList = thirdCategoryList;
    }
}
