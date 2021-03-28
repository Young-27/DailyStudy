package com.kh.chap01_beforeVSafter.before.run;

import com.kh.chap01_beforeVSafter.before.model.vo.Desktop;
import com.kh.chap01_beforeVSafter.before.model.vo.SmartPhone;
import com.kh.chap01_beforeVSafter.before.model.vo.Tv;

public class BeforeRun {

	public static void main(String[] args) {

		// Desktop 객체
		// brand, pCode, pName, price, allInOne
		Desktop d = new Desktop("삼성", "d-01", "짱짱데스크탑", 2000000, true);
		
		// SmartPhone 객체
		// brand, pCode, pName, price, mobileAgency
		SmartPhone s = new SmartPhone("애플", "s-01", "아이폰", 1300000, "KT");
		
		// Tv 객체
		// brand, pCode, pName, price, inch
		Tv t = new Tv("엘지", "t-01", "겁나얇은티비", 3500000, 60);
		
		// 출력
		System.out.println(d.information());
		System.out.println(s.information());
		System.out.println(t.information());
		
		/*
		 * 	매 클래스마다 중복된 코드들을 일일이 기술해두게 되면
		 * 	수정과 같은 유지보수시 매번 일일이 찾아서 수정해야되는 번거로움들이 생김!!
		 * 
		 * 	상속이라는 개념을 적용시켜서
		 * 	매 클래스마다 중복된 필드, 메소드들을 단 한번 또 하나의 클래스(Product)로 정의해둔 후
		 * 	해당 클래스를 가져다 쓰는 식으로 진행!!
		 * 
		 */
		
	}

}
