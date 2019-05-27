package com.test.demo.service;

import com.test.demo.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleService {
    //网页访问，热度增加
    public void AddHot(int article_id);

    //通过文章id得到文章信息
    public Article findArticleById(int article_id);

    //通过文章id得到文章tag
    public List<String> findArticleTagById(int article_id);

    //通过搜索关键词得到相应的文章列表
    public List<Article> findArticle(String findstr);

    //通过搜索关键词得到未结束的相应的文章列表
    public List<Article> findFreshArticle(String findstr);

    //通过搜索关键词得到相应的文章列表，选取需要的行数输出，用于分页
    public List<Article> findArticlePage(String findstr, int start, int length);

    //通过搜索关键词得到未结束的相应的文章列表，选取需要的行数输出，用于分页
    public List<Article> findFreshArticlePage(String findstr, int start, int length);

    //通过搜索关键词得到相应的文章的数量
    public int findArticleNum(String findstr);

    //通过搜索关键词得到未结束的相应的文章的数量
    public int findFreshArticleNum(String findstr);

    //通过搜索关键词得到相应的热点文章（5篇）
    public List<Article> findHotArticle(String findstr);

    //通过搜索关键词得到未结束的相应的热点文章（5篇）
    public List<Article> findFreshHotArticle(String findstr);

    //未结束的文章的数量
    public int freshArticleNum();

    //未结束的文章列表
    public List<Article> freshArticle();

    //所有文章列表
    public List<Article> allArticle();

    //未结束的相应的文章列表，选取需要的行数输出，用于分页
    public List<Article> freshArticlePage(int start, int length);
}
