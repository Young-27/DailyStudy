package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DAO (Data Access Object) : 데이터가 보관되어있는 공간과 직접 접근해서 데이터를 입출력하는 클래스

public class FileByteDao {
	
	// 프로그램(자바) --> 외부매체(파일)
	// 출력 : 프로그램 내의 데이터를 파일로 내보내기 (즉, 파일에 기록하겠다.)
	public void fileSave() {
		
		// FileOutputStream : "파일"로 데이터를 1바이트 단위로 출력하는 스트림
		
		FileOutputStream fout = null;
		try {
			// 1. FileOutputStream 객체 생성 == 해당 파일과 직접 연결되는 통로를 만들겠다.
			//	     해당 파일이 존재하지 않으면 해당 파일 생성되면서 통로 연결  / 존재하는 파일이면 그냥 통로 연결
			//		true 미작성시 => 기존에 해당 파일이 있을 경우 덮어씌워짐 (기본값 false)
			//		true 작성시 => 기존에 해당 파일이 있을 경우 이어서작성
			fout = new FileOutputStream("a_byte.txt");
			//fout = new FileOutputStream("a_byte.txt", true);
			
			// 2. 연결 통로로 데이터 출력 write() 메소드 사용
			//	  1바이트 범위 : -128 ~ 127 까지의 숫자 (단, 파일에 기록되기를 해당 숫자의 고유한 문자가 기록됨)
			//				음수는 불가!! (0 ~ 127 가능) => 아스키코드표 참고
			fout.write(97);		// a 기록
			fout.write('b');	// b 기록
			// fout.write('강');	// 한글은 2byte짜리기때문에 깨져서 저장(바이트 스트림으로는 제한)
			
			byte[] bArr = {99, 100, 101};
			fout.write(bArr); // cde 기록
			fout.write(bArr, 1, 2); // 1번인덱스부터 2개 => de 기록
			
			// 3. 스트림 다 이용했으면 자원 반납하기 (반드시)
			fout.close(); // 위에서 혹시 예외가 발생했을 경우 실행이 안될 수도 있음!!
			
			
		} catch (FileNotFoundException e) { // 존재하지 않는 경로 제시시 발생
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 어떤 예외가 발생하든간에 반드시 실행할 구문을 작성하는 블럭
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	// 프로그램(자바) <-- 외부매체(파일)
	// 입력 : 파일로부터 데이터를 가지고 오겠다.
	public void fileRead() {
		
		// FileInputStream : 파일로부터 데이터를 1바이트 단위로 입력받는 스트림
		
		FileInputStream fin = null; //초기화습관
		
		try {
			// 1. FileputStream 객체 생성 (스트림을 열겠다.)
			fin = new FileInputStream("a_byte.txt"); // 존재하는 파일로 꼭 제시해야됨
			
			// 2. 통로로 데이터 입력받기 read() 사용
			// 단, 1byte 단위로 하나씩 읽어옴
			/*
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());  
			System.out.println(fin.read());
			// 파일의 끝을 만나는 순간 fin.read() => -1
			System.out.println(fin.read());
			System.out.println(fin.read());
			*/
			
			/* 퐁당퐁당 출력
			while(fin.read() != -1) {
				System.out.println(fin.read());
			}
			*/
			
			int value = 0;
			while((value = fin.read()) != -1) { // fin.read값이 value에 담긴 후 -1과 비교함
				System.out.print((char)value);
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // finally 어떤 예외가 발생하든간에 반드시 실행할 구문을 작성하는 블럭
			
			// 3. 다 쓴 스트림 자원 반납하기
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
	
	

}
