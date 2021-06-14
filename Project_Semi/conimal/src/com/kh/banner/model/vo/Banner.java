package com.kh.banner.model.vo;

public class Banner {
	private int mainNo;
	private int memNo;
	private String refType;
	
	public Banner() {}
	
	public Banner(int mainNo, int memNo, String refType) {
		super();
		this.mainNo = mainNo;
		this.memNo = memNo;
		this.refType = refType;
	}
	
	public int getMainNo() {
		return mainNo;
	}
	public void setMainNo(int mainNo) {
		this.mainNo = mainNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
	@Override
	public String toString() {
		return "Banner [mainNo=" + mainNo + ", memNo=" + memNo + ", refType=" + refType + "]";
	}
	
	
	
	
	

}
