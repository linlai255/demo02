package com.cll.mbg.mapper;

import com.cll.mbg.model.TProductCategory;
import com.cll.mbg.model.TProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductCategoryMapper {
    long countByExample(TProductCategoryExample example);

    int deleteByExample(TProductCategoryExample example);

    int deleteByPrimaryKey(Integer cateId);

    int insert(TProductCategory record);

    int insertSelective(TProductCategory record);

    List<TProductCategory> selectByExample(TProductCategoryExample example);

    TProductCategory selectByPrimaryKey(Integer cateId);

    int updateByExampleSelective(@Param("record") TProductCategory record, @Param("example") TProductCategoryExample example);

    int updateByExample(@Param("record") TProductCategory record, @Param("example") TProductCategoryExample example);

    int updateByPrimaryKeySelective(TProductCategory record);

    int updateByPrimaryKey(TProductCategory record);
}