package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Create Servlet !!
/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("잘 되는거니?...");
		/*
		 * Get방식으로 요청했으면 해당 이 doGet 메소드가 호출됨
		 * 
		 * 첫번째 매개변수인 HttpServletRequest request에는 요청시 전달된 내용들 담김 (사용자가 입력한값, 요청전송방식, 요청한 사용자의 ip등등)
		 * 두번째 매개변수인 HttpServletResponse response는 요청 처리 후 응답을 할 때 사용하는 객체
		 * 
		 * 우선 요청 처리하기 위해 요청시 전달된 값(사용자가 입력한 값)들 뽑기
		 * request의 parameter영역안에 존재 => 키-밸류 세트로 담겨있음!! (name속성값-value값)
		 * 
		 * 따라서 request의 parameter영역으로부터 전달된 데이터 뽑는 메소드
		 * > request.getParameter("키값") : String (그에 해당하는 value값)
		 * > request.getParameterValues("키값") : String[] (그에 해당하는 value값들)
		 */
		
		String name = request.getParameter("name"); // "홍길동" / ""
		String gender = request.getParameter("gender"); // "M" "F" / null
		int age = Integer.parseInt(request.getParameter("age")); // "20" => 20 / "" => NumberFormatException 오류 (빈 문자열을 parseInt하려고 할 때)
		String city = request.getParameter("city"); // "서울"
		double height = Double.parseDouble(request.getParameter("height")); // "160" => 160.0
																			// String => double은 Double.parseDouble 이라는거 .. 전에 배웠다는거 ... ㅠ
		
		// 체크박스와 같이 복수개의 정보를 받을 때는 배열로 받아야됨
		String[] foods = request.getParameterValues("food"); // ["한식", "일식"] / null
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		if(foods == null) {
			System.out.println("foods : 없음");
		}else {
			System.out.println("foods : " + String.join(",", foods)); // 처음봥.. String.join("구분자", 배열)
		}
		
		// 이 뽑아낸 값들을 가지고 요청처리해야됨 (db와 상호작용) => jdbc 때 배웠던 흐름
		// 보통의 흐름 : > Service의 메소드 호출시 뽑은값들 전달 > Dao호출 > DB sql문 실행
		//			<							 <
		/*
		int result = new MemberService().insertMember(name, gender, age, city, height, foods);
		if(result > 0) {
			// 성공
		}else {
			// 실패
		}
		*/
		
		// 위와 같은 요청 처리 다 했다는 가정하에 사용자가 보게될 응답 페이지 만들어서 전달할거임!!
		// 즉, 여기 Java코드 내에 사용자가 보게될 응답 html을 만드는 구문을 작성할거임!
		
		// 장점 : Java코드 내에 작성하기 때문에 반복문이나 조건문, 유용한 메소드 같은걸 활용할 수 있음
		// 단점 : 복잡할 것, 혹시라도 후에 html을 수정하고자 할 때 Java 코드내에서 자바코드를 수정하기
		//		수정된 내용을 다시 반영시키고자 한다면 서버 재실행(리스타트) 해야됨
		
		// * response 객체를 통해 사용자에게 html(응답화면) 전달
		// 1) 이제부터 내가 출력할 내용은 문서형태의 html이고 문자셋은 utf-8이다 라는 걸 지정
		response.setContentType("text/html; charset=UTF-8");
		// 2) 응답하고자 하는 사용자(요청했던 사용자)와의 스트림(클라이언트와의 통로) 생성
		PrintWriter out = response.getWriter();
		// 3) 저 스트림을 통해 응답 html구문을 한줄씩 출력
		out.println("<html>");
		out.println("<head>");
		
		out.println("<style>");
		
		out.println("h2{color:red}");
		out.println("#name{color:orange}");
		out.println("#age{color:yellow}");
		out.println("#city{color:blue}");
		out.println("#height{color:green}");
		out.println("#gender{color:purple}");
		
		out.println("</style>");
		
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h2>개인정보응답화면</h2>");
		
		//out.println("<span id='name'>" + name + "</span>님은");
		out.printf("<span id='name'>%s</span>님은 ", name);
		out.printf("<span id='age'>%d</span>살이며, ", age);
		out.printf("<span id='city'>%s</span>에 살고  ", city);
		out.printf("키는 <span id='height'>%.1f</span>cm이고 ", height);
		out.print("성별은 ");
		if(gender == null) {
			out.print("선택을 안했습니다. <br>");
		}else {
			if(gender.equals("M")) {
				out.print("<span id='gender'>남자</span>입니다. <br>");
			}else {
				out.print("<span id='gender'>여자</span>입니다. <br>");
			}
		}
		
		out.print("좋아하는 음식은 ");
		if(foods == null) {
			out.print("없습니다. <br>");
		}else {
			
			out.print("<ul>");
			for(int i=0; i<foods.length; i++) {
				out.printf("<li>%s</li>", foods[i]);
			}
			out.print("</ul>");
			
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
