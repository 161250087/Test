package com.test.demo.controller;


import com.test.demo.entity.User;
import com.test.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     *@Author : LML
     *@Date : 15:49 2019/5/26
     *@Desciption : 登录的方法
     * @param username
     * @param password
     *@return : 如果成功返回userID 失败的话返回-1
     */
    @PostMapping("/login/{username}/{password}")
    public int login(@PathVariable String username,@PathVariable String password){
        System.out.println("login"+username+password);
        User u = new User(username,password);
        return loginService.loginConfig(u);
    }


    /**
     *@Author : LML
     *@Date : 15:49 2019/5/26
     *@Desciption : 注册的方法
     * @param username
     * @param password
     *@return : 无返回
     */
    @PostMapping("/register/{username}/{password}")
    public void register(@PathVariable String username,@PathVariable  String password){
        System.out.println(username+password);
        User u = new User(username,password);
        loginService.addUser(u);
    }


    /**
     *@Author : LML
     *@Date : 15:49 2019/5/26
     *@Desciption : 检查username是否可用的方法
     * @param username
     *@return : 如果username可用，返回true 反之，false
     */
    @PostMapping("/check/{username}")
    public boolean checkUserName(@PathVariable String username){
        if(loginService.findUserByName(username)==-1)
            return true;
        return false;
    }
}
