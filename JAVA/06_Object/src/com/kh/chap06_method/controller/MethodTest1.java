package com.kh.chap06_method.controller;

public class MethodTest1 {

	
	/*
	 * 	* 메소드
	 * 
	 * 	접근제한자  [예약어]  반환할값의자료형  메소드명([매개변수, 매개변수, ...]) {
	 * 
	 * 		수행할코드;
	 * 		수행할코드;
	 * 
	 * 		return 반환할값;
	 *	}
	 * 
	 */
	
	// 1. 매개변수 없고 반환값도 없는 메소드
	public void method1() {
	
		System.out.println("매개변수와 반환값이 둘 다 없는 메소드 입니다.");
		
		// 1부터 10까지의 총 합계 출력
		int sum = 0;
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("총 합계 : " + sum);
		
		//return; // 모든 메소드에 return이 있음. 다만, 반환값이 없는 void메소드는 JVM이 자동생성
		
	}
	
	// 2. 매개변수 없고 반환값은 있는 메소드
	public int method2() {
		System.out.println("매개변수 없고 반환값은 있는 메소드입니다.");
		
		// 1에서부터 100사이의 랜덤값 발생시켜서 돌려주는 메소드
		//int random = (int)(Math.random() * 100 + 1);
		//return random;
		return (int)(Math.random() * 100 + 1);
	}
	
	// 3. 매개변수 있고 반환값은 없는 메소드
	public void method3(int num1, int num2) {
		
		System.out.println("매개변수 있고 반환값은 없는 메소드입니다.");
		
		// 최소값 : xx
		// 최대값 : xx
		int min = 0; // 두 수 중 작은 값 보관할 변수
		int max = 0; // 두 수 중 큰 값 보관할 변수
		if(num1 > num2) {
			min = num2;
			max = num1;
			
		}else {
			min = num1;
			max = num2;
		}
		
		System.out.println("최소값 : " + min + "\n최대값 : " + max);
	}
	
	// 4. 매개변수도 있고 반환값도 있는 메소드
	public int method4(int a, int b) {
		System.out.println("매개변수 있고 반환값도 있는 메소드입니다.");
		return a * b; 
	}
	
	
	
}
