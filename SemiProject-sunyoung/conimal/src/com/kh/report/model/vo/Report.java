package com.kh.report.model.vo;

import java.sql.Date;

public class Report {
	
	private int reportUnique;	 	 		// 신고 고유번호
	private String memberId;		 		// 신고자 아이디
	private String refBoardType; 	 		// 게시판 타입 이름
	private int refNo;						// 게시글 번호
	private String cpostTitle;		 		// 게시글 제목
	private String adoptTitle;	
	private String animalTitle;	
	private String donationTitle;	
	private String volunteerTitle;	
	private String reportReason;			 // 신고 사유
	private Date reportDate;		 		// 신고 날짜
	
	public Report() {}

	public Report(int reportUnique, String memberId, String refBoardType, int refNo, String cpostTitle,
			String adoptTitle, String animalTitle, String donationTitle, String volunteerTitle, String reportReason,
			Date reportDate) {
		super();
		this.reportUnique = reportUnique;
		this.memberId = memberId;
		this.refBoardType = refBoardType;
		this.refNo = refNo;
		this.cpostTitle = cpostTitle;
		this.adoptTitle = adoptTitle;
		this.animalTitle = animalTitle;
		this.donationTitle = donationTitle;
		this.volunteerTitle = volunteerTitle;
		this.reportReason = reportReason;
		this.reportDate = reportDate;
	}

	public int getReportUnique() {
		return reportUnique;
	}

	public void setReportUnique(int reportUnique) {
		this.reportUnique = reportUnique;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRefBoardType() {
		return refBoardType;
	}

	public void setRefBoardType(String refBoardType) {
		this.refBoardType = refBoardType;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public String getCpostTitle() {
		return cpostTitle;
	}

	public void setCpostTitle(String cpostTitle) {
		this.cpostTitle = cpostTitle;
	}

	public String getAdoptTitle() {
		return adoptTitle;
	}

	public void setAdoptTitle(String adoptTitle) {
		this.adoptTitle = adoptTitle;
	}

	public String getAnimalTitle() {
		return animalTitle;
	}

	public void setAnimalTitle(String animalTitle) {
		this.animalTitle = animalTitle;
	}

	public String getDonationTitle() {
		return donationTitle;
	}

	public void setDonationTitle(String donationTitle) {
		this.donationTitle = donationTitle;
	}

	public String getVolunteerTitle() {
		return volunteerTitle;
	}

	public void setVolunteerTitle(String volunteerTitle) {
		this.volunteerTitle = volunteerTitle;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Override
	public String toString() {
		return "Report [reportUnique=" + reportUnique + ", memberId=" + memberId + ", refBoardType=" + refBoardType
				+ ", refNo=" + refNo + ", cpostTitle=" + cpostTitle + ", adoptTitle=" + adoptTitle + ", animalTitle="
				+ animalTitle + ", donationTitle=" + donationTitle + ", volunteerTitle=" + volunteerTitle
				+ ", reportReason=" + reportReason + ", reportDate=" + reportDate + "]";
	}

	
	
	
	
	
	
	
}
