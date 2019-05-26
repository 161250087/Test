package com.test.demo.service;

import com.test.demo.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    public List<Article> getAllArticle();

    public List<Article> getFreshArtiche();

    public List<Article> sortByHot(List<Article> articleList);

    public int addTag(int user_id,String tag);

    public void deleteTag(int user_id,String tag);

    public List<String> getAllTag();

    public List<String> getMyTag(int user_id);

    public int addCollection(int user_id,int article_id);

    public void deleteCollection(int user_id,int article_id);

    public List<Article> getMyCollection(int user_id);

    public List<Article> getMyFreshCollection(int user_id);

    public int addSubscribe(int user_id,String author);

    public void deleteSubscribe(int user_id,String author);

    public List<String> getMySubscribe(int user_id);

    public List<Article> getMySubscribe_Article(int user_id);

    public List<Article> getMyFreshSubscribe_Article(int user_id);
}
