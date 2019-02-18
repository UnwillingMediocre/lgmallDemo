package com.stodger.lgmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid; //����ID
	private double total; //�ܼ�
	private int state; //״̬  ע��0 ��֧��  1 ������ 2 ���ջ�
	private double coupon; //�Ż�
	private Date orderTime; //��������ʱ��
	private Date payTime; //֧��ʱ��
	private Date closingtime; //�ɽ�ʱ��
	private String expressNumber; //����˵���
	private Date sendGoodsTime; //����ʱ��
	
	private User user; //�û�
	private DeliveryAddress  deliveryAddress; //�ջ�
	private ExpressDelivery expressDelivery; //���
	private List<OrderItem> orderItems = new ArrayList<>(); //��Ʒ�б�
	
	
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
