package com.TTEnglish.backend.util;

import com.TTEnglish.backend.dao.UserMapper;
import com.TTEnglish.backend.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckPermission {
    public boolean check(String username, String password) throws IOException {

            SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.getUserByUsername(username);
            System.out.println(user);

            if(!user.getUsername().equals(null)){
                return true;
            }
            session.close();
            return false;
    }

    public boolean checkSession(HttpSession frontsession) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        if(frontsession.getAttribute("username")==null){
            return true;
        }
        String username = frontsession.getAttribute("username").toString();
        User user = userMapper.getUserByUsername(username);
        if(user.getUsername().equals(null)){
            return true;
        }
        session.close();
        return false;
    }
}
