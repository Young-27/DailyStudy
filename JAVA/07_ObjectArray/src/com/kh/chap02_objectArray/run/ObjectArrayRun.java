package com.kh.chap02_objectArray.run;

import java.util.Arrays;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ObjectArrayRun {

	public static void main(String[] args) {

		Phone[] arr = new Phone[3];
		
		/*
		System.out.println(arr);
		System.out.println(arr.length);
		System.out.println(arr[0]);
		System.out.println(arr[0].getName());
		*/
		
		//arr[0].setName("갤럭시");
		
		// Phone
		arr[0] = new Phone(); 
		arr[1] = new Phone("갤럭시s", "10", "샘송", 1200000);
		arr[2] = new Phone("아이폰", "11pro", "사과", 1400000);
		
		arr[0].setName("아이폰");
		arr[0].setSeries("8");
		arr[0].setBrand("사과");
		arr[0].setPrice(1000000);
		
		int sum = 0;
		/*	for loop문
		for(int i=0; i<arr.length; i++) {
			//System.out.println(arr[i]);
			System.out.println(arr[i].information());
			sum += arr[i].getPrice();
		}
		*/
		
		// 향상된 for문으로!
		for(Phone p : arr) {
			System.out.println(p.information());
			sum += p.getPrice();
		}
		// 첫번째 반복문 시 Phone p = arr[0];
		// 두번째 반복문 시 Phone p = arr[1];
		// 세번째 반복문 시 Phone p = arr[2];
		
		
		System.out.println("총 가격 : " + sum + "원");
		System.out.println("평균가 : " + sum/arr.length + "원");
	
		int[] iArr = {10, 20, 30};
		
		/*	
		for(int i=0; i<iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		*/
		
		// 향상된 for문 (for each문)
		for(int a : iArr) { // int a = iArr[0]; => 첫번째 반복문 실행시
							// int a = iArr[1]; => 두번째 반복문 실행시
							// int a = iArr[2]; => 세번째 반복문 실행시
			System.out.println(a);
		}
		
		// 향상된 for문을 쓰는 경우 : 해당 배열의 0번인덱스에서부터 마지막인덱스까지 순차적으로 접근할 목적
		
		
		
	}

}
