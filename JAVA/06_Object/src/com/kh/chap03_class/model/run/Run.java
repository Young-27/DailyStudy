package com.kh.chap03_class.model.run;

import com.kh.chap03_class.model.vo.Person;
import com.kh.chap03_class.model.vo.Product;

public class Run {

	public static void main(String[] args) {

		// Person 이라는 클래스  == 나만의 자료형(여러개의 자료형의 여러개의 값들을 보관) == 사용자 정의 자료형
		
		//int[] arr = new int[5];
		
		Person p = new Person(); // 객체 생성 == 인스턴스화
		System.out.println(p.information());
		
		// 값 넣기
		p.setId("user01");
		p.setPwd("pass01");
		p.setName("강개똥");
		
		System.out.println(p.information());
		
		p.setAge(20);
		p.setGender('M');
		p.setPhone("010-5111-4444");
		p.setEmail("aaa@gmail.com");
		
		System.out.println(p.information());
		
		//System.out.println(p); => 주소값출력
		
		// default 접근제한자의 클래스는
		// 다른패키지에 존재할 경우 갖다 쓸 수 없음
		// 단, 같은 패키지에 있을 경우 사용 가능
		
		// 상품객체생성
		Product p1 = new Product();
		
		p1.setpName("아이폰11");
		p1.setPrice(1300000);
		p1.setBrand("애플");		
		
		Product p2 = new Product();
		
		p2.setpName("아이폰11pro");
		p2.setPrice(1400000);
		p2.setBrand("애플");
		
		System.out.println(p1.information());
		System.out.println(p2.information());
		System.out.println(p1.getPrice() + "원입니다.");
		
		p1.setBrand("samsung");
		System.out.println(p1.information());
		
	}
	
		

}
