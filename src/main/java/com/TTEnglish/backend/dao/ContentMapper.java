package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.Content;

import java.util.List;

public interface ContentMapper {
    void inputContent(String topic_id, String topic_name, String username,String title, String content);
    public String selectString();
    public String SelectMaxTopicId();
    public List<Content> SelectAllContent();
    public List<Content> SelectCommentContent(String visitFlag,String username,String topic_id);
    public Content SelectContent();
}
