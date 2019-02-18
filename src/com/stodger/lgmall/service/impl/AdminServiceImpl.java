package com.stodger.lgmall.service.impl;

import com.stodger.lgmall.service.AdminService;

public class AdminServiceImpl implements AdminService{
	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @param newCode
	 * @param oldCode
	 * @return
	 */
	public String adminLogin(String username, String password, String newCode, String oldCode){
		String result = "";
		if(!username.equals("admin")){
			result = "用户名不存在！";
		}else if(!password.equals("123456")){
			result = "密码错误！";
		}else if(!newCode.toLowerCase().equals(oldCode.toLowerCase())){
			result = "验证码错误！";
		}else{
			result = "true";
		}
		return result;
	}
}
