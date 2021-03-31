package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	
	// 1. Connection 객체 생성(DB와 접속) 해서 반환시켜주는 메소드
	public static Connection getConnection() {
		
		/*
		 * 기존의 방식 : jdbc driver구문, 접속할 db의 url, 접속할 계정명/비밀번호들을 자바 소스코드 내에 명시적으로 작성함 => 정적코딩방식
		 * 
		 *  > 문제점 : dbms가 변경이 되었을 경우, 접속할 db의 url 또는 계정명/비번이 변경될 경우 => 자바코드 수정해야됨!!
		 *  		 => 수정된 내용을 반영시키고자 한다면 프로그램을 재구동해야됨!! (프로그램이 비정상적으로 종료됐다가 다시 구동)
		 *  		 => 유지보수에 불편하다 !!
		 *  
		 *  > 해결방식 : db관련된 정보들을 별도로 관리하는 외부 파일(.properties)로 만들어서 관리!!
		 *  		    외부파일로 읽어들여서 반영 시킬거임!! => 동적코딩방식
		 * 
		 */
		
		Connection conn = null;
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
											   prop.getProperty("username"),
											   prop.getProperty("password"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
