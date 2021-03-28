package com.kh.array.practice.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {
		
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
		
	}
	
	
	public void practice2() {
		
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = 10-i;
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
			
		int[] arr = new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice4() {
		
		String[] arr = new String[5];
	
		arr[0] = "사과";
		arr[1] = "귤";
		arr[2] = "포도";
		arr[3] = "복숭아";
		arr[4] = "참외";
		
		System.out.println(arr[1]);
		
		}
		
	public void practice5() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		// 사용자가 입력한 문자열(str)을 char[] 배열에 담기
		char[] arr = str.toCharArray();
		
		// 특정문자가 char[]배열에 일치하는 게 몇개인지 개수 센 후 출력
		int count = 0; // 매번 일치하는 것을 찾는 순간 1씩 증가시킬 변수
		for(int i=0; i<arr.length; i++) {
			if(ch == arr[i]) { // 사용자가 입력한 문자와 해당 배열의 각 인덱스에 담긴 문자가 일치할 경우
				count++;	
			}
		}
		
		// x 개수 : xx	결과 출력
		System.out.println(ch + " 개수 : " + count);
		
		
		/* 내 소듕한 풀이..
		char[] arr = new char[str.length()];
		
		int sum = 0;
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
			if(arr[i]==ch) {
				sum += 1;
				
			}				
		}
		System.out.println(ch + " 개수 : " + sum);
		 */
	}
	
	
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		String[] day = new String[7];
		
		day[0] = "월요일";
		day[1] = "화요일";
		day[2] = "수요일";
		day[3] = "목요일";
		day[4] = "금요일";
		day[5] = "토요일";
		day[6] = "일요일";
		
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num>=0 && num<=6) {
			System.out.println(day[num]);
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		int sum = 0;
		for(int i=0; i<num; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			int a = sc.nextInt();
			sc.nextLine();
			arr[i] = a;
			
			sum += arr[i];
		}
		
		for(int i=0; i<num; i++) {
			
			if(i==num-1) {
				System.out.println(arr[i]);
			}else {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println("총 합 : " + sum);
			
		
	}
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.print("정수 : ");
			int num = sc.nextInt();
		
			if(num>=3 && num%2==1) {
				// 사용자가 입력한 정수 크기만큼의 배열 만들기
				int[] arr =  new int[num];
				
				// 배열에 값 넣기
				/*
				 * 배열의 크기 : 3
				 * 1 2 1				중간인덱스 : 1 == 3/2
				 * 
				 * 배열의 크기: 5
				 * 1 2 3 2 1			중간인덱스 : 2 == 5/2
				 * 
				 * 배열의 크기: 7
				 * 1 2 3 4 3 2 1		중간인덱스 : 3 == 7/2
				 * 
				 * 어떤 배열이든 중간인덱스 : 배열의크기/2
				 */
				
				int value = 1;
				for(int i=0; i<arr.length; i++) {
					if(i < arr.length/2) {
						arr[i] = value++;
					}else {					
						arr[i] = value--;
						
						}
					}
				// 배열에 담긴 값 출력
				for(int i=0; i<arr.length; i++) {				
					if(i == arr.length-1) {
						System.out.print(arr[i]);
					}else {
						System.out.print(arr[i] + ", ");
					}					
				}
				
				break;
			}else {
				System.out.println("다시 입력하세요.");
				continue;
			}
		}
			
	}
	
	
	public void practice9() {
		/*
		String[] arr = new String[3];
		arr[0] = "양념";
		arr[1] = "후라이드";
		arr[2] = "간장";
		*/
		String[] chickens = {"후라이드", "양념", "파닭", "치즈"};
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("치킨 이름을 입력하세요 : ");
		String menu = sc.nextLine();
		
		int count = 0; // 일치하는 메뉴를 찾았을 경우 1증가
	
		for(int i=0; i<chickens.length; i++) { // 사용자가 입력한 메뉴와 동일한 메뉴를 찾았을 경우
			if(menu.equals(chickens[i])) {
				count++;
				break;
			}
		}
		
		// 탐색이 다 끝나고 나서
		if(count > 0) {
			System.out.println(menu + "치킨 배달 가능");
		}else {
			System.out.println(menu + "치킨은 없는 메뉴입니다.");
		}
		
	}
	
	public void practice10() {
		
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		// 출력
		System.out.print(Arrays.toString(arr)); // [x, x, x, x, ..]
		
	}
	
	public void practice11() {
		// 1. 사용자에게 주민등록번호 문자열 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.nextLine();
		
		// 2. char[] 옮겨 담기 => 원본 배열
		char[] origin = str.toCharArray();
		
		// 3. 복사본 char[]에 옮겨 담기
		char[] copy = new char[origin.length];
		/*
		copy[0~7] = origin[0~7];
		copy[8~마지막] = '*';
		*/
		for(int i=0; i<copy.length; i++) {
			
			if(i<=7) {
				copy[i] = origin[i];
			}else {
				copy[i] = '*';
			}
		}
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i]);
		}
	}

}
