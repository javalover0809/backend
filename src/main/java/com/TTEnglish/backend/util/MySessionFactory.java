package com.TTEnglish.backend.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MySessionFactory {

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        //下面四行是获取 SqlSessionFactory的方式,其目的是为了获取 SqlSession
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        inputStream = Resources.getResourceAsStream(resource);
        org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /*  SqlSession 是非线程安全的，所以不能把它设成一个成型变量
         *  SqlSession 代表与数据库的一次会话，相当于Connection
         *  SqlSession 使用完成后记得关闭
         * */
        return sqlSessionFactory;
    }
}