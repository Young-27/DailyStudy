package com.kh.chap05_constructor.run;

import com.kh.chap05_constructor.model.vo.User;

public class ConstructorRun {

	public static void main(String[] args) {
		
		// 1. 기본생성자로 객체 생성 후 setter메소드로 각 필드 초기화
		User u1 = new User();
		u1.setUserId("user01");
		u1.setUserPwd("pass01");
		u1.setUserName("강개순");
		// age, gender 필드값에는 JVM이 초기화한 값이 여전히 담겨있음!
				
		System.out.println(u1.information());
		
		// 2. 매개변수 3개짜리 생성자로 객체생성 (객체 생성과 동시에 각 필드에 값 초기화)
		User u2 = new User("user02", "pass02", "홍길동");
		
		System.out.println(u2.information());
		
		u2.setAge(40);
		u2.setGender('남');
		
		u2.setUserPwd("passpass02");
		
		System.out.println(u2.information());
		
		// 3. 매개변수 5개짜리 생성자로 객체 생성
		User u3 = new User("user03", "pass03", "강보람", 19, '여');
		System.out.println(u3.information());
	}

}
