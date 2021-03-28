package list.controller;

import java.util.ArrayList;

import list.model.vo.Book;

public class BookController {
	
	// 도서들을  담고 있는 bookList
	private ArrayList<Book> bookList = new ArrayList<Book>();
	{
		// 초기값 4개정도 추가
		bookList.add(new Book("자바의 정석", "홍길동", "기타", 20000));
		bookList.add(new Book("C언어", "김말똥", "기타", 15000));
		bookList.add(new Book("도움이 되었나요", "강보람", "인문", 17500));
		bookList.add(new Book("여러분", "KH", "의료", 10000));
	}
	
	
	public void insertBook(String title, String author, int category, int price) {
		/*
		 * 1. 매개변수 생성자를 이용하여 Book 객체 생성 (단, 객체 생성 시 장르 번호별로 조건식 이용해서 장르번호가 아닌 장르명으로 생성!)
		 * 2. bookList에 위의 생성된 Book객체 추가
		 */
		
		String cg = "";
		
		switch(category) {
		case(1) : cg = "인문";
		case(2) : cg = "자연과학";
		case(3) : cg = "의료";
		case(4) : cg = "기타";
		
		}
		
		bookList.add(new Book(title, author, cg, price));
		
		
		
	}
	
	
	public ArrayList<Book> selectList(){
		/*
		 * 1. 해당 bookList 반환
		 */
		
		return bookList; 	// 이 부분 수정해야되요~! 우선은 null로 해놨어요
	}
	
	
	public ArrayList<Book> searchBook(String keyword){
		/*
		 * 1. 검색 결과 리스트를 담아줄 리스트(ArrayList<Book> searchList) 선언 및 생성
		 * 2. 반복문을 통해 bookList의 책들 중 도서명에 전달받은 keyword가 "포함 되어있는 경우" 
		 *    searchList에 해당 Book객체 "추가"하기 
		 * 
		 * 3. searchList 반환
		 */
		
		ArrayList <Book> searchList = new ArrayList<>();
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(keyword)) {
				searchList.add(new Book(bookList.get(i).getTitle(), bookList.get(i).getAuthor(),
						bookList.get(i).getCategory(), bookList.get(i).getPrice()));
			}
		}
				
		return searchList;   // 이 부분 수정해야되요~! 우선은 null로 해놨어요
		
	}
	
	public int deleteBook(String title, String author) {
		/*
		 * 1. 사용자가 입력한 도서명과 저자명이 일치할 경우 성공적으로 삭제 될 것이고, 그게 아닐 경우 삭제할 도서를 찾지 못한 경우이다.
		 *    그래서 이를 처리하기 위한 result 변수를 0으로 초기화 한 채로 만들어 두자.
		 * 2. 반복문을 통해 bookList의 책들 중 책명이 전달받은 title과 동일하고, 저자명이 전달받은 author와 동일한 경우 
		 *    해당 인덱스의 도서 "삭제"하고 result를 1로 변경 
		 * 
		 * 3. result 값 반환
		 */
		int result = 0;
		for(int i=0; i<bookList.size(); i++) {
			if(title.equals(bookList.get(i).getTitle()) && 
					author.equals(bookList.get(i).getAuthor())){
				bookList.remove(i--);
				result++;
			}
		}
	
		return result;   // 이 부분 수정해야되요~! 우선은 0으로 해놨어요
	}
	
	
	
	
}
