package com.test.test;

import com.test.test.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    public MailService mailService;

    @Test
    public void test() throws Exception{
        /*User u = new User("123","456","madi2009@126.com");
        int an =userService.loginConfig(u);
        if(an>0) System.out.print("FFFF");
        else System.out.print("TTTT");*/
    }

    @Test
    public void test1() throws  Exception{
        mailService.sendSimpleMail("1293086146@qq.com","FUCK","FUCK");
    }
}
