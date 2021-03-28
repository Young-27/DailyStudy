package com.kh.chap03_class.model.vo;

// 클래스에서 사용 가능한 접근 제한자 : public, default(public과 달리 접근제한자를 생략하는것이 default)
public class Person { 
	
	// 필드 == 멤버변수 == 인스턴스변수	
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	// 각 필드에 대입하고자 하는 값 전달받아서 해당 필드에 대입시켜주는 용도의 setter메소드 7개
	// setter메소드명 : setXXX (낙타표기법) 
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// 각 각의 필드값을 돌려주는 용도의 getter메소드 7개
	
	public String getId() {
		return id;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String information() {
		return id + " " + pwd + " " + name + " " + age + " " + gender + " " + phone + " " + email;
	}
}
