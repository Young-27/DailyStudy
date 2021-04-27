package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("잘 실행되나?");
		
		// 요청시 전달된 값들은 request의 parameter영역에 담겨있음
		
		// POST방식 요청인 경우에는 "뽑기 전"에 인코딩 설정 해야됨 (한글값이 포함될 여지가 있을 때)
		request.setCharacterEncoding("UTF-8");
		
		// parameter : 매개변수
		String name = request.getParameter("name"); // "김말똥" / ""
		String gender = request.getParameter("gender"); // "M", "F" / null
		int age = Integer.parseInt(request.getParameter("age")); // "20"=>20 / ""=>NumberFormatException
		String city = request.getParameter("city"); // "서울"
		double height = Double.parseDouble(request.getParameter("height")); // "160"=>160.0
		
		String[] foods = request.getParameterValues("food"); // ["한식", "분식"] / null
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		
		if(foods == null) {
			System.out.println("좋아하는 음식 없음");
		}else {
			System.out.println("foods : " + String.join("-", foods));
		}
		
		// 요청처리 : Service > Dao > sql문
		
		// 위의 요청 처리 다 했다는 가정하에 사용자가 보게될 응답 페이지 출력
		
		// 순수 Servlet : Java 코드 내에 html을 기술
		// JSP(Java Server Page) : html 내에 Java코드를 쓸 수 있는 기술
		
		// 응답 페이지를 만드는 과정을 jsp에게 위임(떠넘김)
		// 이유 : JSP를 사용하지 않으면 서블릿에 번거롭게  html을 작성해야함
		
		// 단, 그 응답하면(jsp)에서 필요로 하는 데이터들은 주섬주섬 담아서 보내줘야 함
		// 주섬주섬 담기위한 공간 => request의 attribute영역 (키-밸류 세트로)
		// request.setAttribute("키",밸류);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
		// 위임시 필요한 객체 : RequestDispatcher
		// 응답하고자 하는 뷰(jsp) 선택하면서 생성
		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		// 포워딩 : 발송 ~
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
