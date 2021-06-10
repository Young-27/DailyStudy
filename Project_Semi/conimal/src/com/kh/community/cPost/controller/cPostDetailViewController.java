package com.kh.community.cPost.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.cPost.model.service.cPostService;
import com.kh.community.cPost.model.vo.Attachment;
import com.kh.community.cPost.model.vo.Cpost;

/**
 * Servlet implementation class cPostDetailViewController
 */
@WebServlet("/detail.cp")
public class cPostDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cPostDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPostNo = Integer.parseInt(request.getParameter("cno"));
		
		cPostService cPostService = new cPostService();
		// 조회수 증가 / 게시글 조회(Board) / 첨부파일 조회 (Attachment)
		int result = cPostService.increaseCount(cPostNo);
		
		if(result>0) { // 유효한 게시글 => 게시글,첨부파일 조회 => 상세조회 페이지
			
			Cpost c = cPostService.selectCpost(cPostNo);
			ArrayList<Attachment> list = new cPostService().selectAttachmentList(cPostNo);
			
			request.setAttribute("c", c);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/community/cPost/cPostDetailView.jsp").forward(request, response);
											
			
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
