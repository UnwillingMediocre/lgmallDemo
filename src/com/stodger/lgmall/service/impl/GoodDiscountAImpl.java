package com.stodger.lgmall.service.impl;

import com.stodger.lgmall.service.GoodDiscount;

public class GoodDiscountAImpl implements GoodDiscount {
	/**
	 * ����200�����
	 */
	@Override
	public double calculateMoney(double totalMoey) {
		return (totalMoey - 200 > 0) ? totalMoey * 0.8 : totalMoey;
	}
}
