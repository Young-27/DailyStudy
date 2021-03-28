package com.kh.hard;

import java.util.Scanner;

public class RockPaperScissors {
	
	// 컴퓨터와 가위바위보 하는 게임
	
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		// 마지막에 몇전 몇승 몇무 몇패 를 출력할꺼임 
		int count = 0;		// 수행 횟수(전)
		int win = 0;		// 이긴 횟수(승)
		int draw = 0;		// 비긴 횟수(무)
		int lose = 0;		// 진 횟수(패)
		
		String result = "";	// 결과 값을 담을 변수
		String winStr = "이겼습니다!!"; // 이겼을 경우 result에 담을 변수
		String loseStr = "졌습니다 ㅠㅠ";// 졌을 경우 result에 담을 변수
		String drawStr = "비겼습니다."; // 비겼을 경우 result에 담을 변수
		
		
		while(true) { // 사용자가 종료하겠다는 의사를 밝힐때까지 무한 반복
			
			// 1. 먼저 컴퓨터에서 랜덤값을 이용해서 랜덤으로 가위,바위,보 가 정해지게 한다.
			int compRan = (int)(Math.random() * 3);  // 0, 1, 2 에서의 랜덤값 발생
			
			String computer = ""; 	// 컴퓨터의 가위/바위/보 에 해당 하는 값을 담을 변수
			
			switch(compRan) {
			case 0: computer = "가위"; break; // 랜덤값이 0일 경우 컴퓨터는 "가위"
			case 1: computer = "바위"; break; // 랜덤값이 1일 경우 컴퓨터는 "바위"
			case 2: computer = "보"; break;	 // 랜덤값이 2일 경우 컴퓨터는 "보"
			}
			
			// 2. 사용자한테 가위/바위/보/exit 중 하나를 입력받게 한다.
			System.out.print("가위바위보(종료하시려면 exit 입력) : ");
			String user = sc.nextLine();
			
			
			// 3. 사용자가 입력한 값이 가위/바위/보 중 하나일 경우 	--> 3_1 조건실행
			//    사용자가 입력한 값이 exit일 경우 		   	--> 3_2 조건 실행
			//    사용자가 입력한 값이 잘못된 값일 경우 		 	--> 3_3 조건 실행
			
			if (user.equals("가위") || user.equals("바위") || user.equals("보")) { // 3_1. 사용자가 가위, 바위, 보 중 하나를 입력하였을 경우
				
				if(computer.equals(user)) {	// 컴퓨터와 사용자가 입력한 값이 같은 경우 (즉, 비긴 경우)
					result = drawStr; // 결과 값에 비긴 내용을 담고
					draw++;	// 비긴 횟수 1 증가
					boolean winner = false;
					
				}else if(computer.equals("가위")){ // 컴퓨터의 값이 가위 일 때
					
					// * switch 방법
					switch(user) {
					case "바위" : result = winStr; win++; break; // 사용자가 바위인 경우 (즉, 이긴 경우) --> 결과값에 이긴 내용 담고 이긴 횟수 1 증가 
					case "보" : result = loseStr; lose++; break; // 사용자가 보인 경우 (즉, 진 경우) --> 결과값에 진 내용 담고 진 횟수 1 증가 
					}
					
				}else if(computer.equals("바위")) { // 컴퓨터의 값이 바위 일 때
					
					// * if-else if문 방법
					if(user.equals("가위")) { // 사용자가 가위인 경우 (즉, 진 경우)
						result = loseStr;    // 결과 값에 진 내용 담고
						lose++; 		     // 진 횟수 1 증가 
						
					}else if(user.equals("보")) { // 사용자가 보인 경우 (즉, 이긴 경우)
						result = winStr; 		 // 결과 값에 이긴 내용 담고
						win++;  		 		 // 이긴 횟수 1 증가 
					}
					
				}else {	// 컴퓨터의 값이 보 일 때
					
					// * 삼항연산자 방법
					result = user.equals("가위") ? winStr : loseStr;
					
					if(result.equals(winStr)) { // 이긴 경우
						win++;
					}else {		// 진 경우
						lose++;
					}
					
				}
				
				count++;	// 수행 횟수 1 증가 
				
			}else if(user.equals("exit")) { // 3_2. exit 입력 시
				break;	// 무한 반복문을 빠져나가게 된다.
				
			}else {	// 3_3. 그 외의 경우 (즉, 잘못 입력하였을 경우)
				System.out.println("잘못입력하였습니다.");
				continue; // 반복문 처음부터 다시 시작
			}
			
			System.out.println("컴퓨터 : " + computer);
			System.out.println(name + " : " + user);
			System.out.println(result);
			System.out.println();
			
		}
		
		
		System.out.println(count + "전 " + win + "승 " + draw + "무 " + lose + "패");
		
	}

}
