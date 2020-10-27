package com.zjgsu.backend.controller;

import com.zjgsu.backend.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        System.out.println("数据是：" + greeting.getId() + " : " + greeting.getContent());
        if(greeting.getId().equals(111) && greeting.getContent().equals(111)){
            return "result";
        }
        return "result";
    }

    @GetMapping("/4_post")
    public String post4form(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "4_post";
    }

    @PostMapping("/4_post")
    public String postSubmit(@ModelAttribute Greeting greeting) {
        System.out.println("数据是：" + greeting.getId() + " : " + greeting.getContent());
        if(greeting.getId().equals(111) && greeting.getContent().equals(111)){
            return "result";
        }
        return "result";
    }


}