package com.kh.test.book;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectDao {
	
	public void fileSave(String fileName) {
		
		Book bk = new Book("자바를 정복하자", 35000);
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			
			oos.writeObject(bk);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
