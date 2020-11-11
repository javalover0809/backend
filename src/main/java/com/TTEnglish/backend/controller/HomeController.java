package com.TTEnglish.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}