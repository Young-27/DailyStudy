package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	// 마이바티스 방식
	
	public static SqlSession getSqlSession() {
		
		// driver클래스경로, 어떤 url에 어떤 계정에 접속할건지 계정 정보 => 환경설정파일 mybatis-config.xml
		SqlSession sqlSession = null;
		
		try {
			InputStream stream = Resources.getResourceAsStream("/myBatis-config.xml");
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
		
	}
	
	
	
}
