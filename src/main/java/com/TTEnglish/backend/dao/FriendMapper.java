package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.Friend;

import java.util.List;

public interface FriendMapper {
   void insertNewFriend(String username,String recommend_friend_name);
   void insertNewFriendApply(String username,String recommend_friend_name,String apply_friend_message,String is_friend);
   void insertApproveFriendApply(String username,String recommend_friend_name,String is_accept);
   void deleteFriend(String username,String deletefriend_name);
   public List<Friend> SelectFriendByUsername(String username);
   public List<Friend> selectApplyFriend(String username);
   public List<Friend> SelectRecommendFriendByUsername(String username);

}
