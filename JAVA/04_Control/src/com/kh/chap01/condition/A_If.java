package com.kh.chap01.condition;

import java.util.Scanner;

public class A_If {
	
	/*
	 *  * 단독 if문
	 *  
	 *  if(조건식) {
	 *  	 조건식이 true일 때만 실행할 코드
	 *  }
	 *  
	 *  => 조건식의 결과가 참(true)일 경우 중괄호 블럭안의 코드가 실행
	 *  => 조건식의 결과가 거짓(false)일 경우 중괄호 안의 코드 무시하고 넘어감
	 *  
	 */
	
	public void method1() {
		// 연산자 실습문제 1, 2 : 사용자에게 정수값 입력받은 후 "양수다" "0이다" "음수다" 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수다");
		}
		
		/*
		if(num <= 0) {
			System.out.println("양수가 아니다");
		}
		*/
		
		if(num == 0) {
		System.out.println("0이다");
		}
		
		if(num < 0) {
		System.out.println("음수다");
		}
	}
	
	public void method2() {
		
		// 연산자 실습문제3. 사용자가 입력한 정수값이 짝수인지 홀수인지 판별 후 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		/*
		if(num > 0 && num % 2 == 0) {
			System.out.println("짝수다");
		}
		
		if(num > 0 && num % 2 != 0) {
			System.out.println("홀수다");
		}
		*/
		
		if(num > 0) { // 중첩 if문
			
			if(num % 2 == 0) {
				System.out.println("짝수다");
			}
			
			if(num % 2 !=0) {
				System.out.println("홀수다");
			}
			
		}
		
	}

	public void method3() {
		
		// 연산자 실습문제 6. 사용자가 입력한 나이값을 가지고 어린이/청소년/성인 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// 어린이(13세 이하), 청소년(13세 초과 ~ 19세 이하), 성인(19세 초과)
		
		String result = ""; // 조건에 맞춰서 결과를 담아줄 변수 만들어두기
							// 지역변수 셋팅해두고자 할 때 반드시 초기화 해두는 습관!
		
		if (age >= 0 && age <= 13) {
			result = "어린이";
		}
		
		if (age > 13 && age <= 19) {
			result = "청소년";
		}
		
		if (age > 19) {
			result = "성인";
		}
		
		System.out.println(result);
		
	}
	
	public void method4() {
		// 연산자 실습문제 8. 사용자에게 입력받은 주민번호를 가지고 남자/여자 판별 후 출력
		
		// 1. 사용자에게 주민번호 입력받기 (String personId)		=>951009-2415647
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 입력(-포함) : ");
		String personId = sc.nextLine();
		//char ch = sc.nextLine().charAt(7);
		
		// 2. 입력받은 주민번호로부터 성별에 해당하는 문자(7번인덱스) 하나만을 뽑아놓기 (char ch) => '2'
		char ch = personId.charAt(7); // '1', '2', '3', '4'
		
		// 3_1. ch 문자가 '1' 또는 '3' 일 경우 => 남자 출력 
		if (ch == '1' || ch == '3') {
			System.out.println("남자");
		}
		
		// 3_2. ch 문자가 '2' 또는 '4' 일 경우 => 여자 출력
		if(ch == '2' || ch == '4') {
			System.out.println("여자");
		}
		
		// 3_3. ch 문자가 '1', '2', '3', '4' 모두 아닐 경우
		if(ch != '1' && ch != '2' && ch != '3' && ch != '4') {
			System.out.println("잘못된 주민번호를 입력하였습니다.");
		}	
	}
	
	
	
}
