package com.cll.admin.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class SkuDetail {
    private Integer skuId;

    private String picUrl;

    private BigDecimal originalPrice;

    private BigDecimal separatePrice;

    private BigDecimal groupPrice;

    private String specValues;

    private Integer stock;

    @Override
    public String toString() {
        return "SkuDetail{" +
                "skuId=" + skuId +
                ", picUrl='" + picUrl + '\'' +
                ", originalPrice=" + originalPrice +
                ", separatePrice=" + separatePrice +
                ", groupPrice=" + groupPrice +
                ", specValues='" + specValues + '\'' +
                ", stock=" + stock +
                '}';
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    public String getSpecValues() {
        return specValues;
    }

    public void setSpecValues(String specValues) {
        this.specValues = specValues;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
