package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.shelter.model.vo.Shelter;


public class MemberService {
	
	//로그인 요청 서비스
	public Member loginMember(String memId, String memPwd) {
		Connection conn =getConnection();
		Member m = new MemberDao().loginMember(conn,memId,memPwd);
		
		close(conn);
		return m;
	}

	
	/**사용자
	 * 회원가입용 서비스 
	 * @param m		회원가입폼에 작성된 사용자가 입력한 값들이 담겨있는 Member 객체
	 * @return		처리된 행수
	 */
	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		int count = new MemberDao().idCheck(conn, checkId);
		close(conn);
		
		return count;
	}
	
	// ID찾기용 Service구문
	public Member searchMember(String memName, String email) {
		Connection conn =getConnection();
		Member m = new MemberDao().searchMember(conn,memName, email);
		
		close(conn);
		return m;
	}


	
	// PWD찾기용 Service구문
	public Member searchPwdMember(String memName, String email, String memId) {
		Connection conn =getConnection();
		Member m = new MemberDao().searchPwdMember(conn,memName, email, memId);
			
		close(conn);
		return m;
	}

	/**
	 * 보호소 회원가입용 서비스
	 * @param m
	 * @return
	 */
	public int insertSh(Member m) {
		
		Connection conn = getConnection();
		int result = new MemberDao().insertSh(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	/**
	 * 보호소 마이페이지 정보수정
	 * @param m
	 * @return
	 */
	public int updateMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, m);			
		
		if(result > 0) {
			commit(conn);
			// 갱신된 회원 객체 다시 조회해오기
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 보호소 비밀번호번경 서비스
	 * @param memId
	 * @param memPwd
	 * @param updatePwd
	 * @return
	 */
	public Member updatePwdMember(String memId, String memPwd, String updatePwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updatePwdMember(conn, memId, memPwd, updatePwd);
		
		Member updateMem = null;
		if(result > 0) {
			commit(conn);
			// 갱신된 회원 객체 다시 조회해오기(이미 있는 기능 호출하기)
			updateMem = new MemberDao().selectMember1(conn, memId);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
		
	}
	

	

	
	// 비밀번호 변경 서비스
	public int changePwdMember(Member m) {
		
		Connection conn = getConnection();
		int result = new MemberDao().changePwdMember(conn, m);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
		
	/**
	 * 보호소/사용자 회원 탈퇴 메소드
	 * @param memId
	 * @param memPwd
	 * @return
	 */
	public int deleteMember(String memId, String memPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, memId, memPwd);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

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
		int result2 = 1;
		if(m.getMemCode()==2) {
			result2 = new MemberDao().imUpdateShelter(conn, m);
		}
		close(conn);
		if(result*result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result*result2;
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
