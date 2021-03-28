package com.kh.chap01_poly.part02_electronic.controller;

import com.kh.chap01_poly.part02_electronic.model.vo.Desktop;
import com.kh.chap01_poly.part02_electronic.model.vo.NoteBook;
import com.kh.chap01_poly.part02_electronic.model.vo.Tablet;

// 다형성 적용안했을 때의 클래스
public class Store1 {
	
	// 이 클래스는 용산전자상가에 새로 차린 가게라고 생각!!
	private Desktop desk;
	private NoteBook note;
	private Tablet tab;
	
	public void insert(Desktop d) {
		// Desktop d = new Desktop("Samsung", "데탑", 120000, "Geforce 1080")
		desk = d;
	}
	
	public void insert(NoteBook n) {
		// NoteBook n = new NoteBook("LG", "그램", 2000000, 4)
		note = n;
	}
	
	public void insert(Tablet t) {
		// Tablet t = new Tablet("Apple", "아이패드", 800000, false)
		tab = t;
	}
	
	public Desktop selectDesktop() {
		return desk;
	}
	
	public NoteBook selectNoteBook() {
		return note;
	}
	
	public Tablet selectTablet() {
		return tab;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
