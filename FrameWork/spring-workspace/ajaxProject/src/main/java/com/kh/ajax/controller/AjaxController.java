package com.kh.ajax.controller;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.Member;

@Controller
public class AjaxController {
	
	
	
	/*
	 *  1. HttpServletResponse객체로 응답데이터 응답하기 (jsp/servlet 때 했던 Stream을 통해서 응답)
	 */
	/*
	@RequestMapping("ajax1.do")
	public void ajaxMethod1(String name, int age, HttpServletResponse response) throws IOException { // spring이 에러 알아서 처리해주게 떠넘김
		System.out.println(name);
		System.out.println(age);
		
		// 요청처리를 위한 호출
		
		// 요청 처리 다 했다는 가정하에 요청한 그 페이지에 응답할 데이터가 있을 경우?
		String responseData = "응답문자열 : " + name + "는 " + age + "살 입니다.";
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(responseData);
		// getWriter => stream 통로가 만들어진다고 생각하면 됨
	}
	*/
	
	/*
	 *  2. @ResponseBody를 이용한 방식
	 *     응답할 데이터를 문자열로 리턴
	 *     단, 문자열 리턴하면 원래는 포워딩 방식이었음   => 뷰로 인식해서 해당 뷰페이지를 찾을거임
	 *     따라서 내가 리턴하는 문자열이 응답뷰가 아닌 응답데이터야 라는걸 선언하는 어노테이션이 바로 @ResponseBody임!!
	 */
	/*
	@ResponseBody
	@RequestMapping(value="ajax1.do", produces="text/html; charset=utf-8")
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
	
	/*
	@ResponseBody
	@RequestMapping(value="ajax2.do", produces="application/json; charset=utf-8")
	public String ajaxMethod2(int num) {
		
		//Member m = mService.selectMember(num);
		Member m = new Member("user01", "pass01", "홍길동", 20, "01011112222");
		
		JSONObject jObj = new JSONObject();
		jObj.put("userId", m.getUserId());
		jObj.put("userPwd", m.getUserPwd());
		jObj.put("userName", m.getUserName());
		jObj.put("age", m.getAge());
		jObj.put("phone", m.getPhone());
		
		return jObj.toJSONString();
		
	}
	*/
	
	@ResponseBody
	@RequestMapping(value="ajax2.do", produces="application/json; charset=utf-8")
	public String ajaxMethod2(int num) {
		
		//Member m = mService.selectMember(num);
		Member m = new Member("user01", "pass01", "홍길동", 20, "01011112222");
		
		/*
		JSONObject jObj = new JSONObject();
		jObj.put("userId", m.getUserId());
		jObj.put("userPwd", m.getUserPwd());
		jObj.put("userName", m.getUserName());
		jObj.put("age", m.getAge());
		jObj.put("phone", m.getPhone());
		
		return jObj.toJSONString();
		*/
		return new Gson().toJson(m);
		
	}
	
	@ResponseBody
	@RequestMapping(value="ajax3.do", produces="application/json; charset=utf-8")
	public String ajaxMethod3() {
		//ArrayList<Member> list = mService.selectList();
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member("user01", "pass01", "홍길동", 20, "01011112222"));
		list.add(new Member("user02", "pass02", "영이", 22, "01055555555"));
		list.add(new Member("user03", "pass03", "이선", 21, "01032133213"));
		list.add(new Member("user04", "pass04", "이선영", 233, "01045323323"));
		
		// [{}, {}, {}, {}]
		return new Gson().toJson(list);
	}
	
	
	
	
	
	
	
	
}
