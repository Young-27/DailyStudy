package com.kh.model.service;

// import static => 메소드 호출시 클래스명생략가능
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberService {
	
	public int insertMember(Member m) {
		
		Connection conn = /*JDBCTemplate.*/getConnection();
		
		int result = new MemberDao().inserMember(conn, m);
		
		if(result > 0) {
			/*JDBCTemplate.*/commit(conn);
		}else {
			/*JDBCTemplate.*/rollback(conn);
		}
		
		/*JDBCTemplate.*/close(conn);
		
		return result;
		
	}
	
	public ArrayList<Member> selectList() {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectList(conn);
		
		close(conn);
		
		return list;
		
	}
	
	public int deleteMember(String userId) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId);
				
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
	}
	
	public Member selectByUserId(String userId) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().selectByUserId(conn, userId);	
		
		close(conn);
		
		return m;
		
		
	}
	
	public ArrayList<Member> selectByUserName(String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectByUserName(conn, keyword);
		
		close(conn);
		
		return list;
	}
	
	public int updateMember(String userId, String userPwd, String email, String phone, String address) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, userId, userPwd, email, phone, address);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return m;
		
	}
	
	
	
	
	
	
	
	
	

}
