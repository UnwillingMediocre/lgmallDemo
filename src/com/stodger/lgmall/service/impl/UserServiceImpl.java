package com.stodger.lgmall.service.impl;


import java.util.List;

import com.stodger.lgmall.dao.UserDao;
import com.stodger.lgmall.dao.Impl.UserDaoImpl;
import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.UserService;

public class UserServiceImpl implements UserService{
	private static final boolean OK = true;
	private static final boolean NO = false;
	private LGResult result = new LGResult();
	private UserDao userDao = new UserDaoImpl();
	private boolean tempResult = NO;
	private int row = 0;
	
	/**
	 * �û�ע��
	 * 
	 * @return
	 */
	public LGResult register(User user) {
		tempResult = userDao.getUsername(user.getUsername());
		if (tempResult) {
			result.setOk(tempResult);
			result.setMsg("�û����Ѿ����ڣ�");
		} else {
				row = userDao.register(user);
				result.setOk(row >= 1 ? OK : NO);
				result.setMsg("ע��ɹ�");
		}
		return result;
	}
	
	@Override
	public LGResult login(User user) {
		tempResult = userDao.login(user);
		if(tempResult){
			result.setOk(tempResult);
			result.setMsg("��¼�ɹ�");
		}else{
			result.setOk(tempResult);
			result.setMsg("��¼ʧ�ܣ��û������������");
		}
		return result;
	}
	
	/**
	 * �û�����
	 */
	@Override
	public boolean active(String activeCode) {
		tempResult = userDao.active(activeCode);
		return tempResult;
	}
	/**
	 * ��֤�û���������
	 */
	public LGResult usernameCode(User user) {
		tempResult = userDao.usernameCode(user);
		result.setOk(tempResult);
		if(tempResult){
			result.setMsg("");
		}else{
			result.setMsg("�û��������䲻ƥ��");
		}
		return result;
	}
	/**
	 * ��������
	 */
	@Override
	public boolean fotgotPassword(User user) {
		row = userDao.fotgotPassword(user);
		return row > 0 ? OK : NO;
	}
	/**
	 * �����û�������ID
	 */
	@Override
	public String getUid(String username) {
		String uid = userDao.getUid(username);
		return null;
	}
	/**
	 * ��ȡ�û���Ϣ
	 */
	@Override
	public User userInfo(String username) {
		return userDao.userInfo(username);
	}
	
	/**
	 * ��ȡ�����û���Ϣ
	 */
	@Override
	public List<User> allUser() {
		return userDao.allUser();
	}
	/**
	 * �����û���Ϣ
	 */
	@Override
	public User findUserInfo(String uid) {
		return userDao.findUserInfo(uid);
	}

	/**
	 * ɾ���û�
	 */
	@Override
	public LGResult delUser(String uid) {
		tempResult = userDao.delUser(uid);
		result.setOk(tempResult);
		if(!tempResult){
			result.setMsg("ɾ��ʧ��");
		}else{
			result.setMsg("ɾ���ɹ�");
		}
		return result;
	}
	/**
	 * ��ѯ�û�
	 */
	@Override
	public List<User> searchUser(String searchName) {
		return userDao.searchUser(searchName);
	}
}
