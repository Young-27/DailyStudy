package com.kh.chap02.practice.example;

import java.util.Scanner;

public class LoopPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num >= 1) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num >= 1) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			practice2();

		}
	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if (num >= 1) {
			for (int i = 1; i <= num; num--) {
				System.out.print(num + " ");
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if (num >= 1) {
			for (int i = 1; i <= num; num--) {
				System.out.print(num + " ");
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
			practice4();
		}

	}

	// "o + o + o = O" 의 형식을 어떻게 만들지........
	public void practice5() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			
			if(i < num) {  //if(i != num)도 가능.
				System.out.print(i + " + ");
			}else {
				System.out.print(i + " = ");
			}
			
			sum += i;
		}
		
		System.out.print(sum);

	}

	public void practice6() {

		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if (num1 >= 1 && num2 >= 1) {
			if (num1 > num2) {
				for (int i = 1; i <= (num1 - num2 + 1); num2++) {
					System.out.print(num2 + " ");
				}
			} else {
				for (int i = 1; i <= (num2 - num1 + 1); num1++) {
					System.out.print(num1 + " ");
				}
			}
		} else {
			System.out.println("1이상의 숫자만을 입력해주세요.");
		}

	}

	public void practice7() {

		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if (num1 >= 1 && num2 >= 1) {
			if (num1 > num2) {
				for (int i = 1; i <= (num1 - num2 + 1); num2++) {
					System.out.print(num2 + " ");
				}
			} else {
				for (int i = 1; i <= (num2 - num1 + 1); num1++) {
					System.out.print(num1 + " ");
				}
			}
		} else {
			System.out.println("1이상의 숫자만을 입력해주세요.");
			practice7();
		}
	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();

		System.out.println("===== " + num + " 단 =====");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num * i);
		}

	}

	// 으아..
	public void practice9() {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();

		if (num>=2 && num<=9) {
			for (int i=num; i <= 9 ; i++) {
				System.out.println("===== " + i + " 단 =====");
				for (int j=1; j<=9; j++ ) {
					System.out.printf("%d * %d = %d\n", i, j, i * j);
				}
			}
			
			
		} else {
			System.out.println("2~9 사이의 숫자만 입력해주세요.");
		}

	}
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자 : ");
			int num = sc.nextInt();

			if (num>=2 && num<=9) {
				for (int i=num; i<=9 ; i++) {
					System.out.println("===== " + i + " 단 =====");
					for (int j=1; j<=9; j++) {
						System.out.printf("%d * %d = %d\n", i, j, i * j);
					}
				}
				
				// 반복문빠져나감
				break;
			} else {
				System.out.println("2~9 사이의 숫자만 입력해주세요.");
		}
		
						
		
		}
	}

	public void practice11() {

		Scanner sc = new Scanner(System.in);
		System.out.print("시작 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("공차 : ");
		int num2 = sc.nextInt();

		/*
		for (int i=0; i<10; i++) { // (10회)
			
			// 뭔가를 출력
			System.out.print(num1 + " ");
			num1 += num2;
		}
		*/
		
		
		int count = 0;
		/*
		while(true) {
			
			System.out.print(num1 + " ");
			num1 += num2;
			
			count++;
			
			if(count == 10) {
				break;
			}
		}
		*/
		
		for(;;num1 += num2) {
			System.out.print(num1 + " ");
			count++;
			if(count == 10) {
				break;
			}
			
		}
		
	}


	public void practice12() {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("연산자(+, -, *, /, %) : ");
		String a = sc.nextLine();
		
		int result = 0;
		
		if(a.equals("exit")) {			
			System.out.println("프로그램을 종료합니다."); 
			return;
			
		}else {			
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
			if(a.equals("/") && num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				practice12();
			}else {			
				switch(a) {
				case "+": result = num1+num2; break;
				case "-": result = num1-num2; break;
				case "*": result = num1*num2; break;
				case "/": result = num1/num2; break;
				case "%": result = num1%num2; break;
				default: System.out.println("없는 연산자입니다. 다시 입력해주세요."); practice12();
				
				}
			System.out.printf("%d %s %d = %d\n", num1, a, num2, result);
			practice12();
			
			
			}
		}
	}		
	
	
	 public void practice13() { //practice12 강사님 풀이
		 
		 Scanner sc = new Scanner(System.in);
		 
		 while(true) {
			 
			 // 1. 연산자 입력받기 ( + - * / % exit)
			 System.out.print("연산자(+, -, *, /, %) : ");
			 String op = sc.nextLine();
			 
			 // >> 연산자 입력받고 두개의 정수를 입력받기 전에 
			 //	       사용자가 입력한 연산자가 "exit"일 경우=> "프로그램을 종료합니다" 출력 후 반복문 빠져나가야됨
			 if(op.equals("exit")) {
				 System.out.println("프로그램을 종료합니다.");
				 break; // 아예 while문을 빠져나간것!!
			 }
			 
			 // 2. 두 개의 정수 입력받기
			 System.out.print("정수1 : ");
			 int num1 = sc.nextInt();			 
			 System.out.print("정수2 : ");
			 int num2 = sc.nextInt();
			 sc.nextLine();
			 
			 // >> 두 개의 정수까지 입력받고 본격적인 산술연산 수행 전에
			 //    연산자가 "/" 이거나 "%" 이고 뿐만 아니라 두 번째 정수가 0과 일치할 경우
			 //    => "0으로 나눌 수 없습니다. 다시 입력해주세요." 출력 후 반복문 위로 올라가도록
			 if(op.equals("/") || op.equals("%") && num2 == 0) {
				 System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.\n");
				 continue; 
			 }
	
			 // 3. 산술연산 후 결과 출력하기
			 int result = 0; // 산술연산 결과를 보관할 변수
			 switch(op) {
			 case "+": result = num1+num2; break;
			 case "-": result = num1-num2; break;
			 case "*": result = num1*num2; break;
			 case "/": result = num1/num2; break;
			 case "%": result = num1%num2; break;
			 // >> 잘못된 연산자를 입력했을 경우 => "없는 연산자입니다. 다시 입력해주세요." 출력 후 반복문 위로 올라가기
			 default: System.out.println("없는 연산자입니다. 다시 입력해주세요.\n"); continue;
			 } // continue; (가장 가까운 반복문인) while문으로 올라감
			 
			 // num1 op num2 = 산술연산결과
			 System.out.printf("%d %s %d = %d\n\n", num1, op, num2, result);
			 
		 }
	 }
		
		
		
		
/*		
		if(a = "/" && num2 == 0) {
			//System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
		}else {
			switch(a) {
			case "+": result = num1+num2; break;
			case "-": result = num1-num2; break;
			case "*": result = num1*num2; break;
			case "/": result = num1/num2; break;
			case "%": result = num1%num2; break;
			case "exit": System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("없는 연산자입니다. 다시 입력해주세요."); 
			}
		
			System.out.printf("%d %c %d = %d", num1, a, num2, result);
			practice12();
			
		}
		 */
	
	
	
}
