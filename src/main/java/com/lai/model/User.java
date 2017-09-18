package com.lai.model;

import java.io.Serializable;

/**
 * Created by lailai on 2017/9/18.
 */
public class User implements Serializable{

    private static final long serialVersionID=-1L;

    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public static long getSerialVersionID() {
        return serialVersionID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
