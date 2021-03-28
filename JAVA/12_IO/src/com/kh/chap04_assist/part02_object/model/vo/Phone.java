package com.kh.chap04_assist.part02_object.model.vo;

import java.io.Serializable;

public class Phone implements Serializable { // 직렬화 선언 
											 // 통로를 통과하기위해 일렬화하는것!! 직렬화하기 위한 인터페이스일뿐, 오버라이딩 하지 않아도됨
	
	private String name;
	private int price;
	
	public Phone() {
		
	}

	public Phone(String name, int price) {
		this.name = name;
		this.price = price;
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
		return "Phone [name=" + name + ", price=" + price + "]";
	}
	
	
	

}
