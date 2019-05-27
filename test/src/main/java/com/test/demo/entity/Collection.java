package com.test.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="collection")
public class Collection implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="article_id",nullable = false)
    private int article_id;

    @Column(name="user_id",nullable = false)
    private int user_id;

    public Collection(){
    }

    public Collection(int article_id,int user_id){
        this.article_id=article_id;
        this.user_id=user_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
