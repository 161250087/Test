package com.test.demo.dao;

import com.test.demo.entity.Article;
import com.test.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    //id返回用户信息
    public User findById(int id);

    //姓名返回用户信息
    public User findByName(String name);

    //所有用户
    public List<User> findAll();

    //登录验证
    @Query("from User where name=?1 and password=?2")
    public User userConfig(String name, String password);

    //新增用户
    @Modifying
    @Transactional
    @Query(value="insert into user(name,password) values(?1,?2)",nativeQuery = true)
    public int addUser(String name, String password);

    //用户收藏文章列表
    @Query("select a from Collection c,Article a where c.user_id=?1 and c.article_id = a.id")
    public List<Article> findArticleById(int id);

    //用户关注作者的文章
    @Query("select a from Subscribe s,Article a where s.user_id=?1 and s.author = a.author")
    public List<Article> findArticleByAuthor(int id);

    //用户关注作者文章数量
    @Query("select count(a) as number from Subscribe s,Article a where s.user_id=?1 and s.author = a.author")
    public int findArticleByAuthorNum(int id);

    //删除用户
    @Modifying
    @Transactional
    @Query(value="delete from user where name=?1",nativeQuery = true)
    public void deleteUser(String name);
}