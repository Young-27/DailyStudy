package com.kh.chap02.loop;

import java.util.Scanner;

public class A_For {
	
	/*
	 *  * for문
	 *  
	 *  for(초기식; 조건식; 증감식) {
	 *  	반복적으로 실행시키고자 하는 코드;
	 *  }
	 *  
	 *  - 초기식 : 반복문이 시작될때 "초기에 단 한번만 실행되는 구문"
	 *  		 (반복문에서 사용할 변수를 선언 및 초기화 구문) ex) int i=0;
	 *  
	 *  - 조건식 : "반복문이 수행될 조건"을 작성하는 구문
	 *  		조건식이 true일 경우 반복문 실행
	 *  		조건식이 false가 되는 순간 반복문 멈추고 빠져나옴
	 *  		(보통 초기식에 제시된 변수를 가지고 조건식을 작성함) ex) i<10;
	 *  - 증감식 : 반복문을 제어하는 변수 값을 증감시키는 구문
	 *  		(보통 초기식에 제시된 변수를 가지고 증감식을 작성함) ex) i++
	 *  
	 *  for문을 만나는 순간
	 *  초기식  --> 조건식 검사 --> true일 경우 코드 실행 --> 증감식
	 *  	 --> 조건식 검사 --> true일 경우 코드 실행 --> 증감식
	 *  	 --> 다시 조건식 --> true일 경우 코드 실행 --> 증감식
	 *  	 -----------------이 내용이 계속 반복-----------
	 *  	 --> 다시 조건식 --> false일 경우 코드 실행x ------>반복문 빠져나옴
	 *  
	 */
	
	public void method1() {
		// "안녕하세요"를 5번 반복해서 출력하고싶다
		/*
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		*/
		
		for(int i=1; i<=5 ;i++) { // i값이 1에서부터 5보다 작거나 같을때까지 1씩 증가할 동안 반복 수행
								  // 1 2 3 4 5 (5회)
			System.out.println("안녕하세요");
		}
		
		for(int i=1; i<6; i++) { //i값이 1에서부터 5까지 매번 1씩 증가하는 동안 반복수행
								 //1 2 3 4 5 (5회)
			System.out.println("반갑습니다");
		}
		
		for(int i=11; i<16;i++) { // i값이 11에서부터 15까지 매번 1씩 증가하는 동안 반복수행
							      // 11 12 13 14 15
			System.out.println("다시만나요");
		}
		
		// int i=10; i<=14; i++		=> 10 11 12 13 14
		
		
		// 제일 단순하게 반복되는 횟수를 지정하는 표현법
		// int i=0; i<반복시키고자하는횟수; i++
		
		// int i=0; i<5; i++	0 1 2 3 4 (5회)
		// int i=0; i<7; i++    0 1 2 3 4 5 6 (7회)
		
		
	}
	
	public void method2() {
		
		// i값이 1에서부터 10까지 매번 2씩 증가할 동안 반복 수행
		// 1 3 5 7 9
		for(int i=1; i<=10; i+=2) {
			System.out.println("하이");
		}
		
		// 10 9 8 7 6 (5회)
		for(int i=10;i>=6;i--) {
			System.out.println("헬로우");			
		}
		
	}
	
	public void method3() {
		// 1 2 3 4 5 6 7 8 9 10 (10회)
		for(int i=1; i<11 ; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\n안녕");
	}
	
	public void method4() {
		
		// 1 2 3 4 5 6 7 8 9 10 출력
		for(int i=0; i<10; i++) { // 0 1 2 3 4 5 6 7 8 9 (10회)
			System.out.print(i + 1 +" ");
		}
		 
	}
	
	public void method5() {
		// 5 4 3 2 1
		for(int i=5; i>0; i--) {
			System.out.print(i + " ");
		}
	}
	
	public void method6() {
		
		// 1 2 3 4 5 ~~~~~~~~ 98 99 100
		/*
		for(int i=1; i<=100; i++) {
			System.out.print(i + " ");
		}
		*/
		
		// 1에서부터 사용자가 입력한 수까지 매번 1씩 증가되는 값 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양수 : ");
		int num = sc.nextInt();
		
		if(num > 0) { // 잘 입력했을 경우 => 1에서부터 사용자가 입력한 수까지 매번 1씩 증가되는 값 출력
			
			// 1 2 3 ... num
			for(int i=1; i<=num ; i++) {
				System.out.print(i + " ");
			}
			
		}else { // 잘못 입력했을 경우
			System.out.println("양수만을 입력해야됩니다. 잘못입력하셨습니다.");
			
		}
		
	}
	
	public void method7() {
		// 1에서 10까지 매번 1씩 증가되는 값들의 총 합계
		//int sum = 1+2+3+4+5+6+7+8+9+10;
		
		/*
		 * int sum = 0;
		 * 
		 * sum += 1;		// sum = 1
		 * sum += 2;		// sum = 3
		 * sum += 3;
		 * ...
		 * sum += 9;
		 * sum += 10;
		 * 
		 */
		int sum = 0;
		
		for(int i=1; i<=100; i++){
			sum += i;
		}
		
		System.out.println("1부터 100까지의 총 합계 : " + sum);
		
	}
	
	public void method8() {
		
		// 1에서부터 사용자가 입력한 수까지의 총 합계
		Scanner sc = new Scanner(System.in);
		System.out.print("양수 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		if (num>0) { // 잘 입력했을 경우 => 총 합계 구해주기
			for(int i=1; i<=num; i++) {
				sum += i;			
			}
			
			// 1에서부터 xx까지의 총 합계 : xxx
			System.out.println("1에서부터 " + num + "까지의 총 합계 : " + sum);
		
		}else {	// 잘못 입력했을경우
			System.out.println("잘못입력했습니다.");
		}
		
	}
	
	public void method9() {
		
		// 1에서부터 매번 달라지는 랜덤값(1~10사이의 랜덤한 정수) 까지의 총 합계
		
		/*
		 * Math 클래스에서 정의되어있는 random() 메소드를 호출해서 매번 다른 랜덤값을 얻어올 수 있음!
		 * 0.0 ~ 0.99999999999.. 사이의 랜덤값 발생
		 * 0.00 <= 랜덤값  < 1.0
		 */
		//Math m = new Math();
		//m.random();
		
		//int random = Math.random();  // double형이라서 오류
					 // 0.0 <=  < 1.0		=> 0.0 ~ 0.99999999
		
		//int random = Math.random() * 10;
					 // 0.0 <=   < 10.0		=> 0.0 ~ 9.9999999
		
		//int random = Math.random() * 10 + 1;
					 // 1.0 <=   < 11.0		=> 1.0 ~ 10.999999
		
		int random = (int)(Math.random() * 10 + 1);
					 // 1 <=	< 11		=> 1 ~ 10
		
					 // 11 ~ 20 까지 랜덤값	 11 12 13 14 15 16 17 18 19 20
					 // (int)(Math.random() * 몇개의랜덤값 + 시작수)
		
		System.out.println("현재 발생된 랜덤값 : " + random);
		
		int sum = 0;
		for (int i=1; i<=random; i++) {
			sum += i;
		}
		
		// 1에서부터 x까지의 총 합계 : xx
		System.out.println("1에서부터" + random + "까지의 총 합계 : " + sum);
		
		
	}
	
	public void method10() {
		
		/*
		 *  사용자에게 문자열을 입력받아서
		 *  각 인덱스별 문자를 매번 추출해서 출력
		 *  
		 *  예를 들어서 "apple" 일 경우
		 *  String str = "apple";
		 *  
		 *  a --> str.charAt(0) 출력
		 *  p --> str.charAt(1) 출력
		 *  p --> str.charAt(2) 출력
		 *  l --> str.charAt(3) 출력
		 *  e --> str.charAt(4) 출력
		 *  
		 *  apple 길이 : 5	strawberry 길이 : 10	kiwi 길이 : 4
		 *  01234			0123456789			0123
		 *  
		 *  마지막 인덱스 수 == 문자열의길이 -1 == 문자열.length()-1
		 *  
		 *  0번 인덱스에서부터 마지막 인덱스까지 매번 1씩 증가하는 동안 반복 수행
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
		System.out.println("문자열의 길이 : " + str.length());
		
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
	}
	
	public void method11() {
		
		// 구구단 중 2단 출력
		/*
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * ....
		 * 2 x 9 = 18
		 * 
		 */
		
		System.out.println("=== 2 단 ===");
		
		for(int su=1; su<=9; su++) {
			System.out.printf("%d x %d = %d\n", 2, su, 2*su);
		}
		
		
	}
	
	public void method12() {
	
		// 구구단 1~9단 출력
		// method11을 모두 복붙하면 비효율적
		for(int dan=2; dan<=9; dan++) {
			
			System.out.println("=== " + dan + "단 ===");		
			for(int su=1; su<=9; su++) {
				System.out.printf("%d x %d = %d\n", dan, su, dan*su);
			}
		}
		
	}
	
	public void method13() {
		
		// 1 2 3 4 5
		// 1 2 3 4 5
		// 1 2 3 4 5
		
		for(int i=0; i<3; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}
	
	public void method14() {
		
		// ***** 	1행 1열 ~ 5열
		// ***** 	2행 1열 ~ 5열
		// ***** 	3행 1열 ~ 5열
		
		for(int i=1; i<=3; i++) { // 바깥쪽 for문 행 (1행 ~ 3행)
			
			for(int j=1; j<=5; j++) { // 안쪽 for문 열(1열 ~ 5열)
				System.out.print("*");
			}
			System.out.println();
		}
	
	}
	
	public void method15() {
		
		// 0시 0분 ~ 23시 59분 까지 출력

		/*
		 * 시간 0시 ~ 23시 1씩 증가		=> 바깥쪽 for문
		 * 분    0시 ~ 59분 1씩 증가		=> 안쪽 for문
		 */
		
		for(int hour=0; hour<24; hour++) {
			
			for(int min=0; min<60; min++) {
				System.out.println(hour + "시" + min + "분");
			}
			System.out.println();
		}
	}

}
