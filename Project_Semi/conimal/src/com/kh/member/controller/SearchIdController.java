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
 * Servlet implementation class SearchIdController
 */
@WebServlet("/searchId.me")
public class SearchIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdController() {
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
		
		
			//아이디 찾기 위한 
			Member searchUser = new MemberService().searchMember(memName,email);
			
			if(searchUser == null) {
				request.setAttribute("errorMsg", "ID찾기에 실패했습니다.");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}else { // 아이디 찾기에 성공해야 searchUser에 필요한 정보가 담김
				HttpSession session = request.getSession();
				session.setAttribute("searchUser", searchUser);
				session.setAttribute("alertMsg", "ID찾기에 성공했습니다.");
				
				request.getRequestDispatcher("views/member/searchIdResultFrom.jsp").forward(request, response);
				
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
