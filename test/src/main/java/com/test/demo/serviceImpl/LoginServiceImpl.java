package com.test.demo.serviceImpl;

import com.test.demo.dao.UserDao;
import com.test.demo.entity.User;
import com.test.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;

    @Override
    public int loginConfig(User user) {
        User newUser = userDao.userConfig(user.getName(),user.getPassword());
        if(newUser==null) return -1;
        else return newUser.getId();
    }

    @Override
    public User findUserById(int id) {
        User user = userDao.findById(id);
        return user;
    }

    @Override
    public int addUser(User user) {
        if(userDao.findByName(user.getName())!=null)
            return -1;
        return userDao.addUser(user.getName(),user.getPassword());
    }
}
