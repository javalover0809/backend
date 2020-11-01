package com.TTEnglish.backend;

import com.TTEnglish.backend.dao.UserMapper;
import com.TTEnglish.backend.model.Content;
import com.TTEnglish.backend.model.ReqDto;
import com.TTEnglish.backend.model.User;
import com.TTEnglish.backend.service.UserService;
import com.TTEnglish.backend.util.CheckPermission;
import com.TTEnglish.backend.util.MySessionFactory;
import com.TTEnglish.backend.util.UseContent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {
	public Content content = new Content();
	public UseContent write = new UseContent();
	private CheckPermission permission = new CheckPermission();
	private UserService  service = new UserService();
	private ReqDto reqDto = new ReqDto();

	@Test
	public void contextLoads() {
	}
	@Test
	public void selectall() throws IOException {

		System.out.println(service.selectAll(reqDto));
	}
	@Test
	public void writes() throws IOException {
		write.insert("唐国洁","这个是标题的内容","这些内容真的很重要");
	}

	@Test
	public void mytest() throws IOException {


			SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
			SqlSession session = sqlSessionFactory.openSession();
			//获取dao接口的代理类
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User user = userMapper.getUserById(1);
			System.out.println(user);
			session.close();
	}


		@Test
		public void test () throws ClassNotFoundException, SQLException {
			String URL = "jdbc:mysql://localhost:3306/test_use?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			String USER = "root";
			String PASSWORD = "123456";
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库链接
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("数据库连接的是：" + conn);
			//3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			//4.处理数据库的返回结果(使用ResultSet类)
			while (rs.next()) {
				System.out.println(rs.getString("username") + " "
						+ rs.getString("password"));
			}

			//关闭资源
			rs.close();
			st.close();
			conn.close();
		}
	}

