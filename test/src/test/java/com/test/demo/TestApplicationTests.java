package com.test.demo;

import com.test.demo.dao.*;
import com.test.demo.entity.Article;
import com.test.demo.serviceImpl.ArticleServiceImpl;
import com.test.demo.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public ArticleServiceImpl articleService;
    @Autowired
    public ArticleDao articleDao;

    @Autowired
    public Article_tagDao article_tagDao;

    @Autowired
    public CollectionDao collectionDao;

    @Autowired
    public SubscribeDao subscribeDao;

    @Autowired
    public User_tagDao user_tagDao;

    @Test
    public void test() throws Exception{
        /*User u = new User("123","456","madi2009@126.com");
        int an =userService.loginConfig(u);
        if(an>0) System.out.print("FFFF");
        else System.out.print("TTTT");*/
    }

    @Test
    public void test1() throws  Exception{
        //subscribeDao.deleteSubscribe(1,"作者1");
        for(Article a:userService.sortByHot(userService.getAllArticle()))
            System.out.println(a.getTitle());
    }

    @Test
    public void test2() throws  Exception{
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        articleDao.addArticle("题目1","内容1","作者1",5,timeStamp,timeStamp,timeStamp);
        articleDao.addArticle("题目2","内容2","作者2",15,timeStamp,timeStamp,timeStamp);
        articleDao.addArticle("题目3","内容3","作者3",7,timeStamp,timeStamp,timeStamp);
        //System.out.print(articleDao.findAll().get(0).getAuthor());
        //collectionDao.deleteCollection(1,2);
        //article_tagDao.addArticle_tag(1,"运动1");
        //subscribeDao.addSubscribe(1,"作者1");
        //user_tagDao.addUser_tag(1,"运动1");
        //articleService.AddHot(1);
    }
}
