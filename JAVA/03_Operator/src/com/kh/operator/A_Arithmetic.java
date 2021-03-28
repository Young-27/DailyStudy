package com.kh.operator;

public class A_Arithmetic {
	
	// 산술연산자 (이항연산자)
	// * / %	>   + - (우선순위)
	
	public void method() {
		
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 x num2 = " + (num1 * num2)); // 괄호로 묶지 않아도 됨.
		System.out.println("num1 / num2 = " + (num1 / num2)); // 몫
		System.out.println("num1 % num2 = " + (num1 % num2)); // 나머지
		
		//System.out.println(10 / 0);
		// 0으로 나누려고 하는 순간 => ArithmeticException
		
		double a = 35;	// 35.0
		double b = 10;	// 10.0
		
		System.out.println(a / b);
		System.out.println(a % b);
		
	}
	
	
}
