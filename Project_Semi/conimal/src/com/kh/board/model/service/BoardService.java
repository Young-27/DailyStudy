package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;

public class BoardService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new BoardDao().selectListCount(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Board> selectBoardList(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectBoardList(conn, pi);
		close(conn);
		return list;
	}
	
	public int searchListCount(String keyword) {
		Connection conn = getConnection();
		int listCount = new BoardDao().searchListCount(conn, keyword);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Board> searchBoardList(PageInfo pi, String keyword){
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().searchBoardList(conn, pi, keyword);
		close(conn);
		return list;
	}

}