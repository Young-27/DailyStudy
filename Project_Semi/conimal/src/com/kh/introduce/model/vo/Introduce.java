package com.kh.introduce.model.vo;

public class Introduce {
	private int introNo;
	private String introContent;
	private String introTitle;
	private String refType;
	
	
	
	
	
	public Introduce() {
		super();
	}
	
	public Introduce(int introNo, String introContent, String introTitle) {
		super();
		this.introNo = introNo;
		this.introContent = introContent;
		this.introTitle = introTitle;
	}
	
	public Introduce(int introNo, String introContent, String introTitle, String refType) {
		super();
		this.introNo = introNo;
		this.introContent = introContent;
		this.introTitle = introTitle;
		this.refType = refType;
	}
	
	
	
	public int getIntroNo() {
		return introNo;
	}
	public void setIntroNo(int introNo) {
		this.introNo = introNo;
	}
	public String getIntroContent() {
		return introContent;
	}
	public void setIntroContent(String introContent) {
		this.introContent = introContent;
	}
	public String getIntroTitle() {
		return introTitle;
	}
	public void setIntroTitle(String introTitle) {
		this.introTitle = introTitle;
	}
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
	
	
	@Override
	public String toString() {
		return "Introduce introNo=" + introNo + ", introContent=" + introContent + ", introTitle=" + introTitle
				+ ", refType=" + refType;
	}
	
	
	

}
