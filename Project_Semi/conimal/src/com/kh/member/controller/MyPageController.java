package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/myPage.me")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// url로 직접 요청도 가능하기 때문에
		// 로그인 전 요청 시 => 메인페이지 alert
		// 로그인 후 요청 시 => 마이페이지 포워딩
		HttpSession session = request.getSession();
		// int memNo = Integer.parseInt(request.getParameter("memNo"));
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			
			session.setAttribute("alertMsg", "로그인 후 이용가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
			
		}else { // 로그인 후
			
			if(loginUser.getMemCode() == 2) {
				request.getRequestDispatcher("views/member/shMyPage.jsp").forward(request, response);
			}else if(loginUser.getMemCode() == 3) {
				request.getRequestDispatcher("views/member/myPageModify.jsp").forward(request, response);
			}
			
			
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
