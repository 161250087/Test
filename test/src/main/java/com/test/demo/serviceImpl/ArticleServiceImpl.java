package com.test.demo.serviceImpl;

import com.test.demo.dao.ArticleDao;
import com.test.demo.dao.Article_tagDao;
import com.test.demo.dao.UserDao;
import com.test.demo.entity.Article;
import com.test.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private Article_tagDao article_tagDao;
    @Autowired
    private UserDao userDao;

    public void AddHot(int article_id){
        articleDao.AddHot(article_id);
    }

    @Override
    public List<Article> findArticle(String findstr) {
        return articleDao.findArticleByStr(findstr);
    }

    @Override
    public List<Article> findFreshArticle(String findstr) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleByStr(findstr,timestamp);
    }

    @Override
    public List<Article> findArticlePage(String findstr, int start, int length) {
        return articleDao.findArticleByStrPage(findstr,start,length);
    }

    @Override
    public List<Article> findFreshArticlePage(String findstr, int start, int length) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleByStrPage(findstr,start,length,timestamp);
    }

    private boolean tag(String findstr,int article_id){
        List<String> sl = article_tagDao.findTagById(article_id);
        for(String s:sl)
            if(s.contains(findstr))
                return true;
        return false;
    }

    @Override
    public int findArticleNum(String findstr) {
        return articleDao.findArticleByStrNum(findstr);
    }

    @Override
    public int findFreshArticleNum(String findstr) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleByStrNum(findstr,timestamp);
    }

    @Override
    public List<Article> findHotArticle(String findstr) {
        return articleDao.findHotArticleByStr(findstr);
    }

    @Override
    public List<Article> findFreshHotArticle(String findstr) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshHotArticleByStr(findstr,timestamp);
    }

    @Override
    public int freshArticleNum() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshAllNum(timestamp);
    }

    @Override
    public List<Article> freshArticle() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshAll(timestamp);
    }

    @Override
    public List<Article> allArticle() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> freshArticlePage(int start, int length) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshAllPage(start,length,timestamp);
    }
}
