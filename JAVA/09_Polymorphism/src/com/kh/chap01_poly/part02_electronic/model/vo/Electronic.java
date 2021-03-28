package com.kh.chap01_poly.part02_electronic.model.vo;

public class Electronic {
	
	private String brand;
	private String name;
	private int price;
	
	public Electronic() {}

	public Electronic(String brand, String name, int price) {
		this.brand = brand;
		this.name = name;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "brand : " + brand + ", name : " + name + ", price : " + price;
	}
	

}
