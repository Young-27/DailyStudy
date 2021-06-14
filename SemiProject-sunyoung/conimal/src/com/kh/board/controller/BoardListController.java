package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.adopt.model.vo.Adopt;
import com.kh.animal.model.vo.Animal;
import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.c_post.model.vo.C_Post;
import com.kh.common.model.vo.PageInfo;
import com.kh.donation.model.vo.Donation;
import com.kh.member.model.service.MemberService;
import com.kh.volunteer.model.vo.Volunteer;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ----------------------------------------- *페이징처리 --------------------------------------
		int listCount;		// 총 회원 수
		int currentPage;	// 현재 페이지
		int pageLimit;		// 페이징바의 최대 개수
		int boardLimit;		// 한 페이지에 보여질 회원 최대 개수
		
		int maxPage;		// 가장 마지막 페이지 (총 페이지 수)
		int startPage;		// 페이징바의 시작 수
		int endPage;		// 페이징바의 끝 수
		
		listCount = new BoardService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 15;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
				
		// ---------------------------------------------------------------------------------------
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<Board> list = new BoardService().selectBoardList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		
		if(list!=null) { // 성공
			request.getRequestDispatcher("views/integratedManagement/boardListView.jsp").forward(request, response);
		} else {
			
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
