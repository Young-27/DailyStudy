package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class BoardSearchListController
 */
@WebServlet("/listSearch.bo")
public class BoardSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		
		// ----------------------------------------- *페이징처리 --------------------------------------
		int listCount;		// 총 회원 수
		int currentPage;	// 현재 페이지
		int pageLimit;		// 페이징바의 최대 개수
		int boardLimit;		// 한 페이지에 보여질 회원 최대 개수
		
		int maxPage;		// 가장 마지막 페이지 (총 페이지 수)
		int startPage;		// 페이징바의 시작 수
		int endPage;		// 페이징바의 끝 수
		
		listCount = new BoardService().searchListCount(keyword);
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 15;
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		// ---------------------------------------------------------------------------------------------
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> searchList = new BoardService().searchBoardList(pi, keyword);
		request.setAttribute("pi", pi);
		request.setAttribute("searchList", searchList);
		request.setAttribute("keyword", keyword);
		
		if(searchList!=null) { // 성공
			request.getRequestDispatcher("views/integratedManagement/boardSearchListView.jsp").forward(request, response);
		}else { // 실패
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
