package com.stodger.lgmall.service.impl;

import com.stodger.lgmall.service.AdminService;

public class AdminServiceImpl implements AdminService{
	/**
	 * ����Ա��¼
	 * @param username
	 * @param password
	 * @param newCode
	 * @param oldCode
	 * @return
	 */
	public String adminLogin(String username, String password, String newCode, String oldCode){
		String result = "";
		if(!username.equals("admin")){
			result = "�û��������ڣ�";
		}else if(!password.equals("123456")){
			result = "�������";
		}else if(!newCode.toLowerCase().equals(oldCode.toLowerCase())){
			result = "��֤�����";
		}else{
			result = "true";
		}
		return result;
	}
}
