package com.zjgsu.backend.postcontroller;


import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:08
 */
@RestController
public class PostController {
    @PostMapping(value = "/2_post")
    public String demo(@RequestParam("name") String name ,@RequestParam("age") String sex)  {
        System.out.println("名字是 = [" + name + "], age = [" + sex + "]");
        return "server response";
    }
}
