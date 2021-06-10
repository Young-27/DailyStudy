package com.kh.animal.model.vo;

import java.sql.Date;

public class Bookmark {
	
	private int memNo;     // 회원번호
	private int binfoNo;   // 게시글번호(anNo)
	private Date markDate; // 즐겨찾기한날짜

	public Bookmark() {}

	public Bookmark(int memNo, int binfoNo, Date markDate) {
		super();
		this.memNo = memNo;
		this.binfoNo = binfoNo;
		this.markDate = markDate;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getBinfoNo() {
		return binfoNo;
	}

	public void setBinfoNo(int binfoNo) {
		this.binfoNo = binfoNo;
	}

	public Date getMarkDate() {
		return markDate;
	}

	public void setMarkDate(Date markDate) {
		this.markDate = markDate;
	}

	@Override
	public String toString() {
		return "Bookmark [memNo=" + memNo + ", binfoNo=" + binfoNo + ", markDate=" + markDate + "]";
	}
	
	
}
