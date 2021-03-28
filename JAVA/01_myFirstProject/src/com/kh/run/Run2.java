package com.kh.run;

import com.kh.first.ValuePrint;

public class Run2 {
	public static void main(String[] args) {
		
		// 다른 클래스에 존재하는 메소드 호출하고 싶을때
		
		// 1) 클래스 생성
		//    클래스 명 대변할이름 = new 클래스명();
		ValuePrint vp = new ValuePrint();
		
		// 2) 해당 클래스에 존재하는 메소드 호출
		//    대변할이름.메소드명();
		
		vp.printValue();
		vp.sumStringNumber();
		
	}
	
	

}
