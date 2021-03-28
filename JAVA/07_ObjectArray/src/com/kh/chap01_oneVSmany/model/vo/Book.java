package com.kh.chap01_oneVSmany.model.vo;

public class Book {

	// 도서명, 저자명, 가격, 출판사
	private String title;
	private String author;
	private int price;
	private String publisher;
	
	// 기본생성자
	public Book() {		
	}
	// 매개변수생성자 (모든 필드에 대해서 초기화 시킬수있는)
	public Book(String title, String author, int price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}
	// 각 필드에 대한 setter/getter 메소드
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	
	// 모든 필드 하나의 문자열로 합쳐서 반환시켜주는 information
	public String information() {
		return title + ", " + author + ", " + price + ", " + publisher;
		
	}
	
}
