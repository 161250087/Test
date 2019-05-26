package com.test.demo.dao;

import com.test.demo.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SubscribeDao extends JpaRepository<Subscribe,Integer> {
    public List<Subscribe> findAll();

    @Query("select author from Subscribe where user_id = ?1")
    public List<String> findAuthorByUser_id(int user_id);

    @Modifying
    @Transactional
    @Query(value="insert into subscribe (user_id,author,id) values(?1,?2,0)",nativeQuery = true)
    public void addSubscribe(int user_id,String author);

    @Modifying
    @Transactional
    @Query(value="delete from collection where user_id=?1 and author=?2",nativeQuery = true)
    public void deleteSubscribe(int user_id,String author);
}
