package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.service.AllService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AhrefController {

    public ReqDto reqDto = new ReqDto();
    private AllService service = new AllService();

    @GetMapping("/find_friend")
    public String findfriend(HttpSession session) throws IOException {
        reqDto.setTempvalue("1");
        System.out.println("这是第一条数据的用户名是："+session.getAttribute("username").toString());
        System.out.println("这是第一条数据");
        new AxiosController().get_pattern_flag("1");
        System.out.println("这是第二条数据");
        return "home";
    }

    @GetMapping(value = "/home/{username}")
    public String visit_profile(HttpSession session, @PathVariable("username") String username) throws IOException {
        session.setAttribute("visit_username",username);
        System.out.println("前端的get方法的username是："+username);
        return "home";
    }

    @GetMapping("/home/{topic_id}")
    public String home(HttpSession session
            , @PathVariable("topic_id") String topic_id) throws IOException {
        System.out.println("前端的get方法的topic_id是："+topic_id);
        return "home";
    }


    @GetMapping(value = "/friend_add/{recommend_friend_name}")
    public String friendadd(HttpSession session, @PathVariable("recommend_friend_name") String recommend_friend_name) throws IOException {
        reqDto.setSession(session);
        reqDto.recommend_friend_name = recommend_friend_name;
        System.out.println("前端的get方法的username是ss："+recommend_friend_name);
        service.insertNewFriend(reqDto);
        return "home";
    }

    @GetMapping(value = "/info")
    public String openinfo(HttpSession session) throws IOException {
        return "info";
    }

    @GetMapping(value = "/private_message/{friend_name}")
    public String privatemessage(HttpSession session, @PathVariable("friend_name") String private_message_friend_name) throws IOException {
        session.setAttribute("private_message_friend_name",private_message_friend_name);
        reqDto.setSession(session);
        System.out.println("调用s/private_message/{friend_name}："+private_message_friend_name);
        return "home";
    }
    @GetMapping("/profile_edit")
    public String profile_edit(HttpSession session) throws IOException {
        //前端发送资料请求，把profile_edit_flag设置为2，下一步到 /get_profile 中进行profile_edit_flag是否为2的判断
        session.setAttribute("profile_edit_flag","2");
        return "redirect:home";
    }

    @GetMapping("/message")
    public String message(HttpSession session , @RequestParam("friend_name") String friend_name) throws IOException {
        return "message";
    }

}