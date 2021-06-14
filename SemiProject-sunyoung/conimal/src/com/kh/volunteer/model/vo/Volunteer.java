package com.kh.volunteer.model.vo;

import java.sql.Date;

public class Volunteer {
	
	private int volNo;
	private String volTitle;
	private String speriod; // 모집기간
	private String volContent;
	private Date volWriteDate;
	private String volWriter;
	private String refType;
	private int volCount;
	
	public Volunteer() {}

	public Volunteer(int volNo, String volTitle, String speriod, String volContent, Date volWriteDate, String volWriter,
			String refType, int volCount) {
		super();
		this.volNo = volNo;
		this.volTitle = volTitle;
		this.speriod = speriod;
		this.volContent = volContent;
		this.volWriteDate = volWriteDate;
		this.volWriter = volWriter;
		this.refType = refType;
		this.volCount = volCount;
	}

	public int getVolNo() {
		return volNo;
	}

	public void setVolNo(int volNo) {
		this.volNo = volNo;
	}

	public String getVolTitle() {
		return volTitle;
	}

	public void setVolTitle(String volTitle) {
		this.volTitle = volTitle;
	}

	public String getSperiod() {
		return speriod;
	}

	public void setSperiod(String speriod) {
		this.speriod = speriod;
	}

	public String getVolContent() {
		return volContent;
	}

	public void setVolContent(String volContent) {
		this.volContent = volContent;
	}

	public Date getVolWriteDate() {
		return volWriteDate;
	}

	public void setVolWriteDate(Date volWriteDate) {
		this.volWriteDate = volWriteDate;
	}

	public String getVolWriter() {
		return volWriter;
	}

	public void setVolWriter(String volWriter) {
		this.volWriter = volWriter;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	public int getVolCount() {
		return volCount;
	}

	public void setVolCount(int volCount) {
		this.volCount = volCount;
	}

	@Override
	public String toString() {
		return "Volunteer [volNo=" + volNo + ", volTitle=" + volTitle + ", speriod=" + speriod + ", volContent="
				+ volContent + ", volWriteDate=" + volWriteDate + ", volWriter=" + volWriter + ", refType=" + refType
				+ ", volCount=" + volCount + "]";
	}
	
	
	
}
