package com.kh.chap02_objectArray.model.vo;

public class Phone {
	
	// 이름, 시리즈, 브랜드명, 가격
	private String name;
	private String series;
	private String brand;
	private int price;
	
	// 기본생성자
	public Phone() {}
	
	// 모든필드에 대한 매개변수생성자
	public Phone(String name, String series, String brand, int price) {
		this.name = name;
		this.series = series;
		this.brand = brand;
		this.price = price;
	}
	// 각 필드에 대한 setter/getter 메소드
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getSeries() {
		return series;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
		
	// 모든필드 하나의 문자열로 합쳐서 반환하는 information 메소드
	public String information() {
		return name + ", " + series + ", " + brand + ", " + price;
	}
}
