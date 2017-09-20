package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;

public interface AdminSpeakerService {

	Page<Speaker> findSpeakerBySearch(String speakerSearchName, String speakerSearchJob, Integer page);

	void addSpeaker(Speaker speaker);

	void deleteSpeakerById(Integer id);

	Speaker findSpeakerById(Integer id);

}
