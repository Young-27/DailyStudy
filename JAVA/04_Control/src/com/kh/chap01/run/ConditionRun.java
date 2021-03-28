package com.kh.chap01.run;
import com.kh.chap01.condition.*;
public class ConditionRun {
	
	/*
	 *  프로그램은 기본적으로 위에서부터 아래로 순차적으로 진행됨
	 *  하지만 이 순차적인 흐름을 바꾸고자 할 때 "제어문"이라는 걸 통해서 직접 제어 가능
	 *  
	 *  선택적으로 실행하는 선택문 => 조건문 (if문, if-else문, if-else if문, switch문)
	 *  반복적으로 실행하는 실행문 => 반복문 (for문, while문, do-while문)
	 *  그 외의 흐름을 제어하는 구문 => 분기문 (break문, continue문)
	 *  
	 *  * 조건문 *
	 *  조건식을 통해서 참이냐 거짓이냐를 판단해서 해당 조건이 참일 경우 그에 해당하는 구문 실행 가능
	 *  
	 *  => 조건식의 결과가 true/false  논리값이 나올 수 있도록 제시해야됨
	 *  => 보통 조건식에서는 비교연산자(대소, 동등), 논리연산자(&&,||) 주로 사용
	 *  
	 *  조건문은 크게 if문과 switch문으로 나뉨
	 *  1. if문
	 *    - 단독 if문
	 *    - if-else문
	 *    - if-else if문
	 *  2. switch문
	 * 
	 */
	
	public static void main(String[] args) {
		
		A_If a = new A_If();
		//a.method1();
		//a.method2();
		//a.method3();
		//a.method4();
		
		B_Else b = new B_Else();
		//b.method1();
		//b.method2();
		//b.method3();
		//b.method4();
		//b.method5();
		
		C_Switch c = new C_Switch();
		//c.method1();
		//c.method2();
		//c.method3();
		//c.method4();
		//c.method5();
		
	}
	


}
