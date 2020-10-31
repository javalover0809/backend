package com.TTEnglish.backend.model;

public class Users {

    private String username;
    private String password;

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = username;
    }

    public String getContent() {
        return password;
    }

    public void setContent(String content) {
        this.password = password;
    }

}