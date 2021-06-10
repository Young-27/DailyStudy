package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/updateMember.im")
public class ImMemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImMemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int memNo = Integer.parseInt(request.getParameter("mno"));
		String memName = (String)request.getParameter("memName");
		String email = (String)request.getParameter("email");
		String shPhone = (String)request.getParameter("shPhone");
		String shAddress = (String)request.getParameter("shAddress");
		String shAbout = (String)request.getParameter("shAbout");
		int memCode = Integer.parseInt(request.getParameter("memCode"));
		
		Member m = new Member();
		m.setMemNo(memNo);
		m.setMemName(memName);
		m.setEmail(email);
		m.setMemCode(memCode);
		if(memCode == 2) {
			m.setShPhone(shPhone);
			m.setShAddress(shAddress);
			m.setShAbout(shAbout);
		}
		
		int result = new MemberService().imUpdateMember(m);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "정보 수정이 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.me?mno=" + memNo);
		} else {
			
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
