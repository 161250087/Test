package com.test.demo.dao;

import com.test.demo.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectionDao extends JpaRepository<Collection,Integer> {
    public List<Collection> findAll();

    @Query("select c.article_id,a.title from Collection c,Article a where c.user_id=?1 and c.article_id = a.id")
    public List<Object> findArticleById(int id);
}
