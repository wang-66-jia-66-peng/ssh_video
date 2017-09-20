package com.zhiyou100.video.web.action;

import org.apache.taglibs.standard.extra.spath.SPathFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.AdminSpeakerService;
@Controller("adminSpeakerAction")
@Scope(scopeName="prototype")
public class AdminSpeakerAction extends ActionSupport implements ModelDriven<Speaker>{
      @Autowired
	  AdminSpeakerService  ass;
	  
	
	  private  String  speakerSearchName = "";
	  private  String   speakerSearchJob = "";
	  private  Integer  page=1;
	  
	  private  Speaker speaker = new Speaker();
	  
	 public String getSpeakerSearchName() {
		return speakerSearchName;
	}


	public void setSpeakerSearchName(String speakerSearchName) {
		this.speakerSearchName = speakerSearchName;
	}


	public String getSpeakerSearchJob() {
		return speakerSearchJob;
	}


	public void setSpeakerSearchJob(String speakerSearchJob) {
		this.speakerSearchJob = speakerSearchJob;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public String speakerList() throws Exception {
		 
	    Page<Speaker>  pp = ass.findSpeakerBySearch(speakerSearchName,speakerSearchJob,page);
	  
	    ActionContext.getContext().put("pageUtil", pp);
	    
	    System.out.println(pp);
		return super.execute();
		
	}
	
	public String addSpeaker() throws Exception {
		return super.execute();
	}
	
	public String addSpeakerTwo() throws Exception {
		  System.out.println(speaker);
		   ass.addSpeaker(speaker);
		  
		  return SUCCESS;
	}
	public String deleteSpeaker() throws Exception {
		System.out.println(speaker.getId());
		ass.deleteSpeakerById(speaker.getId());
		return SUCCESS;
	}
	public String updateSpeaker01() throws Exception {
		   // System.out.println(speaker.getId());
		    Speaker sp = ass.findSpeakerById(speaker.getId());
		    ActionContext.getContext().put("spe", sp);
		    return SUCCESS;
	}
	public String updateSpeaker02() throws Exception {
		    //System.out.println(speaker);
		    ass.addSpeaker(speaker);
		
		return SUCCESS;
	}


	@Override
	public Speaker getModel() {
		
		return speaker;
	}

}
