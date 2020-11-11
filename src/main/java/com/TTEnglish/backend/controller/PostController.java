package com.TTEnglish.backend.controller;

import com.TTEnglish.backend.constant.VisitFlag;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.model.User;
import com.TTEnglish.backend.service.AllService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

    @RestController
    public class PostController {
        public ReqDto reqDto = new ReqDto();
        public User user = new User();
        private AllService service = new AllService();
        private VisitFlag visitFlag = new VisitFlag();

        @PostMapping("/close_comment_alert")
        public String close_comment_alert(HttpSession session
                , @RequestParam("comment_content_id") String comment_content_id
                , @RequestParam("comment_username") String comment_username)
                throws IOException {
            reqDto.setSession(session);
            //因为是对方发送来的信息，因为需要把对方设未username，方便在mysql进行，已读数据的update操作
            reqDto.setComment_content_id(comment_content_id);
            reqDto.comment_username  =comment_username;
            reqDto.is_read = "1";;
            service.updateReadCommentMessage(reqDto);
            return "new_back";
        }


        @PostMapping("/close_message_alert")
        public String close_message_alert(HttpSession session
                , @RequestParam("friend_name") String friend_name) throws IOException {
            reqDto.setSession(session);
            //因为是对方发送来的信息，因为需要把对方设未username，方便在mysql进行，已读数据的update操作
            reqDto.setUsername(friend_name);
            reqDto.private_message_friend_name = session.getAttribute("username").toString();
            reqDto.is_read = "1";;
            service.updateReadMessage(reqDto);
            return "new_back";
        }

        @PostMapping("/apply_for_friend")
        public String apply_for_friend(HttpSession session
                , @RequestParam("friend_name") String friend_name
                , @RequestParam("apply_friend_message") String apply_friend_message) throws IOException {
            reqDto.setSession(session);
            reqDto.recommend_friend_name = friend_name;
            reqDto.apply_friend_message = apply_friend_message;
            reqDto.is_friend = "0";
            service.insertNewFriendApply(reqDto);
            return "new_back";
        }

        @PostMapping("/approve_for_friend")
        public String approve_for_friend(HttpSession session
                , @RequestParam("friend_name") String friend_name) throws IOException {
            reqDto.setSession(session);
            reqDto.recommend_friend_name = friend_name;
            reqDto.is_accept = "1";
            service.insertApproveFriendApply(reqDto);
            return "new_back";
        }

        @PostMapping("/reject_for_friend")
        public String reject_for_friend(HttpSession session
                , @RequestParam("friend_name") String friend_name) throws IOException {
            reqDto.setSession(session);
            reqDto.recommend_friend_name = friend_name;
            reqDto.is_accept = "0";
            service.insertApproveFriendApply(reqDto);
            return "new_back";
        }

        @PostMapping("/agree_comment")
        public String agree_comment(HttpSession session
                , @RequestParam("assess_id") String assess_id
                , @RequestParam("assessed_username") String assessed_username)throws IOException {
            reqDto.setSession(session);
            reqDto.assess_id = assess_id;
            reqDto.assessed_username = assessed_username;
            reqDto.is_comment = "1";
            reqDto.is_agree = "1";
            System.out.println("assessed_username的数据是："+assessed_username);
            System.out.println("assess_id的数据是："+assess_id);
            service.insertAssessComment(reqDto);
            return "new_back";
        }

        @PostMapping("/agree_content")
        public String agree_content(HttpSession session
                , @RequestParam("assess_id") String assess_id
                , @RequestParam("assessed_username") String assessed_username)throws IOException {
            reqDto.setSession(session);
            reqDto.assess_id = assess_id;
            reqDto.assessed_username = assessed_username;
            reqDto.is_comment = "0";
            reqDto.is_agree = "1";
            System.out.println("assessed_username的数据是："+assessed_username);
            System.out.println("assess_id的数据是："+assess_id);
            service.insertAssessComment(reqDto);
            return "new_back";
        }

        @PostMapping("/disagree_comment")
        public String disagree_comment(HttpSession session
                , @RequestParam("assess_id") String assess_id
                , @RequestParam("assessed_username") String assessed_username)throws IOException {
            reqDto.setSession(session);
            reqDto.assess_id = assess_id;
            reqDto.assessed_username = assessed_username;
            reqDto.is_comment = "1";
            reqDto.is_agree = "0";
            System.out.println("assessed_username的数据是："+assessed_username);
            System.out.println("assess_id的数据是："+assess_id);
            service.insertAssessComment(reqDto);
            return "new_back";
        }

        @PostMapping("/disagree_content")
        public String disagree_content(HttpSession session
                , @RequestParam("assess_id") String assess_id
                , @RequestParam("assessed_username") String assessed_username)throws IOException {
            reqDto.setSession(session);
            reqDto.assess_id = assess_id;
            reqDto.assessed_username = assessed_username;
            reqDto.is_comment = "0";
            reqDto.is_agree = "0";
            System.out.println("assessed_username的数据是："+assessed_username);
            System.out.println("assess_id的数据是："+assess_id);
            service.insertAssessComment(reqDto);
            return "new_back";
        }


        @PostMapping(value = "/friend_delete")
        public String frienddelete(HttpSession session
                , @RequestParam("friend_name") String delete_friend_name) throws IOException {
            reqDto.setSession(session);
            reqDto.delete_friend_name = delete_friend_name;
            System.out.println("前端的get方法的username是ss："+delete_friend_name);
            service.deleteFriend(reqDto);
            return "new_back";
        }





    }