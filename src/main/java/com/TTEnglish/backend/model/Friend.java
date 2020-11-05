package com.TTEnglish.backend.model;

public class Friend {
	private String id;
	private String username;
	private String friend_name;
	private String user_create_time;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFriend_name() {
		return friend_name;
	}

	public void setFriend_name(String friend_name) {
		this.friend_name = friend_name;
	}

	public String getUser_create_time() {
		return user_create_time;
	}

	public void setUser_create_time(String user_create_time) {
		this.user_create_time = user_create_time;
	}
}
