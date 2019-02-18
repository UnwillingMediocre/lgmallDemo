package com.stodger.lgmall.service;

//商品折扣---策略模式
public interface GoodDiscount {
	double calculateMoney(double totalMoey);
}
