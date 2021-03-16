package com.cll.admin.utils;

import com.cll.admin.pojo.MyAttribute;
import com.cll.admin.pojo.MyProduct;
import com.cll.admin.pojo.MySku;
import com.cll.mbg.model.TProduct;
import com.cll.mbg.model.TProductAttribute;
import com.cll.mbg.model.TProductSku;

public class MyTOProductUtil {
    public static TProduct conversion(MyProduct myProduct){
        TProduct tProduct = new TProduct();
        tProduct.setTitle( myProduct.getTitle());
        tProduct.setSales(myProduct.getSales());
        tProduct.setMainPic(myProduct.getMainPic());
        tProduct.setOriginalPrice(myProduct.getOriginalPrice());
        tProduct.setSeparatePrice(myProduct.getSeparatePrice());
        tProduct.setGroupPrice(myProduct.getGroupPrice());
        tProduct.setDetail(myProduct.getDetail());
        tProduct.setRacking(myProduct.getRacking());
        tProduct.setCateId(myProduct.getCateId());
        tProduct.setKeywords(myProduct.getKeywords());
        tProduct.setServices(myProduct.getServices());
         return tProduct;
    }
    public static TProductSku conversion(MySku mySku){
        TProductSku tProductSku = new TProductSku();
        tProductSku.setSkuCode(mySku.getSkuCode());
        tProductSku.setProdId(mySku.getProdId());
        tProductSku.setPicUrl(mySku.getPicUrl());
        tProductSku.setOriginalPrice(mySku.getOriginalPrice());
        tProductSku.setSeparatePrice(mySku.getSeparatePrice());
        tProductSku.setGroupPrice(mySku.getGroupPrice());
        tProductSku.setLowStock(mySku.getLowStock());
        tProductSku.setStock(mySku.getStock());
        tProductSku.setSpecValues(mySku.getSpecValues());
        tProductSku.setParamValues(mySku.getParamValues());
        return tProductSku;
    }
    public static TProductAttribute conversion(MyAttribute myAttribute){
        TProductAttribute tProductAttribute = new TProductAttribute();
        tProductAttribute.setAttrName(myAttribute.getAttrName());
        tProductAttribute.setAttrType(myAttribute.getAttrType());
        tProductAttribute.setInputType(myAttribute.getInputType());
        tProductAttribute.setManuallyAdd(myAttribute.getManuallyAdd());
        tProductAttribute.setManuallyAdd(myAttribute.getManuallyAdd());
        return tProductAttribute;
    }
}
