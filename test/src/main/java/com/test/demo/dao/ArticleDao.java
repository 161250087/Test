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

    @Query("select count(id) as num from Article")
    public int findAllNum();

    @Query("from Article")
    public List<Article> findAll();

    @Query(value="select * from article limit ?1,?2",nativeQuery = true)
    public List<Article> findSome(int start,int length);

    @Modifying
    @Transactional
    @Query(value="insert into article(title,content,author,hot,publish_time,start,end) values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    public int addArticle(String title, String content, String author, int hot, Timestamp publish_time, Timestamp start, Timestamp end);

    @Modifying
    @Transactional
    @Query(value="update article set hot = hot+1 where id=?1",nativeQuery = true)
    public void AddHot(int id);
}
