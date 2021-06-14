package com.kh.donation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.donation.model.service.DonationService;
import com.kh.donation.model.vo.Donation;

/**
 * Servlet implementation class DonationDetailController
 */
@WebServlet("/detail.do")
public class DonationDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int doNo = Integer.parseInt(request.getParameter("dno"));
		
		DonationService dService = new DonationService();
		
		int result = dService.increaseCount(doNo);
		
		if(result > 0) {
			
			Donation d = dService.selectDontion(doNo);
			
			request.setAttribute("d", d);
			request.getRequestDispatcher("views/donation/donateDetailView.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errorMsg", "게시글 조회 실패!");
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
