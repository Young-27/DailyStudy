package com.kh.chap04_date.run;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRun {

	public static void main(String[] args) {
		
		/*
		 * 	* java.util.Date
		 * 	- 날짜와 시간에 대한 정보를 담을 수 있는 클래스
		 * 	- 자바 개발 초창기에 급하게 만든 다국적 쓰기에 적합x
		 * 
		 */
		
		// 기본생성자를 이용한 Date객체 생성 => 현재 날짜와 시간(시스템날짜와시간)에 대한 정보를 가지고옴
		Date date1 = new Date();	
		System.out.println("기본생성자 : " + date1);
		
		// 내가 담고싶은 날짜 (2020년 6월 19일)
		// 매개변수생성자를 이용한 Date객체 생성
		//Date date2 = new Date(2020, 6, 19); // 밑줄쫙 => Deprecated : 권장하진않아
		// 내부적으로 내가 전달한 연도 + 1900 / 내가 전달한 월 +1
		Date date2 = new Date(2020-1900, 6-1, 19, 19, 30, 50);
		System.out.println("매개변수생성자 : " + date2/*.toString()*/);
		
		/*
		 *  내 입맛대로의 포맷(형식)을 지정한 문자열을 받고자 할 때
		 *  java.text.SimpleDateFormat
		 */
		
		// "2020년 06월 19일 19시 30분 50초"
		// 1. 포맷(형식)을 지정하면서 SimpleDateFormat 객체 생성
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		// "2020/06/19 19:30"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		// HH : 24시간 => hh : 12시간
		
		// 2. SimpleDateFormat에서 제공하는 format메소드 호출시 Date객체 전달 : 포맷이 반영된 문자열 돌아옴
		//		sdf.format(date객체) : String
		String str = sdf.format(date2);
		
		System.out.println(str);
		
		
		
		
		
		
		
		
	}

}
