package com.kh.donation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.donation.model.service.DonationService;

/**
 * Servlet implementation class DonationApproveController
 */
@WebServlet("/Approve.do")
public class DonationApproveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationApproveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("UTF-8");
		int doNo = Integer.parseInt(request.getParameter("doNo"));
		String admission = request.getParameter("admission");
		
		int result = new DonationService().approveDonation(doNo,admission);		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "승인되었습니다.");
			response.sendRedirect(request.getContextPath() + "/Main.do?currentPage=1");
		} else {
			request.setAttribute("errorMsg", "승인실패");
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
