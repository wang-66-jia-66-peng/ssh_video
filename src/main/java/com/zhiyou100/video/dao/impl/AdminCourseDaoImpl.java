package com.zhiyou100.video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.video.dao.AdminCourseDao;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

public class AdminCourseDaoImpl extends HibernateDaoSupport implements AdminCourseDao {
    
	@Override
	public List<Course> findCourseAll() {
	     List<Course> list = (List<Course>) getHibernateTemplate().find("from Course");
		return list;
	}

	@Override
	public Course findCourseAllById(Integer courseId) {
		 List<Course> list = (List<Course>) getHibernateTemplate().find("from Course where  id= ?" ,courseId);
		 return list.get(0);
	}

	@Override
	public List<Course> findCourseBySearch(Integer page) {
		DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
		 
		  List<Course> list = (List<Course>) getHibernateTemplate().findByCriteria(dc, (page-1)*10,10);
		  return list;
	}

	@Override
	public Integer findCourseBySearchCount(Integer page) {
		DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
		List<Course> list = (List<Course>) getHibernateTemplate().findByCriteria(dc);
		 return list.size();
	}

	@Override
	public void addCourse(Course course) {
		getHibernateTemplate().saveOrUpdate(course);
		
	}

	@Override
	public void deleteCourseById(Integer id) {
		 List<Course> list = (List<Course>) getHibernateTemplate().find("from Course where  id= ?" ,id);
		 getHibernateTemplate().delete(list.get(0));
		
	}

	@Override
	public Course findCourseById(Integer id) {
		List<Course> list = (List<Course>) getHibernateTemplate().find("from Course where  id= ?" ,id);
		return list.get(0);
	}

	@Override
	public List<Course> findAllCourseAndVideo(Integer id) {
		List<Course> list = (List<Course>) getHibernateTemplate().find("from Course where  subjectId= ?" ,id);
		return list;
	}

}
