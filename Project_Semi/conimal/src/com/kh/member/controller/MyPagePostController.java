package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.donation.model.service.DonationService;
import com.kh.donation.model.vo.Donation;

/**
 * Servlet implementation class MyPagePostController
 */
@WebServlet("/myPagePost.me")
public class MyPagePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPagePostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 작성게시글(후원) 전체리스트 조회한 후 조회결과 담아서 응답페이지로 포워딩
		ArrayList<Donation> list = new DonationService().selectPostList();
		
		// 응답페이지: 작성게시글(후원) 리스트페이지(myPagePostView.jsp)
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/member/myPagePostView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
