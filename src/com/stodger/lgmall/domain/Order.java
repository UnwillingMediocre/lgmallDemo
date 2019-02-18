package com.stodger.lgmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid; //订单ID
	private double total; //总计
	private int state; //状态  注：0 待支付  1 待发货 2 待收货
	private double coupon; //优惠
	private Date orderTime; //创建订单时间
	private Date payTime; //支付时间
	private Date closingtime; //成交时间
	private String expressNumber; //快递运单号
	private Date sendGoodsTime; //发货时间
	
	private User user; //用户
	private DeliveryAddress  deliveryAddress; //收货
	private ExpressDelivery expressDelivery; //快递
	private List<OrderItem> orderItems = new ArrayList<>(); //商品列表
	
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getCoupon() {
		return coupon;
	}
	public void setCoupon(double coupon) {
		this.coupon = coupon;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getExpressNumber() {
		return expressNumber;
	}
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	public Date getSendGoodsTime() {
		return sendGoodsTime;
	}
	public void setSendGoodsTime(Date sendGoodsTime) {
		this.sendGoodsTime = sendGoodsTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public ExpressDelivery getExpressDelivery() {
		return expressDelivery;
	}
	public void setExpressDelivery(ExpressDelivery expressDelivery) {
		this.expressDelivery = expressDelivery;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getClosingtime() {
		return closingtime;
	}
	public void setClosingtime(Date closingtime) {
		this.closingtime = closingtime;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
