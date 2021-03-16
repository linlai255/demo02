package com.cll.admin.pojo;

import io.swagger.annotations.ApiModelProperty;

public class MyAttribute {

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
        return "MyAttribute{" +
                "attrName='" + attrName + '\'' +
                ", inputType=" + inputType +
                ", valueList='" + valueList + '\'' +
                ", manuallyAdd=" + manuallyAdd +
                ", attrType=" + attrType +
                '}';
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
}
