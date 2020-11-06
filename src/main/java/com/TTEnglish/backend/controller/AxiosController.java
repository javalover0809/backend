package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.constant.VisitFlag;
import com.TTEnglish.backend.model.*;
import com.TTEnglish.backend.service.AllService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class AxiosController {
    public ReqDto reqDto = new ReqDto();
    public User user = new User();
    private AllService service = new AllService();
    private VisitFlag visitFlag = new VisitFlag();

    @GetMapping("/get_pattern_flag")
    public String get_pattern_flag(String result) throws IOException {
        System.out.println("这是第三条数据");
        System.out.println("临时变量的值是:" + reqDto.getTempvalue());
        return result;
    }


    @GetMapping("/messages")
    public List<PrivateMessage> getPrivateMessage(HttpSession session
    , @RequestParam("friend_name") String friend_name) throws IOException {
        reqDto.setSession(session);
        reqDto.private_message_friend_name = session.getAttribute("friend_name").toString();
        System.out.println("调用sprivate_messagefriend_nameDFFDAFAfriend_name2121"+friend_name);
        List<PrivateMessage> privateMessages= service.selectPrivateMessageContent(reqDto);
        return privateMessages;
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
        System.out.println("寻找friend的接口:");
        System.out.println("寻找friend的接口friends:"+friends);
        System.out.println("寻找friend的接口friends:"+ friends.get(0).getFriend_name());
       return friends;
    }


    @GetMapping("/get_content")
    public List<Content> SelectCommentContent(HttpSession session, @RequestParam("visit_username") String visit_username) throws IOException {
        //all_content = 1 在后面sql中 if(#{0}=2, u.username=#{1} ,1=1) 表示看所有的数据
//        reqDto.setContent_flag(visitFlag.all_content);
        reqDto.setSession(session);
        System.out.println("session中保存的topicid是:");
        System.out.println(reqDto.getSession().getAttribute("topic_id"));
        System.out.println("/get_content/{username}:"+visit_username);
        try {
            reqDto.visit_username = session.getAttribute("visit_username").toString();
        }
        catch (Exception e){
            System.out.println("session.get(visit_username)数据异常");
        }
        System.out.println("首先方位get_content");
        return service.SelectCommentContent(reqDto);
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
            System.out.println("session.get(visit_username)数据异常");
        }

        //先查询获取user对象，最后再进行profile_flag的赋值操作
        reqDto.setSession(session);
        user = service.SelectUser(reqDto);
            //判断GetMapping("/profile_edit") 是否设置了profile_edit_flag=2
            try {
                System.out.println("进入到了这里");
                //获取到前端 profile_flage编辑的指令，直接给user赋值profile_flag=2后，返回
                if (session.getAttribute("profile_edit_flag") == "2") {
                    System.out.println("进入到这里最终");
                    user.setProfile_flag("2");
                    return user;
                }
                user.setProfile_flag("1");
            }
            catch(Exception e){
                System.out.println("进入到了异常");
            }


        System.out.println("最后出来了");
        System.out.println("其次方位get_profile");
            return user;
        }

}