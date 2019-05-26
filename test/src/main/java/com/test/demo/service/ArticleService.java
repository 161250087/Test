package com.test.demo.service;

import com.test.demo.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleService {
    public void AddHot(int article_id);

    public List<Article> findArticle(String findstr);

    public List<Article> findFreshArticle(String findstr);

    public List<Article> freshArticle();

    public List<Article> allArticle();
}
