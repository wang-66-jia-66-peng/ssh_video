package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.video.dao.FrontUserDao;
import com.zhiyou100.video.model.User;

public class FrontUserDaoImpl  extends HibernateDaoSupport implements FrontUserDao {

	@Override
	public User findLogin(DetachedCriteria dc) {
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		
		if (list.size()==0) {
			 return  null;
		}
		
		 return list.get(0);
	}

	@Override
	public User findUserByEmail(DetachedCriteria dc) {
		
	  List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
	     if (list.size()==0) {
			 return  null;
		}
		
		 return list.get(0);
	}

	@Override
	public void addResgistUser(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	@Override
	public User findUserById(Integer id) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User  where  id = ?", id);
		return list.get(0);
	}

	@Override
	public void addUserProfile(User us) {
		getHibernateTemplate().saveOrUpdate(us);
		
	}

	@Override
	public List<User> findUserByEmail(String email) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User  where  email = ?", email);
		 return list;
	}
	
	
	
	
	
	

}
