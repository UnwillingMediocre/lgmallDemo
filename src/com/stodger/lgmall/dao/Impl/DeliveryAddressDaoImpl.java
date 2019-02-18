package com.stodger.lgmall.dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.stodger.lgmall.dao.DeliveryAddressDao;
import com.stodger.lgmall.domain.DeliveryAddress;
import com.stodger.lgmall.utils.DataSourceUtils;

public class DeliveryAddressDaoImpl implements DeliveryAddressDao{
	private static final boolean OK = true;
	private static final boolean NO = false;
	
	/**
	 * 添加收货地址
	 */
	@Override
	public boolean addDeliveryAddress(String did, String uid) {
		int row = 0;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into delivery_address(did,uid) values(?,?)";
		try {
			row = runner.update(sql, did, uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? OK: NO;
	}
	
	/**
	 *获取地址信息 
	 */
	@Override
	public DeliveryAddress addressInfo(String uid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from delivery_address where uid=?";
		DeliveryAddress deliveryAddress = null;
		try {
			deliveryAddress = runner.query(sql, new BeanHandler<>(DeliveryAddress.class), uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deliveryAddress;
	}
	/**
	 * 更新地址
	 * 
	 */
	@Override
	public void updateAddress(DeliveryAddress deliveryAddress){
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update delivery_address set name=?,tel=?,address=?,postalcode=? where did=? and uid=?";
		try {
			String name = deliveryAddress.getName();
			String tel = deliveryAddress.getTel();
			String address = deliveryAddress.getAddress();
			String postalcode = deliveryAddress.getPostalcode();
			String did = deliveryAddress.getDid();
			String uid = deliveryAddress.getUid();
			runner.update(sql, name, tel, address, postalcode, did, uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
