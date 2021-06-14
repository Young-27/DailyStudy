package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;


public class MemberService {
	
	/**
	 * 로그인 요청 서비스
	 * @param userId	사용자가 입력했던 아이디값
	 * @param userPwd	사용자가 입력했던 비밀번호값
	 */
	
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		close(conn);
		return m;
	}
	
	/**
	 * 회원가입용 서비스 
	 * @param m		회원가입폼에 작성된 사용자가 입력한 값들이 담겨있는 Member 객체
	 * @return		처리된 행수
	 */
	/*
	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMem = null;
		if(result > 0) {
			commit(conn);
			// 갱신된 회원 객체 다시 조회해오기
			updateMem = new MemberDao().selectMember(conn, m.getUserId());
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}
	
	public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
		
		Member updateMem = null;
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, userId);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
		
	}
	
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	*/
	
	/**
	 * 총 회원 수를 알려주는 메소드
	 * @return 총 회원 수
	 */
	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new MemberDao().selectListCount(conn);
		close(conn);
		return listCount;
	}
	
	/**
	 * 관리자가 회원을 조회하는 창
	 * @return 전체회원
	 */
	public ArrayList<Member> selectMemberList(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectMemberList(pi, conn);
		close(conn);
		return list;
	}
	
	/**
	 * 관리자 회원조회 화면 검색기능
	 * @return 검색내용에 맞는 회원들
	 */
	public ArrayList<Member> searchMemberList(PageInfo pi, String keyword){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().searchMemberList(conn, pi, keyword);
		close(conn);
		return list;
	}
	
	public int imUpdateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().imUpdateMember(conn, m);
		close(conn);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public Member selectMember(int memNo) {
		Connection conn = getConnection();
		Member m = new MemberDao().selectMember(conn, memNo);
		close(conn);
		return m;
	}
	
	public int imDeleteMember(int memNo) {
		Connection conn = getConnection();
		int result = new MemberDao().imDeleteMember(conn, memNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public int searchListCount(String keyword) {
		Connection conn = getConnection();
		int listCount = new MemberDao().searchListCount(conn, keyword);
		close(conn);
		return listCount;
	}
	
	
	
	

}
