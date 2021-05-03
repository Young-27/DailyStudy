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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * < HttpServletRequest 객체와 HttpServletRespone 객체 >
		 * - request : 서버로 요청할때의 정보들이 담겨있음 (요청시 전달값, 요청전송방식 등)
		 * - response : 요청에 대해 응답할때 필요한 객체
		 * 
		 * < Get방식과 Post방식 차이 >
		 * - Get방식 : 사용자가 입력한 값들이 url 노출 o / 데이터 길이제한 o / 대신 즐겨찾기 편리
		 * - Post방식 : 사용자가 입력한 값들이 url 노출 x / 데이터 길이제한 x / 대신 Timeout존재
		 */
		
		// 1) 전달값에 한글이 있을 경우 인코딩 처리해야됨 (Post방식일 경우)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 (request의 parameter영역) 꺼내서 변수 또는 객체에 기록하기
		//	  request.getParameter("키값") : String 밸류값
		//	  request.getParameterValues("키값") : String[] 밸류값들
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 3) 해당 요청을 처리하는 서비스클래스의 메소드 호출 및 결과 받기
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		// 4) 처리된 결과를 가지고 사용자가 보게될 뷰 지정 후 포워딩 또는 url재요청
		//System.out.println(loginUser);
		
		/*
		 * * 응답 페이지에 전달할 값이 있을 경우 어딘가에 담아야됨!! (담아줄 수 있는 JSP Scope내장객체 4종류)
		 * 1) application : application에 담은 데이터는 웹 애플리케이션 전역에서 다 꺼내 쓸 수 있음
		 * 2) session : session에 담은 데이터는 모든 jsp에 servlet에서 꺼내 쓸 수 있음
		 * 				한 번 담은 데이터는 내가 직접 지우기 전까지, 서버가 멈추기 전까지, 브라우저가 종료되기 전까지
		 * 				접근해서 꺼내 쓸 수 있음
		 * 3) request : request에 담은 데이터는 해당 request를 포워딩한 응답 jsp에서만 꺼내 쓸 수 있음 (일회성 느낌)
		 * 4) page : 해당 jsp페이지에서만 꺼내 쓸 수 있음
		 * 
		 * 공통적으로 데이터를 담고자 한다면 .setAttribute("키", 밸류)
		 *   "	     데이터를 꺼내고자 한다면 .getAttribute("키")
		 *   "	     데이터를 지우고자 한다면 .removeAttribute("키")
		 */
		
		if(loginUser == null) { // 로그인 실패 => 에러페이지 응답 
			request.setAttribute("errorMsg", "로그인 실패했습니다.");
			// 응답 페이지 jsp에게 위임시 필요한 객체 (RequestDispatcher)
			// '응답 뷰 지정하는' 포워딩 방식
			// 포워딩 방식 : 해당 경로로 선택된 뷰가 보여질 뿐 url은 절대 변경되지 않음 (요청했을때의 url이 여전히 남아있을 거임)
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
		}else { // 로그인 성공 => index페이지 응답
			
			// Servlet에서 JSP내장객체인 session에 접근하고자 한다면 우선 세션 객체를 얻어와야됨
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			// 1. 포워딩방식 응답뷰 출력하기 
			//    해당 선택된 jsp가 보여질 뿐 url에는 여전히 현재 이 서블릿 매핑값이 남아있을 것
			//    localhost:8888/jsp/login.me
			//RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			//view.forward(request, response);

			// 2. url 재요청방식 (sendRedirect 방식) => response.sendRedirect("요청할 url");
			//	  localhost:8888/jsp
			//response.sendRedirect("/jsp");
			response.sendRedirect(request.getContextPath());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
