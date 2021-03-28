package com.kh.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kh.chap01_list.part02_mvc.model.vo.Music;

// Controller : 사용자의 요청을 받아서 처리해주는 역할
public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	{
		list.add(new Music("안녕", "나의사랑"));
		list.add(new Music("Goodbye", "박효신"));
		list.add(new Music("안경잡이", "나비"));
	}

	public ArrayList<Music> selectMusicList() {

		return list;

	}

	public void insertMusic(String title, String artist) {

		list.add(new Music(title, artist));

	}

	/*
	 * public ArrayList<Music> searchMusic(String keyword) {
	 * 
	 * ArrayList<Music> searchList = new ArrayList<>();
	 * 
	 * for(int i=0; i<list.size(); i++) {
	 * 
	 * if(list.get(i).getTitle().contains(keyword) ||
	 * list.get(i).getArtist().contains(keyword)) {
	 * //System.out.println(list.get(i)); searchList.add(list.get(i)); }
	 * 
	 * }
	 * 
	 * return searchList;
	 * 
	 * }
	 */

	public ArrayList<Music> searchMusic(int menu, String keyword) {
		
		ArrayList<Music> searchList = new ArrayList<>(); // 텅빈리스트
		
		if(menu == 1) {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getTitle().contains(keyword)) {
					searchList.add(list.get(i));
				}
			}
		}else if(menu == 2) {
			for(int i=0; i<list.size(); i++) {				
				if(list.get(i).getArtist().contains(keyword)) {
					searchList.add(list.get(i));
				}
			}
		}else if(menu == 3) {
			for(int i=0; i<list.size(); i++) {
			
				if(list.get(i).getTitle().contains(keyword) || list.get(i).getArtist().contains(keyword)) {
				//System.out.println(list.get(i));
				searchList.add(list.get(i));
				}		
			}
		}
		
		return searchList;
	}

	public int deleteMusic(String title) {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				list.remove(i--);
				// list 삭제하면 크기와 인덱스가 줄어듦(앞으로 땡겨짐) => i--함으로써 remove연산 후 i가 제자리걸음(?)하게 만들어야함
				result++;

			}
		}
		// result = ?
		return result;

	}

	public int updateMusic(String title, String upArtist, String upTitle) {

		int result = 0; // 수정된 개수
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {

				// 1. list.get(i)에 위치해 있는 기존의 Music의 각 필드값 따로따로 수정
				/*
				 * list.get(i).setArtist(upArtist); list.get(i).setTitle(upTitle);
				 */

				// 2. list에 i 위치에 Music 객체를 아예 새로운 내용의 Music 객체로 통째로 변경
				list.set(i, new Music(upTitle, upArtist));
				result++;
			}
		}
		return result;
	}

}
