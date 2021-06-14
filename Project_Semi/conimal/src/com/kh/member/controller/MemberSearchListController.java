package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class SearchMemberListController
 */
@WebServlet("/listSearch.me")
public class MemberSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String keyword = (String)request.getParameter("keyword");
		
		// ----------------------------------------- *페이징처리 --------------------------------------
		int listCount;		// 총 회원 수
		int currentPage;	// 현재 페이지
		int pageLimit;		// 페이징바의 최대 개수
		int boardLimit;		// 한 페이지에 보여질 회원 최대 개수
		
		int maxPage;		// 가장 마지막 페이지 (총 페이지 수)
		int startPage;		// 페이징바의 시작 수
		int endPage;		// 페이징바의 끝 수
		
		listCount = new MemberService().searchListCount(keyword);
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
		
		ArrayList<Member> searchList = new MemberService().searchMemberList(pi, keyword);
		request.setAttribute("pi", pi);
		request.setAttribute("searchList", searchList);
		request.setAttribute("keyword", keyword);
		
		if(searchList!=null) { // 성공
			request.getRequestDispatcher("views/integratedManagement/memberSearchListView.jsp").forward(request, response);
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
