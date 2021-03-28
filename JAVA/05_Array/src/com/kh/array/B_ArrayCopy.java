package com.kh.array;

import java.util.Arrays;

public class B_ArrayCopy {

	/*
	 *  * 배열 복사
	 *  - 얕은 복사 : 배열의 주소값만을 복사
	 *  - 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 실제 내부값들을 복사
	 */
	
	public void method1() {
		
		int[] origin = {1, 2, 3, 4, 5}; // 원본 배열
		
		System.out.println("== 원본 배열 출력 ==");
		for(int i=0; i<origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		// 복사본 배열
		int[] copy = origin;
		System.out.println("\n== 복사본 배열 출력 ==");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		// copy 배열가지고 수정하기
		copy[2] = 99;
		
		System.out.println("\n===복사본 배열 수정 후..===");
		System.out.println("== 원본 배열 출력 ==");
		for(int i=0; i<origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println("\n== 복사본 배열 출력 ==");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		// 복사본 배열만을 가지고 수정을 했는데 원본배열도 같이 수정이 된 듯함!
		// 왜? 원본배열이든 복사본배열이든 같은 주소값을 가지고 있기 때문 == 같은 곳을 참조하고 있었음!
		System.out.println("\n원본 해쉬코드 : " + origin.hashCode());
		System.out.println("복사본 해쉬코드 : " + copy.hashCode());
		
		// "얕은복사" : 주소값만 복사하는 개념 => 같은 주소값 == 같은 곳을  참조하고 있음
		
	}
	
	// 깊은복사 (4가지 방법)
	public void method2() {
		// 1. for문 방법
		//	    아싸리 새로운 배열을 생성한 후
		//	    각 인덱스별 내부 값을 일일이 대입하는 방법
		
		int[] origin = {1, 2, 3, 4, 5};
		
		int[] copy = new int[origin.length];
		/*
		 * copy[0] = origin[0];
		 * copy[1] = orihin[1];
		 * ....
		 * copy[막인덱스] = origin[막인덱스];
		 */
		for(int i=0; i<copy.length; i++) {
			copy[i] = origin[i];
		}
		
		// 잘 복사됐는지 복사본 배열 출력
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		copy[2] = 99;
		System.out.println("\n== 복사본 배열 변경후.. ==");
		
		System.out.println("원본배열출력"); // 1 2 3 4 5
		for(int i=0; i<origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println("\n복사본배열출력"); // 1 2 99 4 5
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		// 각각 다른 해쉬코드 => 각자 다른 곳을 참조하고 있음음
		System.out.println("\n원본 해쉬코드 : " + origin.hashCode());
		System.out.println("복사본 해쉬코드 : " + copy.hashCode());
		
		
		
	}
	
	public void method3() {
		// 2. 아싸리 새로운 배열 생성한 후 System클래스에서의 arraycopy메소드를 이용한 복사
		
		int[] origin = {1, 2, 3, 4, 5};
		
		int[] copy = new int[10];
		
		// System.arraycopy( 원본배열명, 복사를 시작할 인덱스, 복사본배열명, 복사 될 시작인덱스, 복사할개수 );
		System.arraycopy(origin, 2, copy, 1, 2);
		
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");     
		}
		
		System.out.println("\n원본 해쉬코드 : " + origin.hashCode());
		System.out.println("복사본 해쉬코드 : " + copy.hashCode());
		
		// 다른 주소값을 가지고 있음 => 다른 곳을 참조하고 있음
		// => 배열 수정시 서로 영향을 받지 않는다는걸 유추 가능
		
	}
	
	public void method4() {
		// 3. Arrays 클래스에서 제공하는 copyOf 메소드 이용한 복사
		
		int[] origin = {1, 2, 3, 4, 5};
		
		// 복사본배열 = Arrays.copyOf( 원본배열명, 복사할개수 );
		int[] copy = Arrays.copyOf(origin, 7);
		
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\n원본 해쉬코드 : " + origin.hashCode());
		System.out.println("복사본 해쉬코드 : " + copy.hashCode());
		
		/*
		 * 2. System.arraycopy 메소드 : 몇번인덱스부터 몇개를 어느 위치의 인덱스에 복사할건지 다 직접 지정 가능
		 * 
		 * 3. Array.copyOf 메소드 : 무조건 원본배열의 0번 인덱스부터 복사 진행됨 (내가 제시한 개수만큼)
		 * 						    그리고 내가 제시한 개수만큼이 곧 복사본 배열의 크기로 지정됨
		 */
	}
	
	
	public void method5() {
		// 4. clone 메소드 사용하여 복사
		
		int[] origin = {1, 2, 3, 4, 5};
		
		// 복사본배열   = 원본배열.clone();
		int[] copy = origin.clone(); // 인덱스직접지정x, 복사할개수지정x  => 원본배열 똑같이 그냥 복사
		
		// [1, 2, 3, 4, 5]
		/*
		System.out.print("[");
		for(int i=0; i<copy.length; i++) {		
			if(i!=copy.length-1) {
			System.out.print(copy[i] + ", ");
			}else {
			System.out.print(copy[i]);
			}
		}
		System.out.println("]");
		*/
		System.out.println(Arrays.toString(copy));
		// Arrays.toString(각각의 인덱스에 뭐가 담겼는지 궁금한배열)
		// => 앞과 뒤에 [], 사이에는 해당 배열의 각 인덱스에 담긴 값들을 , 찍어가면서 하나의 문자열로 연이어서 돌려주는 메소드
		
		
		
		System.out.println("\n원본 해쉬코드 : " + origin.hashCode());
		System.out.println("복사본 해쉬코드 : " + copy.hashCode());
	}
	
	
	
	
}
