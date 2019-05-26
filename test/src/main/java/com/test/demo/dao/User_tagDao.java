package com.test.demo.dao;

import com.test.demo.entity.User_tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface User_tagDao extends JpaRepository<User_tag,Integer> {
    public List<User_tag> findAll();

    @Query("select tag from User_tag where user_id =?1")
    public List<String> findTagById(int user_id);

    @Modifying
    @Transactional
    @Query(value="insert into user_tag(user_id,tag,id) values(?1,?2,0)",nativeQuery = true)
    public void addUser_tag(int user_id,String tag);

    @Modifying
    @Transactional
    @Query(value="delete from user_tag where user_id=?1 and tag=?2",nativeQuery = true)
    public void deleteUser_tag(int user_id,String tag);
}
