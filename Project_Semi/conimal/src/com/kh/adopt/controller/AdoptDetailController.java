package com.kh.adopt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.adopt.model.service.AdoptService;
import com.kh.adopt.model.vo.Adopt;
import com.kh.adopt.model.vo.Attachment;

/**
 * Servlet implementation class AdoptDetailController
 */
@WebServlet("/detail.ad")
public class AdoptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int adoptNo = Integer.parseInt(request.getParameter("ano"));
	
		AdoptService AdoptService = new AdoptService();
		// 조회 수 증가 
		int result = AdoptService.increaseCount(adoptNo);
	
	
			if(result>0) { // 유효한 게시글 => 게시글,첨부파일 조회 => 상세조회 페이지
				
				Adopt a = AdoptService.selectAdopt(adoptNo);
				ArrayList<Attachment> list = new AdoptService().selectAttachmentList(adoptNo); // null일수도 있지롱
				
				request.setAttribute("a", a);
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("views/adopt/adoptDetailView.jsp").forward(request, response);
												
				
			}else { //에러 페이지
				request.getSession().setAttribute("errorMsg", "자유게시판 상세 조회에 실패했습니다.");
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
