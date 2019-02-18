package com.stodger.lgmall.dao;


import com.stodger.lgmall.domain.DeliveryAddress;

public interface DeliveryAddressDao {

	boolean addDeliveryAddress(String did, String uid);
	DeliveryAddress addressInfo(String uid);
	void updateAddress(DeliveryAddress deliveryAddress);
}
