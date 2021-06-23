package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {

	// 1. 회원가입용 서비스
	/*public abstract*/ int insertMember(Member m); // abstract 생략해도 추상변수(?) 추상메소드(?)
	
	// 2. 로그인용 서비스
	Member loginMember(Member m);
	
	// 3. 회원정보변경용 서비스
	int updateMember(Member m);
	
	// 4. 회원탈퇴용 서비스
	int deleteMember(String userId);
	
	
	
}
