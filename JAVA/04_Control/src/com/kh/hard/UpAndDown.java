package com.kh.hard;

import java.util.Scanner;

public class UpAndDown {

	public void method1() {
		
		// 1부터 100사이의 정수 중에서 임의의 랜덤값이 정해짐
		// 사용자는 임의의 랜덤값을 맞추는데 몇 번만에 맞추는지 출력
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 1부터 100 사이의 임의의 랜덤값 뽑기
		int random = (int)(Math.random() * 100 + 1);
		
		
		int count = 0; // 몇 번만에 맞췄는지 담을 변수 
		
		while(true) { // 사용자가 맞출때까지 무한 반복
			
			// 2. 사용자에게 값 입력받기
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 : ");
			int user = sc.nextInt();
			
			// 3. 사용자가 입력한 값이 1~100 사이의 숫자인지 확인
			if(user >=  1 && user <= 100) { // 3_1. 사용자가 1~100 사이의 숫자를 잘 입력한 경우
				
				// 4. 사용자가 입력한 값과 랜덤 값이 다른지 같은지 확인
				if(user != random) { // 4_1. 입력한 값이 랜덤값과 다른 경우	
					
					// 입력한 값이 random값보다 큰지 작은지 확인
					if(user > random) { // random 보다 큰 경우
						System.out.println("Down!");
						
					}else { // random 보다 작은 경우
						System.out.println("Up!");
					}
					
					count++;	// 틀렸기 때문에 횟수 1 증가
					
				}else { // 4_2. 입력한 값이 랜덤값과 같은 경우
					
					count++; 	// 맞춘 것도 횟수에 들어가기 때문에 1 증가
					System.out.println("정답입니다!");
					break;		// 정답을 맞혔기 때문에 무한반복문을 빠져나가기 위한 break;
				}
				
			}else { // 3_2. 사용자가 1~100 사이의 숫자를 입력하지 않은 경우 
				
				System.out.println("1~100 사이의 숫자를 입력해주세요.");
			}
			
		}
		
		System.out.println(count + "회만에 맞추셨습니다!!"); 
	}
}
