package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.Friend;

import java.util.List;

public interface FriendMapper {
   void insertNewFriend(String username,String recommend_friend_name);
   void deleteFriend(String username,String deletefriend_name);
   public List<Friend> SelectFriendByUsername(String username);
   public List<Friend> SelectRecommendFriendByUsername(String username);

}
