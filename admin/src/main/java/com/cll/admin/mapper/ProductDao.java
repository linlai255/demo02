package com.cll.admin.mapper;

import com.cll.admin.pojo.ProductAndCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    List<ProductAndCategory> search(String title, Integer cateId, Integer racking);
    long countByConditions(String title, Integer cateId, Integer racking);
}