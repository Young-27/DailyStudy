package com.kh.chap02_inherit.model.vo;

public class Airplane extends Vehicle{
	
	private int tire;
	private int wing;
	
	public Airplane() {}
	public Airplane(String name, double mileage, String kind, int tire, int wing) {
		super(name, mileage, kind);
		this.tire = tire;
		this.wing = wing;
	}
	
	public int getTire() {
		return tire;
	}	
	public void setTire(int tire) {
		this.tire = tire;
	}
	
	public int getWing() {
		return wing; 
	}
	public void setWing(int wing) {
		this.wing = wing;
	}
	
	public String information() {
		return super.information() + ", " + tire + ", " + wing;
	}
	
	@Override
	public void howToMove() {
		System.out.println("바퀴를 굴리면서 달리다가 날개를 휘저으면서 움직인다.");
	}

}
