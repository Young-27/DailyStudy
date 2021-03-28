package com.kh.chap04_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectsDao {
	
	// 프로그램 --> 파일 (출력)
	public void fileSave(String fileName) {
		
		/* 객체배열 방법
		Phone[] arr = new Phone[3];
		
		arr[0] = new Phone("아이폰", 1500000);
		arr[1] = new Phone("갤럭시", 1300000);
		arr[2] = new Phone("플립폰", 2000000);
		*/
		
		// Phone 객체만 저장할 수 있는 ArrayList 생성
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		
		// PhoneList에 3개의 Phone객체들 저장
		phoneList.add(new Phone("아이폰", 1500000));
		phoneList.add(new Phone("갤럭시", 1300000));
		phoneList.add(new Phone("플립폰", 2000000));
		
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			
			/* 객체 배열이었을 때의 구문
			for(int i=0; i<arr.length; i++) {
				oos.writeObject(arr[i]);
			}
			*/
			
			for(int i=0; i<phoneList.size(); i++) {
				oos.writeObject(phoneList.get(i));
			}
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// 프로그램 <-- 파일(입력)
	public void fildRead() {
		
		// FileInputStream(기반) / ObjectInputStream(보조)
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PhoneList.txt"))){
			
			while(true) {
				System.out.println(ois.readObject());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) { // EOF == End Of File의 약자
			System.out.println("파일을 다 읽었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	/*	시험!! 아래 내용 복습해보기
	 *	* 스트림의 특징
	 *	
	 *	* 바이트 스트림과 문자 스트림의 차이점
	 *	* 기반 스트림과 보조 스트림의 차이점
	 *	* 보조스트림 (성능향상보조스트림 / 객체단위입출력보조스트림)
	 *	* vo클래스 직렬화선언
	 *
	 * 
	 */
	
	
	
	
	
	
	
	
	

}
