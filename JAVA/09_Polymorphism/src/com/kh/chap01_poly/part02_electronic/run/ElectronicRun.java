package com.kh.chap01_poly.part02_electronic.run;

import com.kh.chap01_poly.part02_electronic.controller.Store2;
import com.kh.chap01_poly.part02_electronic.model.vo.Desktop;
import com.kh.chap01_poly.part02_electronic.model.vo.Electronic;
import com.kh.chap01_poly.part02_electronic.model.vo.NoteBook;
import com.kh.chap01_poly.part02_electronic.model.vo.Tablet;

public class ElectronicRun {

	public static void main(String[] args) {

		
		// 이 클래스는 납품업체라고 생각!
		
		/*
		// 1. 다형성 적용 안했을 경우 (Store1)
		Store1 s1 = new Store1(); // 생성하는 순간 Store1 클래스에 있는 세 개의 필드가 메모리영역에 할당
		
		//s1.desk = new Desktop();
		
		// 저 가게에 새로운 Desktop객체, 새로운 NoteBook객체, 새로운 Tablet 객체 전달!
		s1.insert(new Desktop("Samsung", "데탑", 120000, "Geforce 1080")); 
		s1.insert(new NoteBook("LG", "그램", 2000000, 4));
		s1.insert(new Tablet("애플", "아이패드", 800000, false));
		
		
		// 가게에 있는 제품들의 정보를 조회하기
		Desktop d = s1.selectDesktop();
		NoteBook n = s1.selectNoteBook();
		Tablet t = s1.selectTablet();
		
		System.out.println(d);
		System.out.println(n);
		System.out.println(t);
		*/
		
		// 2. 다형성을 적용 했을 경우 (Store2)
		Store2 s2 = new Store2();
		
		s2.insert(new Desktop("Samsung", "데탑", 120000, "Geforce 1080"), 0); 
		s2.insert(new NoteBook("LG", "그램", 2000000, 4), 1);
		s2.insert(new Tablet("애플", "아이패드", 800000, false), 2);
		
		// 가게에 있는 제품의 정보 조회
		/*
		Desktop d = (Desktop)s2.select(0);
		NoteBook n = (NoteBook)s2.select(1);
		Tablet t = (Tablet)s2.select(2);
		
		System.out.println(d);
		System.out.println(n);
		System.out.println(t);
		*/
		
		Electronic[] arr = s2.select();
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		/*
		 * 	* 다형성의 장점
		 * 	1. 부모타입의 객체배열로 다양한 자식 객체들을 다 받아줄 수 있다.
		 * 		=> 관리하기 수월함
		 * 	2. 메소드 정의시 매개변수에 다형성을 적용하게 되면 메소드 개수를 줄일 수 있다.
		 * 
		 */
		
		
		
		
		
	}

}
