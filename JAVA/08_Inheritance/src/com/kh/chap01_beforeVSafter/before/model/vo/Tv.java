package com.kh.chap01_beforeVSafter.before.model.vo;

public class Tv {
	
	private String brand;
	private String pCode;
	private String pName;
	private int price;
	private int inch;
	
	public Tv() {
		
	}
	
	public Tv(String brand, String pCode, String pName, int price, int inch) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.inch = inch;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpCode() {
		return pCode;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpName() {
		return pName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	public void setInch(int inch) {
		this.inch = inch;
	}
	public int getInch() {
		return inch;
	}
	
	public String information() {
		return brand + " " + pCode + " " + pName 
				+ " " + price + " " + inch;
	}
}
