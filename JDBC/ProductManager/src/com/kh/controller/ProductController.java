package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductMenu;

public class ProductController {
	
	public void selectProduct() {
		
		ArrayList<Product> list = new ProductService().selectProduct();
		
		if(list == null) {
			new ProductMenu().displayNoData();
		}else {
			new ProductMenu().displayProductList(list);
		}
		
	}
	
	public void insertProduct(String product_Id, String p_Name, int price, String description, int stock) {
		
		Product p = new Product();
		
		p.setProduct_Id(product_Id);
		p.setP_Name(p_Name);
		p.setPrice(price);
		p.setDescription(description);
		p.setStock(stock);
		
		int result = new ProductService().insertProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("성공적으로 상품 추가가 완료되었습니다.");
		}else {
			new ProductMenu().displayFail("상품 추가에 실패했습니다.");
		}
		
	}
	
	public void updateProduct(String product_Id, String p_Name, int price, String description, int stock) {
		
		Product p = new Product();
		
		p.setProduct_Id(product_Id);
		p.setP_Name(p_Name);
		p.setPrice(price);
		p.setDescription(description);
		p.setStock(stock);
		
		int result = new ProductService().updateProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("성공적으로 상품 수정이 완료되었습니다.");
		}else {
			new ProductMenu().displayFail("상품 수정에 실패했습니다.");
		}
		
		
		
	}
	
	public void deleteProduct(String product_Id) {
		
		int result = new ProductService().deleteProduct(product_Id);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("성공적으로 삭제 되었습니다.");
		} else {
			new ProductMenu().displayFail("삭제 실패 !!");
		}
		
	}
	
	public void selectByProductName(String keyword) {
		
		ArrayList <Product> list = new ProductService().selectByProductName(keyword);
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData();
		} else {
			new ProductMenu().displayProductList(list);
		}
		
	}

}
