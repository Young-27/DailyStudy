package com.kh.chap03_override.run;

import com.kh.chap03_override.model.vo.Book;

public class OverrideRun {

	public static void main(String[] args) {
		
		// 모든 클래스는 Object 후손이다. 즉, 최상위 클래스는 항상 Object
		// 	=> 즉, Object에 있는 메소드들은 다 가져다 쓸 수 있음
		//		=> 맘에 들지 않으면 오버라이딩을 통해 자식클래스 재정의(재작성) 가능
		
		Book bk = new Book("수학의 정석", "나수학", 10000); 
		
		// 출력문 안에 레퍼런스 변수를 제시해서 출력하고자 할 때 
		// 내부적으로 JVM이 자동으로 toString() 메소드 호출
		
		// 부모 클래스인 Object 클래스에 있는 toString() : "해당 레퍼런스의 타입의 풀클래스명 + @ + 해당객체의 주소값의 16진수 형태" 로 돌려줌
		// Book클래스에 toString() 재정의 : 해당 객체의 모든 필드값 하나의 문자열로 합쳐서 돌려줌
		
		System.out.println(bk/*.toString()*/);
		System.out.println(bk.toString());
		
		int[] arr = {1, 2, 3};
		System.out.println(arr/*.toString()*/);
		System.out.println(arr.toString());
		
		
	}

}
