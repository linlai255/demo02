package com.cll.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class TProduct implements Serializable {
    private Integer prodId;

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

    @ApiModelProperty(value = "是否删除，0-不删除，1-删除")
    private String isDelete;

    @ApiModelProperty(value = "商品服务，引用t_service中的serv_id，中间以逗号隔开")
    private String services;

    @ApiModelProperty(value = "详情")
    private String detail;

    private static final long serialVersionUID = 1L;

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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prodId=").append(prodId);
        sb.append(", title=").append(title);
        sb.append(", sales=").append(sales);
        sb.append(", mainPic=").append(mainPic);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", separatePrice=").append(separatePrice);
        sb.append(", groupPrice=").append(groupPrice);
        sb.append(", racking=").append(racking);
        sb.append(", cateId=").append(cateId);
        sb.append(", keywords=").append(keywords);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", services=").append(services);
        sb.append(", detail=").append(detail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}