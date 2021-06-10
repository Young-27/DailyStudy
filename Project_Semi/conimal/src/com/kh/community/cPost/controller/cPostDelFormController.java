package com.kh.community.cPost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.cPost.model.service.cPostService;

/**
 * Servlet implementation class cPostDelFormController
 */
@WebServlet("/deleteForm.cp")
public class cPostDelFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cPostDelFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int cPostNo = Integer.parseInt(request.getParameter("cno"));
		
		// 게시글/사진/댓글 모두 삭제해줘야함
		int result1 = new cPostService().deleteCpost(cPostNo); //  번호, 카테고리명, 제목, 내용, 작성자 아이디, 작성일
		int result2 = new cPostService().deleteAttachment(cPostNo); // 0(삭제될 행이 없는 경우)/ 삭제된 행 갯수
		int result3 = new cPostService().deleteReply(cPostNo); // 0(삭제된 행이 없는 경우)/ 삭제된 행 갯수
		
		if(result1>0 && result2>=0 && result3>=0 ) {
			request.getSession().setAttribute("alertMsg","게시글이 성공적으로 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.cp?currentPage=1");
			
		}else {
			request.setAttribute("errorMsg","게시글 삭제에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
		
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
