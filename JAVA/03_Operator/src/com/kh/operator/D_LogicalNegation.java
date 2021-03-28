package com.kh.operator;

public class D_LogicalNegation {
	
	/*
	 *  * 논리부정연산자 (!) 
	 * 	  !논리값	 =>  논리값
	 * 
	 * 	     논리값(true/false)을 반대로 바꿔주는 연산자
	 */

	public void method() {
		System.out.println("true의 부정 : " + !true);
		System.out.println("false의 부정 : " + !false);
		
		boolean b = true;
		boolean b2 = !b;
		
		System.out.println(b2);
		
	}
	
	
}
