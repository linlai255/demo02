package com.cll.admin.pojo;

import io.swagger.annotations.ApiModelProperty;

public class CateAndAttri {
    private Integer id;

    @ApiModelProperty(value = "分类id")
    private Integer cateId;

    @ApiModelProperty(value = "属性id")
    private Integer attrId;

    @ApiModelProperty(value = "属性名称")
    private String attrName;

    @ApiModelProperty(value = "属性输入类型：0->输入框；1->单选；2->多选")
    private Integer inputType;

    @ApiModelProperty(value = "可选值列表，以逗号隔开")
    private String valueList;

    @ApiModelProperty(value = "是否支持手动新增；0->不支持；1->支持")
    private Integer manuallyAdd;

    @ApiModelProperty(value = "属性的类型；0->规格；1->参数")
    private Integer attrType;





    @Override
    public String toString() {
        return "CateAndAttri{" +
                "attrId=" + attrId +
                ", attrName='" + attrName + '\'' +
                ", inputType=" + inputType +
                ", valueList='" + valueList + '\'' +
                ", manuallyAdd=" + manuallyAdd +
                ", attrType=" + attrType +
                ", id=" + id +
                ", cateId=" + cateId +
                '}';
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getValueList() {
        return valueList;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
    }

    public Integer getManuallyAdd() {
        return manuallyAdd;
    }

    public void setManuallyAdd(Integer manuallyAdd) {
        this.manuallyAdd = manuallyAdd;
    }

    public Integer getAttrType() {
        return attrType;
    }

    public void setAttrType(Integer attrType) {
        this.attrType = attrType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }
}
