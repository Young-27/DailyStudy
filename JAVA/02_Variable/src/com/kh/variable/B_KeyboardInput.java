package com.kh.variable;

import java.util.Scanner;

// 사용자가 키보드로 입력한 값을 변수에 기록하는 방법
public class B_KeyboardInput {
	
	public void inputTest1() {
		
		/*
		 *  자바에서 이미 제공하고있는 java.util.Scanner 클래스를 이용해야됨!
		 *  Scanner 클래스 안에 작성되어있는 메소드 호출해서 이용할거임!!
		 */
		Scanner sc = new Scanner(System.in);
		
		// 사용자의 인적사항(이름, 나이 , 키) 입력받기
		
		// 입력받고자 하는 내용을 먼저 출력해서 입력을 유도
		System.out.print("당신의 이름은 무엇입니까 : "); // 커서가 밑으로 가지않도록 println을 쓰지않음.
		
		// 사용자가 입력한 값을 문자열로 받아오는 메소드 (next(), nextLine())
		//String name = sc.next();
		// next() : 사용자가 입력한 값 중 공백이 있을 경우 공백이전까지의 값만 가지고 옴  ex)이 선영 => 이
		
		String name = sc.nextLine();
		//nextLine() : 사용자가 입력한 모든 값 가지고 옴
		//			   (즉, 사용자가 입력한 값에 공백이 포함될 여지가 있을 경우 안전빵 nextLine 쓰자!)
		
		System.out.print("당신의 나이는 몇 살입니까 : ");
		int age = sc.nextInt();
		// nextInt() : 사용자가 입력한 정수값 가지고 옴
		
		System.out.println("당신의 키는 몇 cm입니까 : ");
		double height = sc.nextDouble();
		// nextDouble() : 사용자가 입력한 실수값 가지고 옴
		
		// 각 변수에 잘 담겨있는지 출력
		// xxx님은 xx살이며, 키는 xxx cm입니다.
		System.out.println(name + "님은 " + age + "살이며, 키는 " + height + "cm입니다.");
		
		
	}

	public void inputTest2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		sc. nextLine(); // 버퍼에 남아있는 '엔터'를 지워주는 과정의 코드
		/*
		 *  nextLine() : 문자열값을 가져온 후 '엔터'를 비워주는 역할까지 수행
		 *    그  외	   : 	 값을 가져온 후 '엔터'를 비워주지는 않음.
		 *    
		 *  nextInt() 후 nextLine()이 실행되게 작성되어 있을 경우
		 *  버퍼에 남아있는 '엔터'를 사용자가 입력했다는 내용으로 간주해서 곧바로 읽어옴
		 *  
		 *  해결방법. 
		 *  nextXXX() 후에 nextLine() 수행되어야만 할 경우
		 *  해당 nextLine() 메소드가 호출되기 전에 버퍼에 남아있는 '엔터'를 깔끔하게 비워주자!
		 *   => nextLine()한 번 더 호출
		 *  
		 */
		
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("키(cm) : ");
		double height = sc.nextDouble();
		
		// xxx님은 xx살이며, 사는 곳은 xxx이고, 키는 xxx cm입니다.
		
		System.out.println(name + "님은 " + age + "살이며, 사는 곳은 " + address + "이고, 키는 " + height + "cm입니다.");
		System.out.printf("%s님은 %d살이며, 사는 곳은 %s이고, 키는 %.1fcm입니다.\n", name, age, address, height);
		
	}
	
	public void inputScanner3() {
		
		Scanner sc = new Scanner(System.in);
		
		// 문자열을 뽑을 때 => sc.nextLine() / sc.next()
		// 정수값을 뽑을 때 => sc.nextInt() / sc.nextByte() / sc.nextShort() / sc.nextLong()
		// 실수값을 뽑을 때 => sc.nextDouble() /sc.nextFloat()
		// 문자를 뽑을 때    => sc.nextChar() -없음!!
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		//char gender = sc.nextChar();
		char gender = sc.nextLine().charAt(0); // 먼저 문자열로 뽑은 후 그 문자열에 해당 인덱스의 문자 추출
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("키(cm) : ");
		double height = sc.nextDouble();
		
		/*
		 *  xxx님의 개인정보
		 *  성별 : x
		 *  나이 : xx
		 *  키 : xxx
		 */
		
		System.out.println("\n" + name + "님의 개인정보");
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		
		
	}
	
	
}
