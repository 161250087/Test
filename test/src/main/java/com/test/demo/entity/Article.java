package com.test.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="article")
public class Article implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title",nullable = false)
    private String title;

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

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="author",nullable = false)
    private String author;

    @Column(name="hot",nullable = false)
    private int hot;

    @Column(name="publish_time",nullable = false)
    private Date publish_time;

    @Column(name="start",nullable = false)
    private Date start;

    @Column(name="end",nullable = false)
    private Date end;

    public Article(){
    }

    public Article(String title,String content,String author,int hot,Date publish_time,Date start,Date end){
        this.title=title;
        this.content=content;
        this.author=author;
        this.hot=hot;
        this.publish_time=publish_time;
        this.start=start;
        this.end=end;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){return  content;}

    public String getAuthor(){return author;}

    public int getHot(){return hot;}

    public Date getPublish_time(){return publish_time;}

    public Date getStart(){return start;}

    public Date getEnd(){return end;}


}
