package com.kh.chap02_encapsulation.model.vo;

public class Student {

	// 필드부
	/*
	 *  필드 == 멤버변수 == 인스턴스변수
	 * 
	 *  접근제한자[예약어] 자료형 필드명;
	 */
	private String name;
	
	private int age;
	private double height;
	
	// 생성자부
	
	// 메소드부
	/*
	 * 각 기능을 구현하는 부분
	 * 
	 * 접근제한자 반환형(void) 메소드명([매개변수]) {
	 * 		// 기능 구현
	 * }
	 */

	// 데이터를 기록 및  수정하는 기능의 메소드 (setter메소드)
	// 이 때 이 메소드는 접근 가능하도록 해야되기 때문에 public 접근제한자를 사용
	
	// 이름값을 기록 및 수정할 수 있는 기능의 메소드 (name 필드값에 대입시키는 용도)
	public void setName(String newName) {
		// 매개변수 : 해당 이 메소드 호출시 전달되는 값을
		//			받아주기 위한 변수 선언문 (이 메소드에서만 사용가능)
		name = newName;
	}
	
	// 나이값을 기록 및 수정할 수 있는 기능의 메소드 (age필드값에 대입시키는 용도)
	public void setAge(int newAge) {
		age = newAge;
	}
	
	// 키값을 기록 및 수정할 수 있는 기능의 메소드 (height필드값에 대입시키는 용도)
	public void setHeight(double height) { // 매개변수(지역변수)
		height = height; // 매개변수의 height = 매개변수의 height;
		// 특정 영역({})안에서는 해당 영역 안에 있는 지역변수가 우선권이 있음
		
		// 우리가 원하는건 => 필드의 height = 매개변수의 height;
		this.height = height;
	}
	
	// 데이터를 반환해주는 기능의 메소드 (getter메소드)
	
	// name필드에 담긴값 돌려주는 용도의 메소드
	public String getName() {
		
		return name;
		// return 결과값;
	}
	
	// age필드에 담긴값 반환해주는 용도의 메소드
	public int getAge() {
		return age;
	}
	
	// height필드에 담긴값 반환해주는 용도의 메소드
	public double getHeight() {
		return height;
	}
	
	// 
	public String information() {
		//return name, age, height; // 결과값은 반드시 한 개 밖에 안됨!
		
		return name + "님의 나이는 " + age + "살이고, 키는 " + height + "cm입니다.";
		
	}
	
	
	
}
