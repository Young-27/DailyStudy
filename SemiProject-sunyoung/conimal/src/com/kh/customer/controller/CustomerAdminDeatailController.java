package com.kh.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.CustomerService;
import com.kh.customer.model.vo.Customer;

/**
 * Servlet implementation class CustomerAnswerController
 */
@WebServlet("/detail.an")
public class CustomerAdminDeatailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAdminDeatailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int queNo = Integer.parseInt(request.getParameter("cno"));
		
		Customer c = new CustomerService().selectCustomerDetail(queNo);
		request.setAttribute("c", c);
		
		if(c != null) {
			request.getRequestDispatcher("views/integratedManagement/customerDetailView.jsp").forward(request, response);
		}else {
			
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
