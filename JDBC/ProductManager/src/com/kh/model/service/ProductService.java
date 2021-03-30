package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;
import com.kh.view.ProductMenu;

public class ProductService {
	
	public ArrayList<Product> selectProduct() {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectProduct(conn);

		close(conn);
		
		return list;

	}
	
	public int insertProduct(Product p) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().insertProduct(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int updateProduct(Product p) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().updateProduct(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
		
	}
	
	public int deleteProduct(String product_Id) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().deleteProduct(conn, product_Id);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public ArrayList<Product> selectByProductName(String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectByProductName(conn, keyword);
		
		close(conn);
		
		return list;
		
	}

}
