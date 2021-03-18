package com.cll.mbg.mapper;

import com.cll.mbg.model.TProduct;
import com.cll.mbg.model.TProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductMapper {
    long countByExample(TProductExample example);

    int deleteByExample(TProductExample example);

    int deleteByPrimaryKey(Integer prodId);

    int insert(TProduct record);
    int save(TProduct record);
    int insertSelective(TProduct record);

    List<TProduct> selectByExampleWithBLOBs(TProductExample example);

    List<TProduct> selectByExample(TProductExample example);

    TProduct selectByPrimaryKey(Integer prodId);

    int updateByExampleSelective(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByExampleWithBLOBs(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByExample(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKeyWithBLOBs(TProduct record);

    int updateByPrimaryKey(TProduct record);
}