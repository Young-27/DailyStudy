package com.kh.donation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.donation.model.service.DonationService;

/**
 * Servlet implementation class DonationReject
 */
@WebServlet("/Reject.do")
public class DonationRejectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationRejectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int doNo = Integer.parseInt(request.getParameter("doNo"));
		
		int result = new DonationService().deleteDonation(doNo);
	
		if(result > 0) { 
		
			request.getSession().setAttribute("alertMsg", "거절 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/Main.do?currentPage=1");			
			
		}
		else {
			request.setAttribute("errorMsg", "삭제실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
