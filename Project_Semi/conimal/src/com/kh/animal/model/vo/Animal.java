package com.kh.animal.model.vo;

import java.sql.Date;

public class Animal {
	
	private int anNo; // 게시글 번호
	private String anTitle; // 글제목
	private String anPlace; // 발견장소
	private String anDate; // 발견날짜
	private String anSpecies; // 동물종류
	private String anGender; // 동물성별
	private Date anWritedate; // 작성일
	private String anContent; // 글내용
	private String memNo; // 작성시 회원번호 / 조회시 회원아이디
	private String refType; // 게시글 유형
	private int anCount; // 조회수
	
	private String shName; // 보호소명
	
	public Animal() {}

	public Animal(int anNo, String anTitle) {
		super();
		this.anNo = anNo;
		this.anTitle = anTitle;
	}

	// 글번호, 보호소명, 성별, 발견날짜, 발견장소, 글내용
	public Animal(int anNo, String shName, String anGender, String anDate, String anPlace, String anContent) {
		super();
		this.anNo = anNo;
		this.shName = shName;
		this.anGender = anGender;
		this.anDate = anDate;
		this.anPlace = anPlace;
		this.anContent = anContent;
	}
public Animal(int anNo, String anTitle, String anPlace, String anDate, String anSpecies, Date anWritedate,
			String anContent) {
		super();
		this.anNo = anNo;
		this.anTitle = anTitle;
		this.anPlace = anPlace;
		this.anDate = anDate;
		this.anSpecies = anSpecies;
		this.anWritedate = anWritedate;
		this.anContent = anContent;
	}

public Animal(int anNo, String anTitle, String anPlace, String anDate, String anSpecies, String anGender,
			Date anWritedate, String anContent, String memNo, String refType, int anCount) {
		super();
		this.anNo = anNo;
		this.anTitle = anTitle;
		this.anPlace = anPlace;
		this.anDate = anDate;
		this.anSpecies = anSpecies;
		this.anGender = anGender;
		this.anWritedate = anWritedate;
		this.anContent = anContent;
		this.memNo = memNo;
		this.refType = refType;
		this.anCount = anCount;
	}

	public int getAnNo() {
		return anNo;
	}

	public void setAnNo(int anNo) {
		this.anNo = anNo;
	}

	public String getAnTitle() {
		return anTitle;
	}

	public void setAnTitle(String anTitle) {
		this.anTitle = anTitle;
	}

	public String getAnPlace() {
		return anPlace;
	}

	public void setAnPlace(String anPlace) {
		this.anPlace = anPlace;
	}

	public String getAnDate() {
		return anDate;
	}

	public void setAnDate(String anDate) {
		this.anDate = anDate;
	}

	public String getAnSpecies() {
		return anSpecies;
	}

	public void setAnSpecies(String anSpecies) {
		this.anSpecies = anSpecies;
	}

	public String getAnGender() {
		return anGender;
	}

	public void setAnGender(String anGender) {
		this.anGender = anGender;
	}

	public Date getAnWritedate() {
		return anWritedate;
	}

	public void setAnWritedate(Date anWritedate) {
		this.anWritedate = anWritedate;
	}

	public String getAnContent() {
		return anContent;
	}

	public void setAnContent(String anContent) {
		this.anContent = anContent;
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

	public int getAnCount() {
		return anCount;
	}

	public void setAnCount(int anCount) {
		this.anCount = anCount;
	}

	public String getShName() {
		return shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}
	
	
	
	

}
