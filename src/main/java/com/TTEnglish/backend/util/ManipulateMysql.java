package com.TTEnglish.backend.util;

import com.TTEnglish.backend.dao.CommentMapper;
import com.TTEnglish.backend.dao.ContentMapper;
import com.TTEnglish.backend.model.Content;
import com.TTEnglish.backend.model.ReqDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class ManipulateMysql {

    public void insert_comment(String cotent_id ,String comment_username ,String comment_content) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        CommentMapper commentMapper = session.getMapper(CommentMapper.class);
        commentMapper.insertComment(cotent_id,comment_username,comment_content);
        session.commit();
        session.close();
    }


    public void insert(String username,String title ,String content) throws IOException {

            SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
            SqlSession session = sqlSessionFactory.openSession();
            System.out.println("this is two");
            ContentMapper contentMapper = session.getMapper(ContentMapper.class);
            contentMapper.inputContent(username,title,content);
            System.out.println("this is one");
            session.commit();
            session.close();
    }

    public String selectString() throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        String  result = contentMapper.selectString();
        session.close();
        return result;
    }
    public Content SelectContent() throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
//        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
//        Content content = contentMapper.SelectContent();
        Content content = session.selectOne("com.TTEnglish.backend.dao.ContentMapper.SelectContent", 1);
        session.close();
        return content;
    }

    public List<Content> SelectCommentContent(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        List<Content> listcontent = contentMapper.SelectCommentContent(reqDto.getContent_flag(),reqDto.getSession().getAttribute("username").toString());
        session.close();
        return listcontent;
    }

    public List<Content> SelectAllContent() throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        List<Content> listcontent = contentMapper.SelectAllContent();
        session.close();
        return listcontent;
    }
}
