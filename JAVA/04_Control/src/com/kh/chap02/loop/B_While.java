package com.kh.chap02.loop;

import java.util.Scanner;

public class B_While {
	
	/*
	 *  * while문
	 *  
	 *  [초기식;]
	 *  while(조건식) {
	 *  	반복적으로 실행할 내용
	 *  	[증감식;]
	 *  }
	 *  
	 *  
	 */
	public void method1() {
		
		/*
		for(int i=0; i<5; i++) {
			System.out.println("안녕하세요");
		}
		System.out.println(i);
		*/
		
		int i = 0;
		while(i < 5) {
			System.out.println("안녕하세요");
			i++;
		}
		System.out.println(i); // 5
		
		// 5 4 3 2 1
		while(i >= 1) {
			System.out.print(i-- + " "); // 후위감소
			//i--;
		}
				
	}
	
	public void method2() {
		
		// 1에서 10까지의 총 합계
		/*
		int sum = 0;
		for(int i=1; i<11; i++) {
			sum += i;
		}
		*/
		
		int sum = 0;
		
		int i = 1;
		while(i < 11) {
			sum += i;
			i++;
		}
		
		System.out.println("총 합계 : " + sum);
	}
	
	public void method3() {
		
		// 1부터 랜덤값(1~100사이의)까지의 총 합계
		int random = (int)(Math.random() * 100 + 1);
		
		int sum = 0;
		
		int i = 1;
		while(i <= random) {
			
			sum += i++;
			
		}
		
		/* 5 4 3 2 1
		 * while(random > 0) { 
		 * 		sum += random--;
		 * }
		 */
		System.out.println("1부터 " + random + "까지의 총 합계 : " + sum);
	}

	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 안녕하세요 5번 출력");
			System.out.println("2. 1부터 10까지의 총 합계");
			System.out.println("3. 1부터 랜덤값까지의 총 합계");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 0: System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다."); return;
			default: System.out.println("잘못된 메뉴를 입력했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	/*
	 *  * do-while문
	 *  
	 *  do {
	 *  	반복적으로 실행할 코드
	 *  }while(조건식);
	 *  
	 *  while문과 do-while문의 차이점은
	 *  while문은 처음 수행할때도 조건 검사 후 true여야 실행
	 *  단, do-while문은 첫 실행은 별도의 조건 검사 없이 무조건 한번 실행
	 *  
	 */
	
	public void method5() {
		// 애초에 조건이 맞지 않아도 반드시 한 번은 수행
		int num = 1;
		
		do {
			System.out.println("안녕");
		}while(num == 0);
	}
	
	public void method6() {
		// 1 2 3 4 5
		
		int i = 1;
		
		do {
			System.out.print(i++ + " ");
		}while(i <= 5);
	}
	
	
	
	
	
	
	
}
