package com.kh.community.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.notice.model.service.NoticeService;
import com.kh.community.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteController
 */
@WebServlet("/insert.no")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		//int userNo = Integer.parseInt(request.getParameter("userNo"));
		String noticeTitle = request.getParameter("title");
		String noticeContent=request.getParameter("content");
		
		Notice n = new Notice();
		n.setNoticeMem(1);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		int result = new NoticeService().insertNotice(n);
		
				
		request.getRequestDispatcher("/Main.no?currentPage=1").forward(request,response);
			
						
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
