package com.kh.hard;

import java.util.Scanner;

public class CompExample {
	
	public void method1() {
		// 사용자에게 한 개의 정수를 입력받고
		// 1부터 입력 받은 수까지 홀수/짝수를 나눠서
		// 홀수면 박, 짝수면 수 출력
		
		// 단, 입력받은 수가 양수가 아니면 "양수가 아닙니다" 출력
		
		// 예시 ) 4 입력시  -->  박수박수 출력
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) { // 입력받은 수가 양수일 경우 (잘 입력하였을 경우)
			
			for(int i = 1; i <= num; i++) { // 1부터 사용자가 입력한 수까지 반복실행
				
				if(i % 2 == 1) {	// 홀수일 경우
					System.out.print("박");
					
				} else {			// 짝수일 경우
					System.out.print("수");
					
				}
			}
			
		} else {	// 입력 받은 수가 양수가 아닐 경우 (잘 못 입력하였을 경우)
			
			System.out.println("양수가 아닙니다.");
		}
	}
	
	
	public void method2() {
		
		// 위의 method1에서 양수가 아닐 경우 다시 입력받도록 반복 수행
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) { // 우선 무한 반복으로 수행하고
			
			System.out.print("정수 : ");
			int num = sc.nextInt();
			
			if(num > 0) { // 입력받은 수가 양수일 경우 (잘 입력하였을 경우)
				
				for(int i = 1; i <= num; i++) { // 1부터 사용자가 입력한 수까지 반복실행
					
					if(i % 2 == 1) {	// 홀수일 경우
						System.out.print("박");
						
					} else {			// 짝수일 경우
						System.out.print("수");
						
					}
				}
				
				// 양수일 경우 제대로 출력되고 무한반복문을 빠져나가자
				break;
				
			} else {	// 입력 받은 수가 양수가 아닐 경우 (잘못 입력하였을 경우)
				
				System.out.println("양수가 아닙니다.");
				
				// 양수가 아닐 경우 다시 반복문의 처음으로 돌아가 정수를 입력받게 될거다.
			}
			
		}
	}
	
	
	public void method3() {
		
		// 문자열을 입력 받고 					(str)
		// 입력받은 문자열에서 검색하고 싶은 문자도 입력받는다.	(ch)
		
		// 문자열에 그 문자가 몇 개 있는지 개수 출력
		
		// 예시 ) banana, a 를 입력 받게 되면 3출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		System.out.print("찾고자 하는 문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int count = 0;		// 검색된 문자의 갯수를 담을 변수
		
		for(int i=0; i<str.length(); i++) { // 0부터 문자열의 길이-1 만큼 1씩 증가하는 동안 반복
			
			if(ch == str.charAt(i)) { // 입력받은 문자와 문자열의 각 인덱스 값이 같을 경우
				count++; // 동일한 문자라고 판단하여 count 1 증가
			}
			
		}
		
		System.out.println("포함된 갯수 : " + count);
		
	}
	
	
	

}
