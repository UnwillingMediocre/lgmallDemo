package com.stodger.lgmall.service.impl;

import com.stodger.lgmall.service.GoodDiscount;


public class GoodDiscountBImpl implements GoodDiscount{
	/**
	 * ��300��50
	 */
	@Override
	public double calculateMoney(double totalMoey) {
		return (totalMoey - 300 > 0) ? totalMoey - 50 : totalMoey;
	}
}
