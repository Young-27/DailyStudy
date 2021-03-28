package com.kh.chap02_string.controller;

import java.util.StringTokenizer;

public class C_StringTokenizerTest {
	
	public void method() {
		
		String str = "Java,Oracle,JDBC,HEML,SERVER,Spring";
		
		// 문자열에 구분자를 제시해서 각 단어(문자열들)들을 분리시키는 방법
		
		// 방법1. 분리된 각각의 문자열들을 String[] 차곡차곡 담아서 관리하고자 할 때
		//		 문자열.split(String 구분자) : String[]
		String[] arr = str.split(",");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("===========");
		// 향상된 for문
		for(String s : arr) {
			System.out.println(s);
		}
		
		// 방법2. 분리된 각각의 문자열들을 토큰으로 취급하고자 할 때
		//		 java.util.StringTokenizer 클래스를 이용하는 방법
		//		 StringTokenizer stn = new StringTokenizwer(분리시키고자하는문자열, 구분자);
		StringTokenizer stn = new StringTokenizer(str, ",");
		
		System.out.println("=========");
		
		System.out.println("분리된 문자열 개수 : " + stn.countTokens());
		
		/*
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		
		//System.out.println(stn.nextToken());
		System.out.println("현재 담겨있는 문자열 개수 : " + stn.countTokens());
		*/
		
		/*	반복문 돌 때마다 stn.countTokens() 결과값이 줄어들기 때문에 => 원하는 결과 출력되지 않음!!
		for(int i=0; i<arr.length; i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
		//	>> 해결1. 처음 분리된 문자열의 개수로 고정시키기
		/*
		int count = stn.countTokens();
		for(int i=0; i<count; i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
		//	>> 해결2. while문을 이용하는 방법
		//while(stn이라는 공간에 토큰이 남아있을 경우) {
		//while(stn.countTokens() > 0) {
		while(stn.hasMoreTokens()) {
			System.out.println(stn.nextToken());
		}
		
		
		
		
		
		
		
		
	}
	
	

}
