package com.test.demo.service;

import com.test.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginService {
    //登录验证
    public int loginConfig(User user);

    //通过id得到用户信息
    public User findUserById(int id);

    //新增用户
    public int addUser(User user);

    //通过姓名得到用户信息
    public int findUserByName(String username);
}
