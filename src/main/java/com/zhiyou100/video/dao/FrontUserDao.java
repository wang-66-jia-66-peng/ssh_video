package com.zhiyou100.video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.video.model.User;

public interface FrontUserDao {

	User findLogin(DetachedCriteria dc);

	User findUserByEmail(DetachedCriteria dc);

	void addResgistUser(User user);

	User findUserById(Integer id);

	void addUserProfile(User us);

	List<User> findUserByEmail(String email);

}
