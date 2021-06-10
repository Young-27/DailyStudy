package com.kh.community.cPost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.cPost.model.service.cPostService;
import com.kh.community.cPost.model.vo.Reply;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class cPostReplyInsertController
 */
@WebServlet("/rinsert.cp")
public class cPostReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cPostReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String replyContent = request.getParameter("content");
		int cPostNo = Integer.parseInt(request.getParameter("cno"));
		
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		String cUserName = ((Member)request.getSession().getAttribute("loginUser")).getMemName();
		
		Reply r = new Reply();
		r.setReplyContent(replyContent);
		r.setReNo(cPostNo);
		r.setMemNo(memNo);
		r.setcUserName(cUserName);
	
		int result = new cPostService().insertReply(r);
		
		response.getWriter().print(result);
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
