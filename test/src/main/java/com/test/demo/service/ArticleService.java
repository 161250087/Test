package com.test.demo.service;

import com.test.demo.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleService {
    public void AddHot(int article_id);

    public List<Article> findArticle(String findstr);

    public List<Article> findFreshArticle(String findstr);

    public List<Article> findArticlePage(String findstr,int start,int length);

    public List<Article> findFreshArticlePage(String findstr, int start, int length);

    public int findArticleNum(String findstr);

    public int findFreshArticleNum(String findstr);

    public List<Article> findHotArticle(String findstr);

    public List<Article> findFreshHotArticle(String findstr);

    public int freshArticleNum();

    public List<Article> freshArticle();

    public List<Article> allArticle();

    public List<Article> freshArticlePage(int start,int length);
}
