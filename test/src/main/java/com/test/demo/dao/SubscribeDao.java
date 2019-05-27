package com.test.demo.dao;

import com.test.demo.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SubscribeDao extends JpaRepository<Subscribe,Integer> {
    //所有订阅信息
    public List<Subscribe> findAll();

    //用户id返回订阅作者列表
    @Query("select author from Subscribe where user_id = ?1")
    public List<String> findAuthorByUser_id(int user_id);

    //增加订阅
    @Modifying
    @Transactional
    @Query(value="insert into subscribe (user_id,author) values(?1,?2)",nativeQuery = true)
    public void addSubscribe(int user_id, String author);

    //删除订阅
    @Modifying
    @Transactional
    @Query(value="delete from subscribe where user_id = ?1 and author = ?2 ",nativeQuery = true)
    public void deleteSubscribe(int user_id, String author);
}
