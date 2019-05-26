package com.test.demo.dao;

import com.test.demo.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CollectionDao extends JpaRepository<Collection,Integer> {
    public List<Collection> findAll();

    @Query("select article_id from Collection where user_id = ?1")
    public List<Integer> findCollectionByUser_id(int user_id);

    @Modifying
    @Transactional
    @Query(value="insert into collection(user_id,article_id,id) values(?1,?2,0)",nativeQuery = true)
    public void addCollection(int user_id,int article_id);

    @Modifying
    @Transactional
    @Query(value="delete from collection where user_id=?1 and article_id=?2",nativeQuery = true)
    public void deleteCollection(int user_id,int article_id);
}
