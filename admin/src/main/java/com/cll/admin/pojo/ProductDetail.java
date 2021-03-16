package com.cll.admin.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

public class ProductDetail {
    private Integer prodId;

    private String title;

    private BigDecimal originalPrice;

    private BigDecimal separatePrice;

    private BigDecimal groupPrice;

    private Integer sales;

    @Override
    public String toString() {
        return "ProductDetail{" +
                "prodId=" + prodId +
                ", title='" + title + '\'' +
                ", originalPrice=" + originalPrice +
                ", separatePrice=" + separatePrice +
                ", groupPrice=" + groupPrice +
                ", sales=" + sales +
                '}';
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSeparatePrice() {
        return separatePrice;
    }

    public void setSeparatePrice(BigDecimal separatePrice) {
        this.separatePrice = separatePrice;
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
