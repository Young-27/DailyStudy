package com.kh.board.model.vo;

import java.sql.Date;

public class Board {
	
	private int bno;
	private String bRefType;
	private String bTitle;
	private String bWrtier;
	private Date bDate;
	private int bCount;
	
	public Board() {}

	public Board(int bno, String bRefType, String bTitle, String bWrtier, Date bDate, int bCount) {
		super();
		this.bno = bno;
		this.bRefType = bRefType;
		this.bTitle = bTitle;
		this.bWrtier = bWrtier;
		this.bDate = bDate;
		this.bCount = bCount;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getbRefType() {
		return bRefType;
	}

	public void setbRefType(String bRefType) {
		this.bRefType = bRefType;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbWrtier() {
		return bWrtier;
	}

	public void setbWrtier(String bWrtier) {
		this.bWrtier = bWrtier;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", bRefType=" + bRefType + ", bTitle=" + bTitle + ", bWrtier=" + bWrtier
				+ ", bDate=" + bDate + ", bCount=" + bCount + "]";
	}

	
	
	
}
