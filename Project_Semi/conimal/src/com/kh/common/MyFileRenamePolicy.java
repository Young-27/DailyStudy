package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {
	// 인터페이스 하나를 implements 받아야햄(상속) 즉 구현하는거지
	
	// 기존의 파일 (원본파일)을 전달 받아서 파일명 수정 작업 후 수정된 파일을 반환해주는 메소드
	@Override
	public File rename(File originFile) {
		
		// 원본파일명("aaa.jpg")
		String originName = originFile.getName();
		
		// 수정파일명 : 파일업로드된시간(년월일시분초)+5자리랜덤값(10000~99999) + 원본파일에확장자
		
		// 원본명        --> 수정명
		// aaa.jpg --> 2021051322103023489.jpg 로 수정하겠다는 거임!
		
		// 1. 파일업로드된 시간(년월일시분초 형태) (String currentTime)
		// simpleDate 포맷사용하면 원하는 포멧으로 지정할 수 있음(단, util로 import해야함)
		// 이렇게 하며눈 내가원하는 형태로 가져올 수 있음
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 2. 5자리 랜덤값 (int ranNum)
		int ranNum = (int)(Math.random()*90000 + 10000); // 랜덤값에 곱해주는 수는 총 몇개의 랜덤값을 가질거냐 이거임 (99999-10000 +1 =90000)
		
		// 3. 원본파일확장자(String ext)   |원본파일명에서의 제일 뒤에 있는 '.'의 인덱스를 제시해야함
		String ext = originName.substring(originName.lastIndexOf(".")); // 뒤에서부터 .을 찾아서 해당 .부터 끝까지 뽑아올랭
		
		String changeName = currentTime + ranNum + ext; //"2021051322103023489.jpg"
		
		// 최종 수정된 파일을 반환해줘야 하지
		// 원본파일(originFile)을 수정된 파일명으로 적용시켜서 파일객체로 반환
		return new File(originFile.getParent(),changeName);
		
	}

		
	
	
	
}
