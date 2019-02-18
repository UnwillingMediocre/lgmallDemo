package com.stodger.lgmall.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.stodger.lgmall.dao.UserDao;
import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao{
	private static final boolean OK = true;
	private static final boolean NO = false;

	/**
	 * 查询用户名
	 * 
	 * @param username
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean getUsername(String username) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select uid from user where username=?";
		String uid = null;
		try {
			uid = (String) runner.query(sql, new ScalarHandler(), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (uid != null) {
			return OK;
		} else {
			return NO;
		}
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int register(User user){
		int row = 0;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
		try {
			row = runner.update(sql, user.getUid(),user.getName(),user.getSex(),user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getState(),user.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * 用户登录
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean login(User user) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select uid from user where username=? and password=? and state=?";
		String uid = null;
		try {
			uid = (String) runner.query(sql, new ScalarHandler(), user.getUsername(), user.getPassword(), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (uid != null) {
			return OK;
		} else {
			return NO;
		}
	}
	
	/**
	 * 用户激活
	 */
	@Override
	public boolean active(String activeCode) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set state=? where code=?";
		int row = 0;
		try {
			row = runner.update(sql, 1, activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? OK : NO;
	}
	/**
	 * 验证用户名、邮箱
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean usernameCode(User user) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select uid from user where username=? and email=? and state=?";
		String uid = null;
		try {
			uid = (String) runner.query(sql, new ScalarHandler(), user.getUsername(), user.getEmail(),1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (uid != null) {
			return OK;
		} else {
			return NO;
		}
	}
	/**
	 * 修改密码
	 */
	@Override
	public int fotgotPassword(User user) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set password=? where username=?";
		int row = 0;
		try {
			row = runner.update(sql, user.getPassword(), user.getUsername());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	/**
	 * 根据用户名查找ID
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String getUid(String username) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=?";
		String uid = null;
		try {
			List<Object> query = (List<Object>) runner.query(sql,new ColumnListHandler("uid"),username);
			uid = query.get(0).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uid;
	}
	/**
	 * 用户信息
	 */
	@Override
	public User userInfo(String username) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=?";
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<>(User.class), username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 获取所有用户信息
	 */
	@Override
	public List<User> allUser() {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		List<User> userList = null;
		try {
			userList = runner.query(sql, new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	/**
	 * 查询用户信息
	 */
	@Override
	public User findUserInfo(String uid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where uid=?";
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<>(User.class), uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 删除用户
	 */
	@Override
	public boolean delUser(String uid) {
		int row = 0;
		try {
			row = new QueryRunner(DataSourceUtils.getDataSource()).update("update user set state=2 where uid=?", uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row > 0 ? OK : NO;
	}
	/**
	 * 根据名称模糊查找用户
	 */
	@Override
	public List<User> searchUser(String searchName) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username like ?";
		List<User> userList = null;
		try {
			userList = runner.query(sql, new BeanListHandler<>(User.class), "%" + searchName + "%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
