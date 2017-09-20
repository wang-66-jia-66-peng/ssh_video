package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.video.dao.AdminSpeakerDao;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

public class AdminSpeakerDaoImpl extends HibernateDaoSupport implements AdminSpeakerDao {

	@Override
	public List<Speaker> findSpeakerAll() {
		List<Speaker> list = (List<Speaker>) getHibernateTemplate().find("from Speaker");
		return  list;
	}

	@Override
	public Speaker findSpeakerByid(Integer speakerId) {
		List<Speaker> list = (List<Speaker>) getHibernateTemplate().find("from Speaker where id = ?",speakerId);
		return  list.get(0);
	}

	@Override
	public List<Speaker> findVideoBySearch(String speakerSearchName, String speakerSearchJob, Integer page) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(Speaker.class);
		if (!speakerSearchName.equals("")) {
			dc.add(Restrictions.like("speakerName","%"+speakerSearchName+"%"));
		}
		if (!speakerSearchJob.equals("")) {
			dc.add(Restrictions.like("speakerJob","%"+speakerSearchJob+"%"));
		}
	 
	   List<Speaker> list = (List<Speaker>) getHibernateTemplate().findByCriteria(dc,(page-1)*10,10);
		
	   return list;
	}

	@Override
	public Integer findVideoBySearchCount(String speakerSearchName, String speakerSearchJob, Integer page) {
		DetachedCriteria dc = DetachedCriteria.forClass(Speaker.class);
		if (!speakerSearchName.equals("")) {
			dc.add(Restrictions.like("speakerName","%"+speakerSearchName+"%"));
		}
		if (!speakerSearchJob.equals("")) {
			dc.add(Restrictions.like("speakerJob","%"+speakerSearchJob+"%"));
		}
	 
	   List<Speaker> list = (List<Speaker>) getHibernateTemplate().findByCriteria(dc);
		  return list.size();
	}

	@Override
	public void addspeaker(Speaker speaker) {
		  getHibernateTemplate().saveOrUpdate(speaker);
		
	}

	@Override
	public void deleteSpeakerById(Integer id) {
		 List<Speaker> list = (List<Speaker>) getHibernateTemplate().find("from Speaker where id = ?",id);
		 System.out.println(list);
		 getHibernateTemplate().delete(list.get(0));
	}


	

}
