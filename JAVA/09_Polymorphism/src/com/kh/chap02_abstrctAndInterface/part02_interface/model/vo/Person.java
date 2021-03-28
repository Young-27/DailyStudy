package com.kh.chap02_abstrctAndInterface.part02_interface.model.vo;

public abstract class Person {
	
	private String name;
	private double weight;
	private int health;
	
	// 기본생성자 + 매개변수생성자 + getter/setter + toString메소드
	
	public Person() {}

	public Person(String name, double weight, int health) {
		this.name = name;
		this.weight = weight;
		this.health = health;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return weight;
	}
	 public void setWeight(double weight) {
		 this.weight = weight;
	 }
	 
	 public int getHealth() {
		 return health;
	 }
	public void setHealth(int health) {
		 this.health = health;
	 }
	
	// alt+shift+s > s > enter
	 @Override
	public String toString() {
		return "name=" + name + ", weight=" + weight + ", health=" + health;
	}
	 
	 // 추상메소드 추가
	 /*
	 public abstract void eat();
	 public abstract void sleep();
	 */
	 
	 
	 

}
