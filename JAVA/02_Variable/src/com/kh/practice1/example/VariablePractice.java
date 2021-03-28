package com.kh.practice1.example;

import java.util.Scanner;

public class VariablePractice {
	
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("성별을 입력하세요(남/여) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("키를 입력하세요(cm) : ");
		double height = sc.nextDouble();
		
		System.out.println("\n키 " + height + "인 " + age + "살 " + gender + "자 " + name +"님 반갑습니다^^");
		
		
	}

	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int Num1 = sc.nextInt();
		
		System.out.print("두 번째 정수를 입력하세요 : ");
		int Num2 = sc.nextInt();
		
		System.out.println("\n더하기 결과 : " + (Num1 + Num2));
		System.out.println("빼기 결과 : " + (Num1 - Num2));
		System.out.println("곱하기 결과 : " + (Num1 * Num2));
		System.out.println("나누기 몫 결과 : " + (Num1 / Num2));
		
		
		
	}
	
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : ");
		double wide = sc.nextDouble();
		System.out.print("세로 : ");
		double height = sc.nextDouble();
		
		System.out.println("\n면적 : " + (wide * height));
		System.out.println("둘레 : " + ((wide + height)*2));
		
			
	}
	
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String word = sc.nextLine();
		char word1 = word.charAt(0);
		char word2 = word.charAt(1);
		char word3 = word.charAt(2);
		
		System.out.println("\n첫 번째 문자 : " + word1);		
		System.out.println("두 번째 문자 : " + word2);		
		System.out.println("세 번째 문자 : " + word3);
		
		
	}
	
	
}
