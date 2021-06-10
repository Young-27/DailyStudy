package com.kh.animal.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.animal.model.service.AnimalService;
import com.kh.animal.model.vo.Animal;
import com.kh.attachment.model.vo.Attachment;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class AnimalInsertController
 */
@WebServlet("/insert.ao")
public class AnimalInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024;
			
			// 1_2. 전달된 파일을 저장할 서버의 폴더 경로 알아내기 (String savaPath)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String anTitle = multiRequest.getParameter("title");
			String anPlace = multiRequest.getParameter("place");
			String anDate = multiRequest.getParameter("anDate");
			String anSpecies[] = multiRequest.getParameterValues("animal");
			String anGender[] = multiRequest.getParameterValues("gender");
			String anContent = multiRequest.getParameter("content");
			String memNo = multiRequest.getParameter("memNo");
			
			
			Animal an = new Animal();
			an.setAnTitle(anTitle);
			an.setAnPlace(anPlace);
			an.setAnDate(anDate);
			an.setAnSpecies(anSpecies[0]);
			an.setAnGender(anGender[0]);
			an.setAnContent(anContent);
			an.setMemNo(memNo);
			
			Attachment at = null;
			
			// => 첨부파일이 있었을 경우 원본명 / 첨부파일이 없었을 경우 null
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				at = new Attachment();
				 at.setOriginName(multiRequest.getOriginalFileName("upfile")); // 원본명
				 at.setChangeName(multiRequest.getFilesystemName("upfile")); // 수정명(실제 서버에 업로드되어있는 파일명)
				 at.setFilePath("resources/board_upfiles/");
				 
			 }
			 
			 // 4. 서비스요청
			 int result = new AnimalService().insertAnimal(an, at);
			 
			 if(result > 0) { // 성공 => list.bo?currentPage=1 재요청 => 리스트페이지
				 
				 request.getSession().setAttribute("alertMsg", "게시글 작성 성공!");
				 response.sendRedirect(request.getContextPath() + "/list.dog?currentPage=1");
				 
			 }else { // 실패 => 첨부파일이 있었을 경우 업로드 된 파일 찾아서 삭제시킨 후 => 에러페이지
				 
				 if(at != null) {
					 // 삭제시키고자하는 파일 객체 생성 => delete메소드 호출
					 new File(savePath + at.getChangeName()).delete();
				 }
				 
				 request.setAttribute("errorMsg", "게시글 작성 실패..");
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
