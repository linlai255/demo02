package com.cll.admin.mapper;

import com.cll.mbg.model.TProductAttribute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttributeDao {

    List<TProductAttribute> getAttributeByCategory(Integer cateId);
}
