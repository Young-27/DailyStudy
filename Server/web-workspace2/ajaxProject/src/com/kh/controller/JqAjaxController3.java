package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.model.vo.Member;

/**
 * Servlet implementation class JqAjaxController3
 */
@WebServlet("/jqAjax3.do")
public class JqAjaxController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxController3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("no"));
		
		//Member m = new MemberService().selectMember(userNo);
		Member m = new Member(1, "박철수", 30, "남");
		
		//response.getWriter().print(m/*.toString()*/); 
		// toString한 결과가 나타남
		
		/* 1. 정석 JSON 사용해서 객체담기 
		// {속성:속성값, 속성:속성값}
		JSONObject jObj = new JSONObject(); 	// {}
		jObj.put("userNo", m.getUserNo());		// {userNo:1}
		jObj.put("userName", m.getUserName());	// {userNo:1, userName:"박철수"}
		jObj.put("age", m.getAge());			// {userNo:1, userName:"박철수", age:30}
		jObj.put("gender", m.getGender());		// {userNo:1, userName:"박철수", age:30, gender: "남"}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jObj);
		*/
		
		// GSON : Google JSON을 뜻함 (gson라이브러리 연동)
		// https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.2
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(m, response.getWriter()); // toJson(응답할객체, 응답할스트림)
		// 위와 같이 응답시 vo객체의 필드명이 객체의 속성명(키값)으로 세팅됨
		// vo객체하나만 응답시 JSONObject{} 형태로 만들어져서 응답
		
		// ArrayList 응답시 JSONArray[] 형태로 만들어져서 응답
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
