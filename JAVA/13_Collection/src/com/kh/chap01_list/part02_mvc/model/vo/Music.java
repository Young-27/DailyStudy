package com.kh.chap01_list.part02_mvc.model.vo;

// VO(Value Object) : 데이터들을 담을 수 있게 도와주는 역할
public class Music {
	
	private String title;
	private String artist;
	
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
	
	
	

}
