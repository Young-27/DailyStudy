package com.kh.chap02_abstrctAndInterface.part02_interface.run;

import com.kh.chap02_abstrctAndInterface.part02_interface.model.vo.Baby;
import com.kh.chap02_abstrctAndInterface.part02_interface.model.vo.Basic;
import com.kh.chap02_abstrctAndInterface.part02_interface.model.vo.Mother;

public class Run {
	
	public static void main(String[] args) {
		
		/*
		//Person = new Person();
		
		Person mom = new Mother("김엄마", 50, 70, "출산");
		Person baby = new Baby("강아기", 3.5, 70);
		
		System.out.println(mom);
		System.out.println(baby);
		
		mom.eat(); // 몸무게 +10  건강도 -5
		baby.eat();	// 몸무게 +3  건강도 +1
		
		mom.sleep(); // 건강도 +10
		baby.sleep(); // 건강도 +3
		
		// 동적바인딩 : 컴파일시점에서는 정적바인딩으로 현재 레퍼런스의 자료형으로 되어있는 클래스의 메소드들 가르키긴함
		//			단, 실행시점(런타임)에서는 각각의 자식클래스에 오버라이딩 된 메소드 알아서 찾아져서 실행됨
		
		System.out.println("==== 다음날 ====");
		
		System.out.println(mom);
		System.out.println(baby);
		
		// 추상클래스 : 일반필드 + 일반메소드 [+ 추상메소드]
		// 인터페이스 : 상수필드 + 추상메소드
		*/
		
		//Basic b = new Basic();
		Basic mom = new Mother("김엄마", 50, 70, "출산");
		Basic baby = new Baby("강아기", 3.5, 70);
		
		System.out.println(mom);
		System.out.println(baby);
		
		mom.eat();
		baby.eat();
		mom.sleep();
		baby.sleep();
		
		System.out.println(mom);
		System.out.println(baby);
		
		
		/*
		 * 
		 * 클래스에서 클래스를 상속 : 		 클래스 extends 클래스 (단일상속)					: 화살표 실선
		 * 클래스에서 인터페이스를 상속 :    클래스 implements 인터페이스, 인터페이스,... (다중상속)  : 화살표 점선
		 * 인터페이스에서 인터페이스를 상속 : 인터페이스 extends 인터페이스, 인터페이스, .. (다중상속)  : 화살표 실선
		 * 
		 * 
		 * 			|         추상클래스			|		인터페이스 
		 * ================================================================
		 *  상속갯수    |         단일 상속				|		 다중 상속
		 * ----------------------------------------------------------------
		 *   키워드     |		  extends			| 	   implements
		 * ----------------------------------------------------------------
		 * 추상메소드   |	      추상메소드 0개 이상			|	 모든 메소드가 추상메소드
		 * 표현법/개수 |	명시적으로 abstract 기술		|	 묵시적으로 abstract(생략가능)
		 * ----------------------------------------------------------------
		 * 일반메소드여부 |			O				|			X
		 * ----------------------------------------------------------------
		 *   필드       |		일반필드 가질수있음			| 상수필드만 가질수있음 (묵시적으로 public static final)
		 * 
		 * 
		 * 
		 * extends 일반클래스 --> extends 추상클래스 --> implements 인터페이스
		 * --------------------------------------------------------->
		 *					 강제성이 더 짙어짐 (규약이 더 쎄짐)
		 * 
		 * 
		 */
		
		
	}
	
}
