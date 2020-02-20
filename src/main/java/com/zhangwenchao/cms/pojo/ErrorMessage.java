package com.zhangwenchao.cms.pojo;

public class ErrorMessage {
	private String eid;
	private int because;
	@Override
	public String toString() {
		return "ErrorMessage [eid=" + eid + ", because=" + because + "]";
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public int getBecause() {
		return because;
	}
	public void setBecause(int because) {
		this.because = because;
	}
	public ErrorMessage(String eid, int because) {
		super();
		this.eid = eid;
		this.because = because;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
