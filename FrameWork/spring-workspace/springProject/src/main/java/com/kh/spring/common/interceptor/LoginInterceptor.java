package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	/*
	 *  * Interceptor(정확히는 HandlerInterceptor)
	 *  - HandlerInterceptorAdapter를 상속해서 구현
	 *  - 해당 저 클래스에 있는 메소드 오버라이딩 해서 사용
	 *  
	 *  preHandle  (전처리) : DispatcherServlet이 컨트롤러를 호출하기 전에 낚아채는 영역
	 *  postHandle (후처리) : 컨트롤러에서 DispatcherServlet으로 뷰 정보가 리턴되는 순간 낚아채는 영역
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws Exception {
		
		// true 리턴시 => 기존 요청 흐릅대로 해당 controller 제대로 실행
		// false 리턴시 => Controller 실행되지 않음
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) { // 로그인이 되어있지 않을 경우 == 비회원일 경우
			session.setAttribute("alertMsg", "로그인 후 이용가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		return true;
	}
	
}
