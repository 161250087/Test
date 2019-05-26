package com.test.demo.dao;

import com.test.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Integer>{
    public Article findById(int id);

    @Query("from Article")
    public List<Article> findAll();

    @Modifying
    @Transactional
    @Query(value="insert into article(title,content,author,hot,publish_time,start,end) values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    public int addArticle(String title, String content, String author, int hot, Timestamp publish_time, Timestamp start, Timestamp end);
}
