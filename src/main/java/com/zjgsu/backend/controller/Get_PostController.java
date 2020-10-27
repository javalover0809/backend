package com.zjgsu.backend.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:08
 */
@RestController
public class Get_PostController {
    @PostMapping("/get_front")
    public String get_front(@RequestParam("name") String name) {
        System.out.println("名称是：" + name);
        return "name：" + name;
    }
}
