package com.kh.community.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int  noticeNo;
	private int noticeMem;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;
	private String refType;
	
		
	
	
	public Notice() {
		
	}
	
	public Notice(int noticeNo, int noticeMem, String noticeTitle, String noticeContent, Date noticeDate,
			String refType) {
		
		this.noticeNo = noticeNo;
		this.noticeMem = noticeMem;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.refType = refType;
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public int getNoticeMem() {
		return noticeMem;
	}
	public void setNoticeMem(int noticeMem) {
		this.noticeMem = noticeMem;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
	
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeMem=" + noticeMem + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", refType=" + refType + "]";
	}
	
	

}
