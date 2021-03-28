package com.hw2.model.vo;

public class Circle extends Point {

	private int radius;
	
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
	
	@Override
	public void draw() {
		super.draw();
		System.out.printf("면적 : %.1f \n", Math.PI * radius * radius) ;
		System.out.printf("둘레 : %.1f \n", Math.PI * 2 * radius);
	}
}
