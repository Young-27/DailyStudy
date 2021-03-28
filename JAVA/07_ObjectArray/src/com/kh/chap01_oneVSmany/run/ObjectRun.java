package com.kh.chap01_oneVSmany.run;

import java.util.Scanner;

import com.kh.chap01_oneVSmany.model.vo.Book;

public class ObjectRun {

	public static void main(String[] args) {
		
		/*
		// 1. 기본생성자로 객체 생성 후 setter메소드를 통해 각 필드에 값 대입
		Book bk1 = new Book(); // JVM이 각 필드에 초기값 세팅
		bk1.setTitle("자바의 정석");
		bk1.setAuthor("나자바");
		bk1.setPrice(20000);
		bk1.setPublisher("kh");	
		
		// 2. 매개변수생성자로 객체 생성과 동시에 각 필드에 값 대입
		Book bk2 = new Book("c언어", "강보람", 10000, "나무");
		
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		*/
		
		// 3. 사용자가 입력한 값들로 객체 생성
		
		// 세 개의 Book 객체가 필요하다는 가정하에 각 Book 객체를 따로따로 관리
		// 단, 사용자에게 입력받은 값들로 채워넣기
		
		Book bk1 = null;
		Book bk2 = null;
		Book bk3 = null;
		
		Scanner sc = new Scanner(System.in);
		
		// 3개의 전체 도서 정보 입력받은 후 각 객체에 초기화
		for(int i=0; i<3; i++) { // i값이 0에서부터 2까지 매번 1씩 증가되는 동안 반복(0,1,2)
			
			System.out.print("제목 : ");
			String title = sc.nextLine();
			
			System.out.print("저자 : ");
			String author = sc.nextLine();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.print("출판사명 : ");
			String publisher = sc.nextLine();
			
			if(i == 0) {
				bk1 = new Book(title,author, price, publisher);
			}else if(i == 1) {
				bk2 = new Book(title,author, price, publisher);
			}else {				
				bk3 = new Book(title,author, price, publisher);
			}
		}
		
		// 전체 도서 정보들 출력하기(조회) => 반복문 사용 불가		
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		System.out.println(bk3.information());
		
		// 사용자에게 검색할 도서제목을 입력받아
		// 각 전체도서들의 제목과 일일이 비교하여 일치하는 도서의 가격을 알려주는 서비스
		System.out.print("검색할 책 제목");
		String searchTitle = sc.nextLine(); // 검색할 책 제목
	
		if(bk1.getTitle().equals(searchTitle)) {
			System.out.println(bk1.getPrice());
		}		
		if(bk2.getTitle().equals(searchTitle)) {
			System.out.println(bk2.getPrice());
		}
		if(bk3.getTitle().equals(searchTitle)) {
			System.out.println(bk3.getPrice());
		}
		
	}

}
