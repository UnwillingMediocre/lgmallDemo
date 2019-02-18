package com.stodger.lgmall.service;

import java.util.List;

import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.User;

public interface UserService{
	public LGResult register(User user);
	public LGResult login(User user);
	public boolean active(String activeCode);
	public LGResult usernameCode(User user);
	public boolean fotgotPassword(User user);
	public String getUid(String username);
	public User userInfo(String username);
	public List<User> allUser();
	public User findUserInfo(String uid);
	public LGResult delUser(String uid);
	public List<User> searchUser(String searchName);
}
