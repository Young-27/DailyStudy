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
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 뽑아서 변수 및 객체에 기록하기
		String userId = request.getParameter("userId");		// "아이디"
		String userPwd = request.getParameter("userPwd");	// "비밀번호"
		String userName = request.getParameter("userName");	// "이름"
		String phone = request.getParameter("phone");		// "전화번호" / ""
		String email = request.getParameter("email");		// "이메일"
		String address = request.getParameter("address");	// "주소" / ""
		String[] interestArr = request.getParameterValues("interest");	// ["운동", "요리", ..] / null
		
		// String[] 	 --> String
		// ["운동", "등산"] --> "운동, 등산"
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		// 기본생성자로 생성 후 setter 이용해서 담기 / "아싸리 매개변수생성자 이용해서 담기" => Member클래스에 해당 매개변수생성자 만들기
		Member m = new Member(userId, userPwd, userName, phone, email, address, interest);
		
		// 3) 요청 처리 (서비스 메소드 호출 및 결과 받기)
		int result = new MemberService().insertMember(m);
		
		// 4) 처리 결과를 가지고 사용자가 보게될 응답 뷰 지정
		if(result > 0) { // 성공 => /jsp	  url 재요청 => index.jsp
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
			
			response.sendRedirect(request.getContextPath());
			
		}else { // 실패 => 에러페이지
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
