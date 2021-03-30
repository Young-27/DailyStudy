package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductController;
import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;

public class ProductMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	public void MainMenu() {
		
		while(true) {
			System.out.println("\n===== 제품 관리 프로그램 =====");
			System.out.println("======== 메뉴 선택 ========");
			System.out.println("1. 전체 조회 하기");
			System.out.println("2. 상품 추가 하기");
			System.out.println("3. 상품 수정 하기");
			System.out.println("4. 상품 삭제 하기");
			System.out.println("5. 상품 검색 하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.print("\n번호를 입력하세요 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			ProductController pc = new ProductController();

			switch (menu) {
			case 1:
				pc.selectProduct();
				break;
			case 2: insertProduct();
				break;
			case 3: updateProduct();
				break;
			case 4: deleteProduct();
				break;
			case 5: selectByProductName();
				break;
			case 0:
				System.out.println("\n프로그램을 종료합니다.");
				return;
		}
		}
		
	}
	
	public void insertProduct() {
		
		System.out.print("상품 아이디 : ");
		String product_Id = sc.nextLine();
		
		System.out.print("상품명 : ");
		String p_Name = sc.nextLine();
		
		System.out.print("상품가격 : ");
		String price = sc.nextLine();
		
		System.out.print("상품상세정보 : ");
		String description =sc.nextLine();
		
		System.out.print("재고 : ");
		String stock = sc.nextLine();
		
		
		
		new ProductController().insertProduct(product_Id, p_Name, Integer.parseInt(price), description, Integer.parseInt(stock));
		
		
	}
	
	public void updateProduct() {
		
		System.out.print("수정할 상품 아이디를 입력하세요 : ");
		String product_Id = sc.nextLine();
		
		System.out.print("변경할 상품명 : ");
		String p_Name = sc.nextLine();
		
		System.out.print("변경할 상품가격 : ");
		String price = sc.nextLine();
		
		System.out.print("변경할 상품상세정보 : ");
		String description = sc.nextLine();
		
		System.out.print("변경할 재고 : ");
		String stock = sc.nextLine();
		
		new ProductController().updateProduct(product_Id, p_Name, Integer.parseInt(price), description, Integer.parseInt(stock));
		
	}
	
	public void deleteProduct() {
		
		System.out.print("삭제할 상품 아이디 입력 : ");
		String product_Id = sc.nextLine();
		
		new ProductController().deleteProduct(product_Id);
	}
	
	public void selectByProductName() {
		
		System.out.print("검색할 상품명 키워드 입력 : ");
		String keyword = sc.nextLine();
		
		new ProductController().selectByProductName(keyword);
		
	}
	
	
	
	
	
	
	
	
	
	
	// 공통 display 화면
	
	public void displayFail(String message) {
		
		System.out.println("서비스 요청 실패 : " + message);
		
	}
	
	public void displaySuccess(String message) {
		
		System.out.println("서비스 요청 성공 : " + message);
		
	}
	
	public void displayNoData() {
		
		System.out.println("\n 조회 결과가 없습니다.\n");
		
	}
	
	public void displayProductList(ArrayList<Product> list) {
		
		System.out.println("\n조회 결과입니다.\n");

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
