package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		// select문 => ResultSet 객체 (한 행) => Member객체
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 sql문
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
							   rset.getString("mem_id"),
						       rset.getString("mem_pwd"),
							   rset.getString("mem_name"),
							   rset.getString("email"),
							   rset.getDate("enroll_date"),
							   rset.getString("status"),
							   rset.getInt("mem_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}
	
	/**
	 * @return 총 회원 수
	 */
	public int selectListCount(Connection conn) {
		// 한 행 조회 => listCount에 담기
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	/**
	 * 관리자가 회원을 조회하는 창
	 * @return 전체회원
	 */
	
	public ArrayList<Member> selectMemberList(PageInfo pi, Connection conn){
		// 여러행 조회 => ResultSet
		
		/*
		 *  ex) boardlimit : 10이라는 가정하에
		 *  currentPage = 1  => 시작값 : 1   끝값 : 10
		 *  currentPage = 2	 => 시작값 : 11 끝값 : 20
		 *  currentPage = 3  => 시작값 : 21 끝값 : 30
		 *  
		 *  시작값 = (currentPage - 1) * boardLimit + 1
		 *  끝값 = 시작값 + boardLimit - 1
		 */
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
									rset.getString("mem_id"),
									rset.getString("mem_pwd"),
									rset.getString("mem_name"),
									rset.getString("email"),
									rset.getDate("enroll_date"),
									rset.getString("status"),
									rset.getInt("mem_code")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
	/**
	 * 회원조회 검색기능
	 * @return 검색결과 회원
	 */
	public ArrayList<Member> searchMemberList(Connection conn, PageInfo pi, String keyword){
		// 한행 or 여러행조회 => ResultSet, ArrayList
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchMemberList");
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
									rset.getString("mem_id"),
									rset.getString("mem_pwd"),
									rset.getString("mem_name"),
									rset.getString("email"),
									rset.getDate("enroll_date"),
									rset.getString("status"),
									rset.getInt("mem_code")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	
	
	public int imUpdateMember(Connection conn, Member m) {
		// update문 => int result
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("imUpdateMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getEmail());
			pstmt.setInt(3, m.getUserNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public Member selectMember(Connection conn, int memNo) {
		// select문 한 행 조회 => ResultSet
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
							   rset.getString("mem_id"),
							   rset.getString("mem_pwd"),
							   rset.getString("mem_name"),
							   rset.getString("email"),
							   rset.getDate("enroll_date"),
							   rset.getString("status"),
							   rset.getInt("mem_code"),
							   rset.getString("sh_name"),
							   rset.getString("sh_phone"),
							   rset.getString("sh_address"),
							   rset.getString("sh_about"),
							   rset.getString("admission"),
							   rset.getString("sh_local"),
							   rset.getString("ref_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}
	
	
	public int imDeleteMember(Connection conn, int memNo) {
		// update문 => int result
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("imDeleteMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int searchListCount(Connection conn, String keyword) {
		// 한 행 조회 => listCount에 담기
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	
	
	
	
}
