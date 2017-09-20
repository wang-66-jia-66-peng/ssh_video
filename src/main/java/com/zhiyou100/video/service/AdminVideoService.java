package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

public interface AdminVideoService {

	List<Speaker> findSpeakerAll();

	List<Course> findCourseAll();

	Page<Video> findVideoBySearch(String videoKeyWord, Integer videoSearchSpeaker, Integer videoSearchCourse,
			Integer currentPage);

	void addVideo(Video video);

	Course findCourseAllById(Integer courseId);

	Speaker findSpeakerByid(Integer speakerId);

	void deleteVideoById(Integer vid);

	Video findVideoById(Integer id);

	List<Video> statisticsList();

	Video findVideoAllById(String videoId);

	Course findCourseById(Integer courseId);

	Speaker findSpeakerById(Integer speakerId);

	List<Video> findVideoAllandSpeakerNameById(Integer speakerId);

	void addVideoState(String videoId);

	
}
