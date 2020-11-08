package com.TTEnglish.backend.util;

import com.TTEnglish.backend.dao.*;
import com.TTEnglish.backend.model.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class ManipulateMysql {

    public List<Friend> selectApplyFriend(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        FriendMapper friendMapper = session.getMapper(FriendMapper.class);
        List<Friend> friends = friendMapper.selectApplyFriend(reqDto.getSession().getAttribute("username").toString());
        session.close();

        return friends;
    }

    public List<Friend> selectRecommendFriend(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        FriendMapper friendMapper = session.getMapper(FriendMapper.class);
        List<Friend> friends = friendMapper.SelectRecommendFriendByUsername(reqDto.getSession().getAttribute("username").toString());
        session.close();

        return friends;
    }

    public List<Friend> selectFriend(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        FriendMapper friendMapper = session.getMapper(FriendMapper.class);
        List<Friend> friends = friendMapper.SelectFriendByUsername(reqDto.getSession().getAttribute("username").toString());
        session.close();

        return friends;
    }

    public List<PrivateMessage> SelectPrivateMessageAlert(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        PrivateMessageMapper privateMessageMapper = session.getMapper(PrivateMessageMapper.class);
        List<PrivateMessage> ListprivateMessage = privateMessageMapper.SelectPrivateMessageAlert(reqDto.getSession().getAttribute("username").toString());
        session.close();
        return ListprivateMessage;
    }


    public List<PrivateMessage> selectPrivateMessageContent(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        PrivateMessageMapper privateMessageMapper = session.getMapper(PrivateMessageMapper.class);
        List<PrivateMessage> ListprivateMessage = privateMessageMapper.selectPrivateMessageContent(reqDto.getSession().getAttribute("username").toString(),reqDto.private_message_friend_name);
        session.close();
        return ListprivateMessage;
    }



    public void deleteFriend(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        FriendMapper friendMapper = session.getMapper(FriendMapper.class);
        friendMapper.deleteFriend(reqDto.getSession().getAttribute("username").toString(),reqDto.delete_friend_name);
        session.commit();
        session.close();
    }

    public void insertApproveFriendApply(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        FriendMapper friendMapper = session.getMapper(FriendMapper.class);
        friendMapper.insertApproveFriendApply(reqDto.getSession().getAttribute("username").toString()
                ,reqDto.recommend_friend_name
                ,reqDto.is_accept);
        session.commit();
        session.close();
    }

    public void insertNewFriendApply(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        FriendMapper friendMapper = session.getMapper(FriendMapper.class);
        friendMapper.insertNewFriendApply(reqDto.getSession().getAttribute("username").toString()
                ,reqDto.recommend_friend_name
                ,reqDto.apply_friend_message
                ,reqDto.is_friend);
        session.commit();
        session.close();
    }

    public void insertNewFriend(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        FriendMapper friendMapper = session.getMapper(FriendMapper.class);
        friendMapper.insertNewFriend(reqDto.getSession().getAttribute("username").toString(),reqDto.recommend_friend_name);
        session.commit();
        session.close();
    }


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

    public void insertPrivateMessage(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        PrivateMessageMapper privateMessageMapper = session.getMapper(PrivateMessageMapper.class);
        privateMessageMapper.insertPrivateMessage(
                                                  reqDto.getSession().getAttribute("username").toString()
                                                 ,reqDto.private_message_friend_name
                                                 ,reqDto.to_message_content
                                                 ,reqDto.from_message_content
                                                 ,reqDto.private_message_show_flag
                                                 ,reqDto.private_messages_input_value
                                                 ,reqDto.is_read);
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

    public User SelectInfo(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(reqDto.getSession().getAttribute("username").toString());
        session.close();
        return user;
    }

    public User SelectUser(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //reqDto.visit_username!=null 表示获取 访问人的个人信息卡
        if(reqDto.visit_username!=null){
            User user = userMapper.getUserByUsername(reqDto.visit_username);
            //每次访问完之后，清除此字段
            reqDto.getSession().removeAttribute("visit_username");
            reqDto.visit_username = null;
            session.close();
            return user;
        }

        User user = userMapper.getUserByUsername(reqDto.getSession().getAttribute("username").toString());
        session.close();
        return user;
    }


    public List<Content> SelectCommentContent(ReqDto reqDto) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        //reqDto.visit_username!=null 表示获取 访问人发布的信息
        if(reqDto.visit_username!=null){
            System.out.println("最终进入到这里，访问人的数据是："+reqDto.visit_username);
            System.out.println("reqDto.getContent_flag()，访问人的数据是："+reqDto.getContent_flag());
            List<Content> listcontent = contentMapper.SelectProfileContent(reqDto.visit_username, reqDto.getSession().getAttribute("topic_id").toString());
            session.close();
            //每次访问完之后，清除此字段
            reqDto.getSession().removeAttribute("visit_username");
            reqDto.visit_username = null;

            return listcontent;
        }
        List<Content> listcontent = contentMapper.SelectCommentContent(reqDto.getSession().getAttribute("topic_id").toString());

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
