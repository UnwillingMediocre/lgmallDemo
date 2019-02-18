package com.stodger.lgmall.dao;

import java.util.List;

import com.stodger.lgmall.domain.User;

public interface UserDao {
	public boolean  getUsername(String username);
	public int register(User user);
	public boolean login(User user);
	public boolean active(String activeCode);
	public boolean usernameCode(User user);
	public int fotgotPassword(User user);
	public String getUid(String username);
	public User userInfo(String username);
	public List<User> allUser();
	public User findUserInfo(String uid);
	public boolean delUser(String uid);
	public List<User> searchUser(String searchName);
}
