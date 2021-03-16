package com.cll.mbg.mapper;

import com.cll.mbg.model.TProductSku;
import com.cll.mbg.model.TProductSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductSkuMapper {
    long countByExample(TProductSkuExample example);

    int deleteByExample(TProductSkuExample example);

    int deleteByPrimaryKey(Integer skuId);

    int insert(TProductSku record);

    int insertSelective(TProductSku record);

    List<TProductSku> selectByExampleWithBLOBs(TProductSkuExample example);

    List<TProductSku> selectByExample(TProductSkuExample example);

    TProductSku selectByPrimaryKey(Integer skuId);

    int updateByExampleSelective(@Param("record") TProductSku record, @Param("example") TProductSkuExample example);

    int updateByExampleWithBLOBs(@Param("record") TProductSku record, @Param("example") TProductSkuExample example);

    int updateByExample(@Param("record") TProductSku record, @Param("example") TProductSkuExample example);

    int updateByPrimaryKeySelective(TProductSku record);

    int updateByPrimaryKeyWithBLOBs(TProductSku record);

    int updateByPrimaryKey(TProductSku record);
}