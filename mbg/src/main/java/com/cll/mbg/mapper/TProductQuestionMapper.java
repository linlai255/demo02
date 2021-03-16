package com.cll.mbg.mapper;

import com.cll.mbg.model.TProductQuestion;
import com.cll.mbg.model.TProductQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductQuestionMapper {
    long countByExample(TProductQuestionExample example);

    int deleteByExample(TProductQuestionExample example);

    int deleteByPrimaryKey(Integer quesId);

    int insert(TProductQuestion record);

    int insertSelective(TProductQuestion record);

    List<TProductQuestion> selectByExample(TProductQuestionExample example);

    TProductQuestion selectByPrimaryKey(Integer quesId);

    int updateByExampleSelective(@Param("record") TProductQuestion record, @Param("example") TProductQuestionExample example);

    int updateByExample(@Param("record") TProductQuestion record, @Param("example") TProductQuestionExample example);

    int updateByPrimaryKeySelective(TProductQuestion record);

    int updateByPrimaryKey(TProductQuestion record);
}