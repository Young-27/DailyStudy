package com.kh.animal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.animal.model.service.AnimalService;
import com.kh.animal.model.vo.Animal;

/**
 * Servlet implementation class DogDetailController
 */
@WebServlet("/detail.an")
public class AnimalDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int animalNo = Integer.parseInt(request.getParameter("ano"));
		
		AnimalService aService = new AnimalService();
		
		int result = aService.increaseCount(animalNo);
		
		if(result > 0) {
			
			Animal a = aService.selectAnimal(animalNo);
			
			request.setAttribute("a", a);
			
			request.getRequestDispatcher("views/animal/animalDetailView.jsp").forward(request, response);
			
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
