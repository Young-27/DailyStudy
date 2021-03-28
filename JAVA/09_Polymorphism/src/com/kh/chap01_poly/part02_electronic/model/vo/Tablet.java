package com.kh.chap01_poly.part02_electronic.model.vo;

public class Tablet extends Electronic{
	
	private boolean penFlag;
	
	public Tablet() {}

	public Tablet(String brand, String name, int price, boolean penFlag) {
		super(brand, name, price);
		this.penFlag = penFlag;
	}

	public boolean isPenFlag() {
		return penFlag;
	}

	public void setPenFlag(boolean penFlag) {
		this.penFlag = penFlag;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", penFlag : " + (penFlag ? "있음" : "없음");
	}
	
	

}
