package com.kh.chap01_math.run;

// import java.lang.*;

public class Run {
	
	public static void main(String[] args) {
		
		// java.lang.Math : 수학과 관련된 필드 및 기능이 정의되어있는 클래스
		//					상수필드 + 모든 static 메소드
		
		System.out.println("파이 : " + Math.PI);
		
		// 절대값을 알아내고자 할 때 => static abs(int a) : int
		int num1 = -20;
		System.out.println("절대값 : " + Math.abs(num1));
		
		// 올림한 값을 알아내고자 할 때  => ceil
		double num2 = 4.349;
		System.out.println("올림 : " + /*(int)*/Math.ceil(num2));
		
		// 반올림한 값을 알아내고자 할 때 => static round(실수형 a) : 정수형
		System.out.println("반올림 : " + Math.round(num2));
		
		// 버림한 값을 알아내고자 할 때 => static floor(double a) : double
		System.out.println("버림 : " + /*(int)*/Math.floor(num2));
		
		// 가장 가까운 정수값을 알아내고자 할 때 => static rint(double a) : double
		System.out.println("가장 가까운 정수 : " + Math.rint(num2));
		
		// 제곱근(루트)값을 알아내고자 할 때 => static sqrt(double a) : double
		System.out.println("4의 제곱근 : " + Math.sqrt(4));
		
		// 제곱한 값을 알아내고자 할 때 => static pow
		System.out.println("2의 10제곱 : " + Math.pow(2, 10));
		
		// Math m = new Math();
		
		// Math 클래스 기본생성자가 private => 생성 불가하게
		
		// static => 프로그램 시작할 때 단 한번 static메모리 영역에 올림!!
		//			 Math객체 생성할 필요 없이 Math. 으로 접근
		
		// 한번만 메모리 영역에 할당해두고 재사용하는 개념  == 싱글톤 패턴
		
		
		
		
		
		
		
		
	}

}
