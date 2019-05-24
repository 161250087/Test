package com.test.demo.service;

import com.test.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    public int loginConfig(User user);

    public User findUserById(int id);

    public String addUser(User user);
}