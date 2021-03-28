package com.kh.chap06_method.controller;

public class MethodTest2 {
	
	public static void method1() {
		System.out.println("매개변수와 반환값이 없는 메소드");
		
	}
	
	public static String method2() {		
		return "매개변수는 없지만 반환값은 있는 메소드";	
	}
	
	public static void method3(String name, int age) {
		
		// xx살의 xxx님 환영합니다.	출력
		System.out.println(age + "살의 " + name + "님 환영합니다.");
		
	}
	
	public static int method4(int num1, int num2, char op) {
		
		switch(op) {
		case '+': return num1+num2;
		case '-': return num1-num2;
		case '*':
		case 'x': return num1*num2;
		case '/': return num1/num2;
		
		}
		
		return -10000;
		
	}
	

}
