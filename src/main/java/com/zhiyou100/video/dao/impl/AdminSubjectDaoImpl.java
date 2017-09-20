package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.video.dao.AdminSubjectDao;
import com.zhiyou100.video.model.Subject;

public class AdminSubjectDaoImpl  extends  HibernateDaoSupport  implements AdminSubjectDao {

	@Override
	public List<Subject> findAllSubject() {
		List<Subject> list = (List<Subject>) getHibernateTemplate().find("from Subject");
		  
		return list;
	}

	@Override
	public Subject findAllSubjectById(Integer subjectId) {
		List<Subject> list = (List<Subject>) getHibernateTemplate().find("from Subject where id = ?",subjectId);
		return list.get(0);
	}

	@Override
	public Subject findSubjectById(String subjectId) {
		Integer  id= Integer.parseInt(subjectId);
		List<Subject> list = (List<Subject>) getHibernateTemplate().find("from Subject where id = ?",id);
		 System.out.println(list.get(0));
		return list.get(0);
		
	}

	
	
	
}
