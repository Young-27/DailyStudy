package com.kh.test.shape.model.vo;

public class Circle {
	
	public static final double PI = Math.PI;
	
	private int radius;
	
	public Circle() {}

	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
	public static double getPi() {
		return PI;
	}
	
	public String draw() {
		return "반지름" + radius + "cm인 원을 그립니다.";
	}
	
	

}
