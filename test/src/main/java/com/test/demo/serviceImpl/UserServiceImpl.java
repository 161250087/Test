package com.test.demo.serviceImpl;

import com.test.demo.dao.*;
import com.test.demo.entity.Article;
import com.test.demo.entity.User_tag;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private User_tagDao user_tagDao;
    @Autowired
    private CollectionDao collectionDao;
    @Autowired
    private SubscribeDao subscribeDao;

    @Override
    public List<Article> getAllArticle() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> getFreshArtiche() {
        List<Article> al= articleDao.findAll();

        Date date = new Date();
        for(Article a:al)
            if(date.after(a.getEnd()))
                al.remove(a);

        Collections.sort(al, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                Date d1 = o1.getStart(),d2=o2.getStart();
                if(d1.after(d2))
                    return 1;
                return -1;
            }
        });
        return al;
    }

    @Override
    public List<Article> sortByHot(List<Article> articleList) {
        List<Article> list = articleList;
        Collections.sort(list, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.getHot()>o2.getHot()?1:-1;
            }
        });
        return list;
    }

    @Override
    public int addTag(int user_id, String tag) {
        List<String> sl = user_tagDao.findTagById(user_id);
        if(sl.contains(tag)) return -1;
        else{
            user_tagDao.addUser_tag(user_id,tag);
            return 1;
        }
    }

    @Override
    public void deleteTag(int user_id, String tag) {
        user_tagDao.deleteUser_tag(user_id,tag);
    }

    @Override
    public List<String> getAllTag() {
        List<String> sl = new ArrayList<>();
        for(User_tag ut:user_tagDao.findAll())
            if(!sl.contains(ut.getTag()))
                sl.add(ut.getTag());
        return sl;
    }

    @Override
    public List<String> getMyTag(int user_id) {
        return user_tagDao.findTagById(user_id);
    }

    @Override
    public int addCollection(int user_id, int article_id) {
        List<Integer> il = collectionDao.findCollectionByUser_id(user_id);
        if(il.contains(article_id)) return -1;
        else{
            collectionDao.addCollection(user_id,article_id);
            return 1;
        }
    }

    @Override
    public void deleteCollection(int user_id, int article_id) {
        collectionDao.deleteCollection(user_id,article_id);
    }

    @Override
    public List<Article> getMyCollection(int user_id) {
        return userDao.findArticleById(user_id);
    }

    @Override
    public List<Article> getMyFreshCollection(int user_id) {
        List<Article> al= userDao.findArticleById(user_id);

        Date date = new Date();
        for(Article a:al)
            if(date.after(a.getEnd()))
                al.remove(a);

        Collections.sort(al, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                Date d1 = o1.getStart(),d2=o2.getStart();
                if(d1.after(d2))
                return 1;
                return -1;
            }
        });
        return al;
    }

    @Override
    public int addSubscribe(int user_id, String author) {
        List<String> sl = subscribeDao.findAuthorByUser_id(user_id);
        if(sl.contains(author)) return -1;
        else{
            subscribeDao.addSubscribe(user_id,author);
            return 1;
        }
    }

    @Override
    public void deleteSubscribe(int user_id, String author) {
        subscribeDao.deleteSubscribe(user_id,author);
    }

    @Override
    public List<String> getMySubscribe(int user_id) {
        return subscribeDao.findAuthorByUser_id(user_id);
    }

    @Override
    public List<Article> getMySubscribe_Article(int user_id) {
        return userDao.findArticleByAuthor(user_id);
    }

    @Override
    public List<Article> getMyFreshSubscribe_Article(int user_id) {
        List<Article> al= userDao.findArticleByAuthor(user_id);

        Date date = new Date();
        for(Article a:al)
            if(date.after(a.getEnd()))
                al.remove(a);

        Collections.sort(al, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                Date d1 = o1.getStart(),d2=o2.getStart();
                if(d1.after(d2))
                    return 1;
                return -1;
            }
        });
        return al;
    }
}
