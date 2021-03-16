package com.cll.admin.controller;

import com.cll.admin.services.MyUserDetailsService;
import com.cll.admin.services.TUserService;
import com.cll.common.CommonResult;
import com.cll.mbg.mapper.TokenBlacklistMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    TokenBlacklistMapper tokenBlacklistMapper;
    @Autowired
    MyUserDetailsService userDetailsService;
    @Autowired
    TUserService tUserService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "注册")
    public CommonResult register(String tel , String pass ){
        int code = tUserService.register(tel, pass);
       if (code == 0){ return CommonResult.failed("该手机号已注册"); }
       return CommonResult.success("注册成功");
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登录")
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password){
        String token = tUserService.login(username , password);
        try {
            if (token.isEmpty()){}
        }catch (NullPointerException e){
            return CommonResult.loginFailed();
        }
        catch (Exception e){
            return CommonResult.failed("登录失败");
        }
        return CommonResult.success("登录成功",token);
    }
    @RequestMapping("/test")
    @ResponseBody
    @Ignore
    public void test(String username){
        System.out.println("执行test");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
    }

    /**
     * 需要前端删除token
     */
    @ApiOperation(value = "注销")
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public void logout(){
    }
}
