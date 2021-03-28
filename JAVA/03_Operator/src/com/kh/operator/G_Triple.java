package com.kh.operator;

import java.util.Scanner;

public class G_Triple {

	/*
	 *  * 삼항연산자 : 3개의 항목을 가지고 연산하는 연산자
	 *  
	 *  [표현법]
	 *  조건식 ? 조건식이 true일 경우의 결과값 : 조건식이 false일 경우의 결과값
	 */
	public void method1() {
		
		// 사용자가 입력한 정수값이 양수인지 아닌지 판별 후 그에 맞는 결과 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("정수값 입력 : ");
		int num = sc.nextInt();
		
		/*
		String result = (num > 0) ? "양수입니다" : "양수가 아닙니다";			
		// xx은(는) xxxxxx		
		System.out.println(num + "은(는) " + result);
		*/
		
		// xx은(는) xxxxxx
		System.out.println(num + "은(는) " + (num > 0 ? "양수입니다" : "양수가 아닙니다"));
		System.out.println(num + "은(는) " + (num <=0 ? "양수가 아닙니다" : "양수입니다"));
	}
	
	
	public void method2() {
		
		// 사용자가 입력한 정수값이 짝수인지 홀수인지 판별 후 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력: ");
		int num = sc.nextInt();
		
		//String result = (num % 2 == 0 ? "짝수입니다" : "홀수입니다");
		String result = (num % 2 == 1 ? "홀수입니다" : "짝수입니다");
		
		// xx은(는) xxxxxx
		System.out.printf("%d은(는) %s", num, result);
		
		
	}
	
	public void method3() {
		
		// 사용자가 입력한 영문자가 대문자인지 아닌지 판별 후 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영문자 한 문자 입력 : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch >= 'A' && ch <= 'Z' ? "대문자이다" : "대문자가 아니다"); 
		//아스키코드표 참고. 알파벳마다 고유의 숫자가 있어서 대소 가능
		
		// x은(는) xxxxxx
		System.out.println(ch + "은(는) " + result);
		
	}
	
	// 삼항 연산자 중첩 사용
	public void method4() {
		// 사용자가 입력한 정수값이 양수인지, 음수인지, 0인지 정확히 판별 후 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		
		String result = (num > 0 ? "양수이다" : (num == 0 ? "0이다" : "음수이다"));
		
		System.out.println(result);
		
		
	}
	
	public void method5() {
		
		// 두 개의 정수값과 + 또는 -의 문자를 하나 입력받아
		// + 일 경우 두 정수값의 덧셈연산한 결과,
		// - 일 경우 두 정수값의 뺄셈연산한 결과,
		// 둘 다 아닐 경우 "잘못입력했습니다" 결과
		
		Scanner sc = new Scanner(System.in);
		System.out.print("연산자 입력(+ or -) : ");
		char op = sc.nextLine().charAt(0);
		
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
								    // 13 => "13"
		String result = (op == '+' ? num1+num2+"" : (op == '-' ? num1-num2+"" : "잘못입력했습니다"));
		// 뒤에 문자열때문에 int라고는 못하니까 각 숫자를 문자열로 바꿔주고 앞에 String을 붙여 주었다.
		
		System.out.println(result);
		
	}
	
}
