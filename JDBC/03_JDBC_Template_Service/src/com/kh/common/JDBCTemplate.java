package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	// 이 클래스의 모든 메소드들 다 static 메소드
	// 싱글톤 패턴 : 메모리 영역에 단 한번만 올라간 것을 재사용하는 개념
	
	// 1. Connection 객체 생성(DB와 접속) 해서 반환시켜주는 메소드
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 전달받은 JDBC용 객체를 반납시켜주는 메소드
	// 2. Connection 객체 전달받아서 반납시켜주는 메소드
	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 3. Statement관련 객체 전달받아서 반납시켜주는 메소드
	public static void close(Statement stmt) { // 다형성 적용 => 이 메소드 수행시 PreparedStatement 객체 반납도 알아서 시켜줌
		
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 4. ResultSet 객체 전달받아서 반납시켜주는 메소드
	public static void close(ResultSet rset) {
		
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 전달받은 Connection객체를 통해 트랜잭션 처리해주는 메소드
	// 5. 전달받은 Connection객체를 통해 commit처리해주는 메소드
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 6. 전달받은 Connection객체를 통해 rollback처리해주는 메소드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
