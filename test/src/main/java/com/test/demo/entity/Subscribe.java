package com.test.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="subscribe")
public class Subscribe implements Serializable {
    private static final long serialVersionUID=1L;
    @Column(name="author",nullable = false)
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUser_id(String tag) {
        this.user_id = user_id;
    }

    public String getAuthor() {
        return author;
    }

    public int getUser_id() {
        return user_id;
    }

    @Column(name="user_id",nullable = false)
    private int user_id;

    public Subscribe(){
    }

    public Subscribe(String author,int user_id){
        this.author=author;
        this.user_id=user_id;
    }
}
