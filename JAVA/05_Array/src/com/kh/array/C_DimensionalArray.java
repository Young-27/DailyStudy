package com.kh.array;

import java.util.Scanner;

public class C_DimensionalArray {
	
	// 이차원 배열 : 일차원 배열 여러개를 하나로 묶은 것이 2차원 배열
	
	public void method1() {
		// 일차원 배열 선언
		/*
		int[] arr1;
		int arr2[];
		*/
		
		/*
		 * 1. 	이차원 배열 선언
		 * 		자료형 배열명[][];
		 *		자료형[] 배열명[];
		 * 		자료형[][] 배열명;
		 */
		int arr1[][];
		int[] arr2[];
		int[][] arr3;
		
		/*
		 * 2.	이차원 배열 할당 (크기지정)
		 *		배열명 = new 자료형[행크기][열크기];
		 */
		arr3 = new int[2][3];
		
		// * 이차원 배열 선언과 동시에 할당
		int[][] arr = new int[3][5];
		
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[0][0]);
		
		System.out.println("행의 길이 : " + arr.length);
		
		// 각 행별 열의 길이를 알고자 한다면
		System.out.println("0행의 열의 길이 : " + arr[0].length);
		System.out.println("1행의 열의 길이 : " + arr[1].length);
		System.out.println("2행의 열의 길이 : " + arr[2].length);
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			
		}
		
	}
	
	public void method2() {
		
		int[][] arr = new int[3][5];
		
		// 값 대입용
		int value = 1;
		for(int i=0; i<arr.length; i++) { // 0행 ~ 마지막행
			
			for(int j=0; j<arr[i].length; j++) { // 0열 ~ 각 행별 마지막열
				arr[i][j] = value++;
			}
		}
		
		// 값 출력용
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				//System.out.print(arr[i][j] + " ");
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public void method3() {
		
		// 일차원 배열 선언 및 할당과 동시에 초기화
		int[] iArr = {1, 2, 3, 4, 5};
		
		// 이차원 배열 선언 및 할당과 동시에 초기화
		int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	public void method4() {
		
		/*
		 * *	가변배열
		 * 		행은 정해졌으나 각 행별 열의 개수가 정해지지 않은 상태
		 * 		이차원 배열 == 일차원 배열을 여러개 묶은 형태
		 * 		즉, 묶여있는 일차원 배열의 길이가 꼭 같을 필요는 없음!!
		 */
		int[][] arr = new int[3][]; // 가변배열 (행크기는 3행)
		
		/*
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		*/
		//arr[0][0] = 10;
		
		arr[0] = new int[2];
		arr[1] = new int[1];
		arr[2] = new int[3];
		
		/*
		 * 1 2
		 * 3
		 * 4 5 6
		 */
		int value = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = value++;
			}
			
		}
		
		// 출력
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	public void method5() {
		// char [][] 가변 배열 생성 후
		
		/*
		 * a b c
		 * d e
		 * f g h i
		 */
		/*
		char arr[][] = new char[3][];
		arr[0] = new char[3];
		arr[1] = new char[2];
		arr[2] = new char[4];
		
		char value = 'a';
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = value++;
			}
		}
		*/
		
		char[][] arr = {{'a','b','c'},{'d','e'},{'f','g','h','i'}};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void method6() {
		
		// 3행 3열짜리 String[][] 배열 생성 후
		String arr[][] = new String[3][3];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				//arr[i][j] = "(" + i + ", " + j + ")";
				//System.out.print(arr[i][j] + " ");
				System.out.print("(" + i + ", " + j + ")" + " ");
			}
			System.out.println();
		}
		
	}
	
	public void method7() {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[2][3];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				
				if(i == 0) {
					System.out.print("국어점수 : ");
				}else {
					System.out.print("영어점수 : ");
				}
				
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(i == 0) {
				System.out.print("국어점수 : ");
			}else {
				System.out.print("영어점수 : ");
			}
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	/*	숙제
	 * 	국어점수 : 70 80 100 총합계 : 250점
	 * 	영어점수 : 90 80 100 총합계 : 270점 
	 */
	
	public void method8() {
		Scanner sc = new Scanner(System.in);
		
		int arr[][] = new int[2][3];
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=0; j<arr[i].length; j++) {
				
				if(i==0) {
					System.out.print("국어점수 : ");					
				}else {
					System.out.print("영어점수 : ");								
				}
				arr[i][j] = sc.nextInt();
				if(i==0) {
					sum1 += arr[i][j];
				}else {
					sum2 += arr[i][j];								
				}
			}

		}
		
	
		
		for(int i=0; i<arr.length; i++) {
			if(i==0) {
				System.out.print("국어점수 : ");
			}else {
				System.out.print("영어점수 : ");
			}
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
				}
			
			if(i==0) {
				System.out.print("총 합계 : " + sum1);
				System.out.println();
			}else {
				System.out.print("총 합계 : " + sum2);
			}
			
			
			}
		}
		
	
	

}
