package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.User;

public interface UseMapper {
   public User getUserByUsername(String username,String content);
}
