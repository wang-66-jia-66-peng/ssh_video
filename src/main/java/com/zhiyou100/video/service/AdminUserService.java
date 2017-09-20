package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Admin;

public interface AdminUserService {

	List<Admin> findLoginUser(Admin admin);

}
