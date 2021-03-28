package com.kh.operator;

public class B_InDecrease {
	
	/*
	 * * 증감연산자 (단항연산자) ++
	 * ++ : 값을 1증가시키는 연산자
	 *		++값(전위증가)	값++(후위증가)
	 *
	 * -- : 값을 1감소시키는 연산자
	 * 		--값(전위감소)	값--(후위감소)
	 * 
	 * 	(증감연산자)값  : 전위 연산  --> 선증감 후처리
	 * 	값(증감연산자) : 후위 연산  --> 선처리 후증감
	 */
	
	public void method1() {
		int num = 10;
		System.out.println("num : " + num);
		
		num++; // num = num + 1;
		
		System.out.println("변경된 num : " + num);
		
		
	}
	
	public void method2() {
		
		// 전위 연산
		int a = 10;
		int b = ++a; 	// a 1증가 => 대입
		
		System.out.println("a : " + a + ", b : " + b);
		
		// 후위 연산
		int c = 10;
		int d = c++;	 // 대입 = > c 1증가
		
		System.out.println("c : " + c + ", d : " + d);
				
	}
	
	public void method3() {
		int num1 = 20;
		int result1 = num1++ * 3; // 20(21) => 60
								  // num1 = 21 	  result = 60
		
		System.out.println("num1 : " + num1);
		System.out.println("result1 : " + result1);
		
		
		int num2 = 20;
		int result2 = ++num2 * 3; // 21 * 3 => 63
		
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);
		
		int num = 20;
		
		System.out.println("현재 num : " + num);	// num = 20
		System.out.println("++num : " + ++num);	// num = 21 	=> 21출력
		System.out.println("num++ : " + num++); // num = 21(22) => 21출력
												// num = 22
		
		System.out.println("--num : " + --num); // num = 21		=> 21출력
		System.out.println("num-- : " + num--); // num = 21(20) => 21출력
												// num = 20
		
		System.out.println("최종 num : " + num);  // num = 20
			
	}
	
	public void method4() {
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++);					// a=10(11)					=> 10 출력
		System.out.println((++a) + (b++));			// a=12 + b=20(21) 			=> 32 출력
		System.out.println((a++) + (--b) + (--c));	// a=12(13) + b=20 + c=29 	=> 61 출력
		
		System.out.println("a : " + a); // a : 13
		System.out.println("b : " + b); // b : 20
		System.out.println("c : " + c); // c : 29
		
		
	}
	
	
	

}
