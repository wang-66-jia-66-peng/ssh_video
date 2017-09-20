package com.zhiyou100.video.web.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;

@Controller("frontUserDataAction")
@Scope(scopeName="prototype")
public class FrontUserDataAction  extends ActionSupport  implements  ModelDriven<User>{
        @Autowired
    	FrontUserService fus;
        private String  birthdayStr;
	    private File  upload;
	    private String  uploadFileName;
	    private String uploadContentType;
	    
        
        public File getUpload() {
			return upload;
		}
		public void setUpload(File upload) {
			this.upload = upload;
		}
		public String getUploadFileName() {
			return uploadFileName;
		}
		public void setUploadFileName(String uploadFileName) {
			this.uploadFileName = uploadFileName;
		}
		public String getUploadContentType() {
			return uploadContentType;
		}
		public void setUploadContentType(String uploadContentType) {
			this.uploadContentType = uploadContentType;
		}
		public String getBirthdayStr() {
			return birthdayStr;
		}
		public void setBirthdayStr(String birthdayStr) {
			this.birthdayStr = birthdayStr;
		}


		private  User us = new User();
	
	public String index() throws Exception {
		User att =(User) ActionContext.getContext().getSession().get("_front_user");
    	Integer id = att.getId();
    	User use  =  fus.findUserById(id);
    	ActionContext.getContext().getSession().put("_front_user", use );
    	ActionContext.getContext().put("user", use);
    	System.out.println(use);
		return super.execute();
	}
	public String profile() throws Exception {
		User att =(User) ActionContext.getContext().getSession().get("_front_user"); 
    	Integer id = att.getId();
    	User use  =   fus.findUserById(id);
    	ActionContext.getContext().put("user", use);
    	System.out.println(use);
		return super.execute();
	}
	public String profile02() throws Exception {
		  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		  User att =(User) ActionContext.getContext().getSession().get("_front_user"); 
    	  Integer id = att.getId();
    	  User use  =   fus.findUserById(id);
    	  Date parse = sim.parse(birthdayStr);
           use.setBirthday(parse);
           use.setNickName(us.getNickName());
           use.setSex(us.getSex());
           use.setCity(us.getCity());
           use.setProvince(us.getProvince());
    	   fus.addUserProfile(use);
		   return SUCCESS;
	}
	
	public String avatar() throws Exception {
		User att =(User) ActionContext.getContext().getSession().get("_front_user"); 
    	Integer id = att.getId();
    	User use  =   fus.findUserById(id);
    	ActionContext.getContext().put("user", use);
    	ActionContext.getContext().getSession().put("_front_user", use );
	     return super.execute();
	}
	public String avatar02() throws Exception {
		
		User att =(User) ActionContext.getContext().getSession().get("_front_user"); 
    	Integer id = att.getId();
    	User use  =   fus.findUserById(id);
		
		
        String k = UUID.randomUUID().toString().replaceAll("-", "");
    	
        String fileName=k+"."+FilenameUtils.getExtension(uploadFileName);
	    
	    use.setHeadUrl(fileName);
	    
        fus.updateAvatar(use);
	    String path="D:\\upload\\";
	    FileUtils.copyFile(new File(upload.getAbsolutePath()), new File(path+fileName));
		
		return SUCCESS;
	}
	
	public String password() throws Exception {
		User att =(User) ActionContext.getContext().getSession().get("_front_user"); 
    	Integer id = att.getId();
    	User use  =   fus.findUserById(id);
    	ActionContext.getContext().put("user", use);
    	ActionContext.getContext().getSession().put("_front_user", use );
	    return SUCCESS;
	}
	
	public String logout() {
		ActionContext.getContext().getSession().remove("_front_user");
		return SUCCESS;
	}
	public String home() {
		return SUCCESS;
	}
	
	
	
	@Override
	public User getModel() {
		return us;
	}
	
	
	
}
