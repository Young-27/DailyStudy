package com.kh.chap01.practice.example;

import java.util.Scanner;

public class ConditionPractice {
	public void practice1() {
		
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("9. 종료");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.println("입력 메뉴입니다.");
		}
		else if(num == 2) {
			System.out.println("수정 메뉴입니다.");
		}
		else if(num == 3) {
			System.out.println("조회 메뉴입니다.");
		}
		else if(num == 4) {
			System.out.println("삭제 메뉴입니다.");
		}
		else if(num == 9) {
			System.out.println("프로그램이 종료됩니다.");
		}
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			if(num % 2 == 0) {
				System.out.println("짝수다");
			}else {
				System.out.println("홀수다");
			}
		}else {
			System.out.println("양수만 입력해주세요.");
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		int sum = kor + math + eng;
		int avg = sum/3;
		
		if(kor >= 40 && math >= 40 && eng >= 40 && avg>=60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		}else {
			System.out.println("불합격입니다.");
		}
	}
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 3:
		case 4:
		case 5: System.out.println(num + "월은 봄입니다."); break;
		case 6:
		case 7:
		case 8: System.out.println(num + "월은 여름입니다."); break;
		case 9: 
		case 10:
		case 11: System.out.println(num + "월은 가을입니다."); break;
		case 12:
		case 1:
		case 2: System.out.println(num + "월은 겨울입니다."); break;
		}
		
	}
	
	public void practice5() {

		/* 내 풀이 
		Scanner sc = new Scanner(System.in);
				
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String passWord = sc.nextLine();
		
		if(id.equals("boram") && passWord.equals("1234")) {
			System.out.println("로그인 성공");
		}else if(id.equals("boram")) {
			System.out.println("비밀번호가 틀렸습니다.");
		}else {
			System.out.println("아이디가 틀렸습니다.");
		}
		*/
		
		/* 풀이1
		// 미리 아이디와 비밀번호 지정해둠
		String userId = "boran";
		String userPwd = "1234";
		
		
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		if(id.equals(userId) && pwd.equals(userPwd)) {
			System.out.println("로그인 성공");
		}else { // 아이디가 틀렸거나, 비밀번호가 틀렸거나, 둘 다 틀렸거나
			
			if(id.equals(userId)) { // true일 경우 => 아이디는 일치한다는 말 => 비밀번호가 틀렸음
				System.out.println("비밀번호가 틀렸습니다.");
			}
			
			if(pwd.equals(userPwd)) { // true일 경우 => 비밀번호는 일치한다는 말 => 아이디가 틀렸음
				System.out.println("아이디가 틀렸습니다.");
			}
		}
		*/
/*		
 * 		풀이2. else if사용
 * 
		if(id.equals(userId) && pwd.equals(userPwd)) {
			System.out.println("로그인 성공");
		}else if(id.equals(userId)) { // true일 경우 => 아이디는 일치한다는 말 => 비밀번호가 틀렸음
				System.out.println("비밀번호가 틀렸습니다.");
		} else if(pwd.equals(userPwd)) { // true일 경우 => 비밀번호는 일치한다는 말 => 아이디가 틀렸음
				System.out.println("아이디가 틀렸습니다.");
		}
*/		
		
	}
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String grade = sc.nextLine();
		
		switch(grade) {
		case "관리자": System.out.println("회원관리, 게시글 관리");
		case "회원" : System.out.println("게시글 작성, 댓글 작성");
		case "비회원": System.out.println("게시글 조회"); break;
		default: System.out.println("잘못 입력했습니다.");
		}
	}
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		System.out.println("BMI지수 : " + bmi);
		
		if(bmi<18.5) {
			System.out.println("저체중");
		}else if(bmi<23) {
			System.out.println("정상체중");
		}else if(bmi<25) {
			System.out.println("과체중");
		}else if(bmi<30) {
			System.out.println("비만");
		}else {
			System.out.println("고도 비만");
		}
	}

//모르게써욥.. 연산자를 입력하면 문자로 인식할텐데 어떻게 연산을 시키는건지?
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		char ch = sc.nextLine().charAt(0);
		
		int result = 0;
		
		if(num1>0 && num2>0) { // 두 수 모두 양수일 경우
			
			switch(ch) {
			case '+': result = num1 + num2; break;
			case '-': result = num1 - num2; break;
			case '*': result = num1 * num2; break;
			case '/': result = num1 / num2; break;
			case '%': result = num1 % num2; break;
			default : System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다."); return;
			}
			
			System.out.printf("%d %c %d = %d", num1, ch, num2, result);
			
		}else {
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}	
			
} 
		
		
		
		

	public void practice9() {
		
		
			ConditionPractice cp = new ConditionPractice();
			
			Scanner sc = new Scanner(System.in);
		
			System.out.println("실행할 기능을 선택하세요.");
			System.out.println("1. 메뉴 출력");
			System.out.println("2. 짝수/홀수");
			System.out.println("3. 합격/불합격");
			System.out.println("4. 계절");
			System.out.println("5. 로그인");
			System.out.println("6. 권한 확인");
			System.out.println("7. BMI");
			System.out.println("8. 계산기");
			
			System.out.print("선택 : ");
			int num = sc.nextInt();
			
		
			switch(num) {
			case 1: cp.practice1();
			case 2: cp.practice2();
			case 3: cp.practice3();
			case 4: cp.practice4();
			case 5: cp.practice5();
			case 6: cp.practice6();
			case 7: cp.practice7();
			case 8: cp.practice8();
			default : System.out.println("잘못 입력하셨습니다.");
		}
		
		
		
	}
	
}
