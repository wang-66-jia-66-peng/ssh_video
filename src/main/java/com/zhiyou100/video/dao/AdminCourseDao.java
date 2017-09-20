package com.zhiyou100.video.dao;

import java.util.List;

import com.zhiyou100.video.model.Course;

public interface AdminCourseDao {

	List<Course> findCourseAll();

	Course findCourseAllById(Integer courseId);

	List<Course> findCourseBySearch(Integer page);

	Integer findCourseBySearchCount(Integer page);

	void addCourse(Course course);

	void deleteCourseById(Integer id);

	Course findCourseById(Integer id);

	List<Course> findAllCourseAndVideo(Integer id);

}
