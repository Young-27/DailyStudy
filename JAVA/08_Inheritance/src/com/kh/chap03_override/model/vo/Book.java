package com.kh.chap03_override.model.vo;

public class Book /*extends Object*/{
	
	private String title;
	private String author;
	private int price;
	
	// 기본생성자, 매개변수생성자, getter/setter메소드
	
	public Book() {}
	
	// alt+shift+s => o => enter
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	// alt+shigt+s => r => alt+a => alt+r
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 *	* 오버라이딩
	 *	- 상속받고 있는 부모클래스의 메소드를 자식클래스에서 재정의(재작성) 하는 것
	 *	- 부모가 제공하고 있는 메소드를 자식이 일부 고쳐서 사용하겠다는 의미
	 *		자식메소드가 우선권을 가짐
	 *
	 *	* 오버라이딩 성립조건
	 *	- 부모메소드의 메소드명과 동일해야됨
	 *	- 매개변수 자료형, 개수, 순서 동일(매개변수명과는 무관)
	 *	- 반환형 동일 (jdk버전업 되면서 부모메소드의 반환형의 자식자료형까지는 가능)
	 *	- 부모메소드의 접근제한자보다 같거나 커야됨
	 *		=> 규약의 개념이 들어가있음 (재정의 하려면 이정도의 규칙을 지켜줘!!)
	 *
	 *	* @Override 어노테이션
	 *	- 생략가능함! (명시를 안해도 부모메소드와 형태가 똑같으면 오버라이딩 된 것임!!)
	 *	- 어노테이션을 붙이는 이유?
	 *		> 잘못 기술했을 경우 오류를 알려주기 때문에 다시 한번 검토할 수 있게끔 유도해줌!!
	 *		> 혹시라도 부모메소드가 후에 수정되었을 경우 오류로 알려주기 때문에 검토할 수 있게끔 유도해줌
	 *		> 이 메소드가 오버라이딩 된 메소드라는걸 알리고자 할 목적
	 */
	
	@Override
	public String toString() {
		// 모든 필드값 하나의 문자열로 합쳐서 돌려주는 내용으로 재작성
		return "title : " + title + ", author : " + author + ", price : " + price; 
	}

	
}
