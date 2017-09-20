package com.zhiyou100.video.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Result;
import com.zhiyou100.video.model.Msg;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MD5Utils;

@Controller("frontUserAction")
@Scope(scopeName="prototype")
public class FrontUserAction  extends ActionSupport  implements  ModelDriven<User>{
      
	  @Autowired 
	  FrontUserService  fus;
	  private  String  oldPassword;
	  private String  newPassword;
	 
	  private  User  user = new  User();
	
	  private  Msg  msg;
	 
  
    
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}



	public String login() throws Exception {
		 
		// System.out.println(user.getEmail()+"-------"+user.getPassword());
		 String md5 = MD5Utils.getMD5(user.getPassword());
		 DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		 dc.add(Restrictions.eq("email", user.getEmail()));
		 dc.add(Restrictions.eq("password",md5));
		 User uu =  fus.findLogin(dc);
		 msg=new Msg();
		   if (uu == null) {
			msg.setResult("fail"); 
			return  SUCCESS;
		   }
		   ActionContext.getContext().getSession().put("_front_user", uu);
		  // System.out.println(uu);
		   msg.setResult("success");
		 
		    return SUCCESS;
	}

	
	public String resgist() throws Exception {
		//System.out.println(user.getEmail()+"-------"+user.getPassword());
		  String md5 = MD5Utils.getMD5(user.getPassword());
		  DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		  dc.add(Restrictions.eq("email", user.getEmail()));
		  User uu =  fus.findUserByEmail(dc);
		   msg=new Msg();
		  if (uu != null) {
			  msg.setResult("fail"); 
			  return  SUCCESS;
		  }
		   user.setPassword(md5);
		   fus.addResgistUser(user);
		  
		   msg.setResult("success");
		    return SUCCESS;
	}
	
	 public String  oldPassword(){
		 //System.out.println(oldPassword+"0000000");
		  User att =(User) ActionContext.getContext().getSession().get("_front_user"); 
	      Integer id = att.getId();
	      User use  =   fus.findUserById(id); 
	      String md5 = MD5Utils.getMD5(oldPassword.trim());
	      String md52 = MD5Utils.getMD5(newPassword.trim());
	         msg=new Msg();
	      if (md5.equals(use.getPassword())) {
	    	    use.setPassword(md52);
				fus.addUserProfile(use);
				msg.setResult("success"); 
				return  SUCCESS;
		  }
	      
	          msg.setResult("fail");
	      
		  return SUCCESS;
	}
	
	
	
	public User getModel() {
		return user;
	}
	
	
}

