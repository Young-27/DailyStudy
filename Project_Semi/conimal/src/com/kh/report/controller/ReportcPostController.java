package com.kh.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.report.model.service.ReportService;
import com.kh.report.model.vo.Report;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/report")
public class ReportcPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportcPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 신고 게시글 번호
		int cPostNo = Integer.parseInt(request.getParameter("postNo"));
		// 신고 게시글 유형
		String refType = request.getParameter("refType");
		// 신고자 번호
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		// 신고 유형
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		
		Report r = new Report();
		r.setMemNo(memNo);
		r.setRefNo(cPostNo);
		r.setReportNo(reportNo);
		r.setRefType(refType);
		
		int result = new ReportService().insertReport(r);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "신고 접수가 완료되었습니다");
			response.sendRedirect(request.getContextPath() + "/list.cp?currentPage=1");
		} else {
			request.getSession().setAttribute("errorMsg", "신고 실패!");
			response.sendRedirect(request.getContextPath() + "/list.cp?currentPage=1");
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
