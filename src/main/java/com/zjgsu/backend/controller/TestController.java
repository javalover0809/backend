package com.zjgsu.backend.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 1:08
 */
@RestController
public class TestController {


    @RequestMapping("/nihao")
    public String nihao(){
       String str = "这个就是内容问题Vue中axios在发送POST请求时，参数的处理";
       return str;
    }

    @RequestMapping("/contact_post")
    public String contact_post(){
        String str = "contact_post";
        return str;
    }
}
