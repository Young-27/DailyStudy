package com.hw2.model.vo;

public class Circle extends Point{
	
	private int radius;
	
	public Circle() {}

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void draw() {
		super.draw();
		System.out.println("면적 : " + (Math.PI * super.getX() * super.getY()));
		System.out.println("둘레 : " + (Math.PI * super.getX() * super.getY()));
		
		
	}
	

}
