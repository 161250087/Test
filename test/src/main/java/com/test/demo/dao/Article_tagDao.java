package com.test.demo.dao;

import com.test.demo.entity.Article_tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Article_tagDao extends JpaRepository<Article_tag,Integer> {
    public List<Article_tag> findAll();

    @Query("select tag from Article_tag where article_id =?1")
    public List<String> findTagById(int article_id);
}
