package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class JqAjaxController
 */
@WebServlet("/jqAjax2.do")
public class JqAjaxController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 요청처리 다 했다는 가정하에 응답할 데이터 (문자열)
		String responseData = "이름 : " + name + ", 나이 : " + age;
		
		response.setContentType("text/html, charset=UTF-8");
		
		// 수업 4교시(~7:30) 다시
		
		// v2. 응답데이터 여러개 응답하기 (JSON을 많이 사용함)
		/*
		 *  JSON (JavaScript Object Notation : 자바스크립트 객체 표기법)
		 *  - ajax 통신시 데이터 전송에 사용되는 포맷형식 중 하나
		 *  
		 *  - 라이브러리 필요 (JAVA에서 JSON쓰고자 한다면)
		 *  - json-simple-1.1.1.jar 다운로드해서 lib파일로 넣기
		 *    => https://code.google.com/archive/p/json-simple/downloads
		 *  
		 *  - JSONArray[value, value, value] / JSONObject{key:value, key:value}
		 *  => 		배열						 / Object 객체에 담기
		 */
		
		/*
		JSONArray jArr = new JSONArray(); // []
		jArr.add(name); // ["홍길동"]
		jArr.add(age); 	// ["홍길동", 10] => 배열 같아 보이지만 하나의 문자열임
		
		// 배열로 만들기 -> contentType 지정!
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jArr);
		*/
		
		JSONObject jobj = new JSONObject(); // {}
		jobj.put("name", name); // {name:"홍길동"}
		jobj.put("age", age);	// {name:"홍길동", age:10}
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jobj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
