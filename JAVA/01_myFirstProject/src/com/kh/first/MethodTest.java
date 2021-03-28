package com.kh.first;

/*
 *  ** 원칙 ** (지키지 않아도 오류는 나지 않지만, 하나의 약속과 같음)
 *  1. 클래스명 => 대문자로 시작
 *  2. 패키지명 => 소문자로 시작
 *  3. 메소드명 => 소문자로 시작
 *  4. 변수명    => 소문자로 시작
 *  
 *  > 공통적으로 지켜줘야할 원칙 (낙타표기법 == CamelCase)
 *    여러개의 단어를 조합해서 이름을 지을 때는 각 단어 앞 문자는 대문자로!
 *    
 *    ex) 클래스명 Methodtest => MethodTest
 *        메소드명 testprint  => testPrint
 *    
 */

public class MethodTest { // com.kh.first.MethodTest

	/*
	 * 한 클래스 내에 여러개의 메소드(기능)를 정의 해 둘 수 있음.
	 * 무조건 메인 메소드를 포함할 필요도 없음.
	 */
	
	
	//메인메소드가 아닌 메소드는 호출해야만 실행. 메인메소드는 자동으로 실행.
	public void testPrintA() {
		// 이 메소드가 호출되는 순간 실행될 내용
		System.out.println("첫번째 메소드 실행");
		testPrintB(); // 같은 클래스 내에 있는 메소드 호출시 바로 메소드명();
		testPrintC();
	}
	
	public void testPrintB() {
		System.out.println("두번째 메소드 실행");
	}
	
	public void testPrintC() {
		System.out.println("세번째 메소드 실행");
		//testPrintA();
	}
	
	
}
