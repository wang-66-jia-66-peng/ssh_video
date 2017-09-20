package com.zhiyou100.video.dao;

import java.util.List;

import com.zhiyou100.video.model.Subject;

public interface AdminSubjectDao {

	List<Subject> findAllSubject();

	Subject findAllSubjectById(Integer subjectId);

	Subject findSubjectById(String subjectId);

}
