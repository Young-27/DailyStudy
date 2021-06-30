package com.kh.spring.member.model.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {
	
	// 로그인용 서비스
	Member loginMember(Member m);
	
	// 회원가입용 서비스
	int insertMember(Member m);
	
	// 정보수정용 서비스
	int updateMember(Member m);
	
	// 회원탈퇴용 서비스
	int deleteMember(String userId);
	
	// 아이디 중복 체크용 서비스
	int idCheck(String userId);
	
}
