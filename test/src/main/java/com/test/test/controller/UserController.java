package com.test.test.controller;

import com.test.test.entity.User;
import com.test.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/loginVerify")
    public String loginVerify(String username,String password){
        User u = new User();
        u.setName(username);
        u.setPassword(password);

        int an = userService.loginConfig(u);

        if(an>0){
            System.out.print("TTTT");
            return "login";
        }
        else{
            System.out.print("FFFF");
            return "Wrong!";
        }

    }
}
