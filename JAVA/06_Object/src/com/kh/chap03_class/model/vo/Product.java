package com.kh.chap03_class.model.vo;

public class Product {
	
	// 상품명, 상품가격, 브랜드
	private String pName;
	private int price;
	private String brand = "애플";
	
	// setter메소드
	//public void setPName(String pName) {
	//public void setPname(String pName) {
	public void setpName(String pName) {	
		this.pName = pName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	// getter메소드
	
	public String getpName() {
		return pName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getBrand() {
		return brand;
	}
	
	
	// 모든 필드값을 하나의 문자열로 합쳐서 반환시켜주는 information 메소드
	
	public String information() {
		return pName + "의 가격은 " + price + "이고, 브랜드는 " + brand + "입니다.";
	}
	
}
