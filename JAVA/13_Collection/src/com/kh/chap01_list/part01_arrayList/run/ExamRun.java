package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;

import com.kh.chap01_list.part01_arrayList.mode.vo.Music;

public class ExamRun {

	public static void main(String[] args) {
		
		// Music 객체들만 보관 가능한 리스트 생성
		ArrayList <Music> list = new ArrayList<>();
		
		list.add(new Music("술이 달다", "에픽하이"));
		list.add(new Music("이 밤", "양다일"));
		list.add(new Music("GoodBye", "박효신"));
		
		System.out.println("값 삽입 : " + list);
		
		System.out.println(list.get(0));
		
		list.get(1).setTitle("저 밤");
		System.out.println(list.get(1));
		
		System.out.println("=================");
		
		System.out.println(list);
		
		// contains(Object o) : 해당 리스트에 전달된 객체가 포함이 되어있는지 묻는 메소드 (포함 되어 있다면 true / 아니면 false 반환)
		System.out.println(list.contains(new Music("술이 달다", "에픽하이")));
		
		list.remove(1);
		System.out.println("값 삭제1 : " + list);
		
		// remove(Object o)
		list.remove(new Music("술이 달다", "에픽하이"));
		System.out.println("값 삭제2 : " + list);
		// 문제점 : Music클래스에 equals메소드를 오버라이딩 하지 않아서 부모클래스(Object)에 있는 주소값 비교인 equals메소드가 수행됨
		//        new 연산자로 새로운 주소값을 갖고 있기 때문에 다른 객체로 인식하고 있음
		
		// 조치내용 : Music클래스에 equals메소드를 오버라이딩 할꺼임!!
		//         주소값 비교가 아닌 실제 담긴 필드값 비교로 필드값이 일치하면 true / 아니면 false를 반환하는 내용으로 재정의
		
		
	}

}
