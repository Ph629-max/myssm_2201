package com.bigdata.service;


import com.bigdata.entity.User;

import java.util.List;

public interface UserService {
    User queryUserByUsername(String username) throws Exception;

    List<User> queryUsers() throws Exception;

    int regist(String username, String pwd, int gender);

    int login(String username, String pwd);

//     PageInfo<User> queryUserPage(Page page) throws Exception;
}
