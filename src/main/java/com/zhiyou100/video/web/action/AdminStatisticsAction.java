package com.zhiyou100.video.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminVideoService;

@Controller("adminStatisticsAction")
@Scope(scopeName="prototype")
public class AdminStatisticsAction extends ActionSupport {

	  @Autowired
	  AdminVideoService  avs;
	 
	
	
	 public String statisticsList() throws Exception {
		 List<Video>  v =  avs.statisticsList();
		 
		 StringBuilder dataBuiler= new StringBuilder();
		 StringBuilder timeBuiler= new StringBuilder();
		
			for (int i = 0; i < v.size(); i++){
				Video video= v.get(i);
				dataBuiler.append(video.getCName());
				timeBuiler.append(video.getAverage());
				if(i != v.size() -1 ){
					dataBuiler.append(",");
					timeBuiler.append(",");
				}
			}
			
			ActionContext.getContext().put("data", dataBuiler.toString());
			ActionContext.getContext().put("times", timeBuiler.toString());
		 
		 
		return super.execute();
	 }
	
}
