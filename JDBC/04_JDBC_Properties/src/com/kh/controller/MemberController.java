package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {

	/**
	 * 사용자의 회원추가 요청시 요청을 처리해주는 메소드
	 * @param userId ~ hobby  사용자가 입력했던 추가할 회원 데이터
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender, String age, String email,
			String phone, String address, String hobby) {
		
		Member m = new Member(userId, userPwd, userName, gender, Integer.parseInt(age), email, phone, address, hobby);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) { // 성공했을경우
			new MemberMenu().displaySuccess("성공적으로 회원 추가되었습니다.");
			
		} else { // 실패했을경우
			new MemberMenu().displayFail("회원 추가에 실패했습니다.");
		}
		
	}
	
	/**
	 * 사용자의 회원전체조회 요청시 요청을 처리해주는 메소드
	 */
	public void selectList() {
		
		ArrayList<Member> list = new MemberService().selectList();
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("조회 결과가 없습니다.");
		} else {
			new MemberMenu().displayMemberList(list);
		}
		
	}
	
	
	/**
	 * 사용자의 회원 아이디로 검색 요청시 요청처리해주는 메소드
	 * @param userId  검색할 회원의 아이디
	 */
	public void selectByUserId(String userId) {
		
		Member m = new MemberService().selectByUserId(userId);
		
		if(m == null) {
			new MemberMenu().displayFail(userId + "에 대한 검색결과가 없습니다.");
		} else {
			new MemberMenu().displayMember(m);
		}
		
	}

	/**
	 * 사용자의 회원 이름으로 키워드 검색 요청시 요청처리해주는 메소드
	 * @param keyword  사용자가 입력한 검색할 회원명의 키워드
	 */
	public void selectByUserName(String keyword) {
		
		ArrayList<Member> list = new MemberService().selectByUserName(keyword);
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData(keyword + "에 대한 조회결과가 없습니다.");
		}else {
			new MemberMenu().displayMemberList(list);
		}
		
	}

	/**
	 * 사용자의 정보변경 요청시 요청처리해주는 메소드
	 * @param userId 			변경하고자하는 회원아이디
	 * @param userPwd ~ address 변경할 정보들(비번,이메일,전화번호,주소)
	 */
	public void updateMember(String userId, String userPwd, String email, String phone, String address) {
		
		int result = new MemberService().updateMember(userId, userPwd, email, phone, address);
		
		if(result > 0) {
			new MemberMenu().displaySuccess(userId + "에 대한 정보 변경을 성공했습니다.");
		} else {
			new MemberMenu().displayFail("정보 변경을 실패했습니다.");
		}
		
	}

	/**
	 * 사용자의 회원탈퇴 요청시 요청처리해주는 메소드
	 * @param inputMemberId		사용자가입력한 탈퇴할 아이디
	 */
	public void deleteMember(String userId) {
		
		int result = new MemberService().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 탈퇴 성공 !!");
		} else {
			new MemberMenu().displayFail("회원 탈퇴에 실패했습니다.");
		}
		
	}

	/**
	 * 사용자의 로그인 요청시 요청처리해주는 메소드
	 * @param userId	사용자가 입력한 회원 아이디
	 * @param userPwd	사용자가 입력한 회원 비밀번호
	 */
	public void loginMember(String userId, String userPwd) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		Member loginMember = new MemberService().loginMember(m);
		
		if(loginMember == null) {
			new MemberMenu().displayFail("로그인 실패");
		}else {
			new MemberMenu().displaySuccess("로그인 성공");
		}
		
	}

	



	
	
	
	

}
