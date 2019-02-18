package com.stodger.lgmall.service.impl;

import com.stodger.lgmall.service.GoodDiscount;

public class Discount {
	private GoodDiscount goodDiscount;
	private double totalMoey;
	
	public Discount(double totalMoey){
		if(totalMoey > 200 && totalMoey < 300){
			this.goodDiscount = new GoodDiscountAImpl();
			this.totalMoey = this.goodDiscount.calculateMoney(totalMoey);
		}else if(totalMoey > 300 && totalMoey < 1000){
			this.goodDiscount = new GoodDiscountBImpl();
			this.totalMoey = this.goodDiscount.calculateMoney(totalMoey);
		}else{
			this.goodDiscount = new GoodDiscountCImpl();
			this.totalMoey = this.goodDiscount.calculateMoney(totalMoey);
		}
	}
	
	public double getMoney(){
		return this.totalMoey;
	}
}
