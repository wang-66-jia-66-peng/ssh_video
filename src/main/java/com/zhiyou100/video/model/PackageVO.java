package com.zhiyou100.video.model;

public class PackageVO {
	 
	  private Video   vid;
	  
	  private Speaker spe;
	  
	  private Subject  sub;
	  
	  private  Course cou ;
	  
	  private  String  videoKeyWord;
	  
	  private  Integer videoSearchSpeaker ;
	  
	  private  Integer videoSearchCourse;
	   
	  private   Integer currentPage ;
	  
	  private   String SpeakerName;
	  
	  private   String  CourseName;  
	   
	  
	  
	  
	   

	public Integer getVideoSearchSpeaker() {
		return videoSearchSpeaker;
	}

	public void setVideoSearchSpeaker(Integer videoSearchSpeaker) {
		this.videoSearchSpeaker = videoSearchSpeaker;
	}

	public Integer getVideoSearchCourse() {
		return videoSearchCourse;
	}

	public void setVideoSearchCourse(Integer videoSearchCourse) {
		this.videoSearchCourse = videoSearchCourse;
	}

	public String getSpeakerName() {
		return SpeakerName;
	}

	public void setSpeakerName(String speakerName) {
		SpeakerName = speakerName;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getVideoKeyWord() {
		return videoKeyWord;
	}

	public void setVideoKeyWord(String videoKeyWord) {
		this.videoKeyWord = videoKeyWord;
	}

	

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Video getVid() {
		return vid;
	}

	public void setVid(Video vid) {
		this.vid = vid;
	}

	public Speaker getSpe() {
		return spe;
	}

	public void setSpe(Speaker spe) {
		this.spe = spe;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public Course getCou() {
		return cou;
	}

	public void setCou(Course cou) {
		this.cou = cou;
	}


	@Override
	public String toString() {
		return "PackageVO [vid=" + vid + ", spe=" + spe + ", sub=" + sub + ", cou=" + cou + ", videoKeyWord="
				+ videoKeyWord + ", videoSearchSpeaker=" + videoSearchSpeaker + ", videoSearchCourse="
				+ videoSearchCourse + ", currentPage=" + currentPage + ", SpeakerName=" + SpeakerName + ", CourseName="
				+ CourseName + "]";
	}

	

	
	
	 
	  
	  

}
