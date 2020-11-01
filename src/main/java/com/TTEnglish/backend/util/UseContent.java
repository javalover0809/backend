package com.TTEnglish.backend.util;

import com.TTEnglish.backend.dao.ContentMapper;
import com.TTEnglish.backend.model.Content;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class UseContent {
    public void write(String username,String title ,String content) throws IOException {

            SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
            SqlSession session = sqlSessionFactory.openSession();
            System.out.println("this is two");
            ContentMapper contentMapper = session.getMapper(ContentMapper.class);
            contentMapper.inputContent(username,title,content);
            System.out.println("this is one");
            session.commit();
            session.close();
    }

    public Content read() throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        Content content = contentMapper.selectContent();
        session.close();
        return content;
    }
}
