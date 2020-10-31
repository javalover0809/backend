package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.model.PublishRandom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/home")
    public String greethome(Model model) {

        return "home";
    }

    @GetMapping("/home2")
    public String greethome2(Model model) {
        return "home2";
    }

    @PostMapping("/publish_random")
    public String PublishRandom(@ModelAttribute PublishRandom random_time_content) {
        System.out.println("publish_random the contents are " + random_time_content.getRandom());
        return "redirect:home";
    }

}