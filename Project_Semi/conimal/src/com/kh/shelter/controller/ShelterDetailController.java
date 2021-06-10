package com.kh.shelter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.shelter.model.service.ShelterService;
import com.kh.shelter.model.vo.Shelter;

/**
 * Servlet implementation class ShelterDetailController
 */
@WebServlet("/detail.sh")
public class ShelterDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShelterDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String shelterNo = request.getParameter("sno");
		
		ShelterService sService = new ShelterService();
		
		Shelter s = sService.selectShelter(shelterNo);
		
		request.setAttribute("s", s);
		
		request.getRequestDispatcher("views/shelter/shelterDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
