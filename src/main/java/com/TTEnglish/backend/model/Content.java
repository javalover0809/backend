package com.TTEnglish.backend.model;

import java.util.ArrayList;
import java.util.List;

public class Content {

	private String  id;
	private String  topic_id;
	private String  topic_name;
	private String  username;
	private String  title;
	private String  content;
	private String  time;
	private String  content_id;
	private String  agree_content_num;
	private String  disagree_content_num;
	private List<Comment> comment = new ArrayList<Comment>();


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent_id() {
		return content_id;
	}

	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}

	public String getAgree_content_num() {
		return agree_content_num;
	}

	public void setAgree_content_num(String agree_content_num) {
		this.agree_content_num = agree_content_num;
	}

	public String getDisagree_content_num() {
		return disagree_content_num;
	}

	public void setDisagree_content_num(String disagree_content_num) {
		this.disagree_content_num = disagree_content_num;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
}
