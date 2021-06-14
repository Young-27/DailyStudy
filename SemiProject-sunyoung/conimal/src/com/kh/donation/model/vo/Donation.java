package com.kh.donation.model.vo;

import java.sql.Date;

public class Donation {
	private int doNo;
	private String doTitle;
	private String doContent;
	private Date doWriteDate;
	private String doAdmission;
	private String doWriter;
	private String refType;		// 'donation'
	private int doCount;
	
	public Donation() {}

	public Donation(int doNo, String doTitle, String doContent, Date doWriteDate, String doAdmission, String doWriter,
			String refType, int doCount) {
		super();
		this.doNo = doNo;
		this.doTitle = doTitle;
		this.doContent = doContent;
		this.doWriteDate = doWriteDate;
		this.doAdmission = doAdmission;
		this.doWriter = doWriter;
		this.refType = refType;
		this.doCount = doCount;
	}

	public int getDoNo() {
		return doNo;
	}

	public void setDoNo(int doNo) {
		this.doNo = doNo;
	}

	public String getDoTitle() {
		return doTitle;
	}

	public void setDoTitle(String doTitle) {
		this.doTitle = doTitle;
	}

	public String getDoContent() {
		return doContent;
	}

	public void setDoContent(String doContent) {
		this.doContent = doContent;
	}

	public Date getDoWriteDate() {
		return doWriteDate;
	}

	public void setDoWriteDate(Date doWriteDate) {
		this.doWriteDate = doWriteDate;
	}

	public String getDoAdmission() {
		return doAdmission;
	}

	public void setDoAdmission(String doAdmission) {
		this.doAdmission = doAdmission;
	}

	public String getDoWriter() {
		return doWriter;
	}

	public void setDoWriter(String doWriter) {
		this.doWriter = doWriter;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	public int getDoCount() {
		return doCount;
	}

	public void setDoCount(int doCount) {
		this.doCount = doCount;
	}

	@Override
	public String toString() {
		return "Donation [doNo=" + doNo + ", doTitle=" + doTitle + ", doContent=" + doContent + ", doWriteDate="
				+ doWriteDate + ", doAdmission=" + doAdmission + ", doWriter=" + doWriter + ", refType=" + refType
				+ ", doCount=" + doCount + "]";
	}

	
}
