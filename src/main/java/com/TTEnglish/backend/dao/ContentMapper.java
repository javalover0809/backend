package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.Content;

public interface ContentMapper {
    void inputContent(String username,String title, String content);
    public Content selectContent();
}
