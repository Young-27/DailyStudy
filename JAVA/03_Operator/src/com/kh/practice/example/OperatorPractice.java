package com.kh.practice.example;
import java.text.Format;
import java.util.Scanner;


public class OperatorPractice {
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 : ");
		int num = sc.nextInt();
		
		System.out.println( num>0 ? "양수다" : "양수가 아니다");
		
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 : ");
		int num = sc.nextInt();
		
		System.out.println(num>0 ? "양수다" : (num==0? "0이다" : "음수다"));
		
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값: ");
		int num = sc.nextInt();
		
		System.out.println(num%2==0 ? "짝수다" : "홀수다");
		
		
	}
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int personCount = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int candyCount = sc.nextInt();
		
		int result1 = candyCount/personCount;
		int result2 = candyCount%personCount;
		
		System.out.println("1인당 사탕 개수 : " + result1);
		System.out.println("남는 사탕 개수 : " + result2);
		
		
	}
	// 소수점 둘째자리까지만 출력하는방법 모르겠어요.., 출력문 만드는거(만들긴 했는데 너무 길다.ㅜㅠ)
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();	
		
		System.out.print("반(숫자만) : ");
		int studyClass = sc.nextInt();
		sc.nextLine();
		
		System.out.print("번호(숫자만) : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		Double record = sc.nextDouble();
		
		//System.out.printf("%d학년  %d반  %d번 %s(gender = F ? : "여학생" : "남학생 ")의 성적은 %f.2이다. "", name, grade, studyClass, num, gender, record);
		
		//System.out.println(grade + "학년 " + studyClass + "반 " + num + "번 " + name + "(gender == F ? 여학생 : 남학생)" +"의 성적은 " + record + "이다.");
		
		System.out.println(gender == 'F' ? (grade + "학년 " + studyClass + "반 " + num + "번 " + name + " 여학생의 성적은 " + record + "이다."): (grade + "학년 " + studyClass + "반 " + num + "번 " + name + " 남학생의 성적은 " + record + "이다."));
		
	}
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.println(age<=13 ? "어린이" :(age > 19 ? "성인" : "청소년"));
		
		
		
	}
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		int avg = sum/3;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		System.out.println(kor>=40 && eng>=40 && math>=40 && avg>=60 ? "합격" : "불합격");
		
	}
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요(-포함) : ");
		char num = sc.nextLine().charAt(7);
		
		String gender = num == 1 && num == 3 ? "남자" : (num == 2 && num == 4 ? "여자다" : "잘못 입력하셨습니다.");
		
		//System.out.println() 뒷부분 앞자리를 어떻게 잡아야하지,,
		
	}
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("입력 : ");
		int num3 = sc.nextInt();
		
		System.out.println(num3<=num1 || num3>num2 ? "true" : "false");
		
		
	}
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		System.out.println(num1 == num2 && num2 == num3 ? "true" : "false");
	}

}
