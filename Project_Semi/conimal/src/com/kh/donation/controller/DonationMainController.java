package com.kh.donation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.common.model.vo.PageInfo;
import com.kh.donation.model.service.DonationService;
import com.kh.donation.model.vo.Donation;

/**
 * Servlet implementation class DonationMainController
 */
@WebServlet("/Main.do")
public class DonationMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String keyword =request.getParameter("keyword");		
		if(keyword==null) {		 
			keyword="";
		}
		int listCount; 		 
		int currentPage;	
		int pageLimit;		
		int boardLimit;				
		int maxPage;		
		int startPage;		
		int endPage;	
		
		listCount = new DonationService().selectListCount1(keyword);	
		currentPage = Integer.parseInt(request.getParameter("currentPage"));	
			
		pageLimit = 10;		
		boardLimit = 10;			
		maxPage = (int)Math.ceil((double)listCount / boardLimit);		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;	
		endPage = startPage + pageLimit - 1;	
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);	
		ArrayList<Donation> list = new DonationService().selectDonationList(keyword,pi);
		
		if(list!=null) {
		request.setAttribute("list", list);		
		request.setAttribute("pi", pi);
		request.setAttribute("keyword",keyword);		
		request.getRequestDispatcher("views/donation/donation.jsp").forward(request,response);
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
