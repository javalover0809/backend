package com.TTEnglish.backend.model;

import javax.servlet.http.HttpSession;

public class ReqDto {
    private HttpSession session;
    private String content_id;
    private String username;
    private String password;
    private String title;
    private String content;
    private String time;
    private String comment_content_id;
    private String comment_content;
    private String content_flag;
    private String topic_id;
    private String topic_name;
    private String newtopic;
    private String tempvalue;

    public String personal_intro;
    public String love_status;
    public String user_job;
    public String user_company;
    public String user_country;
    public String user_province;
    public String user_city;
    public String user_junior_school;
    public String user_junior_period;
    public String user_senior_school;
    public String user_senior_period;
    public String user_bachelor_school;
    public String user_bachelor_period;
    public String user_master_school;
    public String user_master_period;
    public String user_phd_school;
    public String user_phd_period;
    public String user_postphd_shcool;
    public String user_postphd_period;
    public String is_insertprofile;
    public String is_publishcontent;
    public String visit_username;
    public String recommend_friend_name;
    public String friend_name;
    public String delete_friend_name;
    public String private_message_friend_name;
    public String to_message_content;
    public String from_message_content;
    public String private_message_show_flag;
    public String private_messages_input_value;
    public String apply_friend_message;
    public String is_friend;
    public String is_accept;
    public String is_read;
    public String comment_id;




    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment_content_id() {
        return comment_content_id;
    }

    public void setComment_content_id(String comment_content_id) {
        this.comment_content_id = comment_content_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getContent_flag() {
        return content_flag;
    }

    public void setContent_flag(String content_flag) {
        this.content_flag = content_flag;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getNewtopic() {
        return newtopic;
    }

    public void setNewtopic(String newtopic) {
        this.newtopic = newtopic;
    }

    public String getTempvalue() {
        return tempvalue;
    }

    public void setTempvalue(String tempvalue) {
        this.tempvalue = tempvalue;
    }
}