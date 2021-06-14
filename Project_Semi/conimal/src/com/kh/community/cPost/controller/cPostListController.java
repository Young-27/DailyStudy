package com.kh.community.cPost.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.common.model.vo.PageInfo;
import com.kh.community.cPost.model.service.cPostService;
import com.kh.community.cPost.model.vo.Cpost;

/**
 * Servlet implementation class cPostListController
 */
@WebServlet("/list.cp")
public class cPostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cPostListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	     String keyword =request.getParameter("keyword"); 
	     
	     if(keyword==null) {       
	         keyword="";
	      }
		//------------- 페이징 처리하기-----------------
				int listCount; 		// 현재 총 게시글 갯수 -> count함수를 이용해야겠지! 홀리 기억이 안남 ㅡㅡ
				int currentPage;	// 현재 페이지 (즉, 사용자가 요청한 페이지)
				int pageLimit; 		// 페이지 하단에 보여질  페이징바의 페이지 최대갯수(몇개 단위씩)
				int boardLimit;		// 한 페이지 내에 보여질 게시글 최대갯수(몇개 단위씩)
				
				int maxPage; 		// 가장 마지막 페이지 (총 페이지 수) => 현재 게시글이 총 몇개인지 한 페이지에 몇 개씩 보여줄건지를 계산해서 정해짐
				int startPage; 		// 페이지 하단에 보여질 페이징바의 시작수
				int endPage; 		// 페이지 하단에 보여질 페이징바의 끝수 
			
				// * listCount : 총 게시글 갯수
				listCount = new cPostService().selectListCount(keyword);
						
				// * currentPage : 현재 페이지 (즉, 사용자가 요청한 페이지)
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
						
				// *pageLimit : 하단에 보여질 페이징바의 페이지 최대 갯수 (페이지 목록들 몇개 단위)
				pageLimit = 10;
						
				// *boardLimit : 한 페이지 내에 보여질 게시글 최대 갯수 ( 게시글 몇 개 단위)
				boardLimit = 10;
			
				maxPage =(int) Math.ceil((double)listCount / boardLimit);
				startPage = (currentPage - 1)/pageLimit*pageLimit + 1;
				endPage = startPage + pageLimit -1 ;
				
				if(endPage > maxPage) {
					endPage = maxPage;
				}
				
				// 1. 페이징 바 만들때 필요한 객체임
					PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage, endPage);
						
				// 2. 현재 요청한 페이지 (currentPage)에 보여질 게시글 리스트 조회해오기
					ArrayList<Cpost> list = new cPostService().selectList(keyword, pi);
						
					request.setAttribute("pi", pi);
					request.setAttribute("list",list);
					request.setAttribute("keyword", keyword);
						
					request.getRequestDispatcher("views/community/cPost/cPostMainForm.jsp").forward(request, response);
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
