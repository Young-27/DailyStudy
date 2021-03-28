package com.kh.chap04_assist.part02_object.run;

import com.kh.chap04_assist.part02_object.model.dao.ObjectDao;
import com.kh.chap04_assist.part02_object.model.dao.ObjectsDao;

public class ObjectRun {

	public static void main(String[] args) {
		
		// 객체단위로 입출력할 수 있는 기능을 제공하는 보조스트림
		// ObjectInputStream / ObjectOutputStream
		
		// 기반스트림도 Input, Output 스트림만 가능!!
		
		ObjectDao od = new ObjectDao();
		//od.fileSave("phone.txt");
		//od.fileRead();
		
		ObjectsDao ods = new ObjectsDao();
		//ods.fileSave("PhoneList.txt");
		ods.fildRead();
	}

}
