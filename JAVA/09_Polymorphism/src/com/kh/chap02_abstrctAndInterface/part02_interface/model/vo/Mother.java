package com.kh.chap02_abstrctAndInterface.part02_interface.model.vo;

// implement 구현한다.
public class Mother extends Person implements Basic {
	
	private String babyBirth; // 출산/입양
	
	public Mother() {}
	public Mother(String name, double weight, int health, String babyBirth) {
		super(name, weight, health);
		this.babyBirth = babyBirth;
	}
	
	public String getBabyBirth() {
		return babyBirth;
	}
	public void setBabyBirth(String babyBirth) {
		this.babyBirth = babyBirth;
	}
	
	@Override
	public String toString() {
		return "Mother [" + super.toString() + ", babyBirth=" + babyBirth + "]";
	}
	
	@Override
	public void eat() {
		// 기존의 몸무게 10 증가
		//super.weight = super.weight + 10;
		super.setWeight(super.getWeight() + 10);
		
		// 기존의 건강도 5 감소
		super.setHealth(super.getHealth() - 5);
		
	}
	
	@Override
	public void sleep() {
		// 기존의 건강도 10 증가
		super.setHealth(super.getHealth() + 10);
	}
	
	
	
}
