package com.kh.first;

public class ValuePrint {
	
	// 일반메소드 : public void 메소드명() {}
	
	// 다양한 종류의 값들을 출력해주는 메소드
	public void printValue() {
		
		// 1. 숫자 출력 => 따옴표 없이
		System.out.println(123); 	// 정수값 출력
		System.out.println(1.23);	// 실수값 출력
		
		// 2. 문자(한글자) 출력 => 홑따옴표 이용
		System.out.println('a'); 
		System.out.println('강');
		
		// 3. 문자열(여러글자) 출력 => 쌍따옴표 이용
		System.out.println("\"안녕\"하세요");
		System.out.println("반갑\t습니다");
		
		// 4. 산술연산한 결과 출력
		System.out.println(123 + 456);
		System.out.println(100 - 200);
		
		// 5. 문자열("")과 그 외의 값들의 덧셈연산 => 문자열화 됨(하나의 문자열로 연이어짐)
		System.out.println("하이" + 'a'); //"하이a"
		System.out.println("안녕" + 123); //"안녕123"
		System.out.println("반갑" + 111 + 222); //"반갑111" + 222 => "반갑111222"
		
	}
	
	
	// 문자열과 숫자간의 덧셈 연산 결과 출력하는 메소드
	public void sumStringNumber() {
		
		System.out.println(9 + 9); 		//18
		System.out.println("9" + 9);	//"99"
		System.out.println(9 + "9"); 	//"99"
		System.out.println("9" + "9");  //"99"
	
		System.out.println(9 + 9 + "9");   // 18 + "9" => "189"
		System.out.println(9 + "9" + 9);   // "99" + 9 => "999"
		System.out.println("9" + 9 + 9);   // "99" + 9 => "999"
		
		System.out.println("9" + (9 + 9));  //"9" + 18 => "918"
		
		// 연산에도 순서가 존재함!
		
		// 산술연산 (+, -, *, /, %)
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
