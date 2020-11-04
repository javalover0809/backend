package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.User;

public interface UserMapper {
   void registerMapper(String username,String password);
   void inserProfileMapper(String username
                          ,String password
                          ,String personal_intro
                          ,String love_status
                          ,String user_job
                          ,String user_company
                          ,String user_country
                          ,String user_province
                          ,String user_city
                          ,String user_junior_school
                          ,String user_junior_period
                          ,String user_senior_school
                          ,String user_senior_period
                          ,String user_bachelor_school
                          ,String user_bachelor_period
                          ,String user_master_school
                          ,String user_master_period
                          ,String user_phd_school
                          ,String user_phd_period
                          ,String user_postphd_shcool
                          ,String user_postphd_period);
   public User getUserById(Integer id);
   public User getUserByUsername(String username);
}
