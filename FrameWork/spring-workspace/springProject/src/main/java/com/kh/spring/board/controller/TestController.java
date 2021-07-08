package com.kh.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Product;

@Controller
public class TestController {
	
	@RequestMapping("testEnroll1.do")
	public String testEnrollForm1() {
		return "test/testEnrollForm1";
	}
	
	@RequestMapping("testInsert1.do")
	public String testInsert1(Board b) {
		System.out.println(b);
		System.out.println(b.getBoardList());
		return "test/testEnrollForm1";
	}
	
	@RequestMapping("testEnroll2.do")
	public String testEnrollForm2() {
		return "test/testEnrollForm2";
	}
	
	@RequestMapping("testInsert2.do")
	public String testInsert2(Product p) {
		System.out.println(p);
		System.out.println(p.getOptionList()); // ArrayList<Oprion>
		return "test/testEnrollForm2";
	}
	
}
