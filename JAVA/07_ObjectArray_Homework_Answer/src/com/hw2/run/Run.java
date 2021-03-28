package com.hw2.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.hw2.model.vo.Student;

public class Run {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//Student stu[] = new Student[10];
		
		ArrayList <Student> stu = new ArrayList <Student>(); 
		
		
		while(true) {
			System.out.print("학년 : ");
			int grade = sc.nextInt();
			System.out.print("반 : ");
			int classroom = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("국어점수 : ");
			int kor = sc.nextInt();
			System.out.print("영어점수 : ");
			int eng = sc.nextInt();
			System.out.print("수학점수 : ");
			int math = sc.nextInt();
			sc.nextLine();
			
			// 사용자가 입력한 값들을 가지고 학생객체 생성 후 객체배열에 담기
			stu.add(new Student(grade, classroom, name, kor, eng, math));
			
			System.out.print("계속 추가할 겁니까 ? (y/n) : ");
			String str = sc.nextLine().toUpperCase();
			
			if(str.equals("N")) {
				break;
			}
		}
		
		for (int i = 0; i < stu.size(); i++) { 

			// 해당인덱스 학생의 국어,수학,영어 점수 합계
			int sum = stu.get(i).getKor() + stu.get(i).getMath() + stu.get(i).getEng();

			System.out.println(stu.get(i).information() + ", 평균 = " + sum / 3);

		}
		
		
		/*
		int count = 0; // 현재 학생 수 --> 학생객체 생성 될때마다 1씩 증가 시켜줄꺼임
		
		while(true) {
			System.out.print("학년 : ");
			int grade = sc.nextInt();
			System.out.print("반 : ");
			int classroom = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("국어점수 : ");
			int kor = sc.nextInt();
			System.out.print("영어점수 : ");
			int eng = sc.nextInt();
			System.out.print("수학점수 : ");
			int math = sc.nextInt();
			sc.nextLine();
			
			// 사용자가 입력한 값들을 가지고 학생객체 생성 후 객체배열에 담기
			stu[count++] = new Student(grade, classroom, name, kor, eng, math);
			// 담고나서 count 1 증가
			
			System.out.print("계속 추가할 겁니까 ? (y/n) : ");
			String str = sc.nextLine().toUpperCase();
			
			if(str.equals("N")) {
				break;
			}
		}
		
		
//		for(int i=0; i<stu.length; i++) { // 이렇게 되면 무조건 10번 반복 --> NullPointerException 발생 여지가 있음
		for(int i=0; i<count; i++) { // 따라서 학생 수 만큼만 반복하도록
			
			// 해당인덱스 학생의 국어,수학,영어 점수 합계
			int sum = stu[i].getKor() + stu[i].getMath() + stu[i].getEng();
			
			System.out.println(stu[i].information() + ", 평균 = " + sum / 3);
			
		}
		*/
		
	}

}
