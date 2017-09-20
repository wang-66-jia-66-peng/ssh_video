package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminSpeakerDao;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminSpeakerService;
@Service
public class AdminSpeakerServiceImpl implements AdminSpeakerService {
      @Autowired
      AdminSpeakerDao  asd;
	
	
	@Override
	public Page<Speaker> findSpeakerBySearch(String speakerSearchName, String speakerSearchJob, Integer page) {
		 Page<Speaker> pp = new Page<>();
		 pp.setSize(10);
		 pp.setPage(page);
		 List<Speaker> rows  =  asd.findVideoBySearch(speakerSearchName,speakerSearchJob,page);
		 Integer  total = asd.findVideoBySearchCount(speakerSearchName,speakerSearchJob,page);
		  //System.out.println("aaaaaaaa"+rows);
		 pp.setRows(rows); 
		 pp.setTotal(total);
		 return pp;
		
	}


	@Override
	public void addSpeaker(Speaker speaker) {
		   asd.addspeaker(speaker);
	}


	@Override
	public void deleteSpeakerById(Integer id) {
		   asd.deleteSpeakerById(id);
		
	}


	@Override
	public Speaker findSpeakerById(Integer id) {
		 return asd.findSpeakerByid(id);
	}

	
	
}
