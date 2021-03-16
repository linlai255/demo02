package com.cll.admin.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class MySku {

    @ApiModelProperty(value = "sku编码")
    private String skuCode;

    @ApiModelProperty(value = "所属商品")
    private Integer prodId;

    @ApiModelProperty(value = "图片")
    private String picUrl;

    @ApiModelProperty(value = "原价")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "单独购买价格")
    private BigDecimal separatePrice;

    @ApiModelProperty(value = "拼团价格")
    private BigDecimal groupPrice;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "库存预警")
    private Integer lowStock;

    @ApiModelProperty(value = "商品规格，json格式")
    private String specValues;

    @ApiModelProperty(value = "商品参数，json格式")
    private String paramValues;

    @Override
    public String toString() {
        return "MySku{" +
                "skuCode='" + skuCode + '\'' +
                ", prodId=" + prodId +
                ", picUrl='" + picUrl + '\'' +
                ", originalPrice=" + originalPrice +
                ", separatePrice=" + separatePrice +
                ", groupPrice=" + groupPrice +
                ", stock=" + stock +
                ", lowStock=" + lowStock +
                ", specValues='" + specValues + '\'' +
                ", paramValues='" + paramValues + '\'' +
                '}';
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getPicUrl() {
        return picUrl;
    }
    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public String getSpecValues() {
        return specValues;
    }

    public void setSpecValues(String specValues) {
        this.specValues = specValues;
    }

    public String getParamValues() {
        return paramValues;
    }

    public void setParamValues(String paramValues) {
        this.paramValues = paramValues;
    }
}
