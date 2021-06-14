package com.kh.shelter.model.vo;

import java.sql.Date;

public class Shelter {
	
	private String memNo;     // 작성시 보호소 번호 / 조회시 회원 아이디
	private String shName;    // 보호소명
	private String shPhone;   // 보소호 연락처
	private String shAddress; // 보호소 주소
	private String shAbout;   // 보호소 소개글
	private String admission; // 승인여부(Y/N)
	private String shLocal;   // 보호소 지역
	private String refType;   // 게시글 유형
	private Date enrollDate;
	
		
	
	
	public Shelter() {
		super();
	}

	public Shelter(String memNo, String shName, String shPhone, String shAddress, String shAbout,
			String admission, String shLocal, String refType, Date enrollDate) {
		super();
		this.memNo = memNo;
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.shAbout = shAbout;
		this.admission = admission;
		this.shLocal = shLocal;
		this.refType = refType;
		this.enrollDate= enrollDate;
	}
 public Shelter(String memNo, String shName) {
		super();
		this.memNo = memNo;
		this.shName = shName;
	}

		// 보호소명, 주소, 연락처, 소개글
	
	
	public Shelter (String shName, String shPhone, String shAddress, String shAbout,String shLocal, String memNo) {
		
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.shAbout = shAbout;
		this.shLocal= shLocal;		
		this.memNo = memNo;
		
	}
public Shelter (String shName, String shPhone, String shAddress, String shAbout,String shLocal) {
		
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.shAbout = shAbout;
		this.shLocal= shLocal;			
		
	}
	

public Shelter(String memNo, String shName, String shPhone, String shAddress, String shAbout, String admission,
			String shLocal, String refType) {
		super();
		this.memNo = memNo;
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.shAbout = shAbout;
		this.admission = admission;
		this.shLocal = shLocal;
		this.refType = refType;
	}

	public  String getMemNo() {
		return memNo;
	}
	
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public String getShName() {
		return shName;
	}
	public void setShName(String shName) {
		this.shName = shName;
	}
	public String getShPhone() {
		return shPhone;
	}
	public void setShPhone(String shPhone) {
		this.shPhone = shPhone;
	}
	public String getShAddress() {
		return shAddress;
	}
	public void setShAddress(String shAddress) {
		this.shAddress = shAddress;
	}
	public String getShAbout() {
		return shAbout;
	}
	public void setShAbout(String shAbout) {
		this.shAbout = shAbout;
	}
	public String getAdmission() {
		return admission;
	}
	public void setAdmission(String admission) {
		this.admission = admission;
	}
	public String getShLocal() {
		return shLocal;
	}
	public void setShLocal(String shLocal) {
		this.shLocal = shLocal;
	}
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
	
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	@Override
	public String toString() {
		return "sh [memNo=" + memNo + ", shName=" + shName + ", shPhone=" + shPhone
				+ ", shAddress=" + shAddress + ", shAbout=" + shAbout + ", shAdmission="
				+ admission + ", shLocal=" + shLocal + ", refType=" + refType +", enrollDate"+enrollDate+ "]";
	}
	
	
	

}
