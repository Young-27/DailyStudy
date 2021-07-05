package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.Pagination;
import com.sun.xml.internal.ws.api.message.Attachment;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping("list.bo")
	public String selectList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		// currentPage를 전달받지 않고 RequestParam을 이용해서 디폴트값으로 설정함
		
		//System.out.println(currentPage);
		
		int listCount = bService.selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		ArrayList<Board> list = bService.selectList(pi);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		return "board/boardListView";
		
	}
	
	@RequestMapping("search.bo")
	public String searchBoard(Model model, String keyword, String condition, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		
		// 검색 조건과 키워드 HashMap에 담아서 전달
		HashMap map = new HashMap();
		map.put("keyword", keyword);
		map.put("condition", condition);
		
		// 키워드 검색 => 결과 조회, 페이징처리
		int searchListCount = bService.searchListCount(map);
		
		PageInfo pi = Pagination.getPageInfo(searchListCount, currentPage, 10, 5);
		ArrayList<Board> list = bService.searchList(map, pi);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("condition", condition);
		
		return "board/boardListView";
		
	}
	
	@RequestMapping("calendar.bo")
	public String calendar() {
		return "board/calendar";
	}
	
	@RequestMapping("enrollForm.bo")
	public String enrollForm() {
		return "board/boardEnrollForm";
	}
	
	
	// ** 만약 다중파일 업로드기능시?
	//    여러개의 input type="file" 요소에 다 동일한 키값으로 부여 (ex.upfile)
	//    MultipartFile[] upfile로 받으면 됨 (0번 인덱스부터 차곡차곡 담겨있음)
	@RequestMapping("insert.bo")
	public String insertBoard(Board b, MultipartFile upfile, HttpSession session, Model model) {
		//System.out.println(b);
		//System.out.println(upfile.getOriginalFilename());
		
		// 전달된 파일이 있을 경우 => 파일명 수정 작업 후 업로드 => 원본명, 서버업로드된경로 b에 담기
		if(!upfile.getOriginalFilename().equals("")) { // 빈 문자열이 아닐경우 => 파일O
			
			String changeName = saveFile(session, upfile); // 메소드 호출 => "2021070217013023152.jpg"
			b.setOriginName(upfile.getOriginalFilename());
			b.setChangeName("resources/uploadFiles/" + changeName); // "resources/upfiles/2021070217013023152.jpg"
			
		}
		
		int result = bService.insertBoard(b);
		
		if(result > 0) { // 성공 => 게시글 리스트페이지
			session.setAttribute("alertMsg", "성공적으로 게시글이 등록되었습니다.");
			return "redirect:list.bo";
		} else { // 실패 => 에러페이지
			model.addAttribute("errorMsg", "게시글 등록 실패");
			return "common/errorPage";
		}
		
	}
	
	// detail.bo url요청시 실행될 메소드 작성 (요청시 전달값 받아내주기)
	@RequestMapping("detail.bo")
	public String selectDetailBoard(int bno, Model model) {
		// >> 해당 게시글 조회수 증가용 서비스 호출
		//System.out.println(bno);
		int result = bService.increaseCount(bno);
		
		if(result > 0) { // >> 성공적으로 증가시
			// >> 게시글 조회용 서비스 호출
			Board b = bService.selectBoard(bno);
			model.addAttribute("b", b);
			// >> 조회된 결과 담아서 상세조회 페이지 보여지도록
			return "board/boardDetailView";
		} else { // >> 증가 실패시
			// >> 에러문구 담아서 에러페이지 보여지도록
			model.addAttribute("errorMsg", "상세조회실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("delete.bo")
	public String deleteBoard(HttpSession session, Model model, int bno, String filePath) {
		int result = bService.deleteBoard(bno); // service, dao, sql문
		
		if(result > 0) { // 삭제성공
			
			if(!filePath.equals("")) { // 첨부파일이 있을 경우 => 파일 삭제
				String removeFilePath = session.getServletContext().getRealPath(filePath);
				new File(removeFilePath).delete();
			}
			
			session.setAttribute("alertMsg", "게시물이 삭제 되었습니다.");
			return "redirect:list.bo";
		} else {
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("updateForm.bo")
	public String updateForm(int bno, Model model) {
		Board b = bService.selectBoard(bno);
		model.addAttribute("b", b);
		
		// 한줄
		//model.addAttribute("b", bService.selectBoard(bno));
		
		return "board/boardUpdateForm";
	}
	
	
	@RequestMapping("update.bo")
	public String updateBoard(Board b, MultipartFile reupfile, HttpSession session, Model model) {
		
		// 1. 새로 넘어온 첨부파일이 있을 경우
		if(!reupfile.getOriginalFilename().equals("")) {
			// 기존에 첨부파일이 있었을 경우 => 기존의 첨부파일 지우기
			if(b.getOriginName() != null) {
				new File(session.getServletContext().getRealPath(b.getChangeName())).delete();
			}
			
			// 새로 넘어온 첨부파일 서버 업로드 시키기
			String changeName = saveFile(session, reupfile);
			// b에 새로 넘어온 첨부파일에 대한 정보 담기
			b.setOriginName(reupfile.getOriginalFilename());
			b.setChangeName("resources/uploadFiles/" + changeName);
		}
		
		/*
		 *  b에 boardNo, boardTitle, boardContent 무조건 담겨있음
		 *  
		 *  1. 새로 첨부된 파일 x, 기존 첨부 파일 x
		 *     => originName : null , changeName : null
		 *     
		 *  2. 새로 첨부된 파일 x, 기존 첨부 파일 o
		 *     => originName : 기존 첨부파일 원본명, changeName : 기존 첨부파일 수정명
		 *     
		 *  3. 새로 첨부된 파일 o, 기존 첨부 파일 x
		 *     => 새로 전달된 파일 서버에 업로드
		 *     => originName : 새로운 첨부파일 원본명, changeName : 새로운 첨부파일 수정명
		 *     
		 *  4. 새로 첨부된 파일 o, 기존 첨부 파일 o
		 *     => 기존의 파일 삭제
		 *     => 새로 전달된 파일 서버에 업로드
		 *     => originName : 새로운 첨부파일 원본명, changeName : 새로운 첨부파일 수정명
		 */
		
		// update문 실행하러 service호출 b를 전달하면서
		int result = bService.updateBoard(b);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "성공적으로 게시글이 수정되었습니다");
			return "redirect:detail.bo?bno=" + b.getBoardNo();
		} else {
			model.addAttribute("errorMsg", "게시글 수정 실패");
			return "common/errorPage";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	// 파일 등록은 사용할 일이 많으니 따로 메소드로 빼두자.
	public String saveFile(HttpSession session, MultipartFile upfile) { 
		
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		
		String originName = upfile.getOriginalFilename();
		// 20210702170130(년월일시분초) + 23152(랜덤값) + .jpg(원본파일확장자)
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // java.util.Date
		int ranNum = (int)(Math.random() * 90000 + 10000); // 10000 ~ 99999
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext;
		
		try {
			upfile.transferTo(new File(savePath + changeName)); // java.io
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} 
		
		return changeName;
	}

	
	
	
	
	
}
