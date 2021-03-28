package com.kh.chap02_objectArray.run;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ExamRun {

	public static void main(String[] args) {

		Phone[] arr = new Phone[3];
		/*
		for(int i=0; i<=arr.length; i++) {		
			System.out.println(arr[i].getName());
		}
		*/
		// 첫번째 문제점 : 단지 Phone 객체 3개를 담기위한 공간을 세팅했을 뿐
		//				각 인덱스별 Phone객체를 생성하지않아 null이 담긴 상태
		//				null임에도 불구하고 접근하려고 했기때문에 NullPointerException 발생
		//		해결	: 각 인덱스에 Phone객체 생성 후 접근할 수 있도록
		
		// 두번째 문제점 : 부적절한 index가 제시되므로 ArrayIndexOutOfBoundsException 발생
		//		해결	: for(int i=0; i<arr.length; i++) 로 수정
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Phone();
			System.out.println(arr[i].getName());
		}
		
	}

}
