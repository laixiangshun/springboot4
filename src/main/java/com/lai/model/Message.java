package com.lai.model;

import org.springframework.data.annotation.Id;

/**
 * Created by lailai on 2017/9/18.
 */
public class Message {

    private Long id;

    private String name;
    private String content;
    private Integer number;

    public Message(){}
    public Message(String name, String content, Integer number) {
        this.name = name;
        this.content = content;
        this.number = number;
    }

    public Message(Long id, String name, String content, Integer number) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
