package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.model.Content;
import com.TTEnglish.backend.util.UseContent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OutputController {

    @GetMapping("/get_content")
    public String home() throws IOException {
        Content cnt = new UseContent().read();
        String title = cnt.getTitle();
        String content = cnt.getContent();
        System.out.println(title+":"+content);
        String json= "{\"id\":1,\"name\":\"老王\",\"password\":\"老王\"}";
        System.out.println("data_is_"+json);
        return json;
    }
}