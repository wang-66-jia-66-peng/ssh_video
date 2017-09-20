package com.zhiyou100.video.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminCourseService;
import com.zhiyou100.video.service.AdminVideoService;

@Controller("frontCourseAction")
@Scope(scopeName="prototype")
public class FrontCourseAction extends ActionSupport {
     @Autowired
    AdminCourseService  acs;
	 @Autowired
    AdminVideoService  avs;
	
	private  String subjectId;
	 
	private  String  videoId;
	
	
	
	public String getVideoId() {
		return videoId;
	}



	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}



	public String getSubjectId() {
		return subjectId;
	}



	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}



	public String index() throws Exception {
		    
        Subject  su = acs.findSubjectById(subjectId);
		
		ActionContext.getContext().put("subject", su);
		
		 List<Course>  co  =  acs.findAllCourseAndVideo(subjectId);
		  //System.out.println(co);
		 ActionContext.getContext().put("courses", co);
	
		 return SUCCESS;
	}
	
       	public String  show() {
		
       	Subject  su = acs.findSubjectById(subjectId);
       		
       	ActionContext.getContext().put("subject", su);
       	ActionContext.getContext().put("videoId", videoId);
       		
		  return  SUCCESS;
	  }
	
       	public String  videoData() {
       		//System.out.println(videoId);
            Video  v = avs.findVideoAllById(videoId);
            Integer speakerId = v.getSpeaker().getId();
      	    Integer courseId = v.getCourse().getId();
      	    Course  co = avs.findCourseById(courseId);
      	    Speaker sp = avs.findSpeakerById(speakerId);
      	   
      	    //System.out.println("ccccccc"+co);
      	    //System.out.println("sssssss"+sp);
      	    
      	   ActionContext.getContext().put("video", v);
      	   ActionContext.getContext().put("course", co);
    	  
      	   ActionContext.getContext().put("speaker", sp);
      	  
    	   List<Video> list= avs.findVideoAllandSpeakerNameById(speakerId);
      	    // System.out.println("-------"+list);
      	   ActionContext.getContext().put("videoList", list);
          	 
       		
       	  return  SUCCESS;
       	}
       	
	   public String state() {
		    // System.out.println("aaaaqqqqq"+videoId);
		    avs.addVideoState(videoId); 
		    return SUCCESS;
	   }
	
	
}
