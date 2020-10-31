package com.zjgsu.backend.controller;

import com.zjgsu.backend.model.PublishContent;
import com.zjgsu.backend.model.PublishRandom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String greethome(Model model) {
        model.addAttribute("greetings", new PublishContent());
        model.addAttribute("random", new PublishRandom());
        return "home";
    }
//    @GetMapping("/profile")
//    public String profile(){
//        return "profile";
//    }




    @PostMapping("/publish_random")
    public String PublishRandom(@ModelAttribute PublishRandom random) {
        System.out.println("publish_random发布的内容是：" + random.getRandom());
        return "redirect:home";

    }

}