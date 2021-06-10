package com.kh.adopt.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.adopt.model.service.AdoptService;
import com.kh.adopt.model.vo.Adopt;
import com.kh.adopt.model.vo.Attachment;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class AdoptUpdateController
 */
@WebServlet("/update.ad")
public class AdoptUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8"); //POST방식으로 진행하니까 인코딩이 필수 인고지!
		
		// enctype이 multipart/for-data로 잘 전송되었을 때만 전반적인 내용 수행되도록
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1_1. 전송파일 용량 제한 (int maxSize)
			int maxSize = 10 * 1024 * 1024;
			
			// 1_2. 전달된 파일을 저장시킬 서버의 폴더 품리적인 경로 알아내기 (String savePath)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
			// 2. 전달된 파일명 수정 작업후 서버에 업로드 
			// HttpServletRequest = > MultipartRequest
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy());
			
			// 3. 본격적으로 sql문 실행할 때 필요한 값 (요청시 전달값) 뽑기
			
			// 		>> 공통적으로 수행 :Board테이블에 Update
			int AdoptNo = Integer.parseInt(multiRequest.getParameter("ano"));
			String adoptWriter =multiRequest.getParameter("adoptWriter");
			// 보호소 번호 가져와서 담아줘야함
			String memNo = multiRequest.getParameter("memNo");
			String AdoptTitle = multiRequest.getParameter("adoptTitle");
			String AdoptContent = multiRequest.getParameter("content");
			
			Adopt a = new Adopt();
			a.setAdoptNo(AdoptNo);
			a.setAdoptWriter(adoptWriter);
			a.setMemNo(memNo);
			a.setAdoptTitle(AdoptTitle);
			a.setAdoptContent(AdoptContent);
			
			// 새로이 전달된 첨부파일이 있을 경우 필요한 값 뽑기
			Attachment at = null;
			
			//  새로이 전달된 파일이 있었을 경우
			if(multiRequest.getOriginalFileName("reUpfile1") != null) {
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("reUpfile1"));
				at.setChangeName(multiRequest.getFilesystemName("reUpfile1"));
				at.setFilePath("resources/board_upfiles/");
				
				if(multiRequest.getParameter("originFileNo") != null){
					// 새로운 첨부파일이 있고, 기존의 파일이 있었을 경우
					// => Update Attachment
					// 		+ 기존의 파일 고유번호
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					
					// 기존의 첨부파일 삭제 
					new File(savePath + multiRequest.getParameter("originFileName")).delete();
					
				}else {
					// 새로운 첨부파일이 넘어왔지만, 기존의 파일이 없었을 경우
					// => Insert Attachment
					// 		+ 현재 게시글 번호
					at.setRefNo(AdoptNo);
					
				}
			}
		
			int result = new AdoptService().updateAdopt(a,at);
			// case1 : 새로운 첨부파일 X 					 =>b, null				=>Board Update
			// case2 : 새로운 첨부파일 O, 기존 첨부파일 O       =>b, fileNo이 담긴 at 	=> Board Update, Attachment Update
			// case3 : 새로운 첨부파일 O, 기존 첨부파일 X       =>b, refBoardNo이 담긴 at => Board Update, Attachment Insert
			
			if(result > 0) { // 수정 성공 => detail.bo?bno=XX  url 재요청 => 상세조회 페이지
				request.getSession().setAttribute("alertMsg", "성공적으로 수정됐습니다.");
				response.sendRedirect("detail.ad?ano=" +  AdoptNo);
				
				
				
				
			}else { // 수정실패 => 에러페이지
				request.setAttribute("errorMsg","자유게시판 글 수정에 실패했습니다.");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
			
				
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
