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
import com.kh.shelter.model.vo.Shelter;

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
	
	// 로그인 요청 서비스
	
	public Member loginMember(Connection conn, String memId, String memPwd) {
		// select문 => ResultSet 객체 (한행) => Member객체 
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 sql문
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memPwd);
			
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
	
	/**사용자 
	 * 회원가입용 서비스
	 */
		public int insertMember(Connection conn, Member m) {
			// insert문 => 처리된 행수 
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("insertMember");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getMemId());
				pstmt.setString(2, m.getMemPwd());
				pstmt.setString(3, m.getMemName());
				pstmt.setString(4, m.getEmail());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
	
	public int idCheck(Connection conn, String checkId) {
		// select문 => ResultSet(숫자 하나로 받아줘야함)
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

	/**
	 * ID찾기 용 DAO
	 */
	public Member searchMember(Connection conn, String memName, String email) {
			
			Member m = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("searchMember");
			
			try {
				pstmt = conn.prepareStatement(sql); // 미완성된 sql문
				
				pstmt.setString(1, memName);
				pstmt.setString(2, email);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					m= new Member(rset.getInt("mem_no"),
								  rset.getString("mem_id"),
								  rset.getString("mem_pwd"),
								  rset.getString("mem_name"),
								  rset.getString("email"),
								  rset.getDate("enroll_date"),
								  rset.getString("status"),
								  rset.getInt("mem_code")); // 값이 있어야 맴버 객체를 생성함
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
				
			}
			
			return m;
					
		}
	
	/**
	 * PWD찾기용 DAO
	 */
	public Member searchPwdMember(Connection conn, String memName, String email, String memId) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchPwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 sql문
			
			pstmt.setString(1, memName);
			pstmt.setString(2, email);
			pstmt.setString(3, memId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m= new Member(rset.getInt("mem_no"),
							  rset.getString("mem_id"),
							  rset.getString("mem_pwd"),
							  rset.getString("mem_name"),
							  rset.getString("email"),
							  rset.getDate("enroll_date"),
							  rset.getString("status"),
							  rset.getInt("mem_code")); // 값이 있어야 맴버 객체를 생성함
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		return m;
				
	}
	
	/**
	 * 보호소 회원가입용
	 * @param conn
	 * @param m
	 * @return
	 */
	public int insertSh(Connection conn, Member m) {
		// insert문 => 처리된 행수 
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertSh");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPwd());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getEmail());
			pstmt.setInt(5, m.getMemCode());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	/**비밀번호 변경 DAO
	 */
	public int changePwdMember(Connection conn, Member m) {
		// insert문 => 처리된 행수 
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("changePwdMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemPwd());
			pstmt.setInt(2, m.getMemNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
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
	public int updateMember(Connection conn, Member m) {
		// update문 => 처리된 행 수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getMemId());
		
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
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
			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getEmail());
			pstmt.setInt(3, m.getMemNo());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int imUpdateShelter(Connection conn, Member m) {
		// update문 => int result
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("imUpdateShelter");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getShPhone());
			pstmt.setString(2, m.getShAddress());
			pstmt.setString(3, m.getShAbout());
			pstmt.setInt(4, m.getMemNo());
			
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
	
	public Member selectMember1(Connection conn, String memId) {
		// select문 한 행 조회 => ResultSet
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMember1");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
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
	
/**
	 * 보호소 마이페이지 정보수정(아이디조회)
	 * @param conn
	 * @param memId
	 * @return
	 */
	public Member selectMember(Connection conn, String memNo) {
		// select문 => ResultSet 객체(한행)
		Member updateMem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				updateMem = new Member(rset.getInt("mem_no"),
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
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return updateMem;
	}
	

	public int updatePwdMember(Connection conn, String memId, String memPwd, String updatePwd) {
		
		/*
		System.out.println("로그인한 회원 아이디 : " + userId);
		System.out.println("기존 비밀번호 : " + userPwd);
		System.out.println("변경할 비밀번호 : " + updatePwd);
		*/
		
		// update문 => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, memId);
			pstmt.setString(3, memPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;		
		
	}
	
	public int deleteMember(Connection conn, String memId, String memPwd) {
		// update문 => 처리된 행 수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertShelter(Connection conn, Member m) {
		
		int result1 = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertShMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPwd());

			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result1;
	}
		
}
