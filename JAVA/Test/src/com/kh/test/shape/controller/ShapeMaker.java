package com.kh.test.shape.controller;

import com.kh.test.shape.model.vo.Circle;
import com.kh.test.shape.model.vo.RectAngle;

public class ShapeMaker {

	public static void main(String[] args) {
		
		Circle [] ar1 = new Circle[3];
		
		ar1[0] = new Circle();
		ar1[1] = new Circle();
		ar1[2] = new Circle();
		
		ar1[0].setRadius(20);
		ar1[1].setRadius(40);
		ar1[2].setRadius(50);
		
		
		for(Circle c : ar1) {
			
			System.out.println(c.draw());
			
		}
		
		RectAngle [] ar2 = new RectAngle[2];
		
		ar2[0] = new RectAngle();
		ar2[1] = new RectAngle();
		
		ar2[0].setHeight(20);
		ar2[0].setWidth(20);
		
		ar2[1].setHeight(60);
		ar2[1].setWidth(50);
		
		
		for(int i=0; i<ar2.length; i++) {

			System.out.println(ar2[i].draw());
			
		}
	
		
		
		

	}

}
