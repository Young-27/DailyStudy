package com.kh.variable;

public class F_Printf {
	
	public void printfTest() {
		
		/*
		 * System.out.println(출력하고자하는값); => 값 출력 후 줄바꿈(개행) 넣어줌
		 * System.out.print(출력하고자하는값);   => 값 출력만 해줌
		 * 
		 * System.out.printf("출력하고자하는형식(포맷)", 출력하고자하는값, 값, ..);
		 * => 형식(포맷)에 맞춰서 값들이 출력만 되고 끝 (줄바꿈x)
		 * 
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열
		 * 
		 */
		
		int iNum1 = 10;
		int iNum2 = 20;
		
		// iNum1 : xx, iNum2 : xx
		System.out.println("iNum1 : " + iNum1 + ", iNum2 : " + iNum2);
		System.out.printf("iNum1 : %d, iNum2 : %d\n", iNum1, iNum2);
		
		// xx + xx = xx
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2));
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1 + iNum2);
		
		System.out.printf("%5d\n", iNum1); // 5칸의 공간 중 오른쪽 정렬 (음수면 왼쪽)
		
		double dNum = 4.57;
		
		System.out.printf("dNum : %f\n", dNum); //%f => 기본적으로 무조건 소수점 아래 6째자리까지 나옴 (반올림)
		System.out.printf("dNum : %.1f\n", dNum); // .1 => 소수점 아래 첫째자리까지 출력
		
		// 162.3		=> 162.3
		// 178.678		=> 178.7
		// 156			=> 156.0
		// 189.4236		=> 189.4
		
		char ch = 'a';
		String str = "Hello";
		
		System.out.printf("%c %s\n", ch, str);
		System.out.printf("%C %S\n", ch, str); // 대문자로도 출력가능
		
		
		
		
		
	}

}
