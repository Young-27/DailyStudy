package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

// DAO(Data Access Object) : DB에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 및 결과 받기 (JDBC)
//							 결과를 Controller로 return
public class MemberDao {
	
	/*
	 * * JDBC용 객체
	 * - Connection : DB의 연결정보를 담는 객체
	 * - [Prepared]Statement : DB에 sql문을 전달해서 실행하고 그 결과를 받아내는 객체
	 * - ResultSet : select문 수행 후 조회된 결과물들이 담길 객체
	 * 
	 * * JDBC 순서
	 * 1) jdbc driver 등록 : 해당 DBMS가 제공하는 클래스 등록
	 * 2) Connection 생성 : 연결하고자 하는 DB정보를 입력해서 해당 DB와 연결하면서 생성
	 * 3) Statement 생성 : Connection 객체를 이용해서 생성 (sql문 실행 및 결과받는 객체)
	 * 4) sql문 전달하면서 실행 : Statement 객체를 이용해서 sql문 실행
	 * 5) 결과 받기 
	 * 		> SELECT문 --> ResultSet객체 (조회된 데이터들이 담겨있음)		=> 6_1)
	 * 		>   DML 문 --> int (처리된 행수)							=> 6_2)
	 * 
	 * 	6_1) ResultSet에 담겨있는 데이터들을 하나씩 하나씩 뽑아서 vo객체에 주섬주섬 옮겨 담기
	 *  6_2) 트랜잭션 처리 (성공이면 commit, 실패면 rollback)
	 *  
	 * 7) 다 사용한 JDBC용 객체들 반드시 자원 반납 (close)	=> 생성된 역순
	 * 
	 */
	
	public int insertMember(Member m) { // insert문 => 처리된 행수 => 트랜잭션 처리
		
		// 필요한 변수들 먼저 셋팅
		int result = 0;	// 처리된 결과(처리된 행수)를 받아줄 변수
		Connection conn = null; // DB의 연결정보를 담는 객체
		Statement stmt = null;	// sql문 전달해서 실행 후 결과 받는 객체
		
		// 실행할 sql문 (완성된형태로 만들어둬야됨!!)
		//INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXX', 'XXX', 'XXX', 'X', XX, 'XXXXX', 'XXXXX', 'XXXXX', 'XXXX', SYSDATE)
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, "
										+ "'" + m.getUserId()   + "', "
										+ "'" + m.getUserPwd()  + "', "
										+ "'" + m.getUserName() + "', "
										+ "'" + m.getGender()   + "', "
											  + m.getAge()      +  ", "
										+ "'" + m.getEmail()    + "', "
										+ "'" + m.getPhone()    + "', "
										+ "'" + m.getAddress()  + "', "
										+ "'" + m.getHobby()    + "', SYSDATE)";
		
		//System.out.println(sql);
		
		
		try {
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성 == DB에 연결 (url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statement 객체 생성 
			stmt = conn.createStatement();
			
			// 4, 5) sql문 전달하면서 실행 후 결과 받기 (처리된 행수)
			result = stmt.executeUpdate(sql);
			
			// 6_2) 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				// 7) 다 쓴 JDBC용 객체 반납 (close) => 생성된 역순
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public ArrayList<Member> selectList() { // select문 => ResultSet객체 (여러행)
		
		// 필요한 변수들 셋팅
		
		// 처리된 결과 (조회된 회원들(여러회원)==여러행)들을 담아줄 ArrayList생성
		ArrayList<Member> list = new ArrayList<>(); // 텅 빈 리스트
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // select문 실행된 조회된 결과값들이 처음에 실질적으로 담길 객체
		
		// 실행할 sql문(완성된 형태로!!)
		String sql = "SELECT * FROM MEMBER";
		
		try {
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2) Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			// 4, 5) sql문 전달해서 실행 후 결과 받기 (ResultSet객체)
			rset = stmt.executeQuery(sql);
			
			// 6_1)
			while(rset.next()) { // 행 커서 움직여주는 역할, 뿐만 아니라 해당 행이 있으면 true 없으면 false반환
				
				// 현재 rset의 커서가 가리키고 있는 한 행의 데이터들을 싹 다 뽑아서 Member객체 담기
				Member m = new Member();
				// rset으로부터 어떤 컬럼에 해당하는 값을 어떤 타입으로 뽑을건지 제시해주면됨!! ( db컬럼명제시!! == 대소문자가리지 않음)
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("userpwd"));
				m.setUserName(rset.getString("username"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enrollDate"));
				// 현재 참조하고 있는 행에 대한 모든 데이터들을 한 Member객체에 담기 끝!
				
				list.add(m); // 리스트에 해당 회원 객체 차곡차곡 담기
				
			}
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 7) 다쓴 JDBC용 객체 반납하기
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	public Member selectByUserId(String userId) { // select문 => ResultSet객체 (한행)
		
		// 필요한 변수들 셋팅
		
		// 처리결과 (조회된 한 회원)
		Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		// 실행할 sql문 (완성된형태로!!)
		// SELECT * FROM MEMBER WHERE USERID = 'XXXX'
		String sql = "SELECT * FROM MEMBER WHERE USERID = '" + userId + "'";
		
		try {
			// 1)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// 3)
			stmt = conn.createStatement();
			// 4, 5)
			rset = stmt.executeQuery(sql);
			// 6_1)
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
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 7)
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
		
	}
	
	public ArrayList<Member> selectByUserName(String keyword) { // select문 => ResultSet객체 (여러행)
		
		ArrayList<Member> list = new ArrayList<>(); // 텅 빈 리스트
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		//SELECT * FROM MEMBER WHERE USERNAME LIKE '%xx%'
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%" + keyword + "%'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				
				// 현재 rset참조하는 한 행 데이터들 => 한 Member객체에 주섬주섬.. => list에 차곡차곡담기
				list.add(new Member(rset.getInt("userno"),
									rset.getString("usErId"),
									rset.getString("userPWd"),
									rset.getString("userName"),
									rset.getString("gender"),
									rset.getInt("age"),
									rset.getString("email"),
									rset.getString("phone"),
									rset.getString("address"),
									rset.getString("hobby"),
									rset.getDate("enrollDate")));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	
	public int updateMember(Member m) { // update문 => 처리된행수(int) => 트랜잭션처리
		
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		// 실행할 sql문(완성된 형태로!!)
		/*
		 * UPDATE MEMBER
			  SET USERPWD = 'XXXX',
			      EMAIL = 'XXXXXX',
			      PHONE = 'XXXXX',
			      ADDRESS = 'XXXX'
			WHERE USERID = 'XXXX'
		 */
		String sql = "UPDATE MEMBER "
					  + "SET USERPWD = '" + m.getUserPwd() + "', "
					  + 	  "EMAIL = '" + m.getEmail()   + "', "
					  +		  "PHONE = '" + m.getPhone()   + "', "
					  +		"ADDRESS = '" + m.getAddress() + "' "
					 + "WHERE USERID = '" + m.getUserId()  + "'";
		
		System.out.println(sql);
		
  
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	
	public int deleteMember(String userId) { // delete문 => 처리된 행수(int) => 트랜잭션처리
		
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = '" + userId + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
		
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	

}






