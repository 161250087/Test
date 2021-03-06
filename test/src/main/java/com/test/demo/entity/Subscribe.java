package com.test.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="subscribe")
public class Subscribe implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="author",nullable = false)
    private String author;

    @Column(name="user_id",nullable = false)
    private int user_id;

    public Subscribe(){
    }

    public Subscribe(String author,int user_id){
        this.author=author;
        this.user_id=user_id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAuthor() {
        return author;
    }

    public int getUser_id() {
        return user_id;
    }
}
