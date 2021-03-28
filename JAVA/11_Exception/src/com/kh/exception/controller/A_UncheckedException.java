package com.kh.exception.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A_UncheckedException {

	/*
	 * 	* RuntimeException
	 * 	- 프로그램 실행 시 발생되는 예외들
	 * 
	 * 	* RuntimeException의 후손들
	 * 	- ArrayIndexOutOfBoundsException : 배열에 부적절한 인덱스로 접근할 때 발생되는 예외
	 * 	- NegativeArraySizeException : 배열의 크기를 음수로 지정하면 발생되는 예외
	 * 	- ClassCastException : 허용할 수 없는 형변환이 진행될 경우 발생되는 예외
	 * 	- NullPointerException : 레퍼런스가 아직 null임에도 불구하고 접근하려고 할 때 발생되는 예외
	 * 	- ArithmeticException : 나누기 연산시 0으로 나눌 때 발생되는 예외
	 * 	- ....
	 * 
	 * 	=> 이런 RuntimeException과 관련한 애들은 충분히 예측가능한 상황이기 때문에
	 * 		아싸리 예외 자체가 발생이 안되게끔 조건문으로 해결 가능하긴 함!!
	 * 		굳이 예외처리(예외가 "발생"했을 때 실행할 내용을 정의해두는거)할 필요없음!
	 * 
	 * 
	 * 
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		
		// ArithmeticException : 나누기 연산에서 0으로 나눌경우 발생되는 예외
		
		// 사용자에게 두개의 정수값을 입력받아 나눗셈 연산 결과 출력
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 정수(0 제외) : ");
		int num2 = sc.nextInt();
		
		//System.out.println("나눗셈 연산 결과 : " + num1 / num2);
		
		// 해결방법1. 조건문으로 처리 (애초에 예외자체가 발생될일 없게 if문으로 조건검사 후에 진행 ) => 예외처리
		/*
		if (num2 != 0) {
			System.out.println("나눗셈 연산 결과 : " + num1 / num2);
		}else {
			System.out.println("0으로는 나눌 수 없습니다.");
		}
		*/
		
		// 해결방법2. 예외처리구문으로 해결(예외처리 == 예외가 발생하는 때를 대비해서 실행할 내용을 정의해두는거)
		/*
		 * 	* try~catch문 표현법
		 * 
		 * try {
		 * 		예외가 발생될법한 구문;
		 * }catch(발생될예외클래스 변수명){
		 * 		해당 예외가 발생될 경우 실행할 구문;
		 * }
		 * 
		 */
		try {
			System.out.println("나눗셈 연산 결과 : " + num1 / num2);
		}catch(ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
			//e.printStackTrace(); // 오류를 추적할 때 사용
		}
		
		
		System.out.println("안녕히가세요");
		
	}
	
	public void method2() {
		
		System.out.print("정수(0제외) 입력 : ");
		
		try {
			
			int num = sc.nextInt(); // InputMismatchException			
			System.out.println("나눗셈 연산 결과 : " + 10 / num); // ArithmeticException 
			
		}catch(InputMismatchException e) { // java.util 메소드에 존재하므로 import해야함
			System.out.println("정수로 제대로 입력해야 됩니다.");
		}catch(ArithmeticException e) { // -> java.lang-> import X
			System.out.println("0으로 나눌 수 없습니다.");
		}
		// 다중 catch블럭 가능함!!
		
		
		System.out.println("프로그램을 종료합니다.");
		
		
	}
	
	
	public void method3() {
		
		
		// NegativeArraySizeException : 배열의 크기를 음수로 지정했을때 발생되는 예외
		// ArrayIndexOutOfBoundsException : 배열에 부적절한 인덱스로 접근했을 때 발생되는 예외
		
		System.out.print("배열의 크기 : ");
		
		int size = sc.nextInt();
		
		/*
		if(size > 0) {
			int[] arr = new int[size];
		}
		*/
		
		/*
		try {			
			int[] arr = new int[size];
			System.out.println("100번 인덱스 값 : " + arr[100]);			
		}catch(NegativeArraySizeException e){
			System.out.println("배열의 크기로는 음수를 제시할 수 없습니다.");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("부적절한 인덱스로 접근했습니다.");
		}
		*/
		
		try {			
			int[] arr = new int[size];
			System.out.println("100번 인덱스 값 : " + arr[100]);			
		}catch(RuntimeException e){ // 다형성 적용해서 부모타입예외클래스 작성 가능
			System.out.println("예외가 발생하긴했어.. 배열의 크기를 음수로 입력했거나 부적절한 인덱스로 접근했어"); // 어느 오류든 catch가 발생하기 때문에 오류를 확실하게 알려주지 못함.
		}//catch(NegativeArraySizeException e) { // 빨간줄 => Unreachable catch block !! => 도달x (catch런타임예외만 실행 후 빠져나감)
												// 런타임예외 윗줄에 쓰는것은 가능!!
		
		// 만일 자식예외클래스와 부모예외클래스를 동시에 기술하고자 한다면
		// 자식예외클래스가 부모예외클래스의 catch 블럭보다 위에 있어야 함!!
		
		
		System.out.println("프로그램을 종료합니다.");
	
	}
	
	/*
	 * 	* RuntimeException 관련된 예외는
	 * 	  > 조건문으로 해결가능 => 애초에 예외 자체가 발생이 안되게끔 개발자가 소스코드로 핸들링하는것 (예외처리x)
	 * 	  > 예외처리구문으로 해결가능 => 예외가 발생했을 때를 대비해서 그 때 실행할 내용을 정의해두는 것!
	 * 
	 * 		예측 가능한 경우 => 조건문으로 해결
	 * 		예츨 불가능한 경우 => 예외처리 구문으로 해결
	 * 
	 * 		RuntimeException 계열은 충분히 예측 가능한 상황이 대부분!! => 조건문으로 해결하는걸 권장!
	 * 		=> 예외처리구문을 작성해도 그만 안해도 그만 (필수는 아님!!) => "UnCheckedException"
	 * 
	 */
	
	

}
