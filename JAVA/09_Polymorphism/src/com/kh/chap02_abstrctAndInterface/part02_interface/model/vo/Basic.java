package com.kh.chap02_abstrctAndInterface.part02_interface.model.vo;

public interface Basic {
	// 인터페이스 : only 상수필드 + 추상메소드
	
	// private int num; => 일반필드 안됨!!
	
	// 생략가능
	/*public static final*/ int Num = 10; // 묵시적으로 public static final
	
	/*public abstract*/ void eat();
	/*public abstract*/ void sleep(); // 묵시적으로 public abstract

}
