package com.zhiyou100.video.utils;

import org.springframework.util.DigestUtils;

/**  
* @ClassName: MD5Utils  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午2:53:39
*    
*/ 

public class MD5Utils {
    //加密
	public static String getMD5(String str){
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
	
	
}
