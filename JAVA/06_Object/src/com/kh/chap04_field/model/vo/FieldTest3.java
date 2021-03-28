package com.kh.chap04_field.model.vo;

// 클래스변수(static변수)와 상수필드(static final)에 대해
public class FieldTest3 {

	// 접근제한자 [예약어] 자료형 변수명;
	
	public static String sta = "static변수";
	
	// 생성시점 : 프로그램 실행과 동시에 메모리 영역(static영역)에 할당됨 (굳이 이 객체 생성안해도!)
	// 소멸시점 : 프로그램 종료시 소멸됨
	
	// static "공유"의 개념이 강함!! => 프로그램 실행과 동시에 메모리영역에 박스 만들어두고 공유해서 사용
	
	/*
	 * 	* 상수필드
	 * 	public static final 자료형 변수명 = 값;
	 * 	public final static 자료형 변수명 = 값;
	 * 
	 * 	예약어 순서 상관 없음!
	 * 
	 * 	static - 공유의 개념 (재사용)
	 * 	final  - 한번 지정된 값 변경 x (상수)
	 * 
	 * 	값이 변경되어서는 안되는 고정적인 값을 메모리상에 올려두고 (프로그램 실행과 동시에)
	 * 	공유하면서 사용할 목적!
	 * 
	 */
	public static final int NUM = 10;
	
	
	
	
	public static void test() {
		System.out.println("안녕");
	}
	
}
