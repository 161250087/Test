package com.test.demo.serviceImpl;

import com.test.demo.dao.ArticleDao;
import com.test.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void AddHot(int article_id){
        articleDao.AddHot(article_id);
    }
}
