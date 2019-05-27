package com.test.demo.dao;

import com.test.demo.entity.Article_tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface Article_tagDao extends JpaRepository<Article_tag,Integer> {
    //全部tag
    public List<Article_tag> findAll();

    //文章id对应tag
    @Query("select tag from Article_tag where article_id =?1")
    public List<String> findTagById(int article_id);

    //文章增加tag
    @Modifying
    @Transactional
    @Query(value="insert into article_tag(article_id,tag,id) values(?1,?2,0)",nativeQuery = true)
    public void addArticle_tag(int article_id, String tag);
}
