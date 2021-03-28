package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Student[] st = new Student[3];

		for (int i = 0; i < st.length; i++) {
			st[i] = new Student();
		}

		st[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		st[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		st[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].information());
		}

		Employee[] em = new Employee[10];

		for (int i = 0; i < em.length; i++) {
			em[i] = new Employee();
		}

		int count = 0;

		while (true) {

			System.out.println("사원 정보를 입력하세요.");

			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("신장 : ");
			double height = sc.nextDouble();
			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("급여 : ");
			int salary = sc.nextInt();
			sc.nextLine();
			System.out.print("부서 : ");
			String dept = sc.nextLine();

			em[count] = new Employee(name, age, height, weight, salary, dept);
			count++;

			System.out.print("더 추가하실건가요?(Y/N) : ");
			char add = sc.nextLine().toUpperCase().charAt(0);
			if (add == 'N') {
				break;
			}
		}
		for (int i = 0; i < count; i++) {
			System.out.println(em[i].information());
		}
	}

}
