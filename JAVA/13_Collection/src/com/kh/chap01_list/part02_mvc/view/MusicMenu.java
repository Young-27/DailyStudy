package com.kh.chap01_list.part02_mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01_list.part02_mvc.controller.MusicController;
import com.kh.chap01_list.part02_mvc.model.vo.Music;

// View : 시각적인 요소 (화면) 입력 및 출력
public class MusicMenu {
	
	// 클래스전역에서 Scanner 객체를 쓸 수 있도록 세팅
	private Scanner sc = new Scanner(System.in);
	// 클래스 전역에서 MusicController 객체를 쓸 수 있도록 세팅
	private MusicController mc = new MusicController();
	
	// alt + shift + j : 파란색주석
	/**
	 * 	프로그램 실행시 처음 보여지는 화면 (메인 메뉴)
	 */
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("\n== Welcome 별밤 ==");
			System.out.println("1. 곡 전체 조회");
			System.out.println("2. 새로운 곡 추가");
			System.out.println("3. 특정 곡 검색");
			System.out.println("4. 특정 곡 삭제");
			System.out.println("5. 특정 곡 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: selectMusicList(); break;
			case 2: insertMusic(); break;
			case 3: searchMusic(); break;
			case 4: deleteMusic(); break;
			case 5: updateMusic(); break;
			case 0: System.out.println("\n그동안 이용해주셔서 감사합니다."); return;
			default : System.out.println("\n잘못 입력하였습니다. 다시 입력해주세요.");
			}
		
		}
	
	}
	
	
	/**
	 * 곡 전체 조회하는 서브 화면
	 */
	public void selectMusicList() {
		
		System.out.println("\n=== 곡 전체 조회 ===");
		
		// 곡 전체 조회 요청!! == Controller에 메소드를 호출!!
		ArrayList<Music> list = mc.selectMusicList();
				
		if(list.isEmpty()) { // 비어있을 경우
			System.out.println("현재 존재하는 곡이 없습니다.");
		}else { // 뭐라도 담겨있을 경우
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
	}
	
	/**
	 * 새로운 곡 추가하는 서브 화면
	 */
	public void insertMusic() {
		
		System.out.println("\n=== 새로운 곡 추가 ===");
		
		System.out.print("제목 입력 : ");		
		String title = sc.nextLine();
		System.out.print("가수 입력 : ");
		String artist = sc.nextLine();
		
		// 곡 추가 요청!! == Controller 메소드 호출!!
		mc.insertMusic(title, artist);
		System.out.println("성공적으로 추가되었습니다.");
		
		
	}
	
	/**
	 * 특정 곡 검색하는 서브 화면
	 */
	/*
	public void searchMusic() {
		
		System.out.println("\n=== 특정 곡 검색 ===");
		
		System.out.print("검색할 곡 키워드 : ");
		String keyword = sc.nextLine();
		
		// 검색 요청 !! == Controller 메소드 호출!!
		ArrayList<Music> list = mc.searchMusic(keyword);
		
		if(list.isEmpty()) { // 검색 결과가 x
			System.out.println(keyword + "에 대한 검색 결과가 없습니다.");
		}else { // 검색 결과가 o
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
	}
	*/
	
	/**
	 * 특정 곡 삭제하는 서브 화면
	 */
	public void deleteMusic() {
		
		System.out.println("\n=== 특정 곡 삭제 ===");
		
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
		// 삭제 요청 !! == Controller 메소드 호출
		int result = mc.deleteMusic(title);
		
		if(result > 0) {
			System.out.println("성공적으로 삭제하였습니다.");
		}else {
			System.out.println("삭제할 곡을 찾지 못했습니다.");
		}
		
		//selecctMusicList(); // 삭제 후에 리스트를 다시 조회요청
		
		
	}
	
	/**
	 * 특정 곡 수정하는 서브 화면
	 */
	public void updateMusic() {
		
		System.out.println("\n=== 특정 곡 수정 ===");
		
		System.out.print("기존 곡 이름 : ");
		String title = sc.nextLine();
		
		System.out.print("수정 내용(가수) : ");
		String upArtist = sc.nextLine();
		
		System.out.print("수정 내용(곡명) : ");
		String upTitle = sc.nextLine();
		
		// 수정 요청 !! == Controller 메소드 호출!!
		int result = mc.updateMusic(title, upArtist, upTitle);
		
		if(result > 0) {
			System.out.println("성공적으로 변경되었습니다.");
			
		}else {
			System.out.println("수정할 곡을 찾지 못했습니다.");
			
		}
		
		
	}
	
	// 심화버전
	public void searchMusic() {
		
		System.out.println("\n=== 특정 곡 검색 ===");
		
		System.out.println("1. 제목으로 검색");
		System.out.println("2. 가수명으로 검색");
		System.out.println("3. 제목+가수명으로 검색");
		System.out.print("메뉴 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		
		System.out.print("검색할 곡 키워드 : ");
		String keyword = sc.nextLine();
		
		// 검색 요청 !! == Controller 메소드 호출!!
		ArrayList<Music> list = mc.searchMusic(menu, keyword);
		
		if(list.isEmpty()) { // 검색 결과가 x
			System.out.println(keyword + "에 대한 검색 결과가 없습니다.");
		}else { // 검색 결과가 o
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
	}
	
	

}
