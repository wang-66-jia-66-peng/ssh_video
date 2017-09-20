package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.dao.AdminUserDao;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminUserService;
import com.zhiyou100.video.utils.MD5Utils;
@Service
public class AdminUserServiceImpl implements AdminUserService {
     
	   @Autowired
       AdminUserDao  aud;

	@Override
	public List<Admin> findLoginUser(Admin admin) {
		
		String  pwd = MD5Utils.getMD5(admin.getLoginPwd());
		
		return aud.findLoginUser(admin.getLoginName(),pwd);
	}
	
	
	
}
