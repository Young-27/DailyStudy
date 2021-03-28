package com.hw2.run;

import java.util.Scanner;

import com.hw2.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student[] st = new Student[10];
		st[0] = new Student();
		st[1] = new Student();
		st[2] = new Student();
		st[3] = new Student();
		st[4] = new Student();
		st[5] = new Student();
		st[6] = new Student();
		st[7] = new Student();
		st[8] = new Student();
		st[9] = new Student();

		
		int count = 0;
		
		while(true) {
			
			for(int i=0; i<st.length; i++) {
				
				System.out.print("학년 : ");
				st[i].setGrade(sc.nextInt());
				sc.nextLine();
				System.out.print("반 : ");
				st[i].setClassroom(sc.nextInt());
				sc.nextLine();
				System.out.print("이름 : ");
				st[i].setName(sc.nextLine());
				System.out.print("국어점수 : ");
				st[i].setKor(sc.nextInt());
				sc.nextLine();
				System.out.print("영어점수 : ");
				st[i].setEng(sc.nextInt());
				sc.nextLine();
				System.out.print("수학점수 : ");
				st[i].setMath(sc.nextInt());
				sc.nextLine();
				count++;
				
				System.out.print("계속 입력합니까?");
				char ans = sc.nextLine().charAt(0);
				if(ans == 'n') {
					for(int j=0; j<count; j++) {
						System.out.print(st[j].information());	
						System.out.println(", 평균점수 : " + ((st[j].getKor()+st[j].getEng()+st[j].getMath())/3));
					}

					return;
				}
			}
		
		}
		}	

}
