package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.User;

public interface UserMapper {
   public User getUserById(Integer id);
   public User getUserByUsername(String username);
}
