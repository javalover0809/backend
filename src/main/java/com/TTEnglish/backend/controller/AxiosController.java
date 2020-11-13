package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.constant.VisitFlag;
import com.TTEnglish.backend.model.*;
import com.TTEnglish.backend.service.AllService;
import com.TTEnglish.backend.util.CheckPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AxiosController {
    public ReqDto reqDto = new ReqDto();
    public User user = new User();
    private AllService service = new AllService();
    private VisitFlag visitFlag = new VisitFlag();
    private CheckPermission checkPermission = new CheckPermission();


    @GetMapping("/get_private_message_alert")
    public List<PrivateMessage> SelectPrivateMessageAlert(HttpSession session) throws IOException {
        reqDto.session=session;
        if(checkPermission.checkSession(session)){
             return null;
        }
        List<PrivateMessage> privateMessages= service.SelectPrivateMessageAlert(reqDto);
        return privateMessages;
    }


    @GetMapping("/get_pattern_flag")
    public String get_pattern_flag(String result) throws IOException {
        return result;
    }

    @GetMapping("/messages_send_to")
    public String messages_send_to(HttpSession session
            ,@RequestParam("private_message_friend_name") String private_message_friend_name) throws IOException {
        return private_message_friend_name;
    }

    @GetMapping("/messages")
    public List<PrivateMessage> getPrivateMessage(HttpSession session
            , @RequestParam("friend_name") String friend_name) throws IOException {
        reqDto.setSession(session);

        reqDto.private_message_friend_name = friend_name;
        List<PrivateMessage> privateMessages= service.selectPrivateMessageContent(reqDto);
        return privateMessages;
    }


    @GetMapping("/get_apply_friend_message")
    public List<Friend> get_apply_friend_message(HttpSession session) throws IOException {
        reqDto.setSession(session);
        if(session.getAttribute("username")==null){
            return null;
        }
        List<Friend> selectApplyFriend = service.selectApplyFriend(reqDto);
        return selectApplyFriend;
    }

    @GetMapping("/get_friend_recommend")
    public List<Friend> selectFriendRecommend(HttpSession session) throws IOException {
        reqDto.setSession(session);
        if(session.getAttribute("username")==null){
            return null;
        }
        List<Friend> friend_name_recommends = service.selectRecommendFriend(reqDto);
        return friend_name_recommends;
    }

    @GetMapping("/get_friend")
    public List<Friend> selectFriend(HttpSession session) throws IOException {
        reqDto.setSession(session);
        if(session.getAttribute("username")==null){
            return null;
        }
        List<Friend> friends = service.selectFriend(reqDto);
        return friends;
    }


    @GetMapping("/get_content")
    public ArrayList< List<Content>> SelectCommentContent(HttpSession session
            , @RequestParam("visit_username") String visit_username
            , @RequestParam("topic_id") String topic_id
            , @RequestParam("username") String username) throws IOException {
        reqDto.session = session;
        reqDto.topic_id = topic_id;
        reqDto.visit_username = visit_username;
        reqDto.username = username;
        System.out.println("reqDto.visit_username:"+reqDto.visit_username);
        System.out.println("reqDto.visit_username==null:"+reqDto.visit_username.equals("false"));
        if(reqDto.visit_username.equals("false")){
            List<Content> listcontent = service.SelectProfileContent(reqDto);
            List<Content> contentTopicId = service.SelectTopicId(reqDto);
            System.out.println("这些东西是:"+contentTopicId);
            ArrayList<List<Content>> result =new ArrayList<List<Content>>();
            result.add(contentTopicId);
            result.add(listcontent);
            return result;
        }
        List<Content> listcontent = service.SelectCommentContent(reqDto);
        List<Content> contentTopicId = service.SelectUserTopicId(reqDto);
        ArrayList<List<Content>> result =new ArrayList<List<Content>>();
        result.add(contentTopicId);
        result.add(listcontent);
        System.out.println("外面这些东西是:"+contentTopicId);
        return result;
    }

    @GetMapping("/get_comment_alert")
    public List<Comment> SelectCommentAlert(HttpSession session) throws IOException {
        if(checkPermission.checkSession(session)){
             return null;
        }
        reqDto.session=session;
        return service.SelectCommentAlert(reqDto);
    }



    @GetMapping("/get_profile")
    public User get_profile(HttpSession session, @RequestParam("visit_username") String visit_username) throws IOException {
        //用户没有登录，直接返回null
        if(session.getAttribute("username")==null){
            return null;
        }
        try {
            reqDto.visit_username = session.getAttribute("visit_username").toString();
        }
        catch (Exception e){
        }

        //先查询获取user对象，最后再进行profile_flag的赋值操作
        reqDto.setSession(session);
        user = service.SelectUser(reqDto);
        //判断GetMapping("/profile_edit") 是否设置了profile_edit_flag=2
        try {
            //获取到前端 profile_flage编辑的指令，直接给user赋值profile_flag=2后，返回
            if (session.getAttribute("profile_edit_flag") == "2") {
                user.setProfile_flag("2");
                return user;
            }
            user.setProfile_flag("1");
        }
        catch(Exception e){
        }

        return user;
    }

    @GetMapping("/infos")
    public User get_info(HttpSession session) throws IOException {
        //用户没有登录，直接返回null
        if(session.getAttribute("username")==null){
            return null;
        }
        reqDto.setSession(session);
        user = service.SelectInfo(reqDto);
        return user;
    }
}