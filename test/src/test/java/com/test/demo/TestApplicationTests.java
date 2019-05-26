package com.test.demo;

import com.test.demo.dao.ArticleDao;
import com.test.demo.dao.Article_tagDao;
import com.test.demo.dao.CollectionDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    public ArticleDao articleDao;

    @Autowired
    public Article_tagDao article_tagDao;

    @Autowired
    public CollectionDao collectionDao;

    @Test
    public void test() throws Exception{
        /*User u = new User("123","456","madi2009@126.com");
        int an =userService.loginConfig(u);
        if(an>0) System.out.print("FFFF");
        else System.out.print("TTTT");*/
    }

    @Test
    public void test1() throws  Exception{
        //mailService.sendSimpleMail("1293086146@qq.com","FUCK","FUCK");
        Assert.assertEquals("","");
    }

    @Test
    public void test2() throws  Exception{
        /*Timestamp timeStamp = new Timestamp(new Date().getTime());
        articleDao.addArticle("题目","内容","作者",0,timeStamp,timeStamp,timeStamp);*/
        //System.out.print(articleDao.findAll().get(0).getAuthor());

        List<Object> list =collectionDao.findArticleById(1);
        //System.out.print(System.out.printf(list.get(0));
    }
}
