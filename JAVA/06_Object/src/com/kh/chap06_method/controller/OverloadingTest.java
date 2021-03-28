package com.kh.chap06_method.controller;

public class OverloadingTest {

	// 오버로딩 : 같은 클래스 내에 같은 메소드명으로 정의하는것
	
	public void test() {
		
	}
	/*
	public void test() {
		
	}
	*/
	
	public void test(int a) {
		
	}
	
	public void test(int a, String s) {
		
	}
	
	public void test(String s, int a) {
		
	}
	
	public void test(int a, int b) {
		
	}
	
	/*
	public void test(int c, int d) {
	
	}
	*/
	// 매개변수명이랑은 상관없이 자료형의 개수와 순서가 다르게 작성되어야함
	
	/*
	public double test(int c, int d) {
		
	}
	*/
	// 반환형이 다르다고 오버로딩이 적용되지 않는다. (결국은 매개변수의 자료형이 동일하기 때문)
	
	/*
	private void test(int c, int d) {
		
	}
	*/
	// 접근제한자가 다르다고 오버로딩이 적용되지 않는다.
	
	/*
	 * 	* 결론
	 * 	오버로딩 성립조건
	 * 	접근제한자, 반환형을 다 떠나서 매개변수의 "자료형"과 "개수", "순서"가 다르게 작성되어야 함.
	 * 
	 */
	
}
