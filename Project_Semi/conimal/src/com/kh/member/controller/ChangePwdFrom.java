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
 * Servlet implementation class ChangePwdFrom
 */
@WebServlet("/changePwd.me")
public class ChangePwdFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdFrom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		String memPwd = request.getParameter("newMemPwd");
	
		Member m = new Member(memNo, memPwd);
	
		int result = new MemberService().changePwdMember(m); //insert하고자 하는 내용을 담은 맴버객체 넘겨야지
		
		if(result>0) { 
			
			HttpSession session = request.getSession(); // 서블릿단에서는 바로 접근 불가함
			session.setAttribute("alertMsg","비밀번호가 성공적으로 변경되었습니다.");
			
			response.sendRedirect(request.getContextPath());
			
		}else { // 실패 => 에러페이지
			
			request.setAttribute("errorMsg","비밀번호 변경에 실패했습니다. 다시 시도해주세요.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
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
