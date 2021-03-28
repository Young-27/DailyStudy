package com.kh.chap01.condition;

import java.util.Scanner;

public class C_Switch {
	
	/*
	 *  * switch문과 if문의 차이점
	 *  
	 *  if(조건식)	 => 조건식 복잡하게도 기술가능, 범위 제시 가능
	 *  switch 조건식x => 확실한 값의 조건만 기술 (동등비교같이 수행)
	 *  
	 *  * 표현식
	 *  
	 *  switch(앞으로동등비교할대상자) {
	 *  case 값1 : 실행코드1; break;
	 *  case 값2 : 실행코드2; break;
	 *  ....
	 *  default:위의 모든 값들이 다 일치하지 않을 경우 실행코드; [break;]
	 *  }
	 * 
	 * 
	 */
	public void method1() {
		
		// 1~3 사이의 정수값을 입력받아
		// 1인 경우 "빨간불입니다" 출력
		// 2인 경우 "파란불입니다" 출력
		// 3인 경우 "초록불입니다" 출력
		// 잘못입력했을 경우 "잘못입력했습니다" 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수(1~3) : ");
		int num = sc.nextInt();
		
		/*
		if(num == 1) {
			
		}else if(num == 2) {
			
		}else if(num == 3) {
			
		}else {
		*/
		
        /*
		switch(num) {
		case 1 : 
			System.out.println("빨간불입니다."); 
			break;
		case 2 : 
			System.out.println("파란불입니다."); 
			break;
		case 3 : 
			System.out.println("초록불입니다."); 
			break;
		default: System.out.println("잘못입력했습니다.");
		}
		*/
		
		String result = ""; // 결과값을 담아둘 변수
		
		switch(num) {
		case 1 : result = "빨간불"; break;
		case 2 : result = "파란불"; break;
		case 3 : result = "초록불"; break;
		default: System.out.println("잘못 입력했습니다."); return;
		}
		
		// return; => return구문을 만나는 순간 뭐가됐든 간에 현재 이 메소드 자체를 빠져나감
		
		System.out.println(result + "입니다.");
	}
	
	public void method2() {
		
		System.out.println("Welcome 보람쓰 과일가게");
		
		// 사용자에게 구매할 과일명(사과, 바나나, 복숭아)을 입력받아
		// 각 과일마다의 가격을 출력 (사과 1000원, 바나나2000원, 복숭아5000원)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매할 과일(사과, 바나나, 복숭아) 입력 : ");
		String fruit = sc.nextLine();
		
		int price = 0; // 가격을 기록해둘 변수
		switch(fruit) {
		case "사과": price = 1000; break;				//fruit.equals("사과")
		case "바나나": price = 2000; break;			//fruit.equals("바나나")
		case "복숭아": price = 5000; break;
		default: System.out.println("저희 가게에서 판매하는 과일이 아닙니다. 빠이"); return;
		}
	
		// xx의 가격은 xxxx원입니다.
		System.out.printf("%s의 가격은 %d원입니다.", fruit, price);
	}
	
	public void method3() {
		
		System.out.println("Welcome 보람쓰 과일가게");
		
		// 사용자에게 구매할 과일명(사과, 바나나, 복숭아)을 입력받아
		// 각 과일마다의 가격을 출력 (사과 1000원, 바나나1000원, 복숭아5000원)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매할 과일(사과, 바나나, 복숭아) 입력 : ");
		String fruit = sc.nextLine();
		
		int price = 0; // 가격을 기록해둘 변수
		switch(fruit) {
		case "사과": 				
		case "바나나": price = 1000; break;
		case "복숭아": price = 5000; break;
		default: System.out.println("저희 가게에서 판매하는 과일이 아닙니다. 빠이"); return;
		}
	
		// xx의 가격은 xxxx원입니다.
		System.out.printf("%s의 가격은 %d원입니다.", fruit, price);
	}
	
	public void method4() {
		
		// 사용자에게 주민번호 입력 받은 후 성별자리에 해당하는 문자 뽑기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호(-포함) : ");
		char ch = sc.nextLine().charAt(7); // '1' '2' '3' '4'
		
		switch(ch) {
		case '1': 
		case '3': System.out.println("남자"); break;
		case '2':
		case '4': System.out.println("여자"); break;
		default: System.out.println("잘못된 주민번호를 입력했습니다.");
		}
		
	}
	
	public void method5() {
		
		// 사용자에게 1월~12월 사이의 월을 입력받아 (int month)
		Scanner sc = new Scanner(System.in);
		System.out.print("1월~ 12월 중 하나를 입력하세요(정수) : ");		
		int month = sc.nextInt();
		
		// 1, 3, 5, 7, 8, 10, 12 => "해당 달은 31일까지입니다" 출력
		// 4, 6, 9, 11 => "해당 달은 30일까지입니다" 출력
		// 2 => "해당 달은 28일 또는 29일까지입니다" 출력
		// 그외 => "반드시 1월 ~ 12월까지를 입력해야됩니다" 출력
		
		switch(month) {
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: System.out.println("해당 달은 31일까지입니다"); break;
		case 4:
		case 6:
		case 9:
		case 11: System.out.println("해당 달은 30일까지입니다"); break;
		case 2: System.out.println("해당 달은 28일 또는 29일까지입니다"); break;
		default: System.out.println("반드시 1월 ~ 12월까지를 입력해야됩니다");
		}
		
		
		
	}
}
