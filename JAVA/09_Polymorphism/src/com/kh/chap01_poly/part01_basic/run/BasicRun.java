package com.kh.chap01_poly.part01_basic.run;

import com.kh.chap01_poly.part01_basic.model.vo.Child1;
import com.kh.chap01_poly.part01_basic.model.vo.Child2;
import com.kh.chap01_poly.part01_basic.model.vo.Parent;

public class BasicRun {

	public static void main(String[] args) {
		
		// 기억해둘것! '=' 기준으로 왼쪽 오른쪽의 자료형(타입)은 같아야된다!
		
		// 1. 부모타입 레퍼런스로 부모 객체 다루는 경우
		System.out.println("1. 부모타입 레퍼런스로 부모 객체 다루는 경우");
		Parent p1 = new Parent();
		p1.printParent();
		// p1레퍼런스로 Parent에만 접근 가능
		
		// 2. 자식타입 레퍼런스로 자식 객체 다루는 경우
		System.out.println("2. 자식타입 레퍼런스로 자식 객체 다루는 경우");
		Child1 c1 = new Child1();
		c1.printParent();
		c1.printChild1();
		// c1레퍼런스로 Parent, Child1 둘 다 접근 가능
		
		// 3. 부모타입 레퍼런스로 자식 객체 다루는 경우 (다형성)
		System.out.println("3. 부모타입 레퍼런스로 자식 객체 다루는 경우 (다형성)");
		Parent p2 = /*(Parent)*/new Child1();
		// 왼쪽 오른쪽 타입 다름!! 왜 가능? => '자동형변환'이 돼서!!
		// 자식타입 => 부모타입으로 형변환하는건 자동으로 됨
		
		p2.printParent(); // p2라는 레퍼런스로 Parent에만 접근가능
		((Child1)p2).printChild1();	// 단, Child1 강제형변환하면 Child1까지도 접근 가능
		
		/*
		 * 	* 상속 구조의 클래스들 간에는 형변환이 가능!
		 * 
		 * 	1. UpCasting
		 * 		자식 타입 --> 부모타입으로 형변환
		 * 		생략 가능 (자동형변환)
		 * 		ex) 부모타입 변수 = (부모타입)자식객체;
		 * 
		 * 	2. DownCasting
		 * 		부모 타입 --> 자식타입으로 형변환
		 * 		생략 불가 (강제형변환)
		 * 		ex) ((자식타입)부모).자식메소드()	
		 * 
		 */
		
		//((Child2)p2).printChild2(); // ClassCastException 발생!
		
		/*
		 *	사실상 다형성의 정의는
		 *	'부모타입으로부터 파생된 여러가지 자식타입객체를 부모타입하나로 다룰 수 있는 기술'
		 */
		
		// 다형성을 왜 써야되는지, 쓰면 좋은 이유
		
		// Child1 객체 2개, Child2 객체 2개를 다뤄야 될 경우 각각의 객체 배열을 만들었을 것..
		Child1[] arr1 = new Child1[2];
		arr1[0] = new Child1(1, 2, 4);
		arr1[1] = new Child1(2, 3, 5);
		
		Child2[] arr2 = new Child2[2];
		arr2[0] = new Child2(2, 1, 5);
		arr2[1] = new Child2(5, 7, 2);
		
		System.out.println("====================================");
		// 다형성(부모타입레퍼런스로 자식객체를 다루는)을 적용해서 부모타입 배열 만든 후 담기
		Parent[] arr = new Parent[4];
		
		// Parent
		arr[0] = new Child1(1, 2, 4); 
		arr[1] = new Child2(2, 1, 5);
		arr[2] = new Child2(5, 7, 2);
		arr[3] = new Child1(2, 3, 5);
		
		// 각 인덱스별로 실질적으로 담겨있는 자식객체의 타입으로 형변환 후 자식 메소드 실행
		/*
		((Child1)arr[0]).printChild1();
		((Child2)arr[1]).printChild2();
		((Child2)arr[2]).printChild2();
		((Child1)arr[3]).printChild1();
		*/
		
		for(int i=0; i<arr.length; i++) {
			
			/*
			 * 	* instanceof 연산자
			 * 		현재 레퍼런스 실질적으로 어떤 클래스형의 주소를 참조하고 있는지 확인 할 때 사용
			 * 
			 * 		레퍼런스 instanceof 클래스타입 		=> 클래스 타입이 일치하면 true, 아니면 false
			 * 
			 * 
			 */
			
			/*
			if(arr[i] instanceof Child1) {
				((Child1)arr[i]).printChild1();
			}else {
				((Child2)arr[i]).printChild2();
			}
			*/
		
			arr[i].print();
			// 부모타입의 메소드보다 오버라이딩 된 자식타입의 메소드가 우선적으로 실행
		
		}
		
		
		Object[] oarr = new Object[5];
		
		oarr[0] = new Parent();
		oarr[1] = new Child1();
		oarr[2] = new String("하이");
		
		
		
		
	}

}
