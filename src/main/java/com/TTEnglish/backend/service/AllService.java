package com.TTEnglish.backend.service;

import com.TTEnglish.backend.model.Content;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.util.CheckPermission;
import com.TTEnglish.backend.util.ManipulateMysql;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:24
 */
@Service
public class AllService {

    private Content Content = new Content();
    private CheckPermission permission = new CheckPermission();
    private ManipulateMysql manipulateMysql = new ManipulateMysql();


    public List<Content> selecAll(ReqDto reqDto) throws IOException {
        List<Content> content = manipulateMysql.SelectAllContent();
        return content;
    }
    public List<Content> SelectContent(ReqDto reqDto) throws IOException {
        List<Content> content = manipulateMysql.SelectAllContent();
        return content;
    }

    public List<Content> SelectCommentContent(ReqDto reqDto) throws IOException {
        if(reqDto.getSession().getAttribute("username")==null){
            reqDto.getSession().setAttribute("username","supermanager");
        }

        return  manipulateMysql.SelectCommentContent(reqDto);
    }

    public JSONObject SelectAllContent(ReqDto reqDto) throws IOException {
        List<Content> content = manipulateMysql.SelectAllContent();
        JSONObject result = new JSONObject();
        result.put("contents",content);
        result.put("comments",content);
        return result;
    }

    public String insert_content(ReqDto reqDto) throws IOException {
        if(reqDto.getSession().getAttribute("username")==null){
            System.out.println("please login in");
            return "login";

        }
        if(reqDto.getSession().getAttribute("username")!=null&&reqDto.getTitle()==""||reqDto.getContent()==""){
            return "redirect:home";
        }
        String username=reqDto.getSession().getAttribute("username").toString();
        String password=reqDto.getSession().getAttribute("password").toString();
        if(permission.check(username,password)){
            System.out.println("input the data");
            manipulateMysql.insert(username,reqDto.getTitle() ,reqDto.getContent());
            return "home";
        }
        System.out.println("input the data two");
        String resPage = "home";
        return resPage;
    }

    public String insert_comment(ReqDto reqDto) throws IOException {
        if(reqDto.getSession().getAttribute("username")==null){
            System.out.println("please login in");
            return "login";
        }
        if(reqDto.getSession().getAttribute("username")!=null&&reqDto.getComment_content()==""){
            return "redirect:home";
        }
        String comment_username=reqDto.getSession().getAttribute("username").toString();
        String password=reqDto.getSession().getAttribute("password").toString();
        if(permission.check(comment_username,password)){
            System.out.println("正在输入评论数据");
            System.out.println(reqDto.getComment_content_id());
            System.out.println(reqDto.getComment_content());
            manipulateMysql.insert_comment(reqDto.getComment_content_id() ,comment_username,reqDto.getComment_content());
            return "home";
        }
        System.out.println("input the data two");
        String resPage = "home";
        System.out.println("正在输入评论数据");
        System.out.println(reqDto.getComment_content());
        System.out.println(reqDto.getComment_content());
        return resPage;
    }





}
