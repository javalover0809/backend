package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.constant.VisitFlag;
import com.TTEnglish.backend.model.Content;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.service.AllService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class ContentController {
    public ReqDto reqDto = new ReqDto();
    private AllService service = new AllService();
    private VisitFlag visitFlag = new VisitFlag();

    @GetMapping("/get_content")
    public List<Content> SelectCommentContent(HttpSession session) throws IOException {
        reqDto.setContent_flag(visitFlag.all_content);
        reqDto.setSession(session);
        return service.SelectCommentContent(reqDto);
    }

    @GetMapping("/get_profile")
    public List<Content> get_profile(HttpSession session) throws IOException {
        reqDto.setContent_flag(visitFlag.profile_content);
        reqDto.setSession(session);
        return service.SelectCommentContent(reqDto);
    }
}