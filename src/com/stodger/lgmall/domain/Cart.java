package com.stodger.lgmall.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> cartItems = new  HashMap<>(); //存储购物商品项
	private double total; //总计
	private double coupon; //优惠
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCoupon() {
		return coupon;
	}
	public void setCoupon(double coupon) {
		this.coupon = coupon;
	}
	
}
