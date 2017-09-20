package com.zhiyou100.video.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Page;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.AdminCourseService;

@Controller("adminCourseAction")
@Scope(scopeName="prototype")
public class AdminCourseAction  extends ActionSupport implements ModelDriven<Course> {
    @Autowired
	AdminCourseService acs;
    
    private  Integer  page=1;
    
    private  Course course = new Course();
     
    public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public String courseList() throws Exception {
		    System.out.println(6666666);
		     
		    Page<Course>  pp = acs.findCourseBySearch(page);
		  
		    ActionContext.getContext().put("pageUtil", pp);
		    
		    System.out.println(pp);
    	  
    	    return SUCCESS;
    }

    public String addCourse01() throws Exception {
    	     List<Subject>  sub =  acs.findAllSubject();
    	       ActionContext.getContext().put("subject", sub);
    	      return super.execute();
    }
    public String addCourse02() throws Exception {
    	Subject sub =  acs.findAllSubjectById(course.getSubjectId());
         course.setSubject(sub);
    	 acs.addCourse(course);
    	 return  SUCCESS;
    }
    public String deleteCourse() throws Exception {
         acs.deleteCourseById(course.getId());
    	return  SUCCESS;
    }

     
    public String updateCourse01() throws Exception {
	       List<Subject>  sub =  acs.findAllSubject();
	       ActionContext.getContext().put("subject", sub);
	       Course  co = acs.findCourseById(course.getId());
	       //System.out.println(co);
	       ActionContext.getContext().put("Course", co);
	       
	       return super.execute();
    }
    public String updateCourse02() throws Exception {
    	   System.out.println(course);
    	   Subject su = acs.findSubjectById(course.getSubjectId());
    	   course.setSubject(su);
      	    acs.addCourse(course);
    	   return super.execute();
    }
    
    

	@Override
	public Course getModel() {
		return course;
	}


}




