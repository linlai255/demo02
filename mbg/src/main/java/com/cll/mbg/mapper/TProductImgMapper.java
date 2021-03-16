package com.cll.mbg.mapper;

import com.cll.mbg.model.TProductImg;
import com.cll.mbg.model.TProductImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductImgMapper {
    long countByExample(TProductImgExample example);

    int deleteByExample(TProductImgExample example);

    int deleteByPrimaryKey(Integer imgId);

    int insert(TProductImg record);

    int insertSelective(TProductImg record);

    List<TProductImg> selectByExample(TProductImgExample example);

    TProductImg selectByPrimaryKey(Integer imgId);

    int updateByExampleSelective(@Param("record") TProductImg record, @Param("example") TProductImgExample example);

    int updateByExample(@Param("record") TProductImg record, @Param("example") TProductImgExample example);

    int updateByPrimaryKeySelective(TProductImg record);

    int updateByPrimaryKey(TProductImg record);
}