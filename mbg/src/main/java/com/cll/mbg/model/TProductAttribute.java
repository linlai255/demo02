package com.cll.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TProductAttribute implements Serializable {
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

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attrId=").append(attrId);
        sb.append(", attrName=").append(attrName);
        sb.append(", inputType=").append(inputType);
        sb.append(", valueList=").append(valueList);
        sb.append(", manuallyAdd=").append(manuallyAdd);
        sb.append(", attrType=").append(attrType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}