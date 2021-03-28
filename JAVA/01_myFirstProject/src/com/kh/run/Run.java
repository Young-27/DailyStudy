package com.kh.run;

//import문. 선언문.
import com.kh.first.MethodTest; // 해당 패키지에 있는 클래스를 그냥 쓰겠다 라고 선언한 구문. 


public class Run {
	
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		/*
		 * 미리 정의해둔 메소드를 호출 해주면 됨!
		 * 다른 클래스에 있는 메소드를 호출하고자 할 때?
		 */
		// 1) 호출할 메소드가 존재하는 클래스를 생성(new)해라.
		//    [표현법] 클래스명 대변할이름 = new 클래스명();
		//MethodTest mt = new MethodTest();
		// => 기본적으로 현재 같은 패키지 내에 다음과 같은 클래스를 찾는데,
		//	     다른 패키지에 존재하는 클래스이기 때문에 찾을 수가 없는 것임.
		
		// 해결방법1. 해당 클래스가 정확히 어떤 패키지에 있는 클래스인지 명시하는 방법(풀클래스명)
		//com.kh.first.MethodTest mt = new com.kh.first.MethodTest();
		
		// 해결방법2. 그냥 클래스명만을 가지고 작성하되 단, 이 클래스가 어떤 패키지에 속해있는지 선언문(import) 추가
		MethodTest mt = new MethodTest();
		
		
		// 2) 생성 후 이제 해당 클래스에 있는 메소드 호출(실행)
		//   [표현법] 대변할이름.호출하고자하는메소드명();
		/*
		mt.testPrintA();	
		mt.testPrintB();		
		mt.testPrintC();
		*/
		mt.testPrintA();
		
	}

}
