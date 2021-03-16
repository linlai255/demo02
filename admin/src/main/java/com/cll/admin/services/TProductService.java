package com.cll.admin.services;

import com.cll.admin.pojo.Page;
import com.cll.admin.vo.AddProduct;
import com.cll.mbg.model.TProduct;
import com.cll.mbg.model.TProductCategory;

import java.math.BigDecimal;
import java.util.List;

public interface TProductService {

    Page search(String title, Integer cateId, Integer racking, Integer pageNum, Integer pageSize);

    TProduct productDerail(int prodId);

    Integer deleteProduct(int prodId);

    Integer updateProduct(int prodId, String title, Integer cateId, BigDecimal originalPrice, BigDecimal separatePrice, BigDecimal groupPrice, Integer racking);

    List<TProductCategory> categorySearch(String cateName);

    int addSubclass(Integer pCateId, String cateName,Integer cateLevel);

    int updateCategory(String cateName, Integer cateId);

    int addProduct(AddProduct addProduct , String url);

}
