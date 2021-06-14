package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		
		
		Member loginUser = new MemberService().loginMember(memId,memPwd);
		
		
	
		/*
		 * * 응답 페이지에 전달할 값이 있을 경우 어딘가에 담아야됨! (담아줄 수 있는 영역 : JSP Scope내장객체 4종류)
		 * 1) application : application에 담은 데이터는 웹 애플리케이션 전역에서 다 꺼내 쓸 수 있음!!
		 * 2) session : session에 담은 데이터는 모든 jsp와 servlet에서 꺼내 쓸 수 있음
		 * 				한번담은 데이터는 내가 직접 지우기 전까지, 서버가 멈추기 전까지, 브라우저가 종료되기 전까지
		 * 				접근해서 꺼내 쓸 수 있음
		 * 3) request : request에 담은 데이터는 해당 request를 포워딩한 응답 jsp에서만 꺼내 쓸 수 있음
		 * 4) page : 해당 jsp페이지에서만 꺼내 쓸 수 있음
		 * 
		 * 공통적으로 데이터를 담고자 한다면 .setAttribute("키", 밸류값) 라고 작성하면 됨
		 *		   데이터를 꺼내고자 한다면 .getAttribute("키", 밸류값)
		 *		   데이터를 지우고자 한다면 .romoveAttribute("키", 밸류값)
		 *
		 */
		
		if(loginUser == null) { //로그인 실패 => 에러 페이지 응답
			request.setAttribute("errorMsg", "로그인 실패했다!");
			// 응답 페이지 jsp에게 위임시 필요한 객체 (RequestDispatcher)
			// 포워드 방식 (응답뷰 지정을 위한) : 해당 경로로 선택된 뷰가 보여질 뿐 url은 절대 변경되지 않음!!
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}else { // 로그인 성공 => index페이지가 보여짐(원래 메인 화면)
			
			// Servlet에서 JSP내장객체인 session에 접근하고자 한다면 우선 세션 객체를 얻어와야됨!
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "성공적으로 로그인됐습니다!");
			
		
			response.sendRedirect(request.getContextPath());
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
