package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/* 기존 JDBC
	public static Connection getConnection() {
		// driver클래스경로, 어떤url에 어떤 계정에 접속할껀지 계정 정보 => driver.properties
		// 파일 읽어들여서 db와 접속된 Connection 객체 생성
	}
	*/
	
	// 마이바티스
	public static SqlSession getSqlSession() {
		
		// driver클래스경로, 어떤url에 어떤 계정에 접속할껀지 계정 정보 => 환경설정파일 mybatis-config.xml
		SqlSession sqlSession = null;
		
		try {
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
		
	}
	
	
	/*
	public static void close(JDBC용 객체) {
		
	}
	
	public static void commit(Conenction conn) {
		
	}
	
	public static void rollback(Connection conn) {
		
	}
	*/
}
