package com.test.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false,unique = true)
    private String name;

    @Column(name="password",nullable = false)
    private String password;

    public User(){
    }

    public User(String name,String password){
        this.name=name;
        this.password=password;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPassword(String password){
        this.password=password;
    }

    private List<String> tagList;

    public List<String> getTagList(){
        return tagList;
    }

    public void setTagList(List<String> tagList){
        this.tagList=tagList;
    }

    public List<Integer> collectionList;

    public List<Integer> getCollectionList(){
        return collectionList;
    }

    public void  setCollectionList(List<Integer> collectionList){
        this.collectionList=collectionList;
    }

    private List<String> subscribeList;

    public List<String> getSubscribeList(){
        return subscribeList;
    }

    public void setSubscribeList(List<String> subscribeList){
        this.subscribeList=subscribeList;
    }
}
