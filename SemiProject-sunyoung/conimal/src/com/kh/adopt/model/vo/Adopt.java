package com.kh.adopt.model.vo;

import java.sql.Date;

public class Adopt {
	
	private int adoptNo;
	private String adoptWriter;
	private String shelterId;
	private String adoptTitle;
	private String adoptContent;
	private Date adoptDate;
	private int count;
	private String refType;
	
	public Adopt() {}

	public Adopt(int adoptNo, String adoptWriter, String shelterId, String adoptTitle, String adoptContent,
			Date adoptDate, int count, String refType) {
		super();
		this.adoptNo = adoptNo;
		this.adoptWriter = adoptWriter;
		this.shelterId = shelterId;
		this.adoptTitle = adoptTitle;
		this.adoptContent = adoptContent;
		this.adoptDate = adoptDate;
		this.count = count;
		this.refType = refType;
	}
	
	public Adopt(int adoptNo, String adoptWriter, String adoptTitle, String adoptContent, Date adoptDate, int count,
			String refType) {
		super();
		this.adoptNo = adoptNo;
		this.adoptWriter = adoptWriter;
		this.adoptTitle = adoptTitle;
		this.adoptContent = adoptContent;
		this.adoptDate = adoptDate;
		this.count = count;
		this.refType = refType;
	}

	public int getAdoptNo() {
		return adoptNo;
	}

	public void setAdoptNo(int adoptNo) {
		this.adoptNo = adoptNo;
	}

	public String getAdoptWriter() {
		return adoptWriter;
	}

	public void setAdoptWriter(String adoptWriter) {
		this.adoptWriter = adoptWriter;
	}

	public String getShelterId() {
		return shelterId;
	}

	public void setShelterId(String shelterId) {
		this.shelterId = shelterId;
	}

	public String getAdoptTitle() {
		return adoptTitle;
	}

	public void setAdoptTitle(String adoptTitle) {
		this.adoptTitle = adoptTitle;
	}

	public String getAdoptContent() {
		return adoptContent;
	}

	public void setAdoptContent(String adoptContent) {
		this.adoptContent = adoptContent;
	}

	public Date getAdoptDate() {
		return adoptDate;
	}

	public void setAdoptDate(Date adoptDate) {
		this.adoptDate = adoptDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	@Override
	public String toString() {
		return "Adopt [adoptNo=" + adoptNo + ", adoptWriter=" + adoptWriter + ", shelterId=" + shelterId
				+ ", adoptTitle=" + adoptTitle + ", adoptContent=" + adoptContent + ", adoptDate=" + adoptDate
				+ ", count=" + count + ", refType=" + refType + "]";
	}
	
	
	
}
