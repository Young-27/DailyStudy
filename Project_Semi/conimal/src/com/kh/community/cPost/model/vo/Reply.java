package com.kh.community.cPost.model.vo;

public class Reply {
	
	private int reNo;
	private int cPostNo;
	private int memNo;
	private String cUserName;
	private String writtenDate;
	private String replyContent;
	
	public Reply() {}

	public Reply(int reNo, int cPostNo, int memNo, String cUserName, String writtenDate, String replyContent) {
		super();
		this.reNo = reNo;
		this.cPostNo = cPostNo;
		this.memNo = memNo;
		this.cUserName = cUserName;
		this.writtenDate = writtenDate;
		this.replyContent = replyContent;
	}
	
	

	public Reply(int reNo, String cUserName, String writtenDate, String replyContent) {
		super();
		this.reNo = reNo;
		this.cUserName = cUserName;
		this.writtenDate = writtenDate;
		this.replyContent = replyContent;
	}

	
	public Reply(int cPostNo) {
		super();
		this.cPostNo = cPostNo;
	}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public int getcPostNo() {
		return cPostNo;
	}

	public void setcPostNo(int cPostNo) {
		this.cPostNo = cPostNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getcUserName() {
		return cUserName;
	}

	public void setcUserName(String cUserName) {
		this.cUserName = cUserName;
	}

	public String getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(String writtenDate) {
		this.writtenDate = writtenDate;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Override
	public String toString() {
		return "Reply [reNo=" + reNo + ", cPostNo=" + cPostNo + ", memNo=" + memNo + ", cUserName=" + cUserName
				+ ", writtenDate=" + writtenDate + ", replyContent=" + replyContent + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
