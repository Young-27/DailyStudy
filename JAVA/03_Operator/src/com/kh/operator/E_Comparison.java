package com.kh.operator;

import java.util.Scanner;

public class E_Comparison {
	
	/*
	 *  * 비교연산자 (관계연산자)
	 *  - 두 개의 값을 가지고 비교
	 *  - 비교연산한 결과가 참일 경우 => true	/ 거짓일 경우 => false
	 *    => 후에 조건문에서 쓰일 예정
	 *    
	 *  a < b	: a가 b보다 작습니까?
	 *  a > b	: a가 b보다 큽니까?
	 *  a <= b	: a가 b보다 작거나 같습니까?
	 *  a >= b	: a가 b보다 크거나 같습니까?
	 *  
	 *  a == b	: a랑 b가 일치합니까? 같습니까?
	 *  a != b	: a랑 b가 일치하지 않습니까? 같지 않습니까?
	 * 
	 */

	public void method1() {
		
		int a = 10;
		int b = 25;
		
		System.out.println("a > b : " + (a > b));
		System.out.println("a < b : " + (a <= b));
		
		boolean result1 = (a == b);
		boolean result2 = (a != b);
		
		System.out.println("result1 : " + result1);
		System.out.println("resutl2 : " + result2);
		
		// 산술연산 + 비교연산
		System.out.println(a - b < 0);
		
		// 어떤 값을 2로 나눴을때의 나머지 값이 0이냐 1이냐를 가지고 짝수인지 홀수인지 판별 가능
		System.out.println("a가 짝수입니까 : " + (a % 2 == 0));
		System.out.println("b가 홀수입니까 : " + (b % 2 == 1));
		
	}
	
	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 한 개 입력 : ");
		int num = sc.nextInt();
		
		System.out.println("사용자가 입력한 값은 양수입니까 : " + (num > 0));
		
		System.out.println("사용자가 입력한 값은 짝수입니까 : " + (num % 2 == 0));
		
		//System.out.println(1 <= num <= 10);
		
	}
}
