package com.test.demo.serviceImpl;

import com.test.demo.dao.ArticleDao;
import com.test.demo.dao.Article_tagDao;
import com.test.demo.dao.UserDao;
import com.test.demo.entity.Article;
import com.test.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Article> al=articleDao.findAll();
        List<Article> anlist = new ArrayList();
        for(Article a:al){
            if(a.getTitle().contains(findstr)||a.getAuthor().contains(findstr)||tag(findstr,a.getId()))
                anlist.add(a);
        }
        return anlist;
    }

    private boolean tag(String findstr,int article_id){
        List<String> sl = article_tagDao.findTagById(article_id);
        for(String s:sl)
            if(s.contains(findstr))
                return true;
        return false;
    }

    @Override
    public List<Article> findFreshArticle(String findstr) {
        List<Article> al=findArticle(findstr);

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
    public int findArticleNum(String findstr) {
        return userDao.findArticleByStrNum(findstr);
    }

    @Override
    public List<Article> freshArticle() {
        List<Article> al=articleDao.findAll();

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
    public List<Article> allArticle() {
        return articleDao.findAll();
    }
}
