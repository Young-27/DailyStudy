package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		/*
		 * sqlSession이 제공하는 메소드를 통해서 sql문을 실행하고 결과를 바로 받음
		 * 결과 = sql문 종류에 맞는 메소드("매퍼의별칭.해당sql문아이디", [해당 그 sql문을 완성시킬 객체]);
		 */
		// xml문서에서 namespace로 별칭, id로 아이디 설정
		
		//int result = sqlSession.insert("member-mapper.insertMember", m);
		//return result;
		return sqlSession.insert("memberMapper.insertMember", m);
		
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
}
