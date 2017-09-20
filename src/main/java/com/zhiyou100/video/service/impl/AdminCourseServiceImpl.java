package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminCourseDao;
import com.zhiyou100.video.dao.AdminSubjectDao;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.AdminCourseService;
@Service
public class AdminCourseServiceImpl implements AdminCourseService {
       @Autowired
	   AdminCourseDao   acd;
       @Autowired
       AdminSubjectDao  asd;

	@Override
	public Page<Course> findCourseBySearch(Integer page) {
		
		 Page<Course> pp = new Page<>();
		 pp.setSize(10);
		 pp.setPage(page);
		 List<Course> rows  =  acd.findCourseBySearch(page);
		 System.out.println("SSSSSSSS");
		 Integer  total = acd.findCourseBySearchCount(page);
		 System.out.println("aaaaaaaa"+rows);
		 pp.setRows(rows); 
		 pp.setTotal(total);
		 return pp;
	}

	@Override
	public List<Subject> findAllSubject() {
		
		return  asd.findAllSubject();
		 
	}

	@Override
	public Subject findAllSubjectById(Integer subjectId) {
		return asd.findAllSubjectById(subjectId);
	}

	@Override
	public void addCourse(Course course) {
	        acd.addCourse(course);
		
	}

	@Override
	public void deleteCourseById(Integer id) {
		  acd. deleteCourseById( id);
	}

	@Override
	public Course findCourseById(Integer id) {
		
		return acd.findCourseById( id);
	}

	@Override
	public Subject findSubjectById(Integer subjectId) {
	
		return  asd.findAllSubjectById(subjectId);
	}

	@Override
	public Subject findSubjectById(String subjectId) {
		
		return asd.findSubjectById(subjectId);
	}

	@Override
	public List<Course> findAllCourseAndVideo(String subjectId) {
		    Integer  id = Integer.parseInt(subjectId);
		    return acd.findAllCourseAndVideo(id);
	}
	    
}
