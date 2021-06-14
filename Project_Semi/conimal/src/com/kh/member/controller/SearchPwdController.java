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
 * Servlet implementation class SearchPwdController
 */
@WebServlet("/searchPwd.me")
public class SearchPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
request.setCharacterEncoding("UTF-8");
		
		String memName = request.getParameter("memName");
		String email = request.getParameter("email");
		String memId = request.getParameter("memId");
		
			//아이디 찾기 위한 
		Member searchPwdUser = new MemberService().searchPwdMember(memName,email,memId);
		if(searchPwdUser == null) {
			request.setAttribute("errorMsg", "PWD 찾기에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}else { // 아이디 찾기에 성공해야 searchUser에 필요한 정보가 담김
			HttpSession session = request.getSession();
			session.setAttribute("searchPwdUser", searchPwdUser);
			session.setAttribute("alertMsg", "PWD찾기에 성공했습니다.");
			
			request.getRequestDispatcher("views/member/changePwdForm.jsp").forward(request, response);
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
