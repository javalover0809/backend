package com.TTEnglish.backend;

import com.TTEnglish.backend.controller.AxiosController;
import com.TTEnglish.backend.controller.FormController;
import com.TTEnglish.backend.dao.FriendMapper;
import com.TTEnglish.backend.dao.PrivateMessageMapper;
import com.TTEnglish.backend.dao.UserMapper;
import com.TTEnglish.backend.model.*;
import com.TTEnglish.backend.service.AllService;
import com.TTEnglish.backend.util.CheckPermission;
import com.TTEnglish.backend.util.ManipulateMysql;
import com.TTEnglish.backend.util.MySessionFactory;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {
	public FormController FormController = new FormController();
	public Content content = new Content();
	public ManipulateMysql manipulateMysql = new ManipulateMysql();
	private CheckPermission permission = new CheckPermission();
	private AllService service = new AllService();
	private ReqDto reqDto = new ReqDto();
	private AxiosController AxiosController = new AxiosController();

 	@Test
	public void seletprivatemessage() throws IOException {
		SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		PrivateMessageMapper privateMessageMapper = session.getMapper(PrivateMessageMapper.class);
		List<PrivateMessage> ListprivateMessage = privateMessageMapper.selectPrivateMessageContent("唐国洁", "Elon Musk");
		System.out.println(ListprivateMessage);
		session.close();
	}

	@Test
	public void selectRecommendfriend() throws IOException {
		SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		List<Friend> friends = friendMapper.SelectRecommendFriendByUsername("唐国洁");
		System.out.println(friends);
		session.close();


	}

	@Test
	public void selectfriend() throws IOException {

		SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		List<Friend> friends = friendMapper.SelectFriendByUsername("唐国洁");
		System.out.println(friends);
		session.close();

	}
	
	

	@Test
	public void insertfriend() throws IOException {
		SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		friendMapper.insertNewFriend("唐国洁","史玉柱");
		session.commit();
		session.close();
	}



	@Test
	public void setPublishController() throws IOException {
		SqlSessionFactory sqlSessionFactory = new MySessionFactory().getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getUserByUsername("tangguojie");
		System.out.println(user);
		System.out.println(user.getUser_bachelor_period());
		session.close();
	}

	@Test
	public void select() throws IOException {
		List<Content> contents = service.SelectContent(reqDto);
		System.out.println(contents.get(0));
		System.out.println(contents.get(0).getComment());
		System.out.println(contents.get(0).getComment().get(0));
		System.out.println(contents.get(0).getComment().get(0).getComment_content());

}


	@Test
	public void publish_comment() throws IOException {
		FormController.PublishComment(reqDto.getSession(),"5","测试数据");
	}


	@Test
	public void selectContent() throws IOException {
	}


	@Test
	public void selectall() throws IOException {
		String json = "{\"abc\":1,\"hahah\":2}";
		String result = "{\"title\":\"这些是查询的结果\"}";
		String restult2 = "{\"title\": \"会议id:1887\"}";
		String result3 = "{\"first\":\"{\"title\": \"会议id:1887\"}\"\"second\":\"{\"content\": \"每天一起学习英语吧\"}\"}";
		JSONObject jsonObject = JSONObject.parseObject(result3);
		System.out.println(jsonObject);
//		System.out.println(jsonObject.getJSONObject("first"));
//		System.out.println(service.selectString(reqDto));
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

