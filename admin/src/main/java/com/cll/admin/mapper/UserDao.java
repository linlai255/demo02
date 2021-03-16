package com.cll.admin.mapper;

import com.cll.mbg.model.TokenBlacklist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    TokenBlacklist getToken(String token);
}
