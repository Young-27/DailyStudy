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
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 뽑아서 변수 및 객체에 기록
		String memId = request.getParameter("userId"); // "아이디"
		String memPwd = request.getParameter("userPwd"); //"비밀번호"
		String memName = request.getParameter("userName"); //"이름"
		String email = request.getParameter("email"); //"이메일" => 취미 끌어오는 거 예시를 보고 뒤에 select의 option값으로 값을 가져오게 하는걸로 바꿔야할듯!
		// 이렇게 합쳐서 받아도 되는거 맞아,,,?
		
		//  기본 생성자로 생성 후 setter이용해서 담기!
		Member m = new Member(memId, memPwd, memName, email);
		
		// 3) 요청처리 (서비스 메소드 호출 및 결과 돌려받기)
		int result = new MemberService().insertMember(m); //insert하고자 하는 내용을 담은 맴버객체 넘겨야지
		
		// 4) 처리 결과를 갖고 사용자가 보게될 응답뷰 지정
		if(result>0) { // 성공=> /jsp	 url재요청 => index.jsp
			
			HttpSession session = request.getSession(); // 서블릿단에서는 바로 접근 불가함
			session.setAttribute("alertMsg","성공적으로 회원가입이 됐습니다.");
			
			response.sendRedirect(request.getContextPath());
			
		}else { // 실패 => 에러페이지
			
			request.setAttribute("errorMsg","회원가입에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			//view선택하고 포워딩 하는 거 잊지 말라구!!!!!!!!!!!!!!
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
