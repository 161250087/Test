package com.test.demo.serviceImpl;

import com.test.demo.dao.ArticleDao;
import com.test.demo.dao.UserDao;
import com.test.demo.entity.Article;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> getAllArticle() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> sortByHot(List<Article> articleList) {
        List<Article> list = articleList;
        Collections.sort(list, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.getHot()>o2.getHot()?1:0;
            }
        });
        return list;
    }


}
