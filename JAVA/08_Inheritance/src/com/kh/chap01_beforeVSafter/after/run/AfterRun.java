package com.kh.chap01_beforeVSafter.after.run;

import com.kh.chap01_beforeVSafter.after.model.vo.Desktop;
import com.kh.chap01_beforeVSafter.after.model.vo.SmartPhone;
import com.kh.chap01_beforeVSafter.after.model.vo.Tv;

public class AfterRun {

	public static void main(String[] args) {
		
		Desktop d = new Desktop("삼성", "d-01", "짱짱데스크탑", 2000000, true);
		SmartPhone s = new SmartPhone("애플", "s-01", "아이뽄", 1300000, "KT");
		Tv t = new Tv("엘지", "t-01", "겁나얇은티비", 2500000, 60);
		
		System.out.println(d.information());
		System.out.println(s.information());
		System.out.println(t.information());
		// 실행하고자 하는 메소드가 자식클래스에 없다면 자동으로 부모클래스에 있는 메소드에 실행
		// 단, 자식클래스에 오버라이딩(부모클래스의 메소드를 재정의)이 되어있을 경우
		// 자식클래스에 있는 오버라이딩 된 메소드가 우선권을 가짐
		
		
		/*
		 * 	* 상속의 장점
		 * 	- 보다 적은 양의 코드로 새로운 클래스 작성 가능
		 * 	- 중복된 코드를 공통적으로 관리하기 때문에 새로운 코드의 추가나 변경에 용이
		 * 		=> 프로그램의 생산성과 유지보수에 크게 기여
		 * 
		 * 	* 상속의 특징
		 * 	- 클래스간의 상속은 다중 상속이 불가능하다. (단일 상속만 가능)
		 *  - 명시되어있진 않지만 모든 클래스(자바에서 이미 제공하고있는 클래스, 내가 만든 클래스)는 Object 클래스의 후손이다.
		 *  	=> Object 클래스에 있는 메소드 쓸 수 있음!!
		 * 		=> Object 클래스에 있는 메소드가 맘에 안들면 오버라이딩을 통해서 재정의를 할 수 있음!!
		 * 
		 */
		
	
		
	}

}
