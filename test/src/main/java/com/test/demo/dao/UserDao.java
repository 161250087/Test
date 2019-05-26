package com.test.demo.dao;

import com.test.demo.entity.Article;
import com.test.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    public User findById(int id);

    public User findByName(String name);

    public List<User> findAll();

    @Query("from User where name=?1 and password=?2")
    public User userConfig(String name,String password);

    @Modifying
    @Transactional
    @Query(value="insert into user(name,password) values(?1,?2)",nativeQuery = true)
    public int addUser(String name,String password);

    @Query("select a from Collection c,Article a where c.user_id=?1 and c.article_id = a.id")
    public List<Article> findArticleById(int id);

    @Query("select a from Subscribe s,Article a where s.user_id=?1 and s.author = a.author")
    public List<Article> findArticleByAuthor(int id);

    @Query("select count(a) as number from Subscribe s,Article a where s.user_id=?1 and s.author = a.author")
    public int findArticleByAuthorNum(int id);

    @Query(value="select a.* from article a,article_tag atg where a.title like '%fidnstr%' or a.author like '%findser%' or (a.id=atg.article_id and atg.tag like '%findser%')",nativeQuery = true)
    public List<Article> findArticleByStr(@Param("findstr") String findser);

    @Query(value="select count(a.*) from article a,article_tag atg where a.title like '%findstr%' or a.author like '%findser%' or (a.id=atg.article_id and atg.tag like '%findser%')",nativeQuery = true)
    public int findArticleByStrNum(@Param("findstr") String findstr);
}
