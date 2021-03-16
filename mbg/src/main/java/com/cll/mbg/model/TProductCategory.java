package com.cll.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TProductCategory implements Serializable {
    private Integer cateId;

    @ApiModelProperty(value = "分类名称")
    private String cateName;

    @ApiModelProperty(value = "分类外键，自关联，0-一级")
    private Integer pCateId;

    @ApiModelProperty(value = "分类等级")
    private Integer cateLevel;

    private static final long serialVersionUID = 1L;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getpCateId() {
        return pCateId;
    }

    public void setpCateId(Integer pCateId) {
        this.pCateId = pCateId;
    }

    public Integer getCateLevel() {
        return cateLevel;
    }

    public void setCateLevel(Integer cateLevel) {
        this.cateLevel = cateLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cateId=").append(cateId);
        sb.append(", cateName=").append(cateName);
        sb.append(", pCateId=").append(pCateId);
        sb.append(", cateLevel=").append(cateLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}