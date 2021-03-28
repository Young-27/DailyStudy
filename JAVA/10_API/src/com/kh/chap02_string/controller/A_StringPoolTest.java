package com.kh.chap02_string.controller;

public class A_StringPoolTest {
	
	/*
	 * 	* String 클래스
	 * 	- 불변 클래스 (변하지 않는 클래스)
	 *	     기존의 문자열 담은 후 변경했을 경우 기존의 문자열이 담겼던 자리에서 변경이 이뤄지지 않음!
	 * 
	 */
	
	// String 객체 생성 구문으로 문자열 담기
	public void method1() {
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2);
		// toString() => Object 클래스에서는 "레퍼런스자료형클래스명 + @ + 주소값의 16진수"
		// toString() => String 클래스에 이미 오버라이딩 되어있음 (실제 담긴 문자열값을 반환)
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		// hashCode() => Object 클래스에서는 실제 주소값 기반의 10진수 값 반환
		// hashCode() => String 클래스에 이미 오버라이딩 되어있음 (주소값 기반이 아닌 실제 담긴 문자열값 기반으로 해쉬코드를 만들어서 반환)
		
		// 정말 진짜 주소값에 대해 알고자 한다면  System.identityHashCode(레퍼런스)
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println(str1 == str2); // false
		System.out.println(str1.equals(str2)); // true
		// equals() => Object 클래스에서는 두 객체의 주소값의 동등비교한 결과 반환
		// equals() => String 클래스에 이미 오버라이딩 되어있음 (실제 담긴 문자열값을 동등비교한 결과반환)
		
		System.out.println("=============");
		int[] arr1 = {1, 2, 3, 4};
		int[] arr2 = {1, 2, 3, 4};
		
		System.out.println(arr1 == arr2); // false
		System.out.println(arr1.equals(arr2)); // false
		
		
		
		
	}
	
	// 리터럴("hello")로 담기
	public void method2() {
		
		int a = 0;
		double d = 1.3; // 바로 변수에 대입한 값 자체가 리터럴
		
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		
		// 리터럴 제시시 StringPool(상수풀) 영역에 할당됨
		// StringPool특징 : 동일한 문자열 존재 불가
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println(str1 == str2); // true (진짜 주소값이 일치함)
		
	}
	
	// 불변클래스
	public void method3() {
		
		String str = "hello";
		System.out.println(System.identityHashCode(str));
		
		str = "goodbye";
		System.out.println(System.identityHashCode(str));
		
		//str = str + "World";
		str += "World"; // "goodbye" + "World" => "goodbyeWorld"
		System.out.println(System.identityHashCode(str));
		
		// 불변이라고해서 수정이 아예 안되는게 아니라
		// 기존의 그 자리에서 수정이 되지 않음!! => 매번 새로운 주소값을 참조하게됨
		
		int num = 10;
		num = 15;
		
	}
	
	
	
	
	
	
	
	

}
