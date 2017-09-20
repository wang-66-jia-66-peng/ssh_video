package com.zhiyou100.video.dao;

import java.util.List;

import com.zhiyou100.video.model.Admin;

public interface AdminUserDao {

	List<Admin> findLoginUser(String loginName, String pwd);

}
