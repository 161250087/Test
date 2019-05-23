package com.test.test.serviceImpl;

import com.test.test.dao.UserRepository;
import com.test.test.entity.User;
import com.test.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public int loginConfig(User user) {
        User newUser = userRepository.userConfig(user.getName(),user.getPassword());
        if(newUser==null) return -1;
        else return user.getId();
    }

    @Override
    public User findUserById(int id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public String addUser(User user) {
        userRepository.addUser(user.getName(),user.getPassword(),user.getMail());
        return null;
    }
}
