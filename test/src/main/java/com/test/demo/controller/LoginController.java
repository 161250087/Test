package com.test.demo.controller;

import com.test.demo.entity.User;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;



    //注册用户
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response){
        System.out.print("zhuce trigger");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setMail(email);
        System.out.print("zhuce username"+name+ "password "+password);
        userService.addUser(user);
        return "";
    }

    @RequestMapping(value = "/loginVerify/{name}/{password}",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(@PathVariable String name,@PathVariable String password){
        System.out.print("logintrigger");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        System.out.print("denglu username"+name+ "password "+password);
        int id = userService.loginConfig(user);
        if(id == -1){
            return "false";
        }else{
            return ""+id;
        }
    }
}
