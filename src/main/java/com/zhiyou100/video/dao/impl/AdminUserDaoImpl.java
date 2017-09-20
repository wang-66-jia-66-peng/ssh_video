package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.video.dao.AdminUserDao;
import com.zhiyou100.video.model.Admin;

public class AdminUserDaoImpl extends  HibernateDaoSupport implements AdminUserDao {

	@Override
	public List<Admin> findLoginUser(String loginName, String pwd) {
		System.out.println(loginName+pwd);
		List<Admin> find = (List<Admin>) getHibernateTemplate().find("from Admin  where  login_name= ?  and  login_pwd = ? ", 
				loginName,pwd);
		return find;
	}

	
	
	
	
	
}
