package com.kh.chap02_encapsulation.run;

import com.kh.chap02_encapsulation.model.vo.Student;

public class Run {
	
	/*
	 * 7.	캡슐화과정을 통해 완벽한 클래스의 형태를 갖추게끔 하자!
	 * 
	 * 		캡슐화 하지 않으면 : 외부로부터 직접접근이 가능하기 때문에 함부로 값이 변질되거나 조회를 막지못하는 문제
	 * 		=> 캡슐화 작업해야됨!
	 * 		   - 객체지향 설계원칙 중 정보은닉 기술 중에 일부가 캡슐화!
	 * 		   - "데이터의 접근 제한"을 원칙으로 하여 외부로부터 "직접 접근을 막자"
	 * 			  단, 대신에 간접적으로나마 처리(값 대입, 조회)할 수 있는 메소드들을 클래스 내부에 작성해서 관리
	 * 		
	 * 		1) 정보은닉 : private
	 * 		       필드들을 외부로부터 직접 접근을 막기 위해 public 대신에 private 접근제한자 사용
	 * 		
	 * 			ex) 학생들이 본인의 성적을 함부로 바꿀수 없게, 다른학생의 성적이 조회되지도 않도록
	 * 
	 * 		2) setter/getter 메소드
	 * 			간접적으로나마 접근해서 값을 담거나 (변경한다거나) 그 값을 가져올 수 있는 메소드가 setter/getter 메소드
	 * 			
	 * 			ex) 선생님은 학생의 성적을 기록하거나 조회할 수 있는 권한이 있다!
	 * 		
	 * 
	 */
	
	public static void main(String[] args) {

		Student hong = new Student(); // 객체생성 == 인스턴스화
		
		/*
		hong.name = "홍길동";
		hong.age = 20;
		hong.height = 162.3;
		*/
		// 위와 같이 직접접근 불가해짐!!
		// 직접 접근을 막았다면 간접적으로나마 접근할 수 있도록 해두자. (메소드로!)
		
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setHeight(162.3);
		
		System.out.println(hong.getName());
		System.out.println(hong.getAge());
		System.out.println(hong.getHeight());
		
		// xxx님의 나이는 xx살이고, 키는 xxxcm입니다.
		System.out.println(hong.getName() + "님의 나이는 " + hong.getAge() + "살이고, 키는 " + hong.getHeight() + "cm입니다.");
		

		// 김말똥, 21, 180.3 학생 객체를 만드시오
		Student ddong = new Student();
		ddong.setName("김말똥");
		ddong.setAge(21);
		ddong.setHeight(180.3);
		// xxx님의 나이는 xx살이고, 키는 xxxcm입니다. 형식으로 김말똥 학생 정보 출력
		System.out.printf(ddong.information());
		
		
	}
}
	
	
	
