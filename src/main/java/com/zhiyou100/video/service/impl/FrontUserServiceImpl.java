package com.zhiyou100.video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.FrontUserDao;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
@Service
public class FrontUserServiceImpl implements FrontUserService {

      @Autowired
	 FrontUserDao  fud;
	
	@Override
	public User findLogin(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return fud.findLogin( dc);
	}

	@Override
	public User findUserByEmail(DetachedCriteria dc) {
		
		return fud.findUserByEmail(dc);
	}

	@Override
	public void addResgistUser(User user) {
		  fud.addResgistUser( user);
	}

	@Override
	public User findUserById(Integer id) {
		
		return fud.findUserById( id);
	}

	

	@Override
	public void addUserProfile(User us) {
		  fud.addUserProfile(us);
		
	}

	@Override
	public void updateAvatar(User use) {
		fud.addUserProfile(use);
		
	}

	@Override
	public List<User> findUserByEmail(String email) {
		
		return fud.findUserByEmail( email);
	}
  
	
	
}
