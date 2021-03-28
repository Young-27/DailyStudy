package com.kh.chap03_char.run;

import com.kh.chap03_char.model.dao.FileCharDao;

public class CharRun {

	public static void main(String[] args) {
		
		/*
		 * 	"문자 기반 스트림"
		 * 	외부매체를 지정하고 그 외부매체와 직접적으로 연결되는 2바이트 단위의 통로를 만들겠다
		 * 	XXXReader/XXXWriter
		 */
		
		FileCharDao fc = new FileCharDao();
		fc.fileSave();
		fc.fileRead();
		
		
		
	}

}
