package com.TTEnglish.backend.dao;

import com.TTEnglish.backend.model.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend_csdn
 * User: quent
 * Date: 2018/11/29
 * Time: 10:23
 */
public interface UserDao extends JpaRepository<UserBean,Integer> {
}
