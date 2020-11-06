package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.constant.VisitFlag;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.model.User;
import com.TTEnglish.backend.service.AllService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class GetController {
    public ReqDto reqDto = new ReqDto();
    public User user = new User();
    private AllService service = new AllService();
    private VisitFlag visitFlag = new VisitFlag();

    @PostMapping("/get_fold_message")
    public String old_message(HttpSession session
            , @RequestParam("fname") String fname
            , @RequestParam("lname") String lname) throws IOException {
        System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据");
        System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据fname:"+fname);
        System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据lname:"+lname);

        return "这个是后端返回的测试历史聊天数据";
    }

    @PostMapping("/get_fold_message_new_back")
    public String old_message2(HttpSession session
            , @RequestParam("fname") String fname
            , @RequestParam("lname") String lname) throws IOException {
        System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据new_back");
        System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据fname12131:"+fname);
        System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据lname131:"+lname);
        return "这个是后端返回的测试历史聊天数据new_back";
    }
}