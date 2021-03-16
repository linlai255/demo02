package com.cll.admin.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class MyProduct {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "销量")
    private Integer sales;

    @ApiModelProperty(value = "主图")
    private String mainPic;

    @ApiModelProperty(value = "原价")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "单独购买价格")
    private BigDecimal separatePrice;

    @ApiModelProperty(value = "拼团价格")
    private BigDecimal groupPrice;

    @ApiModelProperty(value = "是否上架：0-不上架 1-上架")
    private Integer racking;

    @ApiModelProperty(value = "分类外键")
    private Integer cateId;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "商品服务，引用t_service中的serv_id，中间以逗号隔开")
    private String services;

    @ApiModelProperty(value = "详情")
    private String detail;


    @Override
    public String toString() {
        return "MyProduct{" +
                "title='" + title + '\'' +
                ", sales=" + sales +
                ", mainPic='" + mainPic + '\'' +
                ", originalPrice=" + originalPrice +
                ", separatePrice=" + separatePrice +
                ", groupPrice=" + groupPrice +
                ", racking=" + racking +
                ", cateId=" + cateId +
                ", keywords='" + keywords + '\'' +
                ", services='" + services + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
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

    public Integer getRacking() {
        return racking;
    }

    public void setRacking(Integer racking) {
        this.racking = racking;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
