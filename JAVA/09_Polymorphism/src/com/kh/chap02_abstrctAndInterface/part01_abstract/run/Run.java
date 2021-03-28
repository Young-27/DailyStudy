package com.kh.chap02_abstrctAndInterface.part01_abstract.run;

import com.kh.chap02_abstrctAndInterface.part01_abstract.model.vo.BasketBall;
import com.kh.chap02_abstrctAndInterface.part01_abstract.model.vo.FootBall;
import com.kh.chap02_abstrctAndInterface.part01_abstract.model.vo.Sports;

public class Run {

	public static void main(String[] args) {
		
		// 미완성된 클래스인 추상클래스를 가지고는 객체생성불가!!
		//Sports s = new Sports();
		
		//Sports s; // 객체 생성이 안될 뿐이지 레퍼런스로는 사용 가능!!
		Sports s = new FootBall(); // 다형성 적용가능
		
		Sports[] arr = new Sports[2];
		arr[0] = new BasketBall();
		arr[1] = new FootBall();
		
		for(int i=0; i<arr.length; i++) {
			arr[i].rule();
		}
		
		/*
		 * 	* 추상클래스 (미완성클래스)
		 * 	- 일반필드 + 일반메소드 [+ 추상메소드]
		 * 		=> 추상메소드를 가진 클래스는 "반드시" 추상클래스로 명시해야됨
		 * 		=> 추상메소드가 굳이 없어도 추상클래스로 명시가능하긴함!
		 * 			=> 개념적 : 클래스 정의시 아직 구체적이지 않다 라는 판단이 들 때 추상클래스로 둘 수 있음
		 * 			       기술적 : 객체 생성이 불가하게끔 하고자 할 때
		 * 
		 * 	- 객체 생성 불가하지만 레퍼런스로는 사용가능 (다형성 개념 적용 가능)
		 * 
		 * 	* 추상메소드 (미완성메소드)
		 * 	- 머리부만 존재하고 몸통부({})가 구현되어 있지 않은 메소드
		 * 	- 추상클래스(추상메소드가 존재하는)를 상속 받은 자식 클래스에서는 반드시 오버라이딩을 통해 구현(implement)해야됨!
		 * 		=> 강제성을 부여하는 개념 (자식 클래스에 강제로 메소드가 만들어지게끔)
		 * 		=> 메소드의 통일감 확보 목적 (***)
		 * 		=> 표준화된 틀을 제공할 목적
		 * 
		 */
		
		// 일반클래스를 상속 -----------------> 추상메소드가 존재하는 추상클래스를 상속
		// 오버라이딩 선택적			추상메소드는 반드시 오버라이딩 + 일반메소드는 선택적으로 오버라이딩
		//			    강제성이 짙어짐
		
	}

}
