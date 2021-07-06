package com.kh.ajax.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	/*
	@RequestMapping("ajax1.do")
	public void ajaxMethod1(String name, int age) {
		System.out.println(name);
		System.out.println(age);
	}
	*/
	
	/*
	@ResponseBody
	@RequestMapping(value="ajax1.do", produces="text/html")
	public String ajaxMethod1(String name, int age) {
		String responseData = "응답문자열 : " + name + "는 " + age + "살 입니다.";
		return responseData;
	}
	*/
	
	
	// 다수의 응답데이터가 있을 경우
	/*
	@RequestMapping("ajax1.do")
	public void ajaxMethod1(String name, int age, HttpServletResponse response) {
		// 요청처리 했다는 가정하에 데이터 응답
		
		response.setContentType("text/html, charset=utf-8");
		response.getWriter().print(name);
		response.getWriter().print(age);
		// => "이름나이" 형태로 출력은 되나 두 값 모두 뽑아 쓰고 싶다 => json 사용
		
		
		// JSON 형태로 담아서 응답할거임
		// JSONObject => {속성명:속성값, 속성명:속성값, ...}
		// JSONArray  => [값, 값, 값, ..]
		JSONArray jArr = new JSONArray();
		jArr.add(name); // ["홍길동"]
		jArr.add(age);  // ["홍길동", 20]
		
		response.setContentType("application/json; charset=utf-8");
		try {
			response.getWriter().print(jArr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	
	/*
	// jsonObject 사용
	@RequestMapping("ajax1.do")
	public void ajaxMethod1(String name, int age, HttpServletResponse response) {
		// 요청처리 했다는 가정하에 데이터 응답
		
		// JSON 형태로 담아서 응답할거임
		// JSONObject => {속성명:속성값, 속성명:속성값, ...}
		// JSONArray  => [값, 값, 값, ..]
		JSONObject jObj = new JSONObject(); // {}
		jObj.put("name", name);	// {name:"홍길동"}
		jObj.put("age", age);	// {name:"홍길동", age:20}
		
		response.setContentType("application/json; charset=utf-8");
		try {
			response.getWriter().print(jObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	*/
	
	@ResponseBody
	@RequestMapping(value="ajax1.do", produces="application/json; charset=utf-8")
	public String ajaxMethod1(String name, int age) {
		// 요청처리 했다는 가정하에 데이터 응답
		
		// JSON 형태로 담아서 응답할거임
		// JSONObject => {속성명:속성값, 속성명:속성값, ...}
		// JSONArray  => [값, 값, 값, ..]
		JSONObject jObj = new JSONObject(); // {}
		jObj.put("name", name);	// {name:"홍길동"}
		jObj.put("age", age);	// {name:"홍길동", age:20}
		
		return jObj.toJSONString(); // '{name:"홍길동", age:20}'
	}
	
	
}
