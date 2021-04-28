package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1) 전달값 중에 한글이 있을 경우 인코딩 처리 (post방식 일때만)
		//request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 뽑기 및 데이터가공처리 => 변수 및 객체 기록
		//	  request.getParameter("키값") : "밸류값" (String)
		//	  request.getParameterValues("키값") : ["밸류값", "밸류값", ..] (String[])
		//				만일 키값이 존재하지 않을 경우 : null 반환
		
		String name = request.getParameter("userName"); 	// "홍길동"
		String phone = request.getParameter("phone");		// "01012341234"
		String address = request.getParameter("address");	// "서울시 강남구 ..."
		String message = request.getParameter("message");	// "요청사항어쩌고~~" / ""
		
		String pizza = request.getParameter("pizza"); // "콤비네이션피자"
		String[] toppings = request.getParameterValues("topping"); // ["", ""] / null
		String[] sides = request.getParameterValues("side"); // ["", ""] / null
		String payment = request.getParameter("payment"); // "card"
		
		// 3) 요청 처리 (보통의 흐름 db에 sql문 실행하러 > Service > Dao)
		int price = 0;
		
		switch(pizza) {
		case "콤비네이션피자" : price += 5000; break;
		case "불고기피자" : price += 8000; break;
		case "하와이안피자" : price += 6000; break;
		case "고구마피자" : 
		case "포테이토피자" : price += 7000; break;
		}
		
		if(toppings != null) { // NullPointerException 방지
			for(int i=0; i<toppings.length; i++) {
				switch(toppings[i]) {
				case "콘크림무스" :
				case "고구마무스" : price += 1500; break;
				case "파인애플토핑" :
				case "치즈토핑" : price += 2000; break;
				case "치즈바이트" :
				case "치즈크러스트" : price += 3000; break;
				}
			}
		}
		
		if(sides != null) {
			for(int i=0; i<sides.length; i++) {
				switch(sides[i]) {
				case "콜라":
				case "사이다": price += 2000; break;
				case "갈릭소스":
				case "핫소스": price += 500; break;
				case "피클":
				case "파마산치즈가루": price += 1000; break;
				}
			}
		}
		
		// 4) 요청처리 후 사용자가 보게될 응답페이지(결제페이지) 만들기 혹은  jsp 위임
		// 응답페이지에 필요한 데이터 담기 > request의 attribute영역
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sides", sides);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		// 응답할뷰(jsp) 선택
		RequestDispatcher view = request.getRequestDispatcher("views/05_pizzaPayment.jsp");
		// 선택된 뷰가 사용자에게 보여지도록 포워딩
		view.forward(request, response);
		
		// 04_pizzaOrderForm.jsp 요청=> 응답 PizzaServlet.java 요청=> 응답 05_pizzaPayment.jsp
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
