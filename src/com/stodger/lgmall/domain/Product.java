package com.stodger.lgmall.domain;

public class Product {
	private String pid; //��Ʒ���
	private String p_title; //��Ʒ����
	private String cid; //��Ʒ������
	private String p_sellPoint; //��Ʒ����
	private double p_price; //��Ʒ�ۼ�
	private double p_marketPrice; //��Ʒ�г���
	private int p_num; //��Ʒ����
	private int p_limitNum; //��Ʒ��������
	private String p_image; //��Ʒ����ͼ
	private String p_detail; //��Ʒ����
	private String p_soldInTime; //��Ʒ�ϼ�ʱ��
	private String p_soldOutTime; //��Ʒ�ϼ�ʱ��
	private int p_popular; //��Ʒ�Ƿ�����
	
	//get��set����
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getP_sellPoint() {
		return p_sellPoint;
	}
	public void setP_sellPoint(String p_sellPoint) {
		this.p_sellPoint = p_sellPoint;
	}
	public double getP_price() {
		return p_price;
	}
	public void setP_price(double p_price) {
		this.p_price = p_price;
	}
	public double getP_marketPrice() {
		return p_marketPrice;
	}
	public void setP_marketPrice(double p_marketPrice) {
		this.p_marketPrice = p_marketPrice;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getP_limitNum() {
		return p_limitNum;
	}
	public void setP_limitNum(int p_limitNum) {
		this.p_limitNum = p_limitNum;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public String getP_detail() {
		return p_detail;
	}
	public void setP_detail(String p_detail) {
		this.p_detail = p_detail;
	}
	public String getP_soldInTime() {
		return p_soldInTime;
	}
	public void setP_soldInTime(String p_soldInTime) {
		this.p_soldInTime = p_soldInTime;
	}
	public String getP_soldOutTime() {
		return p_soldOutTime;
	}
	public void setP_soldOutTime(String p_soldOutTime) {
		this.p_soldOutTime = p_soldOutTime;
	}
	public int getP_popular() {
		return p_popular;
	}
	public void setP_popular(int p_popular) {
		this.p_popular = p_popular;
	}
}
