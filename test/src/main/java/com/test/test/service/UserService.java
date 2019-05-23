package com.test.test.service;

import com.test.test.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public int loginConfig (User user);

    public User findUserById(int id);

    public User findUserByName(String name);

    public boolean addUser(User user);
}
