package com.kh.animal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.animal.model.service.AnimalService;
import com.kh.animal.model.vo.Animal;

/**
 * Servlet implementation class AnimalListController
 */
@WebServlet("/list.ao")
public class AnimalListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 보호중인동물 전체 리스트 조회 한 후 조회결과 담아서 응답페이지로 포워딩
		ArrayList<Animal> list = new AnimalService().selectAnimalList();
		
		//System.out.println(list); 잘되는지 먼저 확인
		
		// 응답페이지 : 보호중인동물 리스트 페이지 (animalListView.jsp)
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/animal/animalListView.jsp").forward(request, response);
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
