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

    @Query(value="select * from article whereend > ?1",nativeQuery = true)
    public List<Article> findFreshAll(Timestamp timestamp);

    @Query(value="select * from article limit ?1,?2",nativeQuery = true)
    public List<Article> findSome(int start,int length);

    @Query(value="select * from article where end < ?1",nativeQuery = true)
    public List<Article> findAllFresh(Timestamp timestamp);

    @Query(value="select * from article where end < ?3 limit ?1,?2",nativeQuery = true)
    public List<Article> findSomeFresh(int start,int length,Timestamp timestamp);

    @Query(value="select count(*) as num from article where end < ?3 limit ?1,?2",nativeQuery = true)
    public int findSomeFreshNum(int start,int length,Timestamp timestamp);

    @Modifying
    @Transactional
    @Query(value="insert into article(title,content,author,hot,publish_time,start,end) values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    public int addArticle(String title, String content, String author, int hot, Timestamp publish_time, Timestamp start, Timestamp end);

    @Modifying
    @Transactional
    @Query(value="update article set hot = hot+1 where id=?1",nativeQuery = true)
    public void AddHot(int id);

    @Query(value="select a.* from article a,article_tag atg where a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1)",nativeQuery = true)
    public List<Article> findArticleByStr(String findser);

    @Query(value="select count(a.*) from article a,article_tag atg where a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1)",nativeQuery = true)
    public int findArticleByStrNum(String findstr);

    @Query(value="select a.* from article a,article_tag atg where a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1) limit ?2,?3",nativeQuery = true)
    public List<Article> findArticleByStrPage(String findser,int start,int length);

    @Query(value="select a.* from article a,article_tag atg where (a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1)) and end > ?2",nativeQuery = true)
    public List<Article> findFreshArticleByStr(String findser,Timestamp timestamp);

    @Query(value="select count(a.*) from article a,article_tag atg where (a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1)) and end >?2",nativeQuery = true)
    public int findFreshArticleByStrNum(String findstr,Timestamp timestamp);

    @Query(value="select a.* from article a,article_tag atg where (a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1)) and end >?4 limit ?2,?3",nativeQuery = true)
    public List<Article> findFreshArticleByStrPage(String findser,int start,int length,Timestamp timestamp);

    @Query(value="select a.* from article a,article_tag atg where a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1) order by hot desc limit 0,5",nativeQuery = true)
    public List<Article> findHotArticleByStr(String findser);

    @Query(value="select a.* from article a,article_tag atg where (a.title like ?1 or a.author like ?1 or (a.id=atg.article_id and atg.tag like ?1)) and end > ?2 order by hot desc limit 0,5",nativeQuery = true)
    public List<Article> findFreshHotArticleByStr(String findser,Timestamp timestamp);
}
