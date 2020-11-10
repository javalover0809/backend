package com.TTEnglish.backend.model;

public class Comment {
	private String id;
	private String comment_id;
	private String comment_content_id;
    private String comment_username;
	private String comment_content;
	private String comment_time;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_content_id() {
		return comment_content_id;
	}

	public void setComment_content_id(String comment_content_id) {
		this.comment_content_id = comment_content_id;
	}

	public String getComment_username() {
		return comment_username;
	}

	public void setComment_username(String comment_username) {
		this.comment_username = comment_username;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_time() {
		return comment_time;
	}

	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
}
