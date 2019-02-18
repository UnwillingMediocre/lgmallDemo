package com.stodger.lgmall.service;

import java.sql.SQLException;

import com.stodger.lgmall.domain.DeliveryAddress;

public interface DeliveryAddressService {
	boolean addDeliveryAddress(String did, String uid);
	DeliveryAddress addressInfo(String did, String uid);
	void updateAddress(DeliveryAddress deliveryAddress);

}
