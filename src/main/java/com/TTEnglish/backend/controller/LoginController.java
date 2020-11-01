package com.TTEnglish.backend.controller;


import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.service.UserService;
import com.TTEnglish.backend.util.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:08
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private CheckPermission permission = new CheckPermission();

    public ReqDto reqDto = new ReqDto();

    @PostMapping("/login_verify")
    public String LoginVerify(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        System.out.println("checkpermission: " + permission.check(username, password));
        if(permission.check(username, password)){
            return "redirect:home";
        }
        System.out.println("storedName_is");
        System.out.println("login_verify number");
        System.out.println(username);
        System.out.println(password);
        return "redirect:login";
        }

    @RequestMapping("/login_out")
    public String LoginOut(HttpSession session){
        session.invalidate();
        return "home";
    }


    @PostMapping("/publish_content")
    public String getLogin(HttpSession session, @RequestParam("title") String title, @RequestParam("content") String content) throws IOException {

        System.out.println("publish_content_is_number");
        System.out.println(content);
        reqDto.session = session;
        reqDto.title = title;
        reqDto.content = content;
        String resPage = userService.input_content(reqDto);

        return "redirect:" + resPage;
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }


}