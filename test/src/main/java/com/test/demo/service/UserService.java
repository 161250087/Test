package com.test.demo.service;

import com.test.demo.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    //获取所有文章
    public List<Article> getAllArticle();

    //获取全部文章数量
    public int getArticleNum();

    //文章分页显示，通过起始行以及页长分页
    public List<Article> getAllArticlePage(int start, int end);

    //给用户加标签
    public int addTag(int user_id, String tag);

    //删除用户标签
    public void deleteTag(int user_id, String tag);

    //获取所有用户标签
    public List<String> getAllTag();

    //获取指定用户标签
    public List<String> getMyTag(int user_id);

    //添加收藏
    public int addCollection(int user_id, int article_id);

    //删除收藏
    public void deleteCollection(int user_id, int article_id);

    //获取指定用户收藏
    public List<Article> getMyCollection(int user_id);

    //获取指定用户未过期收藏
    public List<Article> getMyFreshCollection(int user_id);

    //添加订阅
    public int addSubscribe(int user_id, String author);

    //取消订阅
    public void deleteSubscribe(int user_id, String author);

    //获取指定用户订阅
    public List<String> getMySubscribe(int user_id);

    //获取指定用户订阅作者的所有文章
    public List<Article> getMySubscribe_Article(int user_id);

    //获取指定用户订阅作者的所有未过时文章
    public List<Article> getMyFreshSubscribe_Article(int user_id);
    //消息推送，已开始以及两天内开始
    public List<Article> remindMessage(int user_id);
    //根据用户爱好推送热点
    public List<Article> hotPush(int user_id);
}
