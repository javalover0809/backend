package com.TTEnglish.backend.service;

import com.TTEnglish.backend.dao.UserDao;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.model.UserBean;
import com.TTEnglish.backend.util.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public String input_content(ReqDto reqDto){

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
