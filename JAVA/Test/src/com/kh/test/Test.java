package com.kh.test;

import com.kh.test.person.model.vo.Person;

public class Test {

	public static void main(String[] args) {
		
		Person[] pArr = new Person[3];
		
		
		// 첫번째 문제점 : 단지 Phone 객체 3개를 담기위한 공간을 세팅했을 뿐
		//				각 인덱스별 Phone객체 생성하지않아 null이 담긴 상태
		//				null임에도 불구하고 접근하려고 했기때문에 NullPointerException 발생
		//		해결	: 각 인덱스에 Phone객체 생성 후 접근할 수 있도록
		
		for(int i=0; i <pArr.length; i++) {
			pArr[i] = new Person();
			System.out.println(pArr[i].getName());
		}
		
	}

}
