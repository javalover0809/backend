package com.TTEnglish.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {


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




}