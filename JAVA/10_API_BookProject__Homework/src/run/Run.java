package run;

import java.util.Scanner;

import controller.BookController;

public class Run {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BookController bc = new BookController();	// BookController 메소드에 접근하기 위해 bc라는 레퍼런스 생성
		
		
		// 1. 도서 전체 출력
		System.out.println("-----------1. 기존의 전체 도서 추가---------");
		bc.printAll();
		System.out.println();
		
		
		// 2_1. 추가할 도서 입력 받기
		System.out.println("-----------2. 새로운 도서 추가----------");
		System.out.print("도서명을 입력하시오 : ");
		String newTitle = sc.nextLine();
		
		System.out.print("저자명을 입력하시오 : ");
		String newAuthor = sc.nextLine();
		
		System.out.print("출판사명을 입력하시오  : ");
		String newPublisher = sc.nextLine();
		
		System.out.print("출판일 (2011-12-01 과 같이 '-'구분자를 이용하여 입력하시오) : ");
		String newDate = sc.nextLine();	// 날짜도 먼저 문자열로 받기
		
		System.out.print("가격을 입력하시오 : ");
		String newPrice = sc.nextLine();
		
		// 2_2. 입력받은 값들을 BookController의 insertBook() 메소드로 전달
		bc.insertBook(newTitle, newAuthor, newPublisher, newDate, newPrice);
		
		

		// 3. 5번째 도서 출간일 출력
		System.out.println("---------3. 5번째 도서 출간일 출력---------");
		bc.printBookPublishDate();
		
		System.out.println();
		
		// 4_1. 검색할 도서명 입력 (키워드)
		System.out.print("검색할 도서명을 입력하시오 : ");
		String searchTitle = sc.nextLine();
		
		// 4_2. 입력받은 검색명을 BookController의 searchBook() 메소드로 전달
		bc.searchBook(searchTitle);
		
		
	}

}
