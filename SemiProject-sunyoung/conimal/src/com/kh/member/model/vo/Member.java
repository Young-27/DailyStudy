package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private Date enrollDate;
	private String status;
	private int userCode;
	private String shelterName;
	private String shelterPhone;
	private String shelterAddress;
	private String shelterAbout;
	private String admission;		// 승인여부
	private String shelterLocal;
	private String refType;
	
	public Member() {}
	
	public Member(int userNo, String userId, String userPwd, String userName, String email, Date enrollDate,
			String status, int userCode) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.status = status;
		this.userCode = userCode;
	}

	public Member(int userNo, String userId, String userPwd, String userName, String email, Date enrollDate,
			String status, int userCode, String shelterName, String shelterPhone, String shelterAddress,
			String shelterAbout, String admission, String shelterLocal, String refType) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.status = status;
		this.userCode = userCode;
		this.shelterName = shelterName;
		this.shelterPhone = shelterPhone;
		this.shelterAddress = shelterAddress;
		this.shelterAbout = shelterAbout;
		this.admission = admission;
		this.shelterLocal = shelterLocal;
		this.refType = refType;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	public String getShelterName() {
		return shelterName;
	}

	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}

	public String getShelterPhone() {
		return shelterPhone;
	}

	public void setShelterPhone(String shelterPhone) {
		this.shelterPhone = shelterPhone;
	}

	public String getShelterAddress() {
		return shelterAddress;
	}

	public void setShelterAddress(String shelterAddress) {
		this.shelterAddress = shelterAddress;
	}

	public String getShelterAbout() {
		return shelterAbout;
	}

	public void setShelterAbout(String shelterAbout) {
		this.shelterAbout = shelterAbout;
	}

	public String getAdmission() {
		return admission;
	}

	public void setAdmission(String admission) {
		this.admission = admission;
	}

	public String getShelterLocal() {
		return shelterLocal;
	}

	public void setShelterLocal(String shelterLocal) {
		this.shelterLocal = shelterLocal;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", enrollDate=" + enrollDate + ", status=" + status + ", userCode=" + userCode
				+ "]";
	}
	
			
	

}
