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
public class FormController {
    @Autowired
    private AllService service;

    private CheckPermission permission = new CheckPermission();

    public ReqDto reqDto = new ReqDto();

    @PostMapping("/publish_profile")
    public String PublishProfile(HttpSession session
            ,@RequestParam("personal_intro")       String personal_intro
            ,@RequestParam("love_status")          String love_status
            ,@RequestParam("user_job")             String user_job
            ,@RequestParam("user_company")         String user_company
            ,@RequestParam("user_country")         String user_country
            ,@RequestParam("user_province")        String user_province
            ,@RequestParam("user_city")            String user_city
            ,@RequestParam("user_junior_school")   String user_junior_school
            ,@RequestParam("user_junior_period")   String user_junior_period
            ,@RequestParam("user_senior_school")   String user_senior_school
            ,@RequestParam("user_senior_period")   String user_senior_period
            ,@RequestParam("user_bachelor_school") String user_bachelor_school
            ,@RequestParam("user_bachelor_period") String user_bachelor_period
            ,@RequestParam("user_master_school")   String user_master_school
            ,@RequestParam("user_master_period")   String user_master_period
            ,@RequestParam("user_phd_school")      String user_phd_school
            ,@RequestParam("user_phd_period")      String user_phd_period
            ,@RequestParam("user_postphd_shcool")  String user_postphd_shcool
            ,@RequestParam("user_postphd_period")  String user_postphd_period
            ,@RequestParam("confirm")  String confirm
    ) throws IOException {
        // 这里设置成1 表示，个人资料输入到mysql之后，当页面调用"/get_profile"
        // 可以不走 if (session.getAttribute("profile_edit_flag") == "2")里面的条件
        session.setAttribute("profile_edit_flag", "1");
        reqDto.setSession(session);
        reqDto.personal_intro       = personal_intro;
        reqDto.love_status          = love_status;
        reqDto.user_job             = user_job;
        reqDto.user_company         = user_company;
        reqDto.user_country         = user_country;
        reqDto.user_province        = user_province;
        reqDto.user_city            = user_city;
        reqDto.user_junior_school   = user_junior_school;
        reqDto.user_junior_period   = user_junior_period;
        reqDto.user_senior_school   = user_senior_school;
        reqDto.user_senior_period   = user_senior_period;
        reqDto.user_bachelor_school = user_bachelor_school;
        reqDto.user_bachelor_period = user_bachelor_period;
        reqDto.user_master_school   = user_master_school;
        reqDto.user_master_period   = user_master_period;
        reqDto.user_phd_school      = user_phd_school;
        reqDto.user_phd_period      = user_phd_period;
        reqDto.user_postphd_shcool  = user_postphd_shcool;
        reqDto.user_postphd_period  = user_postphd_period;
        System.out.println("publish_profile中confirm的value是："+confirm);
        //只有前端点击确认才写入数据库，点击取消则直接返回home
        if(confirm.equals("确定")){
            String resPage = service.insert_profile(reqDto);
            return "redirect:" + resPage;
        }
        return "redirect:home";
    }

    @PostMapping("/publish_comment")
    public String PublishComment(HttpSession session, @RequestParam("id") String comment_content_id, @RequestParam("comment_content") String comment_content) throws IOException {
        reqDto.setSession(session);
        reqDto.setComment_content_id(comment_content_id);
        reqDto.setComment_content(comment_content);
        String resPage = service.insert_comment(reqDto);
        return "redirect:" + resPage;
    }

    @PostMapping("/publish_content")
    public String PublishContent(HttpSession session
            ,@RequestParam("topic_id") String topic_id
            ,@RequestParam("topic_name") String topic_name
            ,@RequestParam("title") String title
            ,@RequestParam("content") String content) throws IOException {
        reqDto.setSession(session);
        reqDto.setTopic_id(topic_id);
        reqDto.setTopic_name(topic_name);
        reqDto.setTitle(title);
        reqDto.setContent(content);
        reqDto.is_publishcontent = "1";
        System.out.println("这里进行数据的写入工作");
        String resPage = service.insert_content(reqDto);
        System.out.println("这里进行数据的写入工作2");
        return "redirect:" + resPage;
    }




    @PostMapping("/publish_private_message")
    public String publishPrivateMessage(HttpSession session
            ,@RequestParam("private_message_friend_name") String private_message_friend_name
            ,@RequestParam("to_message_content") String to_message_content) throws IOException {
        reqDto.setSession(session);
        reqDto.private_message_friend_name = private_message_friend_name;
        reqDto.to_message_content = to_message_content;
        reqDto.from_message_content = "";
        reqDto.private_message_show_flag = "1";
        reqDto.is_read = "0";
        reqDto.private_messages_input_value = "点击发送私信给" + private_message_friend_name;
        System.out.println("这里进行收到了post的数据");
        System.out.println("这里进行收到了post的数据private_message_friend_name"+private_message_friend_name);
        System.out.println("这里进行收到了post的数据pto_message_content"+to_message_content);
        String resPage = service.insertPrivateMessage(reqDto);

        return "message";
    }


    @PostMapping("/search_content")
    public String search_content(HttpSession session
//            , @RequestParam("select_id") String select_id
            , @RequestParam("content") String content) throws IOException {
//        System.out.println("select_id的内容是："+select_id);
        System.out.println("content的内容是："+content);
        service.insertApproveFriendApply(reqDto);
        return "home";
    }
}