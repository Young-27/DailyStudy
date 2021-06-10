package com.kh.volunteer.model.vo;

import java.sql.Date;

public class Volunteer {
	
	private int volNo; // 자원봉사 글번호
	private String volTitle; // 자원봉사 글제목
	private String speriod; // 모집기간
	private String volContent; // 상세설명
	private Date volWritedate; // 작성일
	private String memNo; // 작성시 회원번호 / 조회시 회원아이디
	private String refType; //게시글 유형
	private int volCount; // 조회수
	
	private String shName; // 보호소 이름
	private String shPhone; // 보호소 연락처
	private String shAddress; // 보호소 주소
	
	public Volunteer() {}

	public Volunteer(int volNo, String volTitle, String speriod, String volContent, Date volWritedate, String memNo,
			String refType, int volCount) {
		super();
		this.volNo = volNo;
		this.volTitle = volTitle;
		this.speriod = speriod;
		this.volContent = volContent;
		this.volWritedate = volWritedate;
		this.memNo = memNo;
		this.refType = refType;
		this.volCount = volCount;
	}
	
	
    // 글번호, 글제목, 작성일, 작성자, 조회수
	public Volunteer(int volNo, String volTitle, Date volWritedate, String memNo, int volCount) {
		super();
		this.volNo = volNo;
		this.volTitle = volTitle;
		this.volWritedate = volWritedate;
		this.memNo = memNo;
		this.volCount = volCount;
	}
	
	

	public Volunteer(String volTitle, String shName, String speriod,
			String shPhone,String shAddress, String volContent) {
		super();
		this.volTitle = volTitle;
		this.shName = shName;
		this.speriod = speriod;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.volContent = volContent;
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

	public Date getVolWritedate() {
		return volWritedate;
	}

	public void setVolWritedate(Date volWritedate) {
		this.volWritedate = volWritedate;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
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
	
	

	public String getShName() {
		return shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}

	public String getShPhone() {
		return shPhone;
	}

	public void setShPhone(String shPhone) {
		this.shPhone = shPhone;
	}

	public String getShAddress() {
		return shAddress;
	}

	public void setShAddress(String shAddress) {
		this.shAddress = shAddress;
	}

	@Override
	public String toString() {
		return "Volunteer [volNo=" + volNo + ", volTitle=" + volTitle + ", speriod=" + speriod + ", volContent="
				+ volContent + ", volWritedate=" + volWritedate + ", memNo=" + memNo + ", refType=" + refType
				+ ", volCount=" + volCount + "]";
	}

	

	
	
	

}
