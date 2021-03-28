package com.kh.variable;

public class C_Cast {

	/*
	 *   * 형변환 : 값의 자료형을 바꾸는 개념
	 *   
	 *   * 컴퓨터 상에서의 값 처리 규칙
	 *   1. 대입 연산자(=)를 기준으로 왼쪽과 오른쪽은 같은 자료형이어야 됨.
	 *      => 즉, 같은 자료형에 해당하는 값만 대입 가능함!
	 *   	=> 다른 자료형의 값을 대입하고자 한다면 "형변환"이 필수!!
	 *   
	 *   	자료형 변수명 = (자료형)값;
	 *   
	 *   2. 같은 자료형끼리만 연산 가능! 뿐만 아니라 연산결과도 같은 자료형으로 나옴!
	 *   	=> 즉, 다른 자료형끼리 연산을 수행하고 싶으면 한 구문은 "형변환"을 해야됨!
	 *   
	 *   	값 + (자료형)값
	 *   
	 *   * 형변환 종류
	 *   1. 자동형변환 => 자동으로 형변환이 진행되기 때문에 내가 직접 형변환 할 필요 없음
	 *   			     작은 바이트의 자료형 => 큰 바이트의 자료형
	 *   
	 *   2. 강제(명시적)형변환 => 자동형변환이 되지 않아 내가 직접 강제로 형변환 해야되는 경우
	 *   					큰 바이트의 자료형 => 작은 바이트의 자료형
	 *   	[표현법]  (바꿀자료형)값
	 *   
	 *   			(바꿀자료형)  ==  형변환연산자  == cast연산자   
	 */
	
	//자동형변환
	public void autoCasting() {
		
		/*
		 * 자동형변환 : 작은바이트의 자료형이 큰 바이트의 자료형으로 자동으로 형변환 되는 경우 
		 */
		
		// 1. int(4byte) --> double(8byte)
		int i1 = 10;
		double d1 = /*(double)*/i1; // 10 => 10.0
		
		System.out.println("d1 : " + d1);
		
		int i2 = 12;
		double d2 = 3.3;
		
		double result2 = /*(double)*/i2 + d2; // 12.0 + 3.3 => 15.3
		
		System.out.println("result2 : " + result2);
		
		// 2. int(4byte) --> long(8byte)
		int i3 = 1000;
		long l3 = /*(long)*/i3; // 1000
		
		long l4 = 2000L; // L을 붙이지 않아도 문제가 없는 이유 => 자동형변환         
		
		
		
		// 특이케이스 3. long(8byte) --> float(4byte)
		// 아무리 4byte float이라고 해도 long형 보다 담을 수 있는 값의 범위가 더 큼
		long l5 = 1000000;
		float f5 = /*(float)*/l5; // 1000000.0
		
		// 특이케이스 4. char(2byte) <--> int(4byte)
		
		//			 char => 0~65XXX
		
		char ch = 65; // 'A'
		System.out.println("ch : " + ch);
		
		int num = 'A'; // 65
		System.out.println("num : " + num);
		
		// 각 문자마다의 고유한 숫자가 정해져있음
		// 아스키코드표(0~127, 영문자/숫자/특수문자), 유니코드표(0~65xxx, 영문/숫자/특수/한글)
		
		System.out.println((int)'헿');
		
		char sum = 'A' + 10;
		
		System.out.println("sum : " + sum);
		
		// 특이케이스 5. byte, short간의 연산
		byte b1 = 1;
		byte b2 = 10;
		
		//byte result = b1 + b2; // byte나 short로 연산시 무조건 int(4byte)로 취급
		byte result = (byte)(b1+ b2); // 강제로 형변환을 하면 저장 가능
		//		11
		
		
	}
	
	// 강제형변환
	public void forceCasting() {
		
		// 강제(명시적)형변환 : 큰 크기의 자료형을 작은 크기의 자료형으로 형변환할 때 직접 해주는 과정
		
		// 1. double(8byte) --> float(4byte)
		float f1 = 4.0f; // 반드시 f 붙여줘야됨! (기본적으로 double로 인식하기 때문에)
		
		double d2 = 8.0;
		float f2 = (float)d2;
		
		// 2. double(8byte) --> int(4byte)
		double d3 = 10.89;
		int i3 = (int)d3; // 10.89 => 10 ---> 실수 => 정수
	
		System.out.println("i3 : " + i3);
		
		int iNum = 10;
		double dNum = 5.89;
		
		//int iSum = /*(double)*/iNum + dNum; // 10.0 + 5.89 => 15.89 (결과가 double형)
		
		//해결방법 1. 연산 결과를 int형으로 강제형변환 한 뒤 담기
		int iSum1 = (int)(iNum + dNum);
		System.out.println("iSum1 : " + iSum1);
		
		//해결방법2.
		int iSum2 = iNum + (int)dNum; // 10 + 5 => 15 (결과가 int형)
		System.out.println("iSum2 : " + iSum2); 
		
		// 실수형을 정수형으로 강제형변환시 => 데이터 손실이 발생할 수 있음!! (신중하게 변환하기)
		
		// 해결방법3. 아싸리 double형 변수에 담기
		double dSum = iNum + dNum;
		System.out.println("dSum : " + dSum); //데이터값 손실 x
		
	}
	
	
	
	
}
