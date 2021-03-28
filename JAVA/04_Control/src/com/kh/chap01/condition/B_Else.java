package com.kh.chap01.condition;

import java.util.Scanner;

public class B_Else {

	/*
	 *  * if-else 문
	 *  
	 *  if(조건식){
	 *  	실행할 코드1
	 *  }else {
	 *  	실행할 코드2
	 *  }
	 *  
	 *  조건식의 결과가 true 일 경우 실행코드1 수행 후 if-else문 자체를 빠져나감
	 *  단, 조건식의 결과가 false일 경우 무조건 실행코드2 수행 후 빠져나감
	 *  
	 *  
	 *  * if-else if문
	 *  동일한 비교대상을 가지고 여러개의 조건을 제시해 두고자 할 때
	 *  
	 *  if(조건식1){
	 *  	실행 코드1;
	 *  
	 *  }else if(조건식2){
	 *  	실행 코드2;
	 *  
	 *  }else if(조건식3){
	 *  	실행 코드3;
	 *  } [else { 			// =>생략가능
	 *  	위의 조건들이 다 false일 경우 반드시 실행코드; 
	 *  }]
	 *  
	 */
	
	public void method1() {
		
		// 사용자가 입력한 정수값이 짝수/홀수 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if (num > 0) {
			
			if(num % 2 == 0) {
				System.out.println("짝수다");
			}else {
				System.out.println("홀수다");
			}
		
		}else {
			System.out.println("양수를 입력해야만 해 임마");
		}
		
	}
	
	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수다");
		}else if(num == 0){
			System.out.println("0이다");
		}else {
			System.out.println("음수다");
		}
		
	}
	
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		if(age < 0) { // 음수로 입력했을 경우 => 잘못 입력했을 경우
			System.out.println("잘못 입력했습니다.");
		} else { // 0이상으로 입력했을 경우 => 잘 입력했을 경우 => 어린이/청소년/성인
			
			if(age <= 13) {
				System.out.println("어린이");
			}else if(age <= 19) {
				System.out.println("청소년");
			}else {
				System.out.println("성인");
			}
				
		}
			
	}
	
	public void method4() {
		
		// 사용자에게 점수 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		// 90점 이상일 경우 "A등급" 출력
		// 90점 미만 80점 이상일 경우 "B등급" 출력
		// 80점 미만 70점 이상일 경우 "C등급" 출력
		// 70점 미만일 경우 "D등급" 출력
		
		String grade = ""; 
		// else 안에 변수의 값이 존재하므로 초기화 안해도됨. (변수에 반드시 값이 들어가므로)
		// 하지만 초기화 습관 들이기.
		
		if(score >= 90) {
			grade = "A등급";
		}else if(score >= 80) {
			grade = "B등급";
		}else if(score >= 70 ) {
			grade = "C등급";
		}else {
			grade = "D등급";
		}
		
		//다른방법
//		if(score < 70) {
//			grade = "D등급";
//		}else {
//			
//			if(score < 80) {
//				grade = "C등급";
//			}else if(score < 90) {
//		}
		
		// 당신의 점수는 xx점이고, 등급은 xxx입니다.
		System.out.println("당신의 점수는 " + score + "점이고, 등급은 " + grade + "입니다.");
			
	}
	
	public void method5() {
		
		// 사용자에게 이름을 입력받은 후
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입장하기 위해서 이름을 입력해 주세요 : ");
		String name = sc.nextLine();
		
		
		// 그 이름이 "이선영" 문자열과 일치할 경우 => "본인입니다" 출력
		// 				 그게 아닐 경우          => "본인이 아닙니다. 돌아가주세요" 출력
		/*
		if(name == "이선영") {
			System.out.println("본인입니다. 어서오세요.");
		}else {
			System.out.println("본인이 아닙니다. 돌아가주세요.");
		}
		*/

		// 기본자료형(boolean, char, byte, short, int, long, float, double)들끼리
		// 동등비교시 == 또는 != 으로 잘 비교됨!!
		
		// String(참조자료형)임!! => 동등비교하고자 할때 == 제대로 안먹힘!
		// 문자열.equals(문자열) 메소드 이용!!
		
		if(name.equals("이선영")) { 
			System.out.println("본인입니다. 어서오세요.");
		}else {
			System.out.println("본인이 아닙니다. 돌아가주세요");
		}
		
		// 일치하지 않을 경우와 같은 != 내용은
		// !문자열.equals(문자열)
	}
	
	
}
