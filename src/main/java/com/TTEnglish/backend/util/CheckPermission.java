package com.TTEnglish.backend.util;

import com.TTEnglish.backend.dao.UserMapper;
import com.TTEnglish.backend.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class CheckPermission {
    public boolean check(String username, String password) throws IOException {

            SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.getUserByUsername(username);
            System.out.println(user);
            session.close();
            if(!user.getUserName().equals(null)){
                return true;
            }
            return false;
    }
}
