package com.kh.chap04_assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDao {
	
	// BufferedReader/BufferedWriter
	
	// 프로그램 --> 파일
	public void fileSave() {
		
		// 1. 기반스트림(FileWriter) 먼저 객체 생성
		//FileWriter fw = newFileWriter("c_buffer.txt");
		// 2. 보조스트림(BufferedWriter) 생성 (위에서 만들어진 기반스트림을 가지고 생성)
		//BufferedWriter bw = new BufferedWriter("c_buffer.txt");
		
		// 위의 과정 한번에 처리 가능
		//BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
		
		/*
		BufferedWriter bw = null;
		
		
			try {
				bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
				
				bw.write("안녕하세요");
				bw.newLine();
				bw.write("반갑습니다. \n");
				bw.write("저리가세요");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		*/
		
		// try~with~resource 구문 (jdk7버전 이상부터만 가능)
		/*
		 * 	try(스트림객체생성; 스트림객체생성) {
		 * 		예외가  발생될 법한 구문
		 * 	}catch(예외클래스명 e) {
		 * 		해당 예외발생시 실행할 구문
		 * 	}
		 * 
		 * 	try() 안에 생성된 스트림 객체는 다 사용되면 알아서 반납됨
		 */
		
		// finally 사용없이 자동반납!!
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))){
					
			bw.write("안녕하세요");
			bw.newLine(); // 개행을 넣어주는 메소드
			bw.write("반갑습니다. \n");
			bw.write("저리가세요");
				
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	// 프로그램 <-- 파일
	public void fileRead() {
		
		// FileReader
		// BufferedReader
		
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){
			
			/*
			System.out.println(br.readLine()); //readLine:한줄단위로 다 가져오겠다.
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			*/
			// 파일의 끝을 만나는 순간 => null
			//System.out.println(br.readLine());
			
			// 반복문 이용해서 파일에 기록된 모든 행 다 읽어오는			
			String value = null;
			while((value = br.readLine()) != null) { // null은 문자가 아니기 때문에 equals아님!!
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
