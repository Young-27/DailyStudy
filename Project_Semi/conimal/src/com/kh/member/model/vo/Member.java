package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int memNo;
	private String memId;
	private String memPwd;
	private String memName;
	private String email;
	private Date enrollDate;
	private String status;
	private int memCode;
	
	private String shName;
	private String shPhone;
	private String shAddress;
	private String shAbout;
	private String admission;
	private String shLocal;
	private String refType;

	public Member(){
		
	}

	public Member(int memNo, String memId, String memPwd, String memName, String email, Date enrollDate, String status,
			int memCode) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.status = status;
		this.memCode = memCode;
	}

	public Member(int memNo, String memId, String memPwd, String memName, String email, Date enrollDate, String status,
			int memCode, String shName, String shPhone, String shAddress, String shAbout, String admission,
			String shLocal, String refType) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.status = status;
		this.memCode = memCode;
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.shAbout = shAbout;
		this.admission = admission;
		this.shLocal = shLocal;
		this.refType = refType;
	}
	
	

	public Member(String memId, String memPwd, String memName, String email) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.email = email;
	}

	
	public Member(int memNo, String memPwd) {
		super();
		this.memNo = memNo;
		this.memPwd = memPwd;
	}
	
	public Member(String memId, String email) {
		super();
		this.memId = memId;
		this.email = email;
	}



	public Member(String memId, String memPwd, String memName, String email, int memCode) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.email = email;
		this.memCode = memCode;
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



	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMemCode() {
		return memCode;
	}

	public void setMemCode(int memCode) {
		this.memCode = memCode;
	}


	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName
				+ ", email=" + email + ", enrollDate=" + enrollDate + ", status=" + status + ", memCode=" + memCode
				+ "]";
	}
	
	

}
