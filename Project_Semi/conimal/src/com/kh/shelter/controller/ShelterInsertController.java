package com.kh.shelter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.kh.member.model.vo.Member;
import com.kh.shelter.model.service.ShelterService;
import com.kh.shelter.model.vo.Shelter;

/**
 * Servlet implementation class ShelterInsertController
 */
@WebServlet("/insertSh.me")
public class ShelterInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShelterInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) 인코딩 작업 (반드시 먼저 해야됨)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 뽑아서 변수 및 객체에 기록
		String shName = request.getParameter("shName"); //"보호소명"
		String memId = request.getParameter("memId"); // "아이디"
		String memPwd = request.getParameter("memPwd"); //"비밀번호"
		String shPhone = request.getParameter("shPhone"); //"연락처"
		String email = request.getParameter("email"); // "이메일"
		String shAddress = request.getParameter("shAddress"); //"주소"
		String shAbout = request.getParameter("shAbout"); //"소개글"
		String shLocal = request.getParameter("shLocal"); //"지역"
		int memCode =2;
		//  기본 생성자로 생성 후 setter이용해서 담기!
		Member m = new Member(memId, memPwd, shName , email, memCode);
		/*
		int result1 = new MemberService().insertSh(m);
		Member m1 = new MemberService().loginMember(m.getMemId(),m.getMemPwd());
		int shNo = m1.getMemNo();
		*/
		Shelter sh = new Shelter(shName, shPhone, shAddress, shAbout, shLocal);
		
		// 3) 요청처리 (서비스 메소드 호출 및 결과 돌려받기)
		int result = new ShelterService().insertShelter(m, sh);
		
		
		// 4) 처리 결과를 갖고 사용자가 보게될 응답뷰 지정
		if(result>0) { // 성공=> /jsp	 url재요청 => index.jsp
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg","회원가입을 승인중입니다. 승인여부는 연락처로 추후 알려드립니다.");
		 
			response.sendRedirect(request.getContextPath());
			
		}else { // 실패 => 에러페이지
			
			request.setAttribute("errorMsg","회원가입에 실패했습니다.");
			
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
