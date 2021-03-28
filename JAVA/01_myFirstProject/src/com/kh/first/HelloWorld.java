package com.kh.first; //패키지 선언부 (이 클래스가 어떤 패키지에 속해있는지 나타냄)

// 한줄 주석 : 소스코드와는 무관한 (즉, 코드로 인식되지 않음) => 주로 코드에 대한 설명을 작성함

/*
 * 여러줄 주석 
 * 
 * 클래스 안에 여러개의 메소드를 작성할 수 있음
 * 메소드 == 기능
 * 
 * 단, 이 클래스 실행시 제일 먼저 찾아서 실행되는 메소드는 main메소드!!
 *  
 */

public class HelloWorld { // HelloWorld 클래스 영역 시작
	
	// 메인 메소드(프로그램 실행시 제일먼저 실행되는 메소드)
	public static void main(String[] args) {
		
		// 뭔가를 화면에 출력하고자 할때 출력문을 통해 작업 (print, println, printf)
		
		// System.out.println(출력하고자하는값); => 해당 값을 출력 한 후 "한줄띄워주는" 역할
		// ln은 line의 약자
		System.out.println("Hi Everyone!!");
		
		// System.out.print(출력하고자하는값); => 해당 값을 출력만 하고 끝 (한 줄 띄워주기X)
		System.out.print("안녕하세요\n");		
		System.out.print("여러분~!");
		// 줄바꿈(개행)을 의미하는 구문 == \n
		
	}

} // HelloWorld 클래스 영역 끝
