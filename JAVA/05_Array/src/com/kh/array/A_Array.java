package com.kh.array;

import java.util.Scanner;

public class A_Array {
	
	/*
	 *  * 변수 : "자료형의 값 하나만"을 담을 수 있는 개념
	 *  		ex) int a = 10;
	 *  			a = 20;
	 *  
	 *  * 배열 : "자료형의 값 여러개"를 담을 수 있는 개념
	 *  		ex) int[] a = new int[3];
	 *  			a[0] = 5;
	 *  			a[1] = 10;
	 *  			a[2] = 15;
	 */
	
	public void method1() {
		
		// * 배열을 왜 써야될까?
		
		/*
		// 변수만을 가지고 프로그래밍을 하게되면..
		// 0, 1, 2, 3, 4 기록해야됨
		int num1 = 0;
		int num2 = 1;
		int num3 = 2;
		int num4 = 3;
		int num5 = 4;
		
		// 출력할때는? => 일일이 출력해야됨... 반복문 X
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);		
		
		// 총합계
		int sum = num1 + num2 + num3 + num4 + num5;
		*/
		
		// 배열을 가지고 프로그래밍 하기
		// 0, 1, 2, 3, 4 기록해야됨
		
		/*
		 *  1. 배열 선언
		 *     자료형 배열명[];
		 *     자료형[] 배열명;
		 */
		//int a; // 변수 선언
		
		//int arr[];
		//int[] arr;
		
		/*
		 *  2. 배열 할당 (몇 개의 값들을 보관할건지 크기지정하는 과정 == 그 개수만큼 방이 만들어짐)
		 *     배열명 = new 자료형[배열크기];
		 */
		//arr = new int[5];
		
		// * 배열 선언과 동시에 할당
		int[] arr = new int[5];
		
		/*
		 *  3. 배열의 각 인덱스 자리에 값 대입
		 *     배열명[인덱스] = 값; 
		 */
		/*
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		*/
		
		// 배열의 가장 큰 장점 : 반복문을 활용할 수 있음!!
		for(int i=0; i<5; i++) {
			arr[i] = i;			
		}
		
		
		for(int i=0; i<5; i++) {
		System.out.println(arr[i]);
		}
		
		//System.out.println(arr);
	}
	
	public void method2() {
		
		int i = 10;
		int [] iArr = new int[5];
		
		System.out.println("i : " + i);
		System.out.println("iArr : " + iArr);
		System.out.println("iArr의 해쉬코드값 : " + iArr.hashCode());
		
		double[] dArr = new double[3];
		System.out.println("dArr : " + dArr);
		System.out.println("dArr의 해쉬코드값 : " + dArr.hashCode());
		
		/*
		 *  기본자료형 (boolean, char, byte, short, int, long, float, double)으로 선언한 변수
		 *  => 실제 값을 바로 담을 수 있는 변수 => 일반 변수
		 *  
		 *  그 외 자료형(int[], double[], char[], short[], ..., String, Scanner, ...)으로 선언된 변수
		 *  => 주소 값을 담고 있는 변수 => 참조변수(레퍼런스변수)
		 */
		
	}
	
	public void method3() {
		
		int[] iArr = new int[3]; // 0번 1번 2번
		double[] dArr = new double[3]; // 0번 1번 2번
		
		// 마지막 인덱스 == 배열의 크기 - 1 == 배열.length-1
		
		// 배열의 크기를 알아낼 수 있는 방법
		System.out.println("iArr배열의 크기 : " + iArr.length);
		System.out.println("dArr배열의 크기 : " + dArr.length);
	 
		for(int i=0; i<iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		
		for(int i=0; i<dArr.length; i++) {
			System.out.println(dArr[i]);
		}
		
		
		/*
		 * 각각의 인덱스에 값을 대입하지 않아도 뭔가 담겨있음!
		 * 왜? Heap에는 절대 빈 공간이 존재할 수 없음!
		 * => JVM이 기본값으로 초기화를 진행해줌!
		 */
		
		//int a;
		
	}
	
	public void method4() {
		
		int[] arr = new int[5];
		
		/*
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;	
		//arr[10] = 10;
		*/
		
		// 값 대입용 for문
		for(int i=0; i<arr.length; i++) {
			arr[i] = i + 1;
		}
		
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			
			System.out.print(arr[i] + " ");
			sum += arr[i];
			
		}
		
		System.out.println("\n총 합계 : " + sum);
		
		System.out.println(arr);
		System.out.println(arr.hashCode()); // 해쉬코드 == 주소값의 10진수형태
		
		
	}
	
	public void method5() {
		
		int[] arr = new int[10];
		
		// 0번인덱스 ~ 마지막인덱스까지 51~100사이의 랜덤값
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 50 + 51);
		}
		
		// arr[x] : xx
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d] : %s\n", i, arr[i]);
		}
		
		
	}
	
	public void method6() {
		
		// 배열 선언과 할당
		//int[] arr;
		//arr = new int[5];
		int[] arr =  new int[5]; // 한 번에 가능
		
		System.out.println(arr);
		System.out.println("arr의 해쉬코드값 : " + arr.hashCode());
		
		/*
		arr[0] = 2;
		arr[1] = 4;
		arr[2] = 6;
		arr[3] = 8;
		arr[4] = 10;
		*/
		
		int value = 2;
		for(int i=0; i<arr.length; i++) {
			arr[i] = value;
			value += 2;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		/*
		arr[5] = 12;
		arr[6] = 14;
		*/
		
		/*
		 *  * 배열의 가장 큰 단점
		 *  - 한 번 지정한 배열의 크기는 변경 불가
		 *    => 배열의 크기를 변경하고자 한다면 어쩔 수 없이 새로운 배열을
		 *    	 다시 만들어줘야함
		 * 
		 */
		
		arr = new int[7];
		
		System.out.println("=== arr 변경 후 ===");
		System.out.println(arr);
		System.out.println("arr의 해쉬코드값 : " + arr.hashCode());
		
		/*
		 *  기존에 참조하고 있던 연결이 끊기고 새로운 곳 참조
		 *  => 연결이 끊어진 기존 배열은 Heap 영역에 둥둥떠다님
		 *  => 일정 시간이 지나면 "가비지 컬렉터(GC)"가 지워줌
		 *  	(자동메모리 관리)
		 */
		
		// 현재 연결되어있는 고리를 끊고자 한다면?
		arr = null; // null : 아무것도 존재하지 않음을 의미
		
		System.out.println(arr);
		
		
		/*
		int a = 0;
		double d = 0.0;
		char c = ' ';
		
		int[] iArr = null;
		double[] dArr = null;
		Scanner sc = null;
		String str = null;
		*/		
		
	}
	
	public void method7() {
		
		// 3명의 사용자에게 매번 키의 정보를 입력받아 배열에 담아두고
		Scanner sc = new Scanner(System.in);
		
		double[] heights = new double[3];
		
		for(int i=0; i<heights.length; i++) {
			
			System.out.print("키 입력(cm) : ");
			heights[i] = sc.nextDouble();	
		}
		
		//3명의 키 정보 출력
		double sum = 0.0;
		for(int i=0; i<heights.length; i++) {
			System.out.println(heights[i]);
			sum += heights[i];
		}
		
		// 3명의 키 총합계, 평균 출력
		System.out.println("세명의 키의 총 합계 : " + sum);
		//System.out.println("세명의 키의 평균 : " + sum / heights.length);
		System.out.printf("세명의 키의 평균 : %.1f", sum / heights.length);
		
		// 10 + 30 + 50 + 70	=> 160
		// 160 / 4	=> 40
		
	}
	
	public void method8() {
		
		// 사용자에게 문자열 하나를 입력받은 후 각각의 문자들을 char배열에 옮겨 담기
		
		// 1. 사용자에게 문자열 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 하나 입력 : ");
		String str = sc.nextLine();
		
		// 2. char배열 생성해두기 (배열 크기 == 문자열의 길이만큼)
		char[] arr = new char[str.length()];
		
		// 3. 문자열에서 각 인덱스별 문자를 뽑아서 char배열의 각 인덱스에 담기
		/*
		 * arr[0] = str.charAt(0);
		 * arr[1] = str.charAt(1);
		 * ....
		 */
		for(int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		
		// 4. char배열의 각 인덱스에 잘 담겨있는지 출력해보기
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void method9() {
		
		// 배열 선언과 동시에 할당 (크기 지정)
		int[] arr = new int[4];
		// 각 인덱스에 값 초기화 (대입)
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		
		
		// 배열 선언 및 할당과 동시에 초기화(대입) 한큐에 끝내기
		int[] arr1 = new int[] {1, 2, 3, 4}; // 첫번째 방법
		int[] arr2 = {1, 2, 3, 4}; // 두번째 방법
		
		System.out.println(arr1 == arr2); // 담겨있는 값이 아닌, 주소값 간의 동등비교이기 때문에 false 나옴.
		
		
	}
	
	public void method10() {
		
		//String[] fruits = {"딸기", "귤", "자두"};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("좋아하는 과일 개수 : ");
		//int size = sc.nextInt();	
		//String[] fruits = new String[size]; // size == friut.length
		String[] fruits = new String[sc.nextInt()]; //2줄을 1줄로.
		
		sc.nextLine();
		
		for(int i=0; i<fruits.length; i++) {
			System.out.print("좋아하는 과일명 입력 : ");
			fruits[i] = sc.nextLine();
		}
		
		for(int i=0; i<fruits.length; i++) {
			System.out.println(fruits[i]);
		}
		
	}
	
	
	
}
