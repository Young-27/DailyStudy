package com.kh.customer.model.vo;

import java.sql.Date;

public class Customer {
	
	private int queNo;
	private String queId;
	private String queTitle;
	private String queContent;
	private Date queDate;
	private String ansStatus;
	private String ansContent;
	private Date ansDate;
	
	public Customer() {}

	public Customer(int queNo, String queId, String queTitle, String queContent, Date queDate, String ansStatus,
			String ansContent, Date ansDate) {
		super();
		this.queNo = queNo;
		this.queId = queId;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queDate = queDate;
		this.ansStatus = ansStatus;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
	}
	

	public Customer(int queNo, String queId, String queTitle, Date queDate, String ansStatus) {
		super();
		this.queNo = queNo;
		this.queId = queId;
		this.queTitle = queTitle;
		this.queDate = queDate;
		this.ansStatus = ansStatus;
	}
	
	

	public int getQueNo() {
		return queNo;
	}

	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}

	public String getQueId() {
		return queId;
	}

	public void setQueId(String queId) {
		this.queId = queId;
	}

	public String getQueTitle() {
		return queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public String getQueContent() {
		return queContent;
	}

	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}

	public Date getQueDate() {
		return queDate;
	}

	public void setQueDate(Date queDate) {
		this.queDate = queDate;
	}

	public String getAnsStatus() {
		return ansStatus;
	}

	public void setAnsStatus(String ansStatus) {
		this.ansStatus = ansStatus;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

	@Override
	public String toString() {
		return "Customer [queNo=" + queNo + ", queId=" + queId + ", queTitle=" + queTitle + ", queContent=" + queContent
				+ ", queDate=" + queDate + ", ansStatus=" + ansStatus + ", ansContent=" + ansContent + ", ansDate="
				+ ansDate + "]";
	}

	
	
	
}
