package com.kh.operator;

import java.util.Scanner;

public class F_Logical {

	/*
	 *   * 논리 연산자
	 *   - 두 개의 논리 값을 연산하는 연산자
	 *   - 논리값 (논리연산자) 논리값			=> 논리값
	 *   
	 *   논리값 && 논리값 : 왼쪽, 오른쪽 둘 다 true여야만 최종 연산결과 true
	 *   논리값 || 논리값 : 왼쪽, 오른쪽 중 하나라도 true면 최종 연산결과 true
	 */
	
	public void method1() {
		
		// 사용자가 입력한 정수값이 양수 "이면서(이고)" 짝수인지 확인하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 한 개 입력 : ");
		int num = sc.nextInt();
		
		boolean result = (num > 0) && (num % 2 == 0);
		// && 의미 : 그리고, ~이고, ~이면서
		
		System.out.println("사용자가 입력한 값이 양수이면서 짝수입니까 : " + result);
		
		//System.out.println("사용자가 입력한 값이 양수이면서 짝수입니까 : " + ((num > 0) && (num % 2 == 0)));
		
		
	}
	
	public void method2() {
		
		// 사용자가 입력한 정수값이 1이상 100이하의 수인지 확인하기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 한 개 입력 : ");
		int num = sc.nextInt();
		
		// 사용자가 입력한 정수값이 1보다 크거나 같고 "그리고" 100보다 작거나 같습니까?
		//boolean result = (1 <= num <= 100);
		boolean result = (num >= 1) && (num <= 100);
		//				  1 <= num
		
		System.out.println("사용자가 입력한 값이 1이상이면서 100이하입니까 : " + result);
		
		System.out.println("사용자가 입력한 값이 1이상이면서 100이하입니까 : " + ((num >= 1) && (num <= 100)));
		
		/*
		 *  && (and) : 그리고, ~이면서, ~이고, 뿐만 아니라
		 *  
		 *  두 개의 조건 모두 true여야 &&연산의 결과값이 최종적으로 true
		 *  둘 중 하나라도 false일 경우 최종적인 결과값은 false!
		 *  
		 */		
	}
	
	public void method3() {
		
		// 사용자가 입력한 값이 y "이거나 " Y인지 확인하기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계속하시려면 y 또는 Y를 입력하세요 : ");
		char ch = sc.nextLine().charAt(0);
		
		boolean result = (ch == 'y') || (ch == 'Y');
		// || : 또는, ~이거나
		
		System.out.println("사용자가 입력한 값이 y 또는 Y입니까 : " + result);
		
		/*
		 * || (or) : 또는, ~이거나
		 * 
		 * 두 개의 조건 중 하나라도 true일 경우 최종 결과값은 true
		 * 두 개의 조건 모두 false일 경우 최종 결과값은 false
		 */		
		
	}
	
	/*
	 * && : 두 개의 조건이 모두 true여야 결과값이 true이다. (AND)
	 * 
	 * true && true		=> true
	 * true && false	=> false
	 * false && true	=> false
	 * false && false	=> false
	 * 
	 * => && 연산자를 기준으로 앞쪽 결과가 false가 나온다면 뒤의 조건은 굳이 연산하지 않음!
	 * 
	 * -------------------------------------------------------------
	 * 
	 * || : 두 개의 조건 중 하나라도 true면 결과값이 true이다. (OR)
	 * 
	 * true || true		=> true
	 * true || false	=> true
	 * false || true	=> true
	 * false || false	=> false
	 * 
	 * => || 연산자를 기준으로 앞쪽 결과가 true가 나온다면 뒤의 조건은 굳이 연산하지 않음!
	 */
	
	public void method4() {
		
		int num1 = 10;
		
		boolean result1 = false && (++num1 > 0);
		
		System.out.println("result1 : " + result1);
		System.out.println("&& 연산 후 num1 : " + num1); // 10
		
		int num2 = 10;
		
		boolean result2 = true || (++num2 > 0);
		
		System.out.println("|| 연산 후 num2 : " + num2); // 11
		
	}
	
	
}
