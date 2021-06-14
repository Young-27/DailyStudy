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
import com.kh.shelter.model.service.ShelterService;
import com.kh.shelter.model.vo.Shelter;

/**
 * Servlet implementation class ShMemberUpdateController
 */
@WebServlet("/updatesh.me")
public class ShMemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 요청시 전달값 뽑아서 변수 및 객체에 담기
		String shName = request.getParameter("shName");
		String memId = request.getParameter("memId");
		String shPhone = request.getParameter("shPhone");
		String email = request.getParameter("email");
		String shAddress = request.getParameter("shAddress");
		String shAbout = request.getParameter("shAbout");
		String shLocal = request.getParameter("shLocal");
		String memNo = request.getParameter("memNo");
		
		
		Member m = new Member(memId, email);			
		int result = new MemberService().updateMember(m);

		Shelter sh = new Shelter(shName,shPhone, shAddress, shAbout, shLocal, memNo);
		sh = new ShelterService().updateShelter(sh);
		
		Member m1 = new MemberService().selectMember(Integer.parseInt(memNo));
		System.out.println(m1);
		
		
		// 돌려받은 처리결과 가지고 사용자가 보게될 응답 뷰 지정
		if(result<=0&&sh == null) { // 실패
			request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}else { // 성공
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",m1);			
			session.setAttribute("alertMsg", "성공적으로 회원정보를 수정했습니다");
			
			// 응답페이지 => /jsp/myPage.me url 재요청 => 마이페이지
			response.sendRedirect(request.getContextPath() + "/myPage.me");
			
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
