package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String userNo = Integer.toString((((Member)session.getAttribute("loginUser")).getUserNo()));
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		//String noticeWriter = Integer.toString(((Member)session.getAttribute("loginUser")).getUserNo()); // "1"
		
		//Notice n = new Notice(noticeTitle, noticeContent, noticeWriter);
		
		Notice n = new Notice();
		n.setNoticeWriter(userNo);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		//Notice list = new NoticeService().insertNotice(n);
		
		int result = new NoticeService().insertNotice(n);
		
		if(result > 0) { // 성공했을 경우 => /jsp/list.no		url 요청 => 리스트페이지가 보여지게끔
			
			//session.setAttribute("alertMsg", "성공적으로 공지사항이 등록되었습니다.");
			//response.sendRedirect(request.getContextPath() + "/list.no");
			
			request.getSession().setAttribute("alertMsg", "성공적으로 공지사항이 등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.no");
		} else {
			request.setAttribute("errorMsg", "공지사항 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
