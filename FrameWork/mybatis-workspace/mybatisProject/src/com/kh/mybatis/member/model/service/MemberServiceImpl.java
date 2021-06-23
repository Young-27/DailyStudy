package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mybatis.common.template.Template.getSqlSession;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao mDao = new MemberDao();
	
	@Override
	public int insertMember(Member m) {
		
		SqlSession sqlSession = getSqlSession(); // 이때 mybatis-config.xml 문서 읽어들임 (mapper파일들도 등록됨)
		
		int result = mDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		
		return result;
		
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
