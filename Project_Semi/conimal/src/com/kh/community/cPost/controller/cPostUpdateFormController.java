package com.kh.community.cPost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.cPost.model.service.cPostService;
import com.kh.community.cPost.model.vo.Attachment;
import com.kh.community.cPost.model.vo.Cpost;

/**
 * Servlet implementation class cPostUpdateFormController
 */
@WebServlet("/updateForm.cp")
public class cPostUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cPostUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cPostNo = Integer.parseInt(request.getParameter("cno"));
		Cpost c = new cPostService().selectCpost(cPostNo); // 번호, 카테고리명, 제목, 내용, 작성자 아이디, 작성일
		Attachment at = new cPostService().selectAttachment(cPostNo); // null/ 번호, 원본명, 수정명, 저장경로
		
		
		request.setAttribute("c", c);
		request.setAttribute("at", at);
	
		request.getRequestDispatcher("views/community/cPost/cPostUpdateForm.jsp").forward(request, response);
		
		
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
