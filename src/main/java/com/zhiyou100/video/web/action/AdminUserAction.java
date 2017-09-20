package com.zhiyou100.video.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.AdminUserService;

@Controller("adminUserAction")
@Scope(scopeName="prototype")
public class AdminUserAction  extends ActionSupport  implements ModelDriven<Admin>{
	
	@Autowired
	AdminUserService   aus;
	
	private  Admin admin = new Admin();
	
	public String adminUserLogin() throws Exception {
		
		List<Admin>  list = aus.findLoginUser(admin);
	if(list.isEmpty()){
			ActionContext.getContext().put("message", "用户名密码不匹配");
			return "fail";
		}
		ActionContext.getContext().getSession().put("ADMIN", list.get(0));
	    return SUCCESS;
	}
		
		



	@Override
	public Admin getModel() {
		
		return admin;
	}
	
	
	
}
