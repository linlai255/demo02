package com.cll.mbg.mapper;

import com.cll.mbg.model.TService;
import com.cll.mbg.model.TServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TServiceMapper {
    long countByExample(TServiceExample example);

    int deleteByExample(TServiceExample example);

    int deleteByPrimaryKey(Integer servId);

    int insert(TService record);

    int insertSelective(TService record);

    List<TService> selectByExample(TServiceExample example);

    TService selectByPrimaryKey(Integer servId);

    int updateByExampleSelective(@Param("record") TService record, @Param("example") TServiceExample example);

    int updateByExample(@Param("record") TService record, @Param("example") TServiceExample example);

    int updateByPrimaryKeySelective(TService record);

    int updateByPrimaryKey(TService record);
}