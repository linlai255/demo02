package com.cll.mbg.mapper;

import com.cll.mbg.model.TokenBlacklist;
import com.cll.mbg.model.TokenBlacklistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TokenBlacklistMapper {
    long countByExample(TokenBlacklistExample example);

    int deleteByExample(TokenBlacklistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TokenBlacklist record);

    int insertSelective(TokenBlacklist record);

    List<TokenBlacklist> selectByExample(TokenBlacklistExample example);

    TokenBlacklist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TokenBlacklist record, @Param("example") TokenBlacklistExample example);

    int updateByExample(@Param("record") TokenBlacklist record, @Param("example") TokenBlacklistExample example);

    int updateByPrimaryKeySelective(TokenBlacklist record);

    int updateByPrimaryKey(TokenBlacklist record);
}