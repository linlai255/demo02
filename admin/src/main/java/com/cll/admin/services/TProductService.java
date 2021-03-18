package com.cll.admin.services;

import com.cll.admin.pojo.MyCategory;
import com.cll.admin.pojo.Page;
import com.cll.admin.vo.AddProduct;
import com.cll.admin.vo.VoProductDetail;
import com.cll.mbg.model.TProductQuestion;

import java.math.BigDecimal;
import java.util.List;

public interface TProductService {

    Page search(String title, Integer cateId, Integer racking, Integer pageNum, Integer pageSize);

    VoProductDetail productDerail(Integer prodId);

    Integer deleteProduct(int prodId);

    Integer updateProduct(int prodId, String title, Integer cateId, BigDecimal originalPrice, BigDecimal separatePrice, BigDecimal groupPrice, Integer racking);

    List<MyCategory> categorySearch(String cateName);

    int addSubclass(Integer pCateId, String cateName,Integer cateLevel);

    int updateCategory(String cateName, Integer cateId);

    int addProduct(AddProduct addProduct , String url);

    List<String> getProductParams(Integer prodId);

    List<TProductQuestion> getProductQA(Integer prodId ,int size);
}
