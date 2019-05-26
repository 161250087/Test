package com.test.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_tag")
public class User_tag implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name="user_id",nullable = false)
    private int user_id;

    @Column(name="tag",nullable = false)
    private String tag;

    public User_tag(){
    }

    public User_tag(int user_id,String tag){
        this.user_id=user_id;
        this.tag=tag;
    }
    public int getUser_id() {return user_id; }

    public String getTag() {return tag; }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
