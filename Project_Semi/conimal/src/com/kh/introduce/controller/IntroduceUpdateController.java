package com.kh.introduce.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.attachment.model.vo.Attachment;
import com.kh.common.MyFileRenamePolicy;
import com.kh.introduce.model.vo.Introduce;
import com.kh.introduce.model.service.IntroduceService;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class IntroduceUpdateController
 */
@WebServlet("/Update.intro")
public class IntroduceUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntroduceUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize=10*1024*1024;			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int introNo= Integer.parseInt(multiRequest.getParameter("introNo"));
			String introTitle = multiRequest.getParameter("introTitle");
			String introContent = multiRequest.getParameter("introContent");
			String refType= "INTRO";
			
			Introduce intro= new Introduce();
			intro.setIntroNo(introNo);
			intro.setIntroTitle(introTitle);
			intro.setIntroContent(introContent);
			intro.setRefType(refType);
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				at = new Attachment();
				at.setRefNo(intro.getIntroNo());
				at.setRefType(intro.getRefType());
				at.setOriginName(multiRequest.getOriginalFileName("upfile")); 
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/board_upfiles/");
				
			}
			
			int result = new IntroduceService().updateIntro(intro, at);
			
			if(result > 0) { // 성공 => list.bo?currentPage=1 재요청 => 리스트페이지
				
				request.getSession().setAttribute("alertMsg", "수정되었습니다.");
				response.sendRedirect(request.getContextPath() + "/Main.intro");
				
			}else { // 실패 => 첨부파일이 있었을 경우 업로드된 파일 찾아서 삭제시킨후 => 에러페이지
				
				if(at != null) {
					// 삭제시키고자하는 파일 객체 생성 => delete메소드 호출
					new File(savePath + at.getChangeName()).delete();
				}
				
				request.setAttribute("errorMsg", "수정실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
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
