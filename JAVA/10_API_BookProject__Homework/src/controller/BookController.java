package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import model.vo.Book;

public class BookController {
	
	private Book[] list = new Book[5];
	{ // 초기화블럭
		list[0] = new Book("자바의 정석", "제임스 고슬링", "나무", new Date(2018-1900, 4-1, 15), 20000);
		list[1] = new Book("여러분들 성공할꺼에요", "보람쌤", "KH", new Date(2019-1900, 6-1, 15), 30000);
		list[2] = new Book("API의 모든것", "강보람", "KH", new Date(2017-1900, 2-1, 13), 15000);
		list[3] = new Book("씨언어 프로그래밍", "김절차", "문학동네", new Date(2016-1900, 8-1, 30), 10000);
	}
	
	public BookController() {}
	
	// 1. 도서 전체 출력 기능 메소드
	public void printAll() {
		
		// list에 담긴 전체 Book객체의 정보 출력하는 구문 작성하시오.
		
		for(int i=0; i<list.length; i++) {
			if(list[i]!=null) {
				System.out.println(list[i]);
			}
		}
		
		
	}
	
	
	
	// 2. 도서 추가 기능 메소드
	public void insertBook(String newTitle, String newAuthor, String newPublisher, String newDate, String newPrice) {
		
		// 1. 매개변수로 전달받은 newPrice값  ==>      String --> int로 변환 작업  (int price라는 변수에 담으시오)
		
		// 코드 작성
		
		int price = Integer.parseInt(newPrice);
		
		
		// --------------------------------------------------------
		// 2. 매개변수로 전달받은 newDate값   ==>        String --> Date로 변환 작업    (Date date에 담으시오)
		//	  '-'를 구분자로 StringTokenizer를 이용하여 문자열 분리 후 각각 년,월,일 을 Date에 적용
	
		// 코드 작성
		
		StringTokenizer stn = new StringTokenizer(newDate, "-");
		
		int year = Integer.parseInt(stn.nextToken());
		int month = Integer.parseInt(stn.nextToken());
		int day = Integer.parseInt(stn.nextToken());
		
		Date date = new Date(year-1900,month-1,day);

		
		// ------------------------------------------------------
		// 3. 나머지 전달받은 값들과 위에서 변환작업을 해준 price와 date값을 
		//	  Book클래스의 매개변수 생성자를 통해 생성
		
		Book bk = new Book(newTitle, newAuthor, newPublisher, date, price);

		list[4] = bk;
		System.out.println(bk); // 임시검사
	
	}
	
	
	private int nexttoken() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 3. 도서 출간일 출력 기능 메소드
	public void printBookPublishDate() {
		// 새로 입력받은 도서 (5번째 도서)의 출간일 출력
		// "xxxx년 xx월 xx일 출간" 과 같은 패턴으로 출력
		// SimpleDateFormat을 이용하여 출력
		
		// 코드 작성

		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 출간");
		String publishDate = sdf2.format(list[4].getPublishDate());
		System.out.println(publishDate);
		
	}
	
	
	// 4. 도서 검색 기능 메소드
	public void searchBook(String searchTitle) {
		
		// 도서 리스트를 전체적으로 조회하면서 (for문 이용)
		// 전달받은 검색명을 포함(HINT : String클래스의 contains메소드 활용)한!! 도서들 전체 출력  
		
		// 코드 작성
		for(Book b : list) {
			
			if(b.getTitle().contains(searchTitle)) {
				System.out.println(b);
				
			}
			
			
		}
		
	}
	
	
	

}
