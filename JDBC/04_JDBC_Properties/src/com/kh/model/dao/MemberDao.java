package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Member;

public class MemberDao {
	
	/*
	 * 	기존의 방식 : DAO 클래스에 사용자가 요청할때마다 실행해야되는 sql문을 자바소스코드내에 명시적으로 작성함 => 정적코딩방식
	 * 	 > 문제점 : sql구문을 수정해야될 경우 자바소스코드를 수정하는 셈 => 수정된 내용을 반영시키고자 한다면 프로그램을 재구동해야함
	 * 
	 * 	 > 해결방식 : SQL문들을 별도로 관리하는 외부 파일(.xml)로 만들어서 실시간으로 이 파일에 기록된 sql문들을
	 * 			       동적으로 읽어들여서 실행 => 동적 코딩 방식
	 */
	private Properties prop = new Properties();
	
	// 사용자가 어떤 서비스 요청 할 때 마다 new MemberDao().xxx(); 호출
	// 즉, 서비스 요청 할 때 마다 이 기본생성자가 매번 실행됨!!
	public MemberDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int inserMember(Connection conn, Member m) {
		// insert문 => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("inserMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 sql문
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*JDBCTemplate.*/close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Member> selectList(Connection conn) {
		// select문 => ResultSet 객체(여러행) => ArrayList<Member>
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql); // 완성된 sql문
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("userno"),
									rset.getString("userid"),
									rset.getString("userpwd"),
									rset.getString("username"),
									rset.getString("gender"),
									rset.getInt("age"),
									rset.getString("email"),
									rset.getString("phone"),
									rset.getString("address"),
									rset.getString("hobby"),
									rset.getDate("enrolldate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*JDBCTemplate.*/close(rset); // 생성된 역순으로 반납 !!
			/*JDBCTemplate.*/close(pstmt);
		}
		
		return list;
		
	}
	
	public int deleteMember(Connection conn, String userId) {
		// delete문 => 처리된행수
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성 sql문
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	public Member selectByUserId(Connection conn, String userId) {
		
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String sql = prop.getProperty("selectByUserId");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("userno"),
							   rset.getString("userid"),
							   rset.getString("userpwd"),
							   rset.getString("username"),
							   rset.getString("gender"),
							   rset.getInt("age"),
							   rset.getString("email"),
							   rset.getString("phone"),
							   rset.getString("address"),
							   rset.getString("hobby"),
							   rset.getDate("enrolldate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	public ArrayList<Member> selectByUserName(Connection conn, String keyword){
		
		ArrayList<Member> list = new ArrayList<>(); 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectByUserName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("userno"),
									rset.getString("userid"),
									rset.getString("userpwd"),
									rset.getString("username"),
									rset.getString("gender"),
									rset.getInt("age"),
									rset.getString("email"),
									rset.getString("phone"),
									rset.getString("address"),
									rset.getString("hobby"),
									rset.getDate("enrolldate")));
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public int updateMember(Connection conn, String userId, String userPwd, String email, String phone, String address) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userPwd);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Member loginMember(Connection conn, Member m) {
		
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new Member(rset.getInt("userno"),
							   rset.getString("userid"),
							   rset.getString("userpwd"),
							   rset.getString("username"),
							   rset.getString("gender"),
							   rset.getInt("age"),
							   rset.getString("email"),
							   rset.getString("phone"),
							   rset.getString("address"),
							   rset.getString("hobby"),
							   rset.getDate("enrolldate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return loginMember;
		
	}
	
	

}
