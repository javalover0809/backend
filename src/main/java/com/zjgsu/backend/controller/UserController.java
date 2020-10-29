package com.zjgsu.backend.controller;


import com.zjgsu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:08
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String login(){
        System.out.println("login");
        return "dashboard2";
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("login");
        return "helloworld";
    }
    @RequestMapping("/contact_back")
    public String contact_back(){
        System.out.println("login");
        return "contact_back";
    }

    @RequestMapping("/1_post")
    public String test_post(){
        System.out.println("1_post");
        return "1_post";
    }

    @RequestMapping("/2_post")
    public String test_post2(){
        System.out.println("2_post");
        return "2_post";
    }

    @RequestMapping("/3_post")
    public String test_post3(){
        System.out.println("3_post");
        return "3_post";
    }

    @RequestMapping("/contact_get")
    public String contact_get(){
        System.out.println("login");
        return "contact_get";
    }

    @RequestMapping("/1_layout")
    public String layout(){
        return "1_layout";
    }

    @RequestMapping("/1_h5")
    public String h5(){
        return "1_h5";
    }

    @RequestMapping("/2_h5")
    public String h5_2(){
        return "2_h5";
    }

    @RequestMapping("/first_page")
    public String first_page(){
        return "first_page";
    }


    @RequestMapping("/1_download")
    public String download_1(){
        return "1_download";
    }
    @RequestMapping("/1_js")
    public String js_1(){
        return "1_js";
    }


    @RequestMapping("/five_page")
    public String five_page(){
        return "five_page";
    }


    @RequestMapping("/1_jsdemo")
    public String jsdemo_1(){
        return "1_jsdemo";
    }


    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }


    @RequestMapping("/logins")
    public String logins(){
        return "logins";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        System.out.println("getlogin");
        boolean b;
        b=userService.find(username,password);
        System.out.println(username);
        System.out.println(password);
        b = true;
        if (b == true){
            System.out.println("dashboard2");
            return "dashboard2";
        }else{
            System.out.println("login");
            return "login";
        }
    }

    @GetMapping("/registration.html")
    public String registration(){
        System.out.println("registration");
        return "registration";
    }

    @GetMapping("/reset-password.html")
    public String resetPassword(){
        System.out.println("resetPassword");
        return "reset-password";
    }

}
