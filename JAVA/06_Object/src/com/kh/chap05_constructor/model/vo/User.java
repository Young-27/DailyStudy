package com.kh.chap05_constructor.model.vo;

public class User {
	
	// 필드부
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;
	
	// 생성자부
	/*
	 * 	* 생성자
	 * 	public 클래스명([매개변수,매개변수, ...]) {
	 * 		// 해당 생성자를 통해서 객체 생성시 실행하고자 하는 코드;
	 * }
	 * 
	 * 	* 생성자를 작성하는 목적
	 * 	1. 객체를 생성해주기 위한 목적
	 *	2. 객체생성뿐만 아니라 매개변수로 전달된 값 곧바로 필드에 초기화할 목적
	 * 	
	 * 
	 * 	* 생성자 작성시 주의사항
	 * 	1. 반드시 클래스명과 동일해야됨 (대/소문자 구분)
	 * 	2. 반환형이 존재하지 않는다. (메소드와 유사해서 헷갈릴 수 있음)
	 * 	3. 매개변수 생성자를 명시적으로 작성하게 되면 기본생성자를 JVM이 자동으로 만들어주지 않는다.
	 * 		즉, 어찌됐든간에 기본생성자는 항상 작성하는 습관을 들이자! 
	 * 	
	 */
	
	public User() {
		// 기본생성자 (매개변수 없는 생성자)
		// 단지 객체 생성(공간을 확보)만을 목적으로 할 때 사용
		// 기본생성자를 생략하는 경우 => 오류 X => JVM이 자동으로 만들어 줬기 때문에 항상 객체 생성 가능했음.	
	}
	
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		
	}
	
	public User(String userId, String userPwd, 
			String userName, int age, char gender) {
		
		/*
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		*/
		// 위와 같이 중복되는 동일한 초기화 하는 내용의 생성자가 존재할 경우
		// this 생성자 호출가능
		// 같은 클래스 내에 있는 다른 생성자를 호출하는 구문
		// 단, 반드시 첫 줄에 기술해야됨
		this(userId, userPwd, userName);
		
		this.age = age;
		this.gender = gender;
		
	}
	
	// 메소드부
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	
	public String information() {
		return userId + " " + userPwd + " " 
				+ userName + " " + age + " " + gender;
	}
	
}
