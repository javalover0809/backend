package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class OutputController {
    public ReqDto reqDto = new ReqDto();
    private UserService service = new UserService();

    @GetMapping("/get_content")
    public JSON get_content(HttpSession session) throws IOException {
        reqDto.session = session;
        return service.selectAll(reqDto);
    }
}