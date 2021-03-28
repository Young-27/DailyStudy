package com.kh.variable;

public class A_Variable {
	
	/*
	 *  * 학습목표
	 *  1. 변수라는게 뭔지
	 *  2. 변수를 사용하는 이유
	 *  3. 변수를 어떻게 쓰면 되는지
	 *  4. 변수명은 어떻게 지으면 되는지 (명명규칙)
	 * 
	 */
	
	public void printValue() {
		
		System.out.println("변수 사용 전");
		System.out.println(100 + 10);
		System.out.println((100 + 10) * 10);
		System.out.println(((100 + 10) * 10) - 10);
		//결과물은 잘 출력이 되나 어떤 의도를 가지고 작업한건지 쉽게 파악되지 않음!
		
		// 1. 변수란? => 어떠한 값을 메모리상에 기록하기 위한 박스같은 개념!
		int point = 100;		// 포인트
		int bonus = 10;			// 보너스
		int personCount = 10;	// 사람명수
		int fees = 10;			// 수수료
		
		System.out.println("변수 사용 후");
		System.out.println(point + bonus);
		System.out.println((point + bonus) * personCount);
		System.out.println(((point + bonus) * personCount) - fees);
		
		/*
		 * 2. 변수를 사용하는 이유
		 * -  변수는 우선적으로 값에 의미를 부여할 목적으로 사용 (가독성이 좋음)
		 * -  또한 변수는 단 한 번 값을 기록해두고 필요할때마다 계속 사용할 목적으로 사용 (재사용)
		 * -  유지보수를 보다 쉽게 할 수 있다
		 */
				
		
	}
	
	public void declareVariable() {
		
		/*
		 *  3. 변수의 선언 (값을 기록하기 위한 변수를 메모리에 확보해 두겠다 == 박스만들겠다!)
		 *     [표현법] 자료형 변수명;
		 *     
		 *     자료형 : 어떤 값을 담아낼지, 어떤 크기의 값을 담아낼지에 따라 변수(박스)의 크기 및 모양 지정하는 부분
		 *     변수명 : 변수(박스)의 이름을 정하는 부분
		 *     
		 *     * 주의할점
		 *     - 변수명은 소문자로 시작하게끔 이름 지어줄 것 (단, 낙타표기법 지키기)
		 *     - 같은 영역({}) 안에서는 동일한 변수명으로 선언 불가
		 *     - 해당 영역({})에 선언된 변수는 해당 영역에서만 사용 가능 (다른메소드에서는 사용 불가)
		 *       => 지역변수 개념
		 *       
		 */
		
		// ------ 자료형에 대한 개념 ------
		// 1. 논리형 (논리값 == true/false)
		boolean isTrue;		// 1byte
		
		// 2. 숫자형
		// 2_1. 정수형
		byte bNum;			// 1byte (-128 ~ 127)
		short sNum;			// 2byte 
		int iNum;			// 4byte (-21억xxx ~ 21억xxx) => 정수형 중에 가장 대표적인 자료형 (기본형)
		long lNum;			// 8byte
		
		// 2_2. 실수형
		float fNum;			// 4byte
		double dNum;		// 8byte => 실수형 중에 가장 대표적인 자료형 (기본형) => 보다 더 정확한 값을 담을 수 있어서
		
		// 3. 문자형
		char ch;			// 2byte
		
		//--------------------- 여기까지 총 8개의 자료형 == 기본자료형 --------------
		
		// 4. 문자열 (참조자료형) => 나중에 좀 더 자세히 다룰 예정
		String str;
		
		
		/*
		 *  * 변수에 값 대입 (담기)
		 *    [표현법] 변수명 = 값;
		 */
		isTrue = false;
				
		bNum = 1;		
		sNum = 2;
		iNum = 4;
		lNum = 8L; // long 형 변수에 정수값을 담을 때 뒤에 l 또는 L을 붙여서 표기해주는편! (L을 더 권장. 소문자는 헷갈리기때문에)
		
		fNum = 4.0f; // 반드시 f를 붙여야됨!
		dNum = 8.0;
		
		ch = 'A'; //쌍따옴표 안됨
		
		str = "ABC";
		
		// 각 변수에 담긴 값 출력
		System.out.println("isTrue의 값 : " + isTrue);   //"isTrue의 값 : " + true = "isTrue의 값 : true"
		System.out.println("bNum의 값 : " + bNum); 	// bNum의 값 : 1
		System.out.println("sNum의 값 : " + sNum);		// sNum의 값 : 2
		System.out.println("iNum의 값 : " + iNum);
		System.out.println("lNum의 값 : " + lNum);
		System.out.println("fNum의 값 : " + fNum);
		System.out.println("dNum의 값 : " + dNum);
		System.out.println("ch의 값 : " + ch);
		System.out.println("str의 값 : " + str);
				
				
	}
	
	
	public void initVariable() {
		
		/*
		 * * 변수 선언과 동시에 초기화(값 대입)
		 *   [표현법] 자료형 변수명 = 값;
		 */
		
		// 1. 논리형
		boolean isTrue = true;		// 1byte
		
		// 2_1. 정수형
		byte bNum = 1;				// 1byte
		short sNum = 2;				// 2byte
		int iNum = 4;				// 4byte
		long lNum = 8L;				// 8byte
		
		// 2_2. 실수형
		float fNum = 4.0f;			// 4byte
		double dNum = 8.0;
		// 3. 문자형
		char ch = '강';				// 2byte
		
		// 4. 문자열 (참조자료형)
		String str = "I오후반";
		
		System.out.println(isTrue); // isTrue의 값 : true
		System.out.println(bNum); 	// bNum의 값 : 1
		System.out.println(sNum);	// sNum의 값 : 2
		System.out.println(iNum);
		System.out.println(lNum);
		System.out.println(fNum);
		System.out.println(dNum);
		System.out.println(ch);
		System.out.println(str);
		
		// 번외 (너무 큰 값은 보기좋게 _ 를 사이에 넣어서 작성할 수 있음.)
		int ect = 999_999_999;
		System.out.println("ect의 값 : " + ect);
		
		
	}
	
	public void namingRule() {
		// 4. 변수의 명명규칙 (변수명을 지을때 지켜야 할 규칙)
		
		// 1) 동일한 변수명으로 선언하면 안됨.
		int number;
		//int number;
		int numBer; // 단, 대소문자는 구분을 하기 때문에 이건 사용 가능
		
		// 2) 예약어(이미 자바에서 사용되고 있는 단어)로 변수명 선언 불가
		/*
		int class;
		int public;
		int void
		int double
		*/
		
		// 3) 숫자 사용가능하긴 하나 단, 숫자로 시작되는 것은 안됨.
		int age1;
		int age2;
		//int 3age;
		int ag3e;
		
		// 4) 특수문자 사용가능하긴 하나 단, _와 $만 가능
		int age_1;
		int age$1;
		//int age#1;
		//int age!1;
		//int age~1;
		
		//---------------------------------------------------
		
		// 1) 낙타표기법 지키키
		String username; // 관례상 틀림
		String userName; // 관례상 맞음 (권장사항)
		
		// 4) 한글 쓰지 않기
		String 이름; // 한글을 사용하지 않는 환경에서는 오류를 발생 시킬 가능성 있음.
		
			
	}
	
	public void constant() {
		
		int age = 20;
		System.out.println("age : " + age);
		
		age = 27;
		System.out.println("변경된 age : " + age);
		
		// 상수 : 한 번 기록된 값 변경 불가 (항상 고정적인 값을 기록해두고자 할 때 사용)
		//		final을 붙여서 선언
		//		상수명은 다 대문자로 짓기
		
		final int AGE = 20;
		
		//AGE = 27;
		
	}
	
	/*
	 *   ** 정리 **
	 *   - 변수: 값을 저장하기 위한 공간 (메모리에 값을 기록하기 위한 공간)
	 *   		> 값(리터럴) : 프로그램 상에 필요한 명시적인 값
	 *   					사용자가 키보드로 입력한 값 / 마우스로 클릭한 값
	 */
	
	
}
