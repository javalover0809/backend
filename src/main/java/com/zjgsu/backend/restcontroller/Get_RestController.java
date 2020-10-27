package com.zjgsu.backend.restcontroller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:08
 */
@RestController
public class Get_RestController {


    @RequestMapping("/get_rest")
    public String get_front() {
        String str= "{\"answer\":\"yes\",\"forced\":false,\"image\":\"https://yesno.wtf/assets/yes/15-3d723ea13af91839a671d4791fc53dcc.gif\"}";
        System.out.println("名称是：" + str);
        return str;
    }
}
