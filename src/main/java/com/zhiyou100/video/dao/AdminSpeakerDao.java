package com.zhiyou100.video.dao;

import java.util.List;

import com.zhiyou100.video.model.Speaker;

public interface AdminSpeakerDao {

	List<Speaker> findSpeakerAll();

	Speaker findSpeakerByid(Integer speakerId);

	List<Speaker> findVideoBySearch(String speakerSearchName, String speakerSearchJob, Integer page);

	Integer findVideoBySearchCount(String speakerSearchName, String speakerSearchJob, Integer page);

	void addspeaker(Speaker speaker);

	void deleteSpeakerById(Integer id);


}
