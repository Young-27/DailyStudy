package com.kh.model.vo;

public class Product {
	
	private String product_Id;
	private String p_Name;
	private int price;
	private String description;
	private int stock;
	
	public Product() {}
	

	public Product(String product_Id, String p_Name, int price, String description, int stock) {
		super();
		this.product_Id = product_Id;
		this.p_Name = p_Name;
		this.price = price;
		this.description = description;
		this.stock = stock;
	}


	public String getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return product_Id + ", " + p_Name + ", " + price + ", "
				+ description + ", " + stock;
	}
	
	
	
	
	
}
