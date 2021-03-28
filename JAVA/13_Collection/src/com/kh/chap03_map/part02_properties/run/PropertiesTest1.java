package com.kh.chap03_map.part02_properties.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class PropertiesTest1 {
	
	public static void main(String[] args) {
		
		/*
		 * Properties : Map 계열이다. --> 키, 밸류 세트로 저장됨!!
		 * 단, 우리가 배웠던 HashMap과의 차이점이라고 한다면
		 * 주로 Properties를 쓰는 경우가 키값과 밸류값을 String으로 담고자할때 사용됨!!
		 */
		
		Properties prop =  new Properties();
		
		/*
		// Map계열이기 때문에 put()이용해서 키-밸류 세트 추가 가능 하긴함
		prop.put("다이제", new Snack("단맛", 1000));
		
		System.out.println(prop);
		System.out.println(prop.get("다이제"));
		
		// 하지만 Properties를 주로 사용하는 경우는 외부 파일로 출력시킨다거나 입력받아올 때 주로 사용함!
		// store(), load() 메소드를 주로 같이 사용함!!
		
		try {
			prop.store(new FileOutputStream("test.properties"), "PropertiesTest");
			// 외부파일에 출력시 형변환 관련 예외 발생
			// 내부적으로 store메소드 실행시 Properties에 담겨있는 key-value들을 String으로 형변환해서 파일에 출력
			// 이 때 Snack을 String으로 형변환 할 수 없어서 발생하는 문제!!
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		// 1. setProperty(String key, String value) : Properties에 key-value세트 추가시
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop); // 순서 유지 x, key 값 중복 x
		
		// 2. getProperty(String key) : key값에 해당하는 value값 String으로 반환
		System.out.println(prop.getProperty("Map"));
		
		
		try {
			// 3. store(출력스트림, 주석구문)
			prop.store(new FileOutputStream("test.properties"), "PropertiesTest");
			// 4. storeToXML(출력스트림, 주석구문)
			prop.storeToXML(new FileOutputStream("test.xml"), "PropertiesTest");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
