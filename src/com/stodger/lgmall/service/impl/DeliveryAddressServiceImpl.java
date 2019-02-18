package com.stodger.lgmall.service.impl;

import com.stodger.lgmall.dao.DeliveryAddressDao;
import com.stodger.lgmall.dao.Impl.DeliveryAddressDaoImpl;
import com.stodger.lgmall.domain.DeliveryAddress;
import com.stodger.lgmall.service.DeliveryAddressService;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
	DeliveryAddressDao deliveryAddressDao = new DeliveryAddressDaoImpl();
	/**
	 * 添加收货地址
	 */
	@Override
	public boolean addDeliveryAddress(String did, String uid) {
		return deliveryAddressDao.addDeliveryAddress(did, uid);
	}
	
	/**
	 * 获取信息
	 */
	@Override
	public DeliveryAddress addressInfo(String did, String uid) {
		DeliveryAddress deliveryAddress = deliveryAddressDao.addressInfo(uid);
		if(deliveryAddress == null){
			addDeliveryAddress(did, uid);
		}
		return deliveryAddress;
	}
	/**
	 * 更新地址
	 */
	@Override
	public void updateAddress(DeliveryAddress deliveryAddress){
		deliveryAddressDao.updateAddress(deliveryAddress);
	}
}
