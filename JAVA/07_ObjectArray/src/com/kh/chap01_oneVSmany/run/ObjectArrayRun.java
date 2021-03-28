package com.kh.chap01_oneVSmany.run;

import java.util.Scanner;

import com.kh.chap01_oneVSmany.model.vo.Book;

public class ObjectArrayRun {

	public static void main(String[] args) {

		Book[] arr = new Book[3]; // arr[0], arr[1], arr[2]
		
		Scanner sc = new Scanner(System.in);
		
		// 3개의 전체 도서 정보 입력받은 후 각 인덱스에 해당 객체 생성
		for(int i=0; i<arr.length; i++) {
			System.out.print("제목 : ");
			String title = sc.nextLine();
			
			System.out.print("저자 : ");
			String author = sc.nextLine();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.print("출판사명 : ");
			String publisher = sc.nextLine();
			
			arr[i] = new Book(title, author, price, publisher);
						
		}
		
		// 전체 도서 정보들 출력하기 (조회)
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].information());
		}
		
		// 사용자에게 검색할 도서제목을 입력받아
		// 각 전체도서들의 제목과 일일이 비교하여 일치하는 도서의 가격을 알려주는 서비스
		System.out.print("검색할 책 제목 : ");
		String searchTitle = sc.nextLine();
		
		int count = 0; // 일치하는 도서의 개수를 보관할 변수 (일치하는 도서를 찾는 순간 1증가)
		for(int i=0; i<arr.length; i++) {
			if(arr[i].getTitle().equals(searchTitle)) {
					System.out.println(arr[i].getPrice());
					count++;
					//break;
			}			
		}
		
		// 만일 일치하는 도서를 찾지 못했을 경우 "검색된 도서가 없습니다." 출력
		if(count == 0) {
			System.out.println("검색된 도서가 없습니다.");
		}
		
		
		
	}

}
