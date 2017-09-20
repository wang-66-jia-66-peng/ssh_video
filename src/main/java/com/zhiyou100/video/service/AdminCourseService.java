package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Subject;

public interface AdminCourseService {

	Page<Course> findCourseBySearch(Integer page);

	List<Subject> findAllSubject();

	Subject findAllSubjectById(Integer subjectId);

	void addCourse(Course course);

	void deleteCourseById(Integer id);

	Course findCourseById(Integer id);

	Subject findSubjectById(Integer subjectId);

	Subject findSubjectById(String subjectId);

	List<Course> findAllCourseAndVideo(String subjectId);

}
