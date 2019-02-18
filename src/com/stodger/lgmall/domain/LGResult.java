package com.stodger.lgmall.domain;

public class LGResult {
	private boolean ok; //true false
	private String msg; //ÏûÏ¢
	
	public LGResult() {
		this.ok = false;
		this.msg = "";
	}
	public boolean getOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
