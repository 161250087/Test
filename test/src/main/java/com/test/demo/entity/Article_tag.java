package com.test.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="article_tag")
public class Article_tag implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name="article_id",nullable = false)
    private int article_id;

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getTag() {
        return tag;
    }

    @Column(name="tag",nullable = false)
    private String tag;

    public Article_tag(){
    }

    public Article_tag(int article_id,String tag){
        this.article_id=article_id;
        this.tag=tag;
    }
}
