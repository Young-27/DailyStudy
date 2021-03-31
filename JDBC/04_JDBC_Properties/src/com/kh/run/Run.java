package com.kh.run;

import com.kh.view.MemberMenu;

public class Run {

	public static void main(String[] args) {
		
		// Properties 복습
		// Properties (Map 계열 == key+value 세트로 담는 특징)
		/*
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		System.out.println(prop.getProperty("select"));
		System.out.println(prop.getProperty("insert"));
		System.out.println(prop.getProperty("update"));
		*/
		
		new MemberMenu().mainMenu();
		
	}

}
