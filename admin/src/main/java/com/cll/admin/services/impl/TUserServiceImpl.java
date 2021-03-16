package com.cll.admin.services.impl;

import com.cll.admin.services.MyUserDetailsService;
import com.cll.admin.services.TUserService;
import com.cll.admin.utils.JwtUtil;
import com.cll.mbg.mapper.TUserMapper;
import com.cll.mbg.model.TUser;
import com.cll.mbg.model.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    MyUserDetailsService userDetailsService;
    @Autowired
    TUserMapper tUserMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public int register(String tel, String pass) {
        TUserExample example = new TUserExample();
         example.createCriteria().andTelEqualTo(tel);
        if (!tUserMapper.selectByExample(example).isEmpty()){return 0;}
        TUser user = new TUser();
        user.setTel(tel);
        user.setPass(passwordEncoder.encode(pass));
        user.setNickname("TUser" + (int) ((Math.random() * 9 + 1) * 1000));
        user.setCreateTime(new Date());
        int insert = tUserMapper.insert(user);
        return insert;
    }

    @Override
    public String login(String tel, String pass) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(tel);
            if(!passwordEncoder.matches(pass,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = JwtUtil.generateToken(userDetails.getUsername());
//            updateLoginTimeByUsername(username);
            //insertLoginLog(username);
        } catch (AuthenticationException e) {
            System.out.println("登录异常:{}" + e.getMessage());
        }
        return token;

    }
    public User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
