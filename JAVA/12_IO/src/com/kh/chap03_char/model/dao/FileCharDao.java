package com.kh.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
	
	// 프로그램(자바) --> 외부매체(파일)
	public void fileSave() {
		
		// FileWriter : 파일로 데이터를 2바이트 단위로 출력하는 스트림
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("b_char.txt");
			
			fw.write("와! IO 재밌다..ㅎ\n");
			fw.write('A');
			fw.write(' ');
		
			char[] cArr = {'k','i','w','i'};
			fw.write(cArr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void fileRead() {
		
		// FileReader : 파일로부터 데이터를 2바이트 단위로 입력받는 스트림
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("b_char.txt");
			
			// 파일의 끝을 만나면 -1반환
			/*
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			*/
			// int를 반환되게 설정되어있기 때문에 숫자로 반환됨
			
			int value = 0;
			while((value = fr.read()) != -1) { 
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	

}
