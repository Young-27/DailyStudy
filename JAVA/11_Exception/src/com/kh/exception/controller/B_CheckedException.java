package com.kh.exception.controller;

import java.io.BufferedReader;  //io:인풋아웃풋
import java.io.IOException;
import java.io.InputStreamReader;

public class B_CheckedException {
	
	/*
	 * CheckedException은 반드시 예외처리를 해줘야 되는 예외들
	 * (즉, 얘네들은 예측불가한 곳에서 문제가 발생하기 때문에 미리 예외처리구문을 작성해둬야됨!! 필수)
	 * 주로 외부매체와 어떤 입출력시 발생!
	 * 
	 */
	
	public void method1() throws IOException {
		
		/*
		try {
			method2();
		}catch(IOException e) {
			
		}
		*/
		
		method2();
	}
	
	public void method2() throws IOException {
		
		// Scanner sc = new Scanner(System.in);
		
		// Scanner와 같이 키보드로 값을 입력받을 수 있는 객체 (단, 문자열로만 가능)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아무 문자열을 입력해주세요 : ");
		//String str = br.readLine(); // 이 메소드 호출시 IOException 발생할 수도 있음!! (컴파일에러로 알려줌 => 반드시 예외처리해둬야됨)
		
		// 1. try~catch문 : 여기서 바로 예외를 처리하겠다.
		/*
		try {
			String str = br.readLine();
			System.out.println("문자열의 길이 : " + str.length());
		}catch(IOException e) {
			System.out.println("예외발생됨");
		}
		*/
		
		// 2. throw : 지금 여기서 예외를 처리하지 않고 현재 이 메소드(method2)를 호출하는 곳으로 떠넘기겠다. (위임)
		String str = br.readLine();
		System.out.println("문자열의 길이 : " + str.length());
		
		
		System.out.println("안녕히가세요");
		
		//int num = Integer.parseInt(br.readLine());
		
		
	}
	
	/*
	 * 							예외발생시점		      예외처리
	 * RuntimeException		런타임 에러(컴파일에러x)		세모 		=> unchecked Exception(개발자 케바케로 해결 => 예외처리로 해결하거나 조건문으로 애초에 예외발생을 막거나)
	 * RuntimeException 그외		컴파일에러				필수		=>	 checked Exception(반드시 예외처리를 통해 해결)
	 * 
	 * 
	 */
	
	

}
