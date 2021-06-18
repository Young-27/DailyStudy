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
 * Servlet implementation class deleteMemberServlet
 */
@WebServlet("/delete.me")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 로그인 회원 정보 가져오기
		// 2_1. input type="hidden"으로 애초에 요청시 숨겨서 전달하기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 2_2. session영역에 담겨있는 회원객체로부터 뽑기
		// userId를 hidden 속성 주지 않고 가져오는 방법
		// String userId = ((Member)session.getAttribute("loginUser").getUserId());
		
		// 3. 전달
		int result = new MemberService().deleteMember(userId, userPwd);
		// 4. 사용자가 보게될 응답뷰
		HttpSession session = request.getSession();	
		if(result > 0) { // 탈퇴성공
			
			session.setAttribute("alertMsg", "성공적으로 회원탈퇴 되었습니다. 그동안 이용해주셔서 감사합니다."); // 탈퇴는 되는데 왜 안뜨지..
			session.removeAttribute("loginUser"); // remove !!! remove 알림창 안해서 안뜨는 거였어.. 
			
			// 응답페이지 (로그아웃된 메인페이지)
			response.sendRedirect(request.getContextPath());
			

		}else { // 탈퇴실패
			
			request.setAttribute("errorMsg", "회원탈퇴 실패");
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
