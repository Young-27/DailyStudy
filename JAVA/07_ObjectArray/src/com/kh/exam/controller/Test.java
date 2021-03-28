package com.kh.exam.controller;

import com.kh.exam.model.vo.Cat;
import com.kh.exam.model.vo.Dog;

public class Test {
	public static void main(String[] args) {
		
		Cat[] arr1 = new Cat[3];
		arr1[0] = new Cat("³Ä¿Ë");
		arr1[1] = new Cat("²¥¿Ë");
		arr1[2] = new Cat("´ô¿Ë");
		
		for(Cat c : arr1) { 
			System.out.println(c.information());
		}
		
		
		Dog[] arr2 = new Dog[2];
		arr2[0] = new Dog("º¹½ÇÀÌ", 3.4, 50.0);
		arr2[1] = new Dog("Çã½ºÅ°", 10.3, 130.4);
		
		for(Dog d : arr2) {
			System.out.println(d.information());
		}
		
	}
}
