package com.zhiyou100.video.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.PackageVO;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminVideoService;

@Controller("adminVideoAction")
@Scope(scopeName="prototype")
public class AdminVideoAction extends ActionSupport implements ModelDriven<Video>{
      @Autowired
	  AdminVideoService  avs;
	  
      private  String   videoKeyWord;
      private  Integer  videoSearchSpeaker;
      private  Integer  videoSearchCourse;
      private  Integer  page=1;
      private  Integer[] ids;
      
     private  Video video = new Video();
      

	public Integer[] getIds() {
		return ids;
	}


	public void setIds(Integer[] ids) {
		this.ids = ids;
	}


	public String getVideoKeyWord() {
		return videoKeyWord;
	}


	public void setVideoKeyWord(String videoKeyWord) {
		this.videoKeyWord = videoKeyWord;
	}


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


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public String videoList() throws Exception {
    	 if (videoKeyWord==null || videoSearchSpeaker ==null || videoSearchCourse==null) {
    		 videoKeyWord="";
    		 videoSearchSpeaker=0;
    		 videoSearchCourse=0;
 		 }
    	 ActionContext.getContext().put("roleKeyword", videoKeyWord);
    	 ActionContext.getContext().put("videoSearchSpeaker", videoSearchSpeaker);
    	 ActionContext.getContext().put("videoSearchCourse", videoSearchCourse);
    	 
 	     Page<Video>  pp = avs.findVideoBySearch(videoKeyWord,videoSearchSpeaker,videoSearchCourse,page);

  	     List<Speaker>  sp = avs.findSpeakerAll();
  	     List<Course>  cr =  avs.findCourseAll();
  	     
  	     ActionContext.getContext().getSession().put("speaker", sp);
  	     ActionContext.getContext().getSession().put("course", cr);
  	     ActionContext.getContext().put("pageUtil", pp);
    	  // System.out.println(pp);
    	 return SUCCESS;
    }
      
    public String addVideo01() throws Exception {
    	return SUCCESS;
    }
    public String addVideo02() throws Exception {
       	
    	 Course co  =  avs.findCourseAllById(video.getCourseId());
         Speaker sp = avs.findSpeakerByid(video.getSpeakerId());
         video.setCourse(co);
         video.setSpeaker(sp);
         avs.addVideo(video);
    	 return SUCCESS;
    }
    
    public String deleteVideo() throws Exception {
    	  avs.deleteVideoById(video.getId());
    	return SUCCESS;
    }

    public String updateVideo01() throws Exception {
    	Video  vi  =  avs.findVideoById(video.getId());
    	ActionContext.getContext().put("video", vi);
    	return SUCCESS;
    }
    public String updateVideo02() throws Exception {
    	Course co  =  avs.findCourseAllById(video.getCourseId());
        Speaker sp = avs.findSpeakerByid(video.getSpeakerId());
        video.setCourse(co);
        video.setSpeaker(sp);
        avs.addVideo(video);
    	return SUCCESS;
    }
    public String deteleVideoLarge() throws Exception {
    	
    	for (Integer i : ids) {
    		  avs.deleteVideoById(i);
		}
    	return SUCCESS;
    }
    
	@Override
	public Video getModel() {
		return video;
	}
      
	
}
