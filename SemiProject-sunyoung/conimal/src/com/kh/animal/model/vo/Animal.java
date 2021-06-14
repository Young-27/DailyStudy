package com.kh.animal.model.vo;

import java.sql.Date;

public class Animal {
	// 보호중인 동물
	
	private int animalNo;
	private String title;
	private String place;
	private Date date;
	private String specties;
	private String gender;
	private Date wrtiteDate;
	private String content;
	private String writer; 		// 작성자
	private String ref_type;
	private int count;
	
	public Animal() {}
	
	public Animal(int animalNo, String title, String place, java.sql.Date date, String specties, String gender,
			java.sql.Date wrtiteDate, String content, String writer, String ref_type, int count) {
		super();
		this.animalNo = animalNo;
		this.title = title;
		this.place = place;
		this.date = date;
		this.specties = specties;
		this.gender = gender;
		this.wrtiteDate = wrtiteDate;
		this.content = content;
		this.writer = writer;
		this.ref_type = ref_type;
		this.count = count;
	}

	public int getAnimalNo() {
		return animalNo;
	}

	public void setAnimalNo(int animalNo) {
		this.animalNo = animalNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSpecties() {
		return specties;
	}

	public void setSpecties(String specties) {
		this.specties = specties;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getWrtiteDate() {
		return wrtiteDate;
	}

	public void setWrtiteDate(Date wrtiteDate) {
		this.wrtiteDate = wrtiteDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRef_type() {
		return ref_type;
	}

	public void setRef_type(String ref_type) {
		this.ref_type = ref_type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Animal [animalNo=" + animalNo + ", title=" + title + ", place=" + place + ", date=" + date
				+ ", specties=" + specties + ", gender=" + gender + ", wrtiteDate=" + wrtiteDate + ", content="
				+ content + ", writer=" + writer + ", ref_type=" + ref_type + ", count=" + count + "]";
	}
	
	
	
}
