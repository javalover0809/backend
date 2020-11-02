package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.service.AllService;
import com.TTEnglish.backend.util.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PublishController {
    @Autowired
    private AllService allService;

    private CheckPermission permission = new CheckPermission();

    public ReqDto reqDto = new ReqDto();

    @PostMapping("/publish_comment")
    public String PublishComment(HttpSession session, @RequestParam("id") String comment_content_id, @RequestParam("comment_content") String comment_content) throws IOException {
        reqDto.setSession(session);
        reqDto.setComment_content_id(comment_content_id);
        reqDto.setComment_content(comment_content);
        String resPage = allService.insert_comment(reqDto);
        return "redirect:" + resPage;
    }

    @PostMapping("/publish_content")
    public String PublishContent(HttpSession session, @RequestParam("title") String title, @RequestParam("content") String content) throws IOException {
        reqDto.setSession(session);
        reqDto.setTitle(title);
        reqDto.setContent(content);
        String resPage = allService.insert_content(reqDto);
        return "redirect:" + resPage;
    }


}