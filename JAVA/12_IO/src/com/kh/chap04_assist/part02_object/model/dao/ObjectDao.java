package com.kh.chap04_assist.part02_object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectDao {
	
	// 프로그램 --> 파일 (출력)
	public void fileSave(String fileName) {
		
		Phone ph = new Phone("아이폰", 1500000);
		
		// 객체단위를 파일에 출력하고자 할 때 필요한 스트림
		// FileOutputStream(기반) : 파일에 데이터를 출력하는 기반 스트림
		// ObjectOutputStream(보조) : 객체 단위로 출력할 수 있는 메소드를 제공하는 보조스트림
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			
			oos.writeObject(ph);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 프로그램 <-- 파일
	public void fileRead() {
		// FileInputStream(기반) : 파일로부터 데이터를 읽어들이기 위해 사용되는 기반스트림
		// ObjectInputStream(보조) : 스트림으로부터 객체 단위로 입력 받기 위해 사용되는 보조스트림
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Phone.txt"))){
			
			Phone p = (Phone)ois.readObject(); // 형변환
			System.out.println(p); //p.toString의 결과가 출력
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
