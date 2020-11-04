package com.TTEnglish.backend.util;

import com.TTEnglish.backend.dao.CommentMapper;
import com.TTEnglish.backend.dao.ContentMapper;
import com.TTEnglish.backend.dao.UserMapper;
import com.TTEnglish.backend.model.Content;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class ManipulateMysql {


    public String SelectMaxTopicId() throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        Content content = contentMapper.SelectContent();
        String maxTopicId = content.getTopic_id();
        session.close();
        return maxTopicId;
    }









    public void registerMysql(String username ,String password) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.registerMapper(username,password);
        session.commit();
        session.close();
    }


    public void insert_comment(String cotent_id ,String comment_username ,String comment_content) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        CommentMapper commentMapper = session.getMapper(CommentMapper.class);
        commentMapper.insertComment(cotent_id,comment_username,comment_content);
        session.commit();
        session.close();
    }
    public void insert_profile(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.inserProfileMapper( reqDto.getSession().getAttribute("username").toString()
                                      ,reqDto.getSession().getAttribute("password").toString()
                                      ,reqDto.personal_intro
                                      ,reqDto.love_status
                                      ,reqDto.user_job
                                      ,reqDto.user_company
                                      ,reqDto.user_country
                                      ,reqDto.user_province
                                      ,reqDto.user_city
                                      ,reqDto.user_junior_school
                                      ,reqDto.user_junior_period
                                      ,reqDto.user_senior_school
                                      ,reqDto.user_senior_period
                                      ,reqDto.user_bachelor_school
                                      ,reqDto.user_bachelor_period
                                      ,reqDto.user_master_school
                                      ,reqDto.user_master_period
                                      ,reqDto.user_phd_school
                                      ,reqDto.user_phd_period
                                      ,reqDto.user_postphd_shcool
                                      ,reqDto.user_postphd_period);
        session.commit();
        session.close();
    }

    public void insert(ReqDto reqDto) throws IOException {

            SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
            SqlSession session = sqlSessionFactory.openSession();
            ContentMapper contentMapper = session.getMapper(ContentMapper.class);
            contentMapper.inputContent(reqDto.getTopic_id(),reqDto.getTopic_name(),reqDto.getSession().getAttribute("username").toString() ,reqDto.getTitle() ,reqDto.getContent());
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

    public User SelectUser(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(reqDto.getSession().getAttribute("username").toString());
        session.close();
        return user;
    }


    public List<Content> SelectCommentContent(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        List<Content> listcontent = contentMapper.SelectCommentContent(reqDto.getContent_flag(),reqDto.getSession().getAttribute("username").toString(), reqDto.getSession().getAttribute("topic_id").toString());
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
