package com.kh.chap06_method.run;

import com.kh.chap06_method.controller.MethodTest1;
import com.kh.chap06_method.controller.MethodTest2;
import com.kh.chap06_method.controller.OverloadingTest;

public class MethodRun {
	
	public static void main(String[] args) {
		/*
		// ----------- 1. MethodTest1 --------------
		MethodTest1 m1 = new MethodTest1();
		
		m1.method1();
		
		System.out.println("==============");
		
		//int a = m1.method2();
		//System.out.println("랜덤값 : " + a);
		System.out.println("랜덤값 : " + m1.method2());
		
		System.out.println("==============");
		
		m1.method3(10, 20);
		
		System.out.println("==============");
		
		System.out.println(m1.method4(10, 20));
		*/
		
		// ----------- 2. MethodTest2 --------------
		
		MethodTest2.method1();
		System.out.println(MethodTest2.method2());
		
		MethodTest2.method3("홍길동", 30);
		
		System.out.println(MethodTest2.method4(20, 30, 'x'));
		System.out.println(MethodTest2.method4(10, 5, '+'));
		System.out.println(MethodTest2.method4(-5, 2, '!'));
		
		// static 메소드는 객체 생성할 필요 없음
		
		OverloadingTest ot = new OverloadingTest();
		ot.test();
		ot.test(10);
		ot.test(20, "강보람");
		ot.test("강보람", 100);
		
		ot.test(5, 3);
		
		//System.out.println(); // 대표적인 오버로딩
		
	}

}
