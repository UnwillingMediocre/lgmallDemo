package com.stodger.lgmall.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	//��ǰҳ
	private int currentPage;
	//��ǰÿҳ��ʾ��������
	private int currentCount;
	//��ѯ���ݿ�õ���������
	private int totalRecord; 
	//��ҳ��
	private int totalPage;
	//���������ݿ�ʼ��ʾ
	private int startIntdex;
	//ÿҳ��ʾ������
	private List<T> dataList = new ArrayList<T>();
	
	//��ҳ��ʾ��ҳ��
	private int start;
	private int end;
	
	public PageBean(int currentPage, int currentCount, int totalRecord){
		this.currentCount = currentCount;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		
		//��ҳ��
		if(totalRecord % currentCount == 0){
			this.totalPage = totalRecord / currentCount;
		}else{
			this.totalPage = totalRecord / currentCount + 1;
		}
		//��ʼ����
		this.startIntdex = (currentPage - 1) * currentCount;
		
		this.start = 1;
		this.end = 5;
		//��ʾҳ���ļ���
		if(totalPage <= 5){
			this.end = this.totalPage;
		}else{
			this.start = currentPage - 2;
			this.end = currentPage + 2;
			
			if(start < 0){
				this.start = 1;
				this.end = 5;
			}
			if(end > this.totalPage){
				this.end = this.totalPage;
				this.start = this.end - 5;
			}
		}
	}
	
	//get��set����
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartIntdex() {
		return startIntdex;
	}
	public void setStartIntdex(int startIntdex) {
		this.startIntdex = startIntdex;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
