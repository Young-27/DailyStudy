package com.kh.animal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.animal.model.service.AnimalService;
import com.kh.animal.model.vo.Bookmark;

/**
 * Servlet implementation class BookmarkController
 */
@WebServlet("/bookmark.an")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookmarkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int anNo = Integer.parseInt(request.getParameter("ano"));
		int memNo = Integer.parseInt(request.getParameter("mno"));
		
		Bookmark bk = new Bookmark();
		bk.setMemNo(memNo);
		bk.setBinfoNo(anNo);
		
		int result = new AnimalService().insertBookMark(bk);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "즐겨찾기에 추가되었습니다");
			response.sendRedirect(request.getContextPath() + "/detail.an?ano=" + anNo);
		} else {
			request.getSession().setAttribute("alertMsg", "즐겨찾기 추가 실패!");
			response.sendRedirect(request.getContextPath() + "/detail.an?ano=" + anNo);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
