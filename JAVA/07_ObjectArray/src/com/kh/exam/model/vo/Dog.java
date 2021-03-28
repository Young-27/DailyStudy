package com.kh.exam.model.vo;

public class Dog {
	
	private String name;
	private double weight;
	private double height;
	
	public Dog() {}
	
	public Dog(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}
	public double weight() {
		return weight;
	}
	public double height() {
		return height;
	}
	
	public String information() {
		return name + "은(는) 몸무게는 " + weight + "kg 이고, 몸의 길이는 " + height + "cm 입니다.";
	}
	
}
