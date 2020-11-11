package com.TTEnglish.backend.model;

public class Comment {
	private String id;
	private String comment_id;
	private String comment_content_id;
    private String comment_username;
	private String comment_content;
	private String comment_time;
	private String agree_comment_num;
	private String disagree_comment_num;
	private String commented_username;
    private String comment_num;
    private String comment_total_num;


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

	public String getAgree_comment_num() {
		return agree_comment_num;
	}

	public void setAgree_comment_num(String agree_comment_num) {
		this.agree_comment_num = agree_comment_num;
	}

	public String getDisagree_comment_num() {
		return disagree_comment_num;
	}

	public void setDisagree_comment_num(String disagree_comment_num) {
		this.disagree_comment_num = disagree_comment_num;
	}

	public String getCommented_username() {
		return commented_username;
	}

	public void setCommented_username(String commented_username) {
		this.commented_username = commented_username;
	}

	public String getComment_num() {
		return comment_num;
	}

	public void setComment_num(String comment_num) {
		this.comment_num = comment_num;
	}

	public String getComment_total_num() {
		return comment_total_num;
	}

	public void setComment_total_num(String comment_total_num) {
		this.comment_total_num = comment_total_num;
	}
}
