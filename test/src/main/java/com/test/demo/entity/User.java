package com.test.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name="mail",nullable = false)
    private String mail;

    public User(){
    }

    public User(String name,String password,String mail){
        this.name=name;
        this.password=password;
        this.mail=mail;
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

    public String getMail(){return mail;}

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setMail(String mail){this.mail=mail;}
}
