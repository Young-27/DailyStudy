package com.kh.chap02_string.controller;

public class B_StringMethodTest {
	
	public void method() {
		
		String str1 = "Hell World";
		
		//		메소드명(매개변수) : 반환형
		
		// 1. 문자열.charAt(int index) : char
		//	     문자열에서 전달받은 index위치의 문자 하나만을 뽑아서 반환
		char ch = str1.charAt(3);
		System.out.println("ch : " + ch);
		
		// 2. 문자열.concat(String str) : String
		//	     문자열과 전달된 또다른 문자열을 하나로 합쳐서 반환
		//String str2 = str1 + "!!!";
		String str2 = str1.concat("!!!");
		System.out.println("str2 : " + str2);
		
		// 3. 문자열.length() : int
		//	     문자열의 길이(글자수)를 변환
		System.out.println("문자열의 길이(글자수) : " + str1.length());
		
		// 4. 문자열.substring(int beginIndex) : String
		//		문자열의 전달된 beginIndex 위치에서부터 끝까지의 문자열을 추출해서 반환
		//	     문자열.substring(int beginIndex, int endIndex) : String
		//		문자열에 전달된 beginIndex 위치에서부터 endIndex-1 위치까지의 문자열을 추출해서 반환
		System.out.println(str1.substring(6));
		System.out.println(str1.substring(0, 6)); // 0 <=   < 6
		
		// 5. 문자열.replace(char old, char new) : String
		//		문자열에서의 old 문자들 찾아서 new 문자로 변환한 새로운 문자열 반환
		System.out.println(str1.replace('l', 'c'));
		
		// 6. 문자열.trim() : String
		//		문자열의 앞과 뒤의 공백을 제거한 새로운 문자열 반환
		String str3 = "   JA VA   ";
		System.out.println(str3.trim());
		
		// 7. 문자열.toUpperCase() : String	=> 문자열을 다 대문자로 변경한 새로운 문자열 반환
		//	     문자열.toLowerCase() : String	=> 문자열을 다 소문자로 변경한 새로운 문자열 반환
		System.out.println("upper : " + str1.toUpperCase());
		System.out.println("lower : " + str1.toLowerCase());
		
		/*
		System.out.print("종료하시겠습니까? (y/n) : ");
		char a = sc.nextLine().toUpperCase().charAt(0); // 메소드체이닝
		
		if(a == 'Y') { // Upper를 사용하여 조건식이 더 짧아진다.
			// 종료시키고
		}else {
			// ~~~~
		}
		*/
		
		// 문자열 => char[]
		/*
		char[] arr = new char[str1.length()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = str1.charAt(i)
		}
		*/
		
		// 8. 문자열.toCharArray() : char[]
		//	     문자열의 각 문자들을 char[]에 옮겨 담은 후 해당 배열을 반환
		char[] arr = str1.toCharArray();
		System.out.println(arr[0]);
		
		
		// char[] => 문자열
		char[] arr2 = {'a', 'p', 'p', 'l', 'e'};
		
		// 9. static valueOf(char[] data) : String
		//	  char[]의 각 문자들을 하나로 합쳐서 새로운 문자열 반환
		System.out.println(String.valueOf(arr2));
		
	
	}

}
