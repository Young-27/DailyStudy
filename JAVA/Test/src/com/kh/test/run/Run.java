package com.kh.test.run;

import java.util.ArrayList;

import com.kh.test.book.Book;
import com.kh.test.book.ObjectDao;

public class Run {

	public static void main(String[] args) {
		ObjectDao od = new ObjectDao();
		od.fileSave("으엥.txt");
		
		
		ArrayList <Book> list = new ArrayList<>();
		list.add(new Book("자바를 잡아라", 30000));
		list.add(new Book("오라클 정복", 35000));
		list.add(new Book("웹표준 2.0", 27500));
		list.add(new Book("자바 Servlet/JSP", 28000));
		list.add(new Book("ajax 사용법", 15000));
		
		System.out.println(list);
		
		
		
		
	}

}
