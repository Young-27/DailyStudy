package com.kh.mybatis.common.template;

import com.kh.mybatis.common.model.vo.PageInfo;

public class Pagination {
	
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		// * maxPage : 제일 마지막 페이지
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		// * startPage : 페이징 바의 시작수
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		// * endPage : 페이징 바의 끝수
		int endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		return new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		
	}
	
}
