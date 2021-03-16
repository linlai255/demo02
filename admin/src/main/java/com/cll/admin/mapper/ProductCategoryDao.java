package com.cll.admin.mapper;

import com.cll.mbg.model.TProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryDao {
    List<TProductCategory> getCategory(String cateName);
    List<TProductCategory> getCategoryBypId(Integer pCateId);

}
