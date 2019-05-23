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
        User u = userRepository.userConfig(user.getName(),user.getPassword());
        if(u==null) return -1;
        else return u.getId();
    }

    @Override
    public User findUserById(int id) {
        User u = userRepository.findById(id);
        return u;
    }
}
