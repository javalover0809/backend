package com.TTEnglish.backend.service;

import com.TTEnglish.backend.dao.UserDao;
import com.TTEnglish.backend.model.Content;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.model.UserBean;
import com.TTEnglish.backend.util.CheckPermission;
import com.TTEnglish.backend.util.UseContent;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserService {
    @Autowired
    private UserDao userDao;

    private CheckPermission permission = new CheckPermission();
    private UseContent useContent = new UseContent();

    public JSON selectAll(ReqDto reqDto) throws IOException {
        Content content= useContent.selectAll();
        JSON json= (JSON) JSON.toJSON(content);
        return json;
    }

    public String insert_content(ReqDto reqDto) throws IOException {
        if(reqDto.session.getAttribute("username")==null){
            System.out.println("please login in");
            return "login";

        }
        String username=reqDto.session.getAttribute("username").toString();
        String password=reqDto.session.getAttribute("password").toString();
        if(permission.check(username,password)){
            System.out.println("input the data");
            useContent.insert(username,reqDto.title ,reqDto.content);
            return "home";
        }
        System.out.println("input the data two");
        String resPage = "home";
        return resPage;
    }





    public boolean find(String username,String password){
        boolean b= true;
        List<UserBean> all = userDao.findAll();
        System.out.println("ALL:" + all);
        System.out.println("all.size()"+all.size());
        for (int i=0;i<all.size();i++){
            UserBean one = all.get(i);
            System.out.println("i="+i);
//            if (username.equals(one.getUsername())&&password.equals(one.getPassword())){
            if (true){
                System.out.println("b=true");
                b=true;
                break;
            }else{
                System.out.println("b=false");
                b=false;
            }
        }
        return b;
    }
}
