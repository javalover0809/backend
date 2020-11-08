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
    public class PostController {
        public ReqDto reqDto = new ReqDto();
        public User user = new User();
        private AllService service = new AllService();
        private VisitFlag visitFlag = new VisitFlag();

        @PostMapping("/close_message_alert")
        public String close_message_alert(HttpSession session
                , @RequestParam("friend_name") String friend_name) throws IOException {
            reqDto.setSession(session);
            //因为是对方发送来的信息，因为需要把对方设未username，方便在mysql进行，已读数据的update操作
            reqDto.setUsername(friend_name);
            reqDto.private_message_friend_name = session.getAttribute("username").toString();
            reqDto.is_read = "1";;
            service.updateReadMessage(reqDto);
            return "这个是后端返回的测试历史聊天数据new_back";
        }

        @PostMapping("/apply_for_friend")
        public String apply_for_friend(HttpSession session
                , @RequestParam("friend_name") String friend_name
                , @RequestParam("apply_friend_message") String apply_friend_message) throws IOException {
            System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据new_back");
            System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据fname12131:"+friend_name);
            System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据lname131:"+apply_friend_message);
            reqDto.setSession(session);
            reqDto.recommend_friend_name = friend_name;
            reqDto.apply_friend_message = apply_friend_message;
            reqDto.is_friend = "0";
            service.insertNewFriendApply(reqDto);
            return "这个是后端返回的测试历史聊天数据new_back";
        }

        @PostMapping("/approve_for_friend")
        public String approve_for_friend(HttpSession session
                , @RequestParam("friend_name") String friend_name) throws IOException {
            System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据new_back");
            System.out.println("这个是后端返回的测试历史聊天数据这是第三条数据fname12131:"+friend_name);
            reqDto.setSession(session);
            reqDto.recommend_friend_name = friend_name;
            reqDto.is_accept = "1";
            service.insertApproveFriendApply(reqDto);
            return "这个是后端返回的测试历史聊天数据new_back";
        }

        @PostMapping("/reject_for_friend")
        public String reject_for_friend(HttpSession session
                , @RequestParam("friend_name") String friend_name) throws IOException {
            reqDto.setSession(session);
            reqDto.recommend_friend_name = friend_name;
            reqDto.is_accept = "0";
            service.insertApproveFriendApply(reqDto);
            return "这个是后端返回的测试历史聊天数据new_back";
        }
    }