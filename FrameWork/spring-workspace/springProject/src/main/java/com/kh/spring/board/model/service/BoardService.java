package com.kh.spring.board.model.service;

import java.util.ArrayList;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;

public interface BoardService {
	
	// 1. 게시판 리스트 페이지 조회용 (페이징)
	int selectListCount();
	ArrayList<Board> selectList(PageInfo pi);
	
	// 2. 게시글 작성하기용
	int insertBoard(Board b);
	
	// 3. 게시글 상세조회용
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	
	// 4. 게시글 삭제용
	int deleteBoard(int boardNo);
	
	// 5. 게시글 수정용
	int updateBoard(Board b);
	
	// 6. 댓글리스트 조회용
	ArrayList<Reply> selectReplyList(int boardNo);
	
	// 7. 댓글 작성용
	int insertReply(Reply r);
	
	
}
