package com.zhiyou100.video.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.video.model.Msg;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MD5Utils;
import com.zhiyou100.video.utils.MailUtil;
import com.zhiyou100.video.utils.RandomUtil;

@Controller("frontFrogetAction")
@Scope(scopeName="prototype")
public class FrontFrogetAction extends ActionSupport {
	  @Autowired 
	  FrontUserService  fus;
	 
	
	private  Msg  msg;
	
	private  String  email;
	private  String  captcha;
	private String    password;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}


	public String  pwd()  {
		return SUCCESS;
	 }
	
	
	public String email() throws Exception {
		 msg = new Msg();
		// System.out.println(email);
    	 List<User> lu = fus.findUserByEmail(email);
    	 System.out.println(lu);
    	if (lu.size()==0) {
			msg.setResult("fail");
			return SUCCESS;
		}else{
		 int i =RandomUtil.getRandomCode();
    	 lu.get(0).setCaptcha(""+i);
    	 fus.updateAvatar(lu.get(0));
    	 MailUtil.send(email, "验证码", "您的验证码:"+i+
    	"<a href='http://192.168.6.175:8080/ssh_video/front/forget/forget_pwd.action'>填写验证码</a>");
		   msg.setResult("success");
		}
    	
		return SUCCESS;
	}
	
	public String  pwd02()  {
		System.out.println(email+"-----"+captcha);
		
		 List<User> lu = fus.findUserByEmail(email);
		 
		if (lu.size()!=0 && lu.get(0).getCaptcha().equals(captcha)) {
			
			ActionContext.getContext().getSession().put("user", lu.get(0));
			
			 return SUCCESS;
		 }
		  ActionContext.getContext().put("error", "验证码有误");
		  return "fail";
	 }
	
	
	public String  resetpwd() {
		System.out.println(password);
		User uu = (User) ActionContext.getContext().getSession().get("user");
		String md5 = MD5Utils.getMD5(password);
		uu.setPassword(md5);
		fus.addResgistUser(uu);
		ActionContext.getContext().getSession().remove("user");
		return  SUCCESS;
	}
	
	
}
