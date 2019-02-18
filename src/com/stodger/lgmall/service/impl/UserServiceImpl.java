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
	 * 用户注册
	 * 
	 * @return
	 */
	public LGResult register(User user) {
		tempResult = userDao.getUsername(user.getUsername());
		if (tempResult) {
			result.setOk(tempResult);
			result.setMsg("用户名已经存在！");
		} else {
				row = userDao.register(user);
				result.setOk(row >= 1 ? OK : NO);
				result.setMsg("注册成功");
		}
		return result;
	}
	
	@Override
	public LGResult login(User user) {
		tempResult = userDao.login(user);
		if(tempResult){
			result.setOk(tempResult);
			result.setMsg("登录成功");
		}else{
			result.setOk(tempResult);
			result.setMsg("登录失败，用户名或密码错误");
		}
		return result;
	}
	
	/**
	 * 用户激活
	 */
	@Override
	public boolean active(String activeCode) {
		tempResult = userDao.active(activeCode);
		return tempResult;
	}
	/**
	 * 验证用户名、邮箱
	 */
	public LGResult usernameCode(User user) {
		tempResult = userDao.usernameCode(user);
		result.setOk(tempResult);
		if(tempResult){
			result.setMsg("");
		}else{
			result.setMsg("用户名与邮箱不匹配");
		}
		return result;
	}
	/**
	 * 重置密码
	 */
	@Override
	public boolean fotgotPassword(User user) {
		row = userDao.fotgotPassword(user);
		return row > 0 ? OK : NO;
	}
	/**
	 * 根据用户名查找ID
	 */
	@Override
	public String getUid(String username) {
		String uid = userDao.getUid(username);
		return null;
	}
	/**
	 * 获取用户信息
	 */
	@Override
	public User userInfo(String username) {
		return userDao.userInfo(username);
	}
	
	/**
	 * 获取所有用户信息
	 */
	@Override
	public List<User> allUser() {
		return userDao.allUser();
	}
	/**
	 * 查找用户信息
	 */
	@Override
	public User findUserInfo(String uid) {
		return userDao.findUserInfo(uid);
	}

	/**
	 * 删除用户
	 */
	@Override
	public LGResult delUser(String uid) {
		tempResult = userDao.delUser(uid);
		result.setOk(tempResult);
		if(!tempResult){
			result.setMsg("删除失败");
		}else{
			result.setMsg("删除成功");
		}
		return result;
	}
	/**
	 * 查询用户
	 */
	@Override
	public List<User> searchUser(String searchName) {
		return userDao.searchUser(searchName);
	}
}
