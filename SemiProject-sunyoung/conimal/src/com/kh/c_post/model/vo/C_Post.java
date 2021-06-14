package com.kh.c_post.model.vo;

import java.sql.Date;

public class C_Post {
	private int cpostNo;
	private String cuserId;
	private String cuserName;
	private String cpostTitle;
	private int cpostCount;
	private String cpostContent;
	private Date cpostDate;
	private String refType;
	
	public C_Post() {}

	public C_Post(int cpostNo, String cuserId, String cuserName, String cpostTitle, int cpostCount, String cpostContent,
			Date cpostDate, String refType) {
		super();
		this.cpostNo = cpostNo;
		this.cuserId = cuserId;
		this.cuserName = cuserName;
		this.cpostTitle = cpostTitle;
		this.cpostCount = cpostCount;
		this.cpostContent = cpostContent;
		this.cpostDate = cpostDate;
		this.refType = refType;
	}

	public int getCpostNo() {
		return cpostNo;
	}

	public void setCpostNo(int cpostNo) {
		this.cpostNo = cpostNo;
	}

	public String getCuserId() {
		return cuserId;
	}

	public void setCuserId(String cuserId) {
		this.cuserId = cuserId;
	}

	public String getCuserName() {
		return cuserName;
	}

	public void setCuserName(String cuserName) {
		this.cuserName = cuserName;
	}

	public String getCpostTitle() {
		return cpostTitle;
	}

	public void setCpostTitle(String cpostTitle) {
		this.cpostTitle = cpostTitle;
	}

	public int getCpostCount() {
		return cpostCount;
	}

	public void setCpostCount(int cpostCount) {
		this.cpostCount = cpostCount;
	}

	public String getCpostContent() {
		return cpostContent;
	}

	public void setCpostContent(String cpostContent) {
		this.cpostContent = cpostContent;
	}

	public Date getCpostDate() {
		return cpostDate;
	}

	public void setCpostDate(Date cpostDate) {
		this.cpostDate = cpostDate;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	@Override
	public String toString() {
		return "Board [cpostNo=" + cpostNo + ", cuserId=" + cuserId + ", cuserName=" + cuserName + ", cpostTitle="
				+ cpostTitle + ", cpostCount=" + cpostCount + ", cpostContent=" + cpostContent + ", cpostDate="
				+ cpostDate + ", refType=" + refType + "]";
	}
}
