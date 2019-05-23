package com.test.test.service;

import com.test.test.dao.UserRepository;
import com.test.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @Override
    public int loginConfig(User user) {
        User u = userRepository.userConfig(user.getName(),user.getPassword());
        if(u==null) return -1;
        else return u.getId();
    }

    @Override
    public User findUserById(int id) {
        User u = userRepository.findById(id);
        return u;
    }

    @Override
    public User findUserByName(String name) {
        User u = userRepository.findByName(name);
        return u;
    }

    @Override
    public boolean addUser(User user) {
        try{
            userRepository.addUser(user.getName(),user.getPassword(),user.getMail());
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
