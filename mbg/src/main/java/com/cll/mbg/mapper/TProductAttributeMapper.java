package com.cll.mbg.mapper;

import com.cll.mbg.model.TProductAttribute;
import com.cll.mbg.model.TProductAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductAttributeMapper {
    long countByExample(TProductAttributeExample example);

    int deleteByExample(TProductAttributeExample example);

    int deleteByPrimaryKey(Integer attrId);

    int insert(TProductAttribute record);

    int insertSelective(TProductAttribute record);

    List<TProductAttribute> selectByExample(TProductAttributeExample example);

    TProductAttribute selectByPrimaryKey(Integer attrId);

    int updateByExampleSelective(@Param("record") TProductAttribute record, @Param("example") TProductAttributeExample example);

    int updateByExample(@Param("record") TProductAttribute record, @Param("example") TProductAttributeExample example);

    int updateByPrimaryKeySelective(TProductAttribute record);

    int updateByPrimaryKey(TProductAttribute record);
}