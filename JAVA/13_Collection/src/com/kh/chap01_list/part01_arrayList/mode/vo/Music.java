package com.kh.chap01_list.part01_arrayList.mode.vo;

public class Music {
	
	private String title; // 노래제목
	private String artist; //가수명
	
	// 기본생성자, 매개변수생성자, getter/setter메소드, toString메소드
	public Music() {}
	
	public Music(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + "]";
	}
	
	// Object클래스에 있는 equals(Object obj) : boolean		=> 두 객체의 주소값이 일치하면 true / 아니면 false 반환
	
	// 주소값 비교가 아닌 실제 필드값들이 모두 같을 경우 true / 하나라도 틀릴 경우 false가 반환되도록 재정의
	@Override
	public boolean equals(Object obj) { // 주소값이 아닌 필드값으로 비교하도록 equals 오버라이딩
		//return (this == obj); // Object 클래스의 equals 메소드의 내용
		
		//				this (현 객체)		vs		obj (전달받은 비교할 대상 객체)
		// 자료형				Music					Object
		
		Music other = (Music)obj;
		
		// this(현객체) vs other(비교할대상객체)
		
		// this.title == other.title && this.artist == other.artist		
		if(this.title.contentEquals(other.title) && this.artist.equals(other.artist)){
			return true;
		}else {
			return false;
		}
		
		
	
		
	}
	
	
	
	
	
	
	
	
	
	

}
