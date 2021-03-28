package com.kh.chap03_map.part02_properties.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest2 {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		
		try {
			// 5. load(입력스트림)
			prop.load(new FileInputStream("test.properties"));
			
			// 6. loadFromXML(입력스트림)
			prop.loadFromXML(new FileInputStream("test.xml"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		
		/*
		 * Properties를 주로 사용하는 경우
		 * 
		 * 1. 해당 프로그램이 기본적으로 가져야 할 정보들을 .properties 확장자 문서로 저장시켜두면
		 * 	     개발자가 아닌 일반인관리자가 해당 문서를 다루기 쉽다.
		 * 
		 * 2. xml파일로 저장시킬 수 있는 메소드를 추가로 제공
		 *	  .xml 확장자 파일은 다양한 프로그래밍 언어간에 호환이 쉽다.
		 *
		 *	후에 JDBC 수업 때 적용할 예정!!
		 */

	}

}
