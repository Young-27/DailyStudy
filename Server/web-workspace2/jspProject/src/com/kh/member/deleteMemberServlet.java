package com.kh.member;

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
public class deleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMemberServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 객체 가져오기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 3. 전달
		Member delMem = new MemberService().deleteMember(userId, userPwd);
		System.out.println(delMem);
		// 4. 사용자가 보게될 응답뷰
		if(delMem == null) { // 탈퇴실패
			request.setAttribute("errorPage", "회원탈퇴 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);	
		}else { // 탈퇴성공
			
			HttpSession session = request.getSession();	
			
			session.setAttribute("alertMsg", "회원탈퇴에 성공했습니다.");
			session.setAttribute("loginUser", delMem);
			
			// 응답페이지 (로그아웃된 메인페이지)
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
