package com.test.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="article")
public class Article implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="author",nullable = false)
    private String author;

    @Column(name="hot",nullable = false)
    private int hot;

    @Column(name="publish_time",nullable = false)
    private Timestamp publish_time;

    @Column(name="start",nullable = false)
    private Timestamp start;

    @Column(name="end",nullable = false)
    private Timestamp end;

    public Article(){
    }

    public Article(String title,String content,String author,int hot,Timestamp publish_time,Timestamp start,Timestamp end){
        this.title=title;
        this.content=content;
        this.author=author;
        this.hot=hot;
        this.publish_time=publish_time;
        this.start=start;
        this.end=end;
    }

    public int getId(){return id;}

    public String getTitle(){return title;}

    public String getContent(){return  content;}

    public String getAuthor(){return author;}

    public int getHot(){return hot;}

    public Timestamp getPublish_time(){return publish_time;}

    public Timestamp getStart(){return start;}

    public Timestamp getEnd(){return end;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public void setPublish_time(Timestamp publish_time) {
        this.publish_time = publish_time;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

}
