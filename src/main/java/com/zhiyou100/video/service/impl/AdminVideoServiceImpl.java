package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminCourseDao;
import com.zhiyou100.video.dao.AdminSpeakerDao;
import com.zhiyou100.video.dao.AdminVideoDao;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.PackageVO;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminVideoService;
@Service
public class AdminVideoServiceImpl implements AdminVideoService {
      
	  @Autowired
	  AdminVideoDao  avd;
      @Autowired
	  AdminSpeakerDao asd;
	  @Autowired
      AdminCourseDao acd;
      
      
      
	@Override
	public List<Speaker> findSpeakerAll() {
		return asd.findSpeakerAll();
	}

	@Override
	public List<Course> findCourseAll() {
		return acd.findCourseAll();
	}

	@Override
	public Page<Video> findVideoBySearch(String videoKeyWord, Integer videoSearchSpeaker, Integer videoSearchCourse,
			Integer currentPage) {
		 Page<Video> pp = new Page<>();
		 pp.setSize(10);
		 pp.setPage(currentPage);
		 List<Video> rows  =  avd.findVideoBySearch(videoKeyWord,videoSearchSpeaker,videoSearchCourse,currentPage);
		 Integer  total = avd.findVideoBySearchCount(videoKeyWord,videoSearchSpeaker,videoSearchCourse,currentPage);
		 pp.setRows(rows); 
		 pp.setTotal(total);
		 return pp;
		
	}

	@Override
	public void addVideo(Video video) {
          avd.addVideo( video);	
	}

	@Override
	public Course findCourseAllById(Integer courseId) {
		
		return acd.findCourseAllById(courseId);
	}

	@Override
	public Speaker findSpeakerByid(Integer speakerId) {
		
		return asd.findSpeakerByid(speakerId);
	}

	@Override
	public void deleteVideoById(Integer vid) {
		avd.deleteVideoById(vid);
	}

	@Override
	public Video findVideoById(Integer id) {
		
		return avd.findVideoById(id);
	}

	@Override
	public List<Video> statisticsList() {
		
		return avd.statisticsList();
	}

	@Override
	public Video findVideoAllById(String videoId) {
		Integer id =Integer.parseInt(videoId);
		return avd.findVideoById(id);
	}

	@Override
	public Course findCourseById(Integer courseId) {
		
		return acd.findCourseAllById(courseId);
	}

	@Override
	public Speaker findSpeakerById(Integer speakerId) {
		
		return asd.findSpeakerByid(speakerId);
	}

	@Override
	public List<Video> findVideoAllandSpeakerNameById(Integer speakerId) {
		
		return avd.findVideoAllandSpeakerNameById(speakerId);
	}

	@Override
	public void addVideoState(String videoId) {
		
		avd.addVideoState(Integer.parseInt(videoId));
		
	}
		
	 
	
	
}
