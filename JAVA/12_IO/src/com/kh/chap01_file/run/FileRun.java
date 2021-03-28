package com.kh.chap01_file.run;

import java.io.File;
import java.io.IOException;

public class FileRun {

	public static void main(String[] args) {
		
		// 간단하게 파일 만드는 과정 및 메소드
		// java.io.File 클래스를 가지고 작업!
		
		
		
		
		try {
			
			// 1. 별도의 경로지정을 딱히 하진 않고 파일명(test.txt)만을 제시해서 생성해보기 => 현재 이 프로젝트 폴더에 파일 생성
			File file1 = new File("test.txt");
			file1.createNewFile();
			
			// 2. 경로지정을 한 파일명(C:\\aaa\\test.txt) 제시해서 생성하기 => 존재하는 경로로 제시해야됨
			File file2 = new File("C:\\aaa\\test.txt");
			file2.createNewFile();
			
			// 3. 폴더생성 후 파일 생성하기
			File bbbFolder = new File("C:\\bbb");
			bbbFolder.mkdir(); // 폴더생성(make directory의 약자)
			
			File file3 = new File("C:\\bbb\\test.txt");
			file3.createNewFile();
			
			// 4. 별도의 경로지정없이 폴더 생성 후 파일 생성하기 (프로젝트 폴더 내에 생성됨)
			File folder = new File("test");
			folder.mkdir();
			
			File file = new File("test\\person.txt");
			file.createNewFile();
			
			// File에서 제공하는 메소드들
			System.out.println(folder.isFile());
			System.out.println(file.isFile());
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("상위폴더 : " + file.getParent());
			System.out.println("파일용량 : " + file.length());
			System.out.println("절대경로 : " + file.getAbsolutePath());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		/*
		 * 	* 프로그램상의 데이터를 외부매체(모니터, 스피커, 마이크, "파일", 시스템, ...)로 출력하거나 입력받는 과정을 진행하고자 한다면
		 *	     반드시 프로그램과 외부매체와의 "통로"를 만들어야됨!! == "스트림"
		 * 
		 * 	* 스트림의 특징
		 *	1) 단방향 : 입력이면 입력 / 출력이면 출력 따로 존재
		 *			 즉, 동시에 입출력 하고자 한다면 하나의 스트림으로는 안됨!!
		 *	2) 선입선출(FIFO) : 먼저 전달한 값이 먼저 나오게 됨!
		 *	3) 시간지연 문제가 발생할 수도 있다!!
		 *	
		 *	* 스트림의 구분
		 *	> 통로의 사이즈
		 *		- 바이트 스트림 : 1byte짜리가 왔다갔다 할 수 있을 정도의 사이즈! (좁은 통로) => 입력(InputStream) / 출력(OutputStream)
		 *		- 문자 스트림 : 2byte짜리가 왔다갔다 할 수 있을 정도의 사이즈! (넓은 통로) => 입력(Reader) / 출력(Writer)
		 *
		 *	> 외부매체와 직접적인 연결여부
		 *		- 기반 스트림 : 외부 매체와 직접적으로 연결되는 통로
		 *		- 보조 스트림 : 기반스트림만으로 부족한 성능을 향상시켜주는 용도의 스트림(외부매체와 직접적으로 연결x)
		 *					(속도 향상, 자료형에 맞춰 변환한다거나, 객체 단위로 입출력하게 도와준다거나,...)
		 *					단, 보조스트림은 단독으로 사용불가! 반드시 외부매체와 직접적으로 연결되는 기반스트림이 필수!!
		 *		
		 *
		 *
		 * 
		 */
		
		
		
	}

}
