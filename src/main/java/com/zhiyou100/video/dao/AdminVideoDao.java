package com.zhiyou100.video.dao;

import java.util.List;

import com.zhiyou100.video.model.Video;

public interface AdminVideoDao {

	List<Video> findVideoBySearch(String videoKeyWord, Integer videoSearchSpeaker, Integer videoSearchCourse,
			Integer currentPage);

	Integer findVideoBySearchCount(String videoKeyWord, Integer videoSearchSpeaker, Integer videoSearchCourse,
			Integer currentPage);

	void addVideo(Video video);

	void deleteVideoById(Integer vid);

	Video findVideoById(Integer id);

	List<Video> statisticsList();

	List<Video> findVideoAllandSpeakerNameById(Integer speakerId);

	void addVideoState(int parseInt);

}
