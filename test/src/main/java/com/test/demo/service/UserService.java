package com.test.demo.service;

import com.test.demo.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    public List<Article> getAllArticle();

    public List<Article> sortByHot(List<Article> articleList);
}
