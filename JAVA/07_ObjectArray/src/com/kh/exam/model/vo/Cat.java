package com.kh.exam.model.vo;

public class Cat {
	public static final String STORE = "보람가게";
	private String name;
	
	public Cat() {
	
	}
	
	public Cat(String name) {
		this.name = name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String information() {
		return STORE + "에 살고있는 " + name + "이(가) 있습니다.";
	}
	
}
