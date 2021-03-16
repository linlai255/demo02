package com.cll.mbg.mapper;

import com.cll.mbg.model.TProductCategoryAttribute;
import com.cll.mbg.model.TProductCategoryAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductCategoryAttributeMapper {
    long countByExample(TProductCategoryAttributeExample example);

    int deleteByExample(TProductCategoryAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProductCategoryAttribute record);

    int insertSelective(TProductCategoryAttribute record);

    List<TProductCategoryAttribute> selectByExample(TProductCategoryAttributeExample example);

    TProductCategoryAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProductCategoryAttribute record, @Param("example") TProductCategoryAttributeExample example);

    int updateByExample(@Param("record") TProductCategoryAttribute record, @Param("example") TProductCategoryAttributeExample example);

    int updateByPrimaryKeySelective(TProductCategoryAttribute record);

    int updateByPrimaryKey(TProductCategoryAttribute record);
}