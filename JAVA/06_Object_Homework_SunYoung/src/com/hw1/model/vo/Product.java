package com.hw1.model.vo;

public class Product {
	
	private String productId;		// 상품아이디
	private String productName;		// 상품명
	private String productArea;		// 생산지
	private int price;				// 가격
	private double tax;				// 부가세비율
	
	public Product() {
		
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
	public String getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getProductArea() {
		return productArea;
	}
	
	public int getPrice() {
		return price;
	}
	
	public double getTax() {
		return tax;
	}	
	
	public String information() {
		return productId + " " + productName + " " + productArea + " " + price + " " + tax;
		
	}

}
