package com.kh.community.cPost.model.vo;

import java.sql.Date;

public class Cpost {

	private int cPostNo;
	private String cUserId;
	private String cUserName;
	private String cPostTitle;
	private int cPostCount;
	private String cPostContent;
	private Date cPostDate;
	private String refType;
	
	
	public Cpost() {
		
	}


	public Cpost(int cPostNo, String cUserId, String cUserName, String cPostTitle, int cPostCount, String cPostContent,
			Date cPostDate, String refType) {
		super();
		this.cPostNo = cPostNo;
		this.cUserId = cUserId;
		this.cUserName = cUserName;
		this.cPostTitle = cPostTitle;
		this.cPostCount = cPostCount;
		this.cPostContent = cPostContent;
		this.cPostDate = cPostDate;
		this.refType = refType;
	}

	
	
	public Cpost(int cPostNo, String cUserName, String cPostTitle, int cPostCount, Date cPostDate) {
		super();
		this.cPostNo = cPostNo;
		this.cUserName = cUserName;
		this.cPostTitle = cPostTitle;
		this.cPostCount = cPostCount;
		this.cPostDate = cPostDate;
	}
	
	public Cpost(int cPostNo, String cUserName, String cPostTitle, String cPostContent, int cPostCount, Date cPostDate) {
		super();
		this.cPostNo = cPostNo;
		this.cUserName = cUserName;
		this.cPostTitle = cPostTitle;
		this.cPostContent = cPostContent;
		this.cPostCount = cPostCount;
		this.cPostDate = cPostDate;
	}

	public Cpost(int cPostNo, String cUserName, String cPostTitle, int cPostCount, String cPostContent,
			Date cPostDate) {
		super();
		this.cPostNo = cPostNo;
		this.cUserName = cUserName;
		this.cPostTitle = cPostTitle;
		this.cPostCount = cPostCount;
		this.cPostContent = cPostContent;
		this.cPostDate = cPostDate;
	}

	
	public Cpost(int cPostNo) {
		super();
		this.cPostNo = cPostNo;
	}


	public int getcPostNo() {
		return cPostNo;


	}


	public void setcPostNo(int cPostNo) {
		this.cPostNo = cPostNo;
	}


	public String getcUserId() {
		return cUserId;
	}


	public void setcUserId(String cUserId) {
		this.cUserId = cUserId;
	}


	public String getcUserName() {
		return cUserName;
	}


	public void setcUserName(String cUserName) {
		this.cUserName = cUserName;
	}


	public String getcPostTitle() {
		return cPostTitle;
	}


	public void setcPostTitle(String cPostTitle) {
		this.cPostTitle = cPostTitle;
	}


	public int getcPostCount() {
		return cPostCount;
	}


	public void setcPostCount(int cPostCount) {
		this.cPostCount = cPostCount;
	}


	public String getcPostContent() {
		return cPostContent;
	}


	public void setcPostContent(String cPostContent) {
		this.cPostContent = cPostContent;
	}


	public Date getcPostDate() {
		return cPostDate;
	}


	public void setcPostDate(Date cPostDate) {
		this.cPostDate = cPostDate;
	}


	public String getRefType() {
		return refType;
	}


	public void setRefType(String refType) {
		this.refType = refType;
	}


	@Override
	public String toString() {
		return "Cpost [cPostNo=" + cPostNo + ", cUserId=" + cUserId + ", cUserName=" + cUserName + ", cPostTitle="
				+ cPostTitle + ", cPostCount=" + cPostCount + ", cPostContent=" + cPostContent + ", cPostDate="
				+ cPostDate + ", refType=" + refType + "]";
	}
	
	
	
	
	
	
	
	
	
}
