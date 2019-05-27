package com.test.demo.dao;

import com.test.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Integer>{
    //id对应文章
    public Article findById(int id);

    //所有文章数量
    @Query("select count(id) as num from Article")
    public int findAllNum();

    //所有文章列表
    @Query("from Article")
    public List<Article> findAll();

    //未结束文章分页展示
    @Query(value="select * from article where end > ?3 limit ?1,?2",nativeQuery = true)
    public List<Article> findFreshAllPage(int start, int length, Timestamp timestamp);

    //未结束文章列表
    @Query(value="select * from article where end > ?1",nativeQuery = true)
    public List<Article> findFreshAll(Timestamp timestamp);

    //未结束文章数量
    @Query(value="select count(*) from article where end > ?1",nativeQuery = true)
    public int findFreshAllNum(Timestamp timestamp);

    //全部文章分页
    @Query(value="select * from article limit ?1,?2",nativeQuery = true)
    public List<Article> findSome(int start, int length);

    //未结束文章列表
    @Query(value="select * from article where end < ?1",nativeQuery = true)
    public List<Article> findAllFresh(Timestamp timestamp);

    //未结束文章分页
    @Query(value="select * from article where end < ?3 limit ?1,?2",nativeQuery = true)
    public List<Article> findSomeFresh(int start, int length, Timestamp timestamp);

    //统计未结束文章
    @Query(value="select count(*) as num from article where end < ?3 limit ?1,?2",nativeQuery = true)
    public int findSomeFreshNum(int start, int length, Timestamp timestamp);

    //新增文章
    @Modifying
    @Transactional
    @Query(value="insert into article(title,content,author,hot,publish_time,start,end) values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    public int addArticle(String title, String content, String author, int hot, Timestamp publish_time, Timestamp start, Timestamp end);

    //文章热度增加
    @Modifying
    @Transactional
    @Query(value="update article set hot = hot+1 where id=?1",nativeQuery = true)
    public void AddHot(int id);

    //通过特定字段检索文章
    @Query(value="select * from article where title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1)",nativeQuery = true)
    public List<Article> findArticleByStr(String findser);

    //特定字段检索文章结果数量
    @Query(value="select count(*) from article where title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1)",nativeQuery = true)
    public int findArticleByStrNum(String findstr);

    //特定字段检索文章分页展示
    @Query(value="select * from article where title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1) limit ?2,?3",nativeQuery = true)
    public List<Article> findArticleByStrPage(String findser, int start, int length);

    //特定字段检索未结束文章
    @Query(value="select * from article where (title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1) )and end > ?2",nativeQuery = true)
    public List<Article> findFreshArticleByStr(String findser, Timestamp timestamp);

    //特定字段检索未结束文章数量
    @Query(value="select count(id) from article where (title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1)) and end > ?2",nativeQuery = true)
    public int findFreshArticleByStrNum(String findstr, Timestamp timestamp);

    //特定字段检索未结束文章分页
    @Query(value="select * from article where (title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1)) and end >?4 limit ?2,?3",nativeQuery = true)
    public List<Article> findFreshArticleByStrPage(String findser, int start, int length, Timestamp timestamp);

    //特定字段检索热点文章（5篇）
    @Query(value="select * from article where title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1) order by hot desc limit 0,5",nativeQuery = true)
    public List<Article> findHotArticleByStr(String findser);

    //特定字段检索未结束热点文章（5篇）
    @Query(value="select * from article where (title like ?1 or author like ?1 or id in (select article_id from article_tag where tag like ?1)) and end > ?2 order by hot desc limit 0,5",nativeQuery = true)
    public List<Article> findFreshHotArticleByStr(String findser, Timestamp timestamp);

    //热点文章（5篇）
    @Query(value="select * from  article where end> ?1 order by hot desc limit 0,5",nativeQuery = true)
    public List<Article> hotFreshArticle(Timestamp timestamp);

    //个人收藏列表未结束的文章
    @Query(value="select a.* from Collection c,Article a where c.user_id=?1 and c.article_id = a.id and a.end > ?2",nativeQuery = true)
    public List<Article> findFreshArticleById(int id, Timestamp timestamp);

    //个人订阅列表未结束的作者的文章
    @Query(value="select a.* from Subscribe s,Article a where s.user_id=?1 and s.author = a.author and a.end > ?2",nativeQuery = true)
    public List<Article> findFreshArticleBySubscribe(int id, Timestamp timestamp);
}
