package com.TTEnglish.backend.controller;


import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.service.AllService;
import com.TTEnglish.backend.util.CheckPermission;
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

    private AllService service = new AllService();

    private CheckPermission permission = new CheckPermission();

    public ReqDto reqDto = new ReqDto();

    @PostMapping("/login_verify")
    public String LoginVerify(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        System.out.println("登陆的权限是: " + permission.check(username, password));
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




    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @PostMapping("/register")
    public String Register(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {

        System.out.println("用户名是: "+username);
        System.out.println("密码是: "+password);
        reqDto.setSession(session);
        reqDto.setUsername(username);
        reqDto.setPassword(password);

        return service.RegisterService(reqDto);
    }


}