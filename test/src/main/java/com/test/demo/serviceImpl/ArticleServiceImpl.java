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
    //依赖注入
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private Article_tagDao article_tagDao;
    @Autowired
    private UserDao userDao;

    //网页访问，热度增加
    public void AddHot(int article_id){
        articleDao.AddHot(article_id);
    }

    //通过文章id得到文章信息
    @Override
    public Article findArticleById(int article_id) {
        return articleDao.findById(article_id);
    }

    //通过文章id得到tag
    @Override
    public List<String> findArticleTagById(int article_id) {
        return article_tagDao.findTagById(article_id);
    }

    //通过搜索关键词得到相应的文章列表
    @Override
    public List<Article> findArticle(String findstr) {
        return articleDao.findArticleByStr("%"+findstr+"%");
    }

    //通过搜索关键词得到未结束的相应的文章列表
    @Override
    public List<Article> findFreshArticle(String findstr) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleByStr("%"+findstr+"%",timestamp);
    }

    //通过搜索关键词得到相应的文章列表，选取需要的行数输出，用于分页
    @Override
    public List<Article> findArticlePage(String findstr, int start, int length) {
        return articleDao.findArticleByStrPage("%"+findstr+"%",start,length);
    }

    //通过搜索关键词得到未结束的相应的文章列表，选取需要的行数输出，用于分页
    @Override
    public List<Article> findFreshArticlePage(String findstr, int start, int length) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleByStrPage("%"+findstr+"%",start,length,timestamp);
    }

    //通过搜索关键词得到相应的文章的数量
    @Override
    public int findArticleNum(String findstr) {
        return articleDao.findArticleByStrNum("%"+findstr+"%");
    }

    //通过搜索关键词得到未结束的相应的文章的数量
    @Override
    public int findFreshArticleNum(String findstr) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleByStrNum("%"+findstr+"%",timestamp);
    }

    //通过搜索关键词得到相应的热点文章（5篇）
    @Override
    public List<Article> findHotArticle(String findstr) {
        return articleDao.findHotArticleByStr("%"+findstr+"%");
    }

    //通过搜索关键词得到未结束的相应的热点文章（5篇）
    @Override
    public List<Article> findFreshHotArticle(String findstr) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshHotArticleByStr("%"+findstr+"%",timestamp);
    }

    //未结束的文章的数量
    @Override
    public int freshArticleNum() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshAllNum(timestamp);
    }

    //未结束的文章列表
    @Override
    public List<Article> freshArticle() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshAll(timestamp);
    }

    //所有文章列表
    @Override
    public List<Article> allArticle() {
        return articleDao.findAll();
    }

    //未结束的相应的文章列表，选取需要的行数输出，用于分页
    @Override
    public List<Article> freshArticlePage(int start, int length) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshAllPage(start,length,timestamp);
    }
}
