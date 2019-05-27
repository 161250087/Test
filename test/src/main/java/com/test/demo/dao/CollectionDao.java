package com.test.demo.dao;

import com.test.demo.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CollectionDao extends JpaRepository<Collection,Integer> {
    //所有收藏
    public List<Collection> findAll();

    //用户id返回收藏列表
    @Query("select article_id from Collection where user_id = ?1")
    public List<Integer> findCollectionByUser_id(int user_id);

    //新增收藏
    @Modifying
    @Transactional
    @Query(value="insert into collection(user_id,article_id,id) values(?1,?2,0)",nativeQuery = true)
    public void addCollection(int user_id, int article_id);

    //删除收藏
    @Modifying
    @Transactional
    @Query(value="delete from collection where user_id=?1 and article_id=?2",nativeQuery = true)
    public void deleteCollection(int user_id, int article_id);
}
