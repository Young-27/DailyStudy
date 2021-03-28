package com.kh.chap03.branch;

public class B_Continue {

	/*
	 *  continue;	: 반복문 안에서 사용하는 구문
	 *  			  continue를 만나게 되면 그 뒤에 어떤 구문이 있든간에 실행하지 않고
	 *  			     가장 가까운 반복문으로 올라가라는걸 의미
	 */
	
	public void method1() {
		
		// 1부터 10까지 홀수만을 출력
		// 1 3 5 7 9
		/* 방법1. 아싸리 i값을 매번 2씩 증가하는 방법
		for(int i=1; i<=10; i+=2) { // 5회 반복
			System.out.print(i + " ");
		}
		*/
		
		/* 방법2. 반복문 돌때마다 바로 출력하는게 아니라 홀수일 경우만 출력되도록
		for(int i=1; i<=10; i++) { // 10회 반복
			if(i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		*/
		
		for(int i=1; i<=10; i++) { // 10회 반복
			
			if(i % 2 == 0) { // 짝수일 경우
				continue;
			}
			
			System.out.print(i + " ");
		}	
		
	}
	
	public void method2() {
		
		// 1부터 100까지의 총 합계
		// 단, 6의 배수는 빼고 덧셈 연산
		
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			
			if(i % 6 == 0) {
				continue;
			}
			
			sum += i;
		}
		
		System.out.println("총 합계 : " + sum);
		
		
	}
	
	public void method3() {
		
		// 2단 ~ 9단 출력하긴 하되
		// 단, 4의 배수 단은 빼고 출력하시오.
		
		// 바깥쪽 for문 => 단을 지정 (2~9)
		// 안쪽 for문 => 매 단마다 반복적으로 곱해지는 수 (1~9)
		
		for(int i=2; i<=9; i++) {
			
			if(i % 4 == 0) {
				continue;
			}			
			System.out.println("== " + i + "단 ==");		
			for(int j=1; j<=9; j++) {			
				// o x o = o
				System.out.printf("%d x %d = %d\n",i,j,i*j);
			}
		}
		
	}
	
	
	
	
	
}
