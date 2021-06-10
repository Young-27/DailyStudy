package com.kh.adopt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.adopt.model.service.AdoptService;
import com.kh.adopt.model.vo.Adopt;
import com.kh.adopt.model.vo.Attachment;

/**
 * Servlet implementation class AdoptUpdateFormController
 */
@WebServlet("/updateForm.ad")
public class AdoptUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int AdoptNo = Integer.parseInt(request.getParameter("ano"));
		Adopt a = new AdoptService().selectAdopt(AdoptNo); // 번호, 카테고리명, 제목, 내용, 작성자 아이디, 작성일
		Attachment at = new AdoptService().selectAttachment(AdoptNo); // null/ 번호, 원본명, 수정명, 저장경로
		
		
		request.setAttribute("a", a);
		request.setAttribute("at", at);
	
		request.getRequestDispatcher("views/adopt/adoptUpdateForm.jsp").forward(request, response);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
