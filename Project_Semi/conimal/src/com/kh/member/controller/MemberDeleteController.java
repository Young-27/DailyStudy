package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memPwd = request.getParameter("memPwd");
		
		// 로그인한 회원의 정보를 얻어내는 방법
		// 1. input type="hidden"으로 애초에 요청시 숨겨서 전달하기
		// 2. session영역에 담겨있는 회원객체로부터 뽑기
		HttpSession session = request.getSession();
		String memId = ((Member)session.getAttribute("loginUser")).getMemId();
		
		int result = new MemberService().deleteMember(memId, memPwd);
		
		if(result > 0) { // 성공 => 메인페이지 alert (단, 로그아웃되도록)
			
			session.setAttribute("alertMsg", "성공적으로 회원탈퇴 되었습니다. 그동안 이용해주셔서 감사합니다.");
			session.removeAttribute("loginUser");
			
			response.sendRedirect(request.getContextPath());
			
		}else { // 실패 => 에러페이지 에러문구 출력
			request.setAttribute("errorMsg", "회원탈퇴실패");
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
