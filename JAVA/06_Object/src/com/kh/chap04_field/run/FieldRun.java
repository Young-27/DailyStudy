package com.kh.chap04_field.run;

import com.kh.chap04_field.model.vo.FieldTest2;
import com.kh.chap04_field.model.vo.FieldTest3;

public class FieldRun {

	public static void main(String[] args) {
		
		// -------------1. FieldTest1 --------------
		/*
		FieldTest1 f1 = new FieldTest1(); // 객체생성시 global멤버변수 할당 (JVM이 초기화도 해줌)
		
		f1.test(10); // test메소드 호출시 num, local 변수 할당
					 // test메소드 종료시 num, local 변수 소멸
		
		f1 = null; // 객체소멸시 global 멤버변수 소멸
		*/
		// ----------------------------------------
		
		// -------------2. FieldTest2 -------------
		
		/*
		FieldTest2 f2 = new FieldTest2();
		
		// * public --> 어디서든 직접 접근 가능
		System.out.println(f2.pub);
		
		// * protected --> 같은 패키지에서는 직접 접근 가능 단, 다른패키지는 상속구조
		//System.out.println(f2.pro);
		
		// * default --> 같은 패키지에서만 직접 접근 가능
		//System.out.println(f2.def);
		
		// * private --> only 같은 클래스에서만 사용가능
		//System.out.println(f2.pri);
		*/
		
		// ------------------ 3. FieldTest3 --------------------
		System.out.println(FieldTest3.sta);
		System.out.println(FieldTest2.sta);
		
		FieldTest3.sta = "FieldTest3꺼";
		System.out.println(FieldTest3.sta);
		
		
		System.out.println(FieldTest3.NUM);
		//FieldTest3.NUM = 20;
		
		System.out.println(Math.PI);
		
		/*
		FieldTest3.test();
		Math.random();
		*/
		
		
		
	}

}
