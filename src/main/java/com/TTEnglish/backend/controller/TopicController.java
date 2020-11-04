package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.model.ReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TopicController {

    public ReqDto reqDto = new ReqDto();

    @GetMapping("/profile_edit")
    public String profile_edit(HttpSession session) throws IOException {
        //前端发送资料请求，把profile_edit_flag设置为2，下一步到 /get_profile 中进行profile_edit_flag是否为2的判断
        session.setAttribute("profile_edit_flag","2");
        return "redirect:home";
    }

    @GetMapping("/topic0")
    public String topic0(HttpSession session) {
        session.setAttribute("topic_id","0");
        reqDto.setSession(session);
        return "redirect:home";
    }


    @GetMapping("/topic1")
    public String topic1(HttpSession session) {
        session.setAttribute("topic_id","1");
        reqDto.setSession(session);
        return "redirect:home";
    }


    @GetMapping("/topic2")
    public String topic2(HttpSession session) {
        session.setAttribute("topic_id","2");
        reqDto.setSession(session);
        return "redirect:home";
    }

    @GetMapping("/topic3")
    public String topic3(HttpSession session) {
        session.setAttribute("topic_id","3");
        reqDto.setSession(session);
        return "redirect:home";
    }

    @GetMapping("/topic4")
    public String topic4(HttpSession session) {
        session.setAttribute("topic_id","4");
        reqDto.setSession(session);
        return "redirect:home";
    }


    @GetMapping("/topic5")
    public String topic5(HttpSession session) {
        session.setAttribute("topic_id","5");
        reqDto.setSession(session);
        return "redirect:home";
    }

    @GetMapping("/topic6")
    public String topic6(HttpSession session) {
        session.setAttribute("topic_id","6");
        reqDto.setSession(session);
        return "redirect:home";
    }
}