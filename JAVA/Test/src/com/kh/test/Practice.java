package com.kh.test;

import java.io.File;
import java.io.IOException;

public class Practice {

	public static void main(String[] args) {

		try {
			// 1. 별도의 경로지정을 딱히 하진 않고 파일명(test.txt)만을 제시해서 생성해보기 => 현재 이 프로젝트 폴더에 파일 생성
			File file1 = new File("SunYoung.txt");

			file1.createNewFile();

			// 2. 경로지정을 한 파일명(C:\\aaa\\test.txt) 제시해서 생성하기 => 존재하는 경로로 제시해야됨
			File file2 = new File("C:\\aaa\\SunYoung.txt");

			file2.createNewFile();

			// 3. 폴더생성 후 파일 생성하기
			// 생-략

			// 4. 별도의 경로지정없이 폴더 생성 후 파일 생성하기 (프로젝트 폴더 내에 생성됨)
			File folder1 = new File("Sun");
			folder1.mkdir();
			File file3 = new File("Sun\\Young.txt");

			file3.createNewFile();

			// File에서 제공하는 메소드들
			System.out.println(folder1.isFile());
			System.out.println(file1.isFile());

			System.out.println(file1.getName());
			System.out.println(file2.getParent());
			System.out.println(file1.length());
			System.out.println(file1.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
