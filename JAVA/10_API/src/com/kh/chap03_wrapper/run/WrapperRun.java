package com.kh.chap03_wrapper.run;

public class WrapperRun {

	public static void main(String[] args) {
		
		int num = 10;
		
		/*
		 * 	* Wrapper 클래스
		 * 	=> 기본자료형을 객체로 포장해주는 클래스들을 래퍼클래스라고 함
		 * 	
		 * 		기본자료형		<-->	Wrapper클래스
		 * 		boolean				Boolean
		 * 		char				Character
		 * 		byte				Byte
		 * 		short				Short
		 * 		int					Integer
		 * 		long				Long
		 * 		float				Float
		 * 		double				Double
		 * 
		 * 
		 */
		
		int num1 = 10;
		int num2 = 15;
		
		//System.out.println(num1.hashCode());
		//System.out.println(num1.equals(num2));
		
		// 기본자료형 => Wrapper자료형 객체		(Boxing)
		Integer i1 = num1;	// 10
		Integer i2 = num2;	// 15
		
		//Integer i3 = 50;
		
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		System.out.println(i1.equals(i2));
		System.out.println(i1.compareTo(i2)); // 두 값을 비교해서 앞쪽이 크면 1반환, 뒤쪽이 크면 -1 반환, 같으면 0 반환
		
		
		// Wrapper자료형 객체 => 기본자료형		(UnBoxing)
		int num3 = i1;
		int num4 = i2;
		
		System.out.println("==========");
		
		// 기본자료형  --> String
		
		String str1 = "10";
		String str2 = "15.3";
		
		System.out.println(str1 + str2);
		
		// 1. String --> 기본자료형		: 파싱한다.
		
		// 해당Wrapper클래스.parseXXX(변환시키고자하는문자열) : 기본자료형
		
		// "10" => 10
		int i = Integer.parseInt(str1); // 10
		// "15.3"	=> 15.3
		double d = Double.parseDouble(str2); // 15.3
		
		System.out.println(i + d);
		
		// 2. 기본자료형 --> String
		//		10	  =>  "10"
		//		15.3  =>  "15.3"
		
		//	String.valueOf(변환시키고자하는기본자료형값) : String
		
		// 15 --> "15"
		String strI = String.valueOf(15);
		
		
		
		
	}

}
