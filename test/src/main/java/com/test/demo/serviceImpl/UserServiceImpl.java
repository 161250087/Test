package com.test.demo.serviceImpl;

import com.test.demo.dao.*;
import com.test.demo.entity.Article;
import com.test.demo.entity.User_tag;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {
    //依赖注入
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

    //获取所有文章
    @Override
    public List<Article> getAllArticle() {
        return articleDao.findAll();
    }

    //获取全部文章数量
    @Override
    public int getArticleNum() {
        return articleDao.findAllNum();
    }

    //文章分页显示，通过起始行以及页长分页
    @Override
    public List<Article> getAllArticlePage(int start, int end) {
        return articleDao.findSome(start, end);
    }

    //给用户加标签
    @Override
    public int addTag(int user_id, String tag) {
        List<String> sl = user_tagDao.findTagById(user_id);
        if (sl.contains(tag)) return -1;
        else {
            user_tagDao.addUser_tag(user_id, tag);
            return 1;
        }
    }

    //删除用户标签
    @Override
    public void deleteTag(int user_id, String tag) {
        user_tagDao.deleteUser_tag(user_id, tag);
    }

    //获取所有用户标签
    @Override
    public List<String> getAllTag() {
        List<String> sl = new ArrayList<>();
        for (User_tag ut : user_tagDao.findAll())
            if (!sl.contains(ut.getTag()))
                sl.add(ut.getTag());
        return sl;
    }

    //获取指定用户标签
    @Override
    public List<String> getMyTag(int user_id) {
        return user_tagDao.findTagById(user_id);
    }

    //添加收藏
    @Override
    public int addCollection(int user_id, int article_id) {
        List<Integer> il = collectionDao.findCollectionByUser_id(user_id);
        if (il.contains(article_id)) return -1;
        else {
            collectionDao.addCollection(user_id, article_id);
            return 1;
        }
    }


    //删除收藏
    @Override
    public void deleteCollection(int user_id, int article_id) {
        collectionDao.deleteCollection(user_id, article_id);
    }

    //获取指定用户收藏
    @Override
    public List<Article> getMyCollection(int user_id) {
        return userDao.findArticleById(user_id);
    }

    //获取指定用户未过期收藏
    @Override
    public List<Article> getMyFreshCollection(int user_id) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleById(user_id, timestamp);
    }

    //添加订阅
    @Override
    public int addSubscribe(int user_id, String author) {
        List<String> sl = subscribeDao.findAuthorByUser_id(user_id);
        if (sl.contains(author)) return -1;
        else {
            subscribeDao.addSubscribe(user_id, author);
            return 1;
        }
    }

    //取消订阅
    @Override
    public void deleteSubscribe(int user_id, String author) {
        subscribeDao.deleteSubscribe(user_id, author);
    }

    //获取指定用户订阅
    @Override
    public List<String> getMySubscribe(int user_id) {
        return subscribeDao.findAuthorByUser_id(user_id);
    }

    //获取指定用户订阅作者的所有文章
    @Override
    public List<Article> getMySubscribe_Article(int user_id) {
        return userDao.findArticleByAuthor(user_id);
    }

    //获取指定用户订阅作者的所有未过时文章
    @Override
    public List<Article> getMyFreshSubscribe_Article(int user_id) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return articleDao.findFreshArticleBySubscribe(user_id, timestamp);
    }

    //消息推送，已开始以及两天内开始
    @Override
    public List<Article> remindMessage(int user_id) {
        Date date = new Date();
        List<Article> articleList = new ArrayList();

        List<Article> subscribeList = getMyFreshSubscribe_Article(user_id);
        List<Article> collectionList = getMyFreshCollection(user_id);
        addToArticle(articleList, subscribeList);
        addToArticle(articleList, collectionList);
        return articleList;
    }
    //根据用户爱好推送热点
    @Override
    public List<Article> hotPush(int user_id) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        List<String> tagList =getMyTag(user_id);
        List<Article> resultList=new ArrayList();

        if(tagList.size()==0){
            return articleDao.hotFreshArticle(timestamp);
        }else if(tagList.size()==1){
            int dlength =5- articleDao.findFreshHotArticleByStr(tagList.get(0),timestamp).size();
            resultList=articleDao.findFreshHotArticleByStr(tagList.get(0),timestamp);
            List<Article> hotList = articleDao.hotFreshArticle(timestamp);
            for(int i=0;i<dlength;i++)
                resultList.add(hotList.get(i));
            return resultList;
        }else{
            List<Article> hotList = new ArrayList();
            for(int i=1;i<tagList.size();i++){
                List<Article> addList = articleDao.findFreshHotArticleByStr(tagList.get(i),timestamp);
                for(int n=0;n<addList.size();n++){
                    for(Article a:addList)
                        hotList.add(addList.get(n));
                }
            }

            if(hotList.size()<5){
                int dlength =5- hotList.size();
                resultList=hotList;
                List<Article> hotList1 = articleDao.hotFreshArticle(timestamp);
                for(int i=0;i<dlength;i++)
                    resultList.add(hotList1.get(i));
                return resultList;
            }else{
                Collections.sort(hotList, new Comparator<Article>() {
                    @Override
                    public int compare(Article o1, Article o2) {
                        return o1.getHot()>o2.getHot()?1:-1;
                    }
                });
                for(int i=0;i<5;i++)
                    resultList.add(hotList.get(i));

                return resultList;
            }
        }
    }

    private List<Article> addToArticle(List<Article> resultList, List<Article> aimList) {
        if(aimList.size()==0) return resultList;
        Date date = new Date();

        for (Article a : aimList) {
            Date artDate = a.getStart();
            if (artDate.before(date)) {
                if (!resultList.contains(a)) resultList.add(a);
            } else if ((a.getEnd().getTime() - date.getTime()) / (3600000 * 24) <= 2) {
                if (!resultList.contains(a)) resultList.add(a);
            }
        }

        return resultList;
    }
}
