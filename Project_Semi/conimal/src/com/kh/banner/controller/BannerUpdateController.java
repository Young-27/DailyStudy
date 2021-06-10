package com.kh.banner.controller;

import java.io.File;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.attachment.model.vo.Attachment;
import com.kh.banner.model.service.BannerService;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BannerUpdateController
 */
@WebServlet("/bannerUpdateController.main")
public class BannerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BannerUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
		
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
						
			
							
				
				if(multiRequest.getOriginalFileName("upfile") != null) {
					
					Attachment at = new Attachment();
					at.setRefNo(1);
					at.setRefType("MAINPAGE");
					at.setOriginName(multiRequest.getOriginalFileName("upfile")); 
					at.setChangeName(multiRequest.getFilesystemName("upfile"));
					at.setFilePath("resources/board_upfiles/");
					
			
			int result = new BannerService().updateBanner(at);
		
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "배너 등록 성공");			
				response.sendRedirect(request.getContextPath());
				
			} else {
				if(at != null) {
					// 삭제시키고자하는 파일 객체 생성 => delete메소드 호출
					new File(savePath + at.getChangeName()).delete();
				}
				request.setAttribute("errorMsg", "게시글 작성 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
			
			
				}
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
