package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.model.ReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PageController {

    public ReqDto reqDto = new ReqDto();


    @RequestMapping("/page1")
    public String page1() {
        System.out.println("page1_is");
        return "redirect:home";
    }
    @RequestMapping("/page2")
    public String page2() {
        System.out.println("page2_is");
        return "redirect:home";
    }
    @GetMapping("/page3")
    public String page3() {
        System.out.println("page3_is");
        return "home";
    }

    @GetMapping("/page4")
    public String page4() {
        System.out.println("page4_is");
        return "home";
    }

    @GetMapping("/find_friend")
    public String findfriend(HttpSession session) throws IOException {
        reqDto.setTempvalue("1");
        System.out.println("这是第一条数据的用户名是："+session.getAttribute("username").toString());
        System.out.println("这是第一条数据");
        new ContentController().get_pattern_flag("1");
        System.out.println("这是第二条数据");
        return "home";
    }

    @GetMapping(value = "/home/{username}")
    public String visit_profile(HttpSession session, @PathVariable("username") String username) throws IOException {
        System.out.println("前端的get方法的username是："+username);

        return "home";
    }
}