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
 * Servlet implementation class UpdateAnswerController
 */
@WebServlet("/update.ca")
public class UpdateAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnswerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int queNo = Integer.parseInt(request.getParameter("cno"));
		String ansContent = request.getParameter("ansContent");
		
		Customer c = new Customer();	
		c.setQueNo(queNo);
		c.setAnsContent(ansContent);
		
		int result = new CustomerService().updateAnswer(c);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "답변을 등록했습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.ca?cno=" + c.getQueNo());
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
