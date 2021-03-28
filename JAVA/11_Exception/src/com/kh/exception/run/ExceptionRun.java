package com.kh.exception.run;

import java.io.IOException;

import com.kh.exception.controller.A_UncheckedException;
import com.kh.exception.controller.B_CheckedException;

public class ExceptionRun {

	public static void main(String[] args) throws IOException { //메인메소드에 throws하면 JVM이 알아서 처리
		
		/*
		 * 	* 에러(오류) 종류
		 * 	- 시스템 에러 : 컴퓨터의 오작동으로 발생하는 에러 --> 소스코드로 해결안됨 (심각한에러)
		 * 	- 컴파일 에러 : 소스코드상의 문법적인 문제로 발생하는 에러 (빨간줄로 애초에 오류 알려줌) => 소스코드 수정으로 해결 (직접해결가능)
		 * 	- 런타임 에러 : 소스코드상으로는 문제가 없는데 프로그램 실행 중 발생하는 에러 (사용자의 잘못일 수도 있고 개발자가 예측가능한 경우를 제대로 처리 안해놓은것일수도 있음)
		 *  - 논리 에러 : 소스코드상의 문법적인 문제도 없고 실행했을 때도 굳이 문제가 되진 않지만 프로그램 의도상 맞지 않은 것
		 *  
		 *  시스템 에러를 제외한 컴파일 에러, 런타임 에러, 논리 에러와 같은 비교적 덜 심각한 것들을 가지고 작업
		 *  이런 것들을 "예외"라고 함!! (Exception)
		 *  
		 *  이러한 예외들이 "발생"했을 경우에 대해서 "처리"하는 방법을 "예외처리"
		 *  
		 *  * 예외처리를 해야되는 경우 : 예외발생시 프로그램이 비정상적으로 종료되는걸 막고자 해서
		 *  
		 *  * 예외처리 방법
		 *  1. try~catch문을 이용
		 *  2. throw를 이용 (떠넘기기)
		 *  
		 *  
		 */
		
		A_UncheckedException a = new A_UncheckedException();
		//a.method1();
		//a.method2();
		//a.method3();
		
		B_CheckedException b = new B_CheckedException();
		b.method1();
		
		
	}

}
