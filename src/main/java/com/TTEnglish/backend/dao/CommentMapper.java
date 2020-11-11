package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.Comment;

import java.util.List;

public interface CommentMapper {

    void updateReadCommentMessage(String comment_content_id
            ,String comment_username
            ,String is_read);
    void insertComment(String comment_cotent_id
            , String comment_username
            , String comment_content
            , String commented_username
            , String is_read);
    List<Comment> SelectCommentAlert(String comment_username);
}
