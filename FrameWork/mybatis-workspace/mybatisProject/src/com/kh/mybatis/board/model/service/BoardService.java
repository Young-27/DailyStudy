package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {

	// 1. 게시글 리스트 조회시
	// 1_1. 게시글 총 개수 조회용 서비스
	int selectListCount();
	// 1_2. 사용자가 요청한 페이지에 보여질 게시글 리스트 조회용 서비스
	ArrayList<Board> selectList(PageInfo pi);
	
	// 2. 게시글 상세조회시
	// 2_1. 게시글 조회수 증가용 서비스
	int increaseCount(int boardNo);
	// 2_2. 해당 게시글 조회용 서비스
	Board selectBoard(int boardNo);
	// 2_3. 해당 게시글에 딸린 댓글리스트 조회용 서비스
	ArrayList<Reply> selectReplyList(int boardNo);
	
	
}
