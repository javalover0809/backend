package com.TTEnglish.backend.service;

import com.TTEnglish.backend.model.*;
import com.TTEnglish.backend.util.CheckPermission;
import com.TTEnglish.backend.util.ManipulateMysql;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:24
 */
@Service
public class AllService {

    private Content Content = new Content();
    private CheckPermission permission = new CheckPermission();
    private ManipulateMysql manipulateMysql = new ManipulateMysql();

    public String RegisterService(ReqDto reqDto) throws IOException {
        manipulateMysql.registerMysql(reqDto.getUsername(),reqDto.getPassword());
        return "login";
    }

    public List<Content> selecAll(ReqDto reqDto) throws IOException {
        List<Content> content = manipulateMysql.SelectAllContent();
        return content;
    }
    public List<Content> SelectContent(ReqDto reqDto) throws IOException {
        List<Content> content = manipulateMysql.SelectAllContent();
        return content;
    }

    public List<Friend> selectApplyFriend(ReqDto reqDto) throws IOException {
        List<Friend> friends = manipulateMysql.selectApplyFriend(reqDto);
        return friends;
    }

    public List<Friend> selectRecommendFriend(ReqDto reqDto) throws IOException {
        List<Friend> friends = manipulateMysql.selectRecommendFriend(reqDto);
        return friends;
    }

    public List<Friend> selectFriend(ReqDto reqDto) throws IOException {
        List<Friend> friends = manipulateMysql.selectFriend(reqDto);
        return friends;
    }
    public void deleteFriend(ReqDto reqDto) throws IOException {
        manipulateMysql.deleteFriend(reqDto);
    }

    public void insertApproveFriendApply(ReqDto reqDto) throws IOException {
        manipulateMysql.insertApproveFriendApply(reqDto);
    }

    public void updateReadMessage(ReqDto reqDto) throws IOException {
        manipulateMysql.updateReadMessage(reqDto);
    }
    public void insertNewFriendApply(ReqDto reqDto) throws IOException {
        manipulateMysql.insertNewFriendApply(reqDto);
    }

    public void insertNewFriend(ReqDto reqDto) throws IOException {
        manipulateMysql.insertNewFriend(reqDto);
    }


    public List<PrivateMessage> SelectPrivateMessageAlert(ReqDto reqDto) throws IOException {
            return  manipulateMysql.SelectPrivateMessageAlert(reqDto);
    }

    public List<PrivateMessage> selectPrivateMessageContent(ReqDto reqDto) throws IOException {
        if(reqDto.private_message_friend_name!=null){
            System.out.println("private_message_friend_name!=null" + reqDto.private_message_friend_name);
            return  manipulateMysql.selectPrivateMessageContent(reqDto);
        }
        System.out.println("private_message_friend_name的数据是" + reqDto.private_message_friend_name);
        return  null;
    }

    public User SelectInfo(ReqDto reqDto) throws IOException {

        return  manipulateMysql.SelectInfo(reqDto);
    }

    public User SelectUser(ReqDto reqDto) throws IOException {

        return  manipulateMysql.SelectUser(reqDto);
    }

    public List<Content> SelectCommentContent(ReqDto reqDto) throws IOException {
        if(reqDto.getSession().getAttribute("username")==null){
            reqDto.getSession().setAttribute("username","supermanager");
        }
        if(reqDto.getSession().getAttribute("topic_id")==null){
            reqDto.getSession().setAttribute("topic_id","1");
        }

        return  manipulateMysql.SelectCommentContent(reqDto);
    }

    public JSONObject SelectAllContent(ReqDto reqDto) throws IOException {
        List<Content> content = manipulateMysql.SelectAllContent();
        JSONObject result = new JSONObject();
        result.put("contents",content);
        result.put("comments",content);
        return result;
    }




    public String insert_profile(ReqDto reqDto) throws IOException {
        manipulateMysql.insert_profile(reqDto);
        return "home";
    }

    public String insertPrivateMessage(ReqDto reqDto) throws IOException {
        manipulateMysql.insertPrivateMessage(reqDto);
        return "home";
    }


    public String insert_content(ReqDto reqDto) throws IOException {
        if(reqDto.getSession().getAttribute("username")==null||reqDto.getSession().getAttribute("password")==null){
            System.out.println("please login in");
            return "login";

        }
        if(reqDto.getSession().getAttribute("username")!=null&&reqDto.getTitle()==""||reqDto.getContent()==""){
            System.out.println("这里进行数据的写入工作3");
            return "redirect:home";
        }
        String username=reqDto.getSession().getAttribute("username").toString();
        String password=reqDto.getSession().getAttribute("password").toString();
        if(permission.check(username,password)){
            System.out.println("input the data");

            //如果新建主题，从数据库读取最新的topic_id，在这里添加上
            if(reqDto.getTopic_id()!=null&&reqDto.getTopic_id().equals("0")){
                System.out.println("这里进行数据的写入工作5");
                reqDto.setTopic_id(manipulateMysql.SelectMaxTopicId());
            }
            manipulateMysql.insert(reqDto);

            return "home";
        }
        System.out.println("input the data two");
        String resPage = "home";
        return resPage;
    }

    public String insert_comment(ReqDto reqDto) throws IOException {
        if(reqDto.getSession().getAttribute("username")==null||reqDto.getSession().getAttribute("password")==null){
            System.out.println("please login in");
            return "login";
        }
        if(reqDto.getSession().getAttribute("username")!=null&&reqDto.getComment_content()==""){
            return "redirect:home";
        }
        String comment_username=reqDto.getSession().getAttribute("username").toString();
        String password=reqDto.getSession().getAttribute("password").toString();
        if(permission.check(comment_username,password)){
            System.out.println("正在输入评论数据");
            System.out.println(reqDto.getComment_content_id());
            System.out.println(reqDto.getComment_content());
            manipulateMysql.insert_comment(reqDto.getComment_content_id() ,comment_username,reqDto.getComment_content());
            return "home";
        }
        System.out.println("input the data two");
        String resPage = "home";
        System.out.println("正在输入评论数据");
        System.out.println(reqDto.getComment_content());
        System.out.println(reqDto.getComment_content());
        return resPage;
    }





}
