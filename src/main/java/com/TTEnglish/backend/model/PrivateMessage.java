package com.TTEnglish.backend.model;

public class PrivateMessage {
	private String id;
	private String username;
	private String private_message_friend_name;
	private String to_message_content;
	private String from_message_content;
	private String private_message_show_flag;
	private String private_messages_input_value;
	private String message_create_time;


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

	public String getPrivate_message_friend_name() {
		return private_message_friend_name;
	}

	public void setPrivate_message_friend_name(String private_message_friend_name) {
		this.private_message_friend_name = private_message_friend_name;
	}

	public String getTo_message_content() {
		return to_message_content;
	}

	public void setTo_message_content(String to_message_content) {
		this.to_message_content = to_message_content;
	}

	public String getFrom_message_content() {
		return from_message_content;
	}

	public void setFrom_message_content(String from_message_content) {
		this.from_message_content = from_message_content;
	}

	public String getPrivate_message_show_flag() {
		return private_message_show_flag;
	}

	public void setPrivate_message_show_flag(String private_message_show_flag) {
		this.private_message_show_flag = private_message_show_flag;
	}

	public String getPrivate_messages_input_value() {
		return private_messages_input_value;
	}

	public void setPrivate_messages_input_value(String private_messages_input_value) {
		this.private_messages_input_value = private_messages_input_value;
	}

	public String getMessage_create_time() {
		return message_create_time;
	}

	public void setMessage_create_time(String message_create_time) {
		this.message_create_time = message_create_time;
	}
}
