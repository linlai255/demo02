package com.cll.admin.pojo;

import com.cll.mbg.model.TProductCategory;

import java.util.List;

public class MyCategory {
    private TProductCategory tProductCategoryFirst;
    private List<SecondCategory> secondCategoryList;

    public MyCategory(List<SecondCategory> secondCategoryList) {
        this.secondCategoryList = secondCategoryList;
    }

    public MyCategory(TProductCategory tProductCategoryFirst, List<SecondCategory> secondCategoryList) {
        this.tProductCategoryFirst = tProductCategoryFirst;
        this.secondCategoryList = secondCategoryList;
    }

    public MyCategory() {
    }

    public MyCategory(TProductCategory tProductCategoryFirst) {
        this.tProductCategoryFirst = tProductCategoryFirst;
    }

    @Override
    public String toString() {
        return "MyCategory{" +
                "tProductCategoryFirst=" + tProductCategoryFirst +
                ", secondCategory=" + secondCategoryList +
                '}';
    }

    public TProductCategory gettProductCategoryFirst() {
        return tProductCategoryFirst;
    }

    public void settProductCategoryFirst(TProductCategory tProductCategoryFirst) {
        this.tProductCategoryFirst = tProductCategoryFirst;
    }

    public List<SecondCategory> getSecondCategoryList() {
        return secondCategoryList;
    }

    public void setSecondCategoryList(List<SecondCategory> secondCategoryList) {
        this.secondCategoryList = secondCategoryList;
    }

}
