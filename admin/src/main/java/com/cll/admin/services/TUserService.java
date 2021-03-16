package com.cll.admin.services;

public interface TUserService {
    int register(String tel, String pass);

    String login(String tel, String pass);
}
