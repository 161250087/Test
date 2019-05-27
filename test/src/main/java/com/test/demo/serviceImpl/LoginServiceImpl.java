package com.test.demo.serviceImpl;

import com.test.demo.dao.UserDao;
import com.test.demo.entity.User;
import com.test.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    //依赖注入
    @Autowired
    UserDao userDao;

    //登录验证
    @Override
    public int loginConfig(User user) {
        User newUser = userDao.userConfig(user.getName(),user.getPassword());
        if(newUser==null) return -1;
        else return newUser.getId();
    }

    //通过id得到用户信息
    @Override
    public User findUserById(int id) {
        return userDao.findById(id);
    }

    //新增用户
    @Override
    public int addUser(User user) {
        if(userDao.findByName(user.getName())!=null)
            return -1;
        return userDao.addUser(user.getName(),user.getPassword());
    }

    //通过姓名得到用户信息
    @Override
    public int findUserByName(String username) {
        if(userDao.findByName(username)!=null)
            return -1;
        return 1;
    }
}
