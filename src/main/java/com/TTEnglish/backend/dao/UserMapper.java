package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.User;

public interface UserMapper {
   void registerMapper(String username,String password);
   public User getUserById(Integer id);
   public User getUserByUsername(String username);
}
