package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		// 마이바티스에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공
		
		// * offset : 조회시 몇 개의 게시글을 건너뛰고 조회할지에 대한 값
		// ex) boardLimit : 5
		
		//								offset			limit
		// currentPage = 1		1~5		"0개"의 게시글 건너뛰고 "5개" 조회
		// currentPage = 2		6~10	"5개"의 게시글 건너뛰고 "5개" 조회
		// currentPage = 3		11~15	"10개"의 게시글 건너뛰고 "5개" 조회
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		// 결과가 여러 행 조회 -> selectList
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		
		return sqlSession.update("boardMapper.increaseCount", boardNo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
