package com.kh.chap01_poly.part02_electronic.controller;

import com.kh.chap01_poly.part02_electronic.model.vo.Desktop;
import com.kh.chap01_poly.part02_electronic.model.vo.Electronic;
import com.kh.chap01_poly.part02_electronic.model.vo.NoteBook;
import com.kh.chap01_poly.part02_electronic.model.vo.Tablet;

// 다형성을 적용한 클래스
public class Store2 {
	
	// 3개의 제품을 하나의 공간에 보관할 부모타입(Electronic)의 객체배열
	private Electronic[] elec = new Electronic[3];
	
	public void insert(Electronic any , int index) {
		elec[index] = any;
	}
	// Electronic any = new Desktop("Samsung", "데탑", 120000, "Geforce 1080");
	// Electronic any = new NoteBook("LG", "그램", 2000000, 4);
	// Electronic any = new Tablet("애플", "아이패드", 800000, false);
	
	public Electronic select(int index) {
		return elec[index];
	}
	
	// 배열 반환도 가능하다.
	public Electronic[] select() {
		return elec;
		
	}
	
	
	
	

}
