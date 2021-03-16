package com.cll.admin.vo;

import com.cll.admin.pojo.MyProduct;
import com.cll.admin.pojo.MySku;

import java.util.List;

public class AddProduct {
    private MyProduct myProduct;
    private List<MySku> mySku;

    @Override
    public String toString() {
        return "AddProduct{" +
                "myProduct=" + myProduct +
                ", mySku=" + mySku +
                '}';
    }

    public MyProduct getMyProduct() {
        return myProduct;
    }

    public void setMyProduct(MyProduct myProduct) {
        this.myProduct = myProduct;
    }

    public List<MySku> getMySku() {
        return mySku;
    }

    public void setMySku(List<MySku> mySku) {
        this.mySku = mySku;
    }
}
