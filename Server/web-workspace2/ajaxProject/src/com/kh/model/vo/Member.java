package com.kh.model.vo;

public class Member {
	
	private int userNo;
	private String userName;
	private int age;
	private String gender;
	
	public Member() {}

	public Member(int userNo, String userName, int age, String gender) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userName=" + userName + ", age=" + age + ", gender=" + gender + "]";
	}
	
	

}
