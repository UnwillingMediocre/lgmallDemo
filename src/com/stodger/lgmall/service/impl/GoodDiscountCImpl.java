package com.stodger.lgmall.service.impl;

import com.stodger.lgmall.service.GoodDiscount;

public class GoodDiscountCImpl implements GoodDiscount {
	/**
	 * ��1000��200
	 */
	@Override
	public double calculateMoney(double totalMoey) {
		return (totalMoey - 1000 > 0) ? totalMoey-200 : totalMoey;
	}
}
