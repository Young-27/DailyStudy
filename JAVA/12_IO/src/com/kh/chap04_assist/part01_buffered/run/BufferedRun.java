package com.kh.chap04_assist.part01_buffered.run;

import com.kh.chap04_assist.part01_buffered.model.dao.BufferedDao;

public class BufferedRun {

	public static void main(String[] args) {
		
		/*
		 * 	* 보조스트림
		 * 	     기반 스트림(외부매체와 직접 연결되어있는 통로)의 부족한 기능들을 확장시킬 수 있는 스트림
		 * 	     보조 스트림은 단독으로 사용 불가 (단독으로 객체생성 불가)
		 * 
		 * 	     보조스트림 변수명 = new 보조스트림(기반스트림객체);
		 * 
		 * 	  [속도]성능향상목적 보조스트림 : BufferedXXX
		 * 							=> 버퍼 공간을 제공해서 한번에 모아놨다가 한꺼번에 입출력 진행
		 * 
		 */
		
		BufferedDao bd = new BufferedDao();
		
		//bd.fileSave();
		bd.fileRead();
		
		
	}

}
