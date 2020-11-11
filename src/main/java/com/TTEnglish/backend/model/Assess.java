package com.TTEnglish.backend.model;

public class Assess {

    private String id;
    private String assess_id;
    private String assess_username;
    private String assessed_username;
    private String is_agree;
    private String is_comment;
    private String assess_time;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssess_id() {
        return assess_id;
    }

    public void setAssess_id(String assess_id) {
        this.assess_id = assess_id;
    }

    public String getAssess_username() {
        return assess_username;
    }

    public void setAssess_username(String assess_username) {
        this.assess_username = assess_username;
    }

    public String getAssessed_username() {
        return assessed_username;
    }

    public void setAssessed_username(String assessed_username) {
        this.assessed_username = assessed_username;
    }

    public String getIs_agree() {
        return is_agree;
    }

    public void setIs_agree(String is_agree) {
        this.is_agree = is_agree;
    }

    public String getIs_comment() {
        return is_comment;
    }

    public void setIs_comment(String is_comment) {
        this.is_comment = is_comment;
    }

    public String getAssess_time() {
        return assess_time;
    }

    public void setAssess_time(String assess_time) {
        this.assess_time = assess_time;
    }
}
