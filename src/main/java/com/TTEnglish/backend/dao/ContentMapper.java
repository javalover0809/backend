package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.Content;

import java.util.List;

public interface ContentMapper {
    void inputContent(String username,String title, String content);
    public String selectString();
    public List<Content> SelectAllContent();
    public List<Content> SelectCommentContent(String visitFlag,String username);
    public Content SelectContent();
}
