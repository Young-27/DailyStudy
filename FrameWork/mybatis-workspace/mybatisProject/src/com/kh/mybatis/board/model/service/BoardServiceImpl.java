package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		int result = bDao.increaseCount(sqlSession, boardNo);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
