package com.kh.volunteer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.volunteer.model.service.VolunteerService;
import com.kh.volunteer.model.vo.Volunteer;

/**
 * Servlet implementation class VolunteerDetailController
 */
@WebServlet("/detail.vo")
public class VolunteerDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int volNo = Integer.parseInt(request.getParameter("vno"));
		
		VolunteerService vService = new VolunteerService();
		
		int result = vService.increaseCount(volNo);
		
		if(result > 0) {
			
			Volunteer v = vService.selectVolunteer(volNo);
			
			request.setAttribute("v", v);
			
			request.getRequestDispatcher("views/volunteer/volunteerDetailView.jsp").forward(request, response);
			
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
