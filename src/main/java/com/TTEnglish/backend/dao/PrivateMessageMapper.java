package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.PrivateMessage;

import java.util.List;

public interface PrivateMessageMapper {
   void insertPrivateMessage(String username
                            ,String private_message_friend_name
                            ,String to_message_content
                            ,String from_message_content
                            ,String private_message_show_flag
                            ,String private_messages_input_value
                            ,String is_read);

   public List<PrivateMessage> SelectPrivateMessageAlert(String username);
   public List<PrivateMessage> selectPrivateMessageContent(String username, String private_message_friend_name);
}
