package com.hw1.run;

import com.hw1.model.vo.Product;

public class ProductTest {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		p1.setProductId("ssgnote");
		p1.setProductName("갤럭시노트9");
		p1.setProductArea("경기도 수원");
		p1.setPrice(96000);
		p1.setTax(10.0);
		
		Product p2 = new Product();
		p2.setProductId("lgnote5");
		p2.setProductName("LG스마트폰5");
		p2.setProductArea("경기도 평택");
		p2.setPrice(960000);
		p2.setTax(0.7);
		
		Product p3 = new Product();
		p3.setProductId("ktsnote3");
		p3.setProductName("KT스마트폰3");
		p3.setProductArea("서울시 강남");
		p3.setPrice(250000);
		p3.setTax(0.3);
		
		System.out.println(p1.information());		
		System.out.println(p2.information());		
		System.out.println(p3.information());
		System.out.println("=======================================");
		
		p1.setPrice(1200000);
		p2.setPrice(1200000);
		p3.setPrice(1200000);
		p1.setTax(0.05);
		p2.setTax(0.05);
		p3.setTax(0.05);
		
		System.out.println(p1.information());		
		System.out.println(p2.information());		
		System.out.println(p3.information());
		System.out.println("=======================================");
		
		System.out.println("상품명 = " + p1.getProductName());
		System.out.printf("부가세 포함 가격 = %.0f원\n", (p1.getPrice() + p1.getPrice() * p1.getTax()));
		System.out.println("상품명 = " + p2.getProductName());
		System.out.printf("부가세 포함 가격 = %.0f원\n", (p2.getPrice() + p2.getPrice() * p2.getTax()));
		System.out.println("상품명 = " + p3.getProductName());
		System.out.printf("부가세 포함 가격 = %.0f원\n", (p3.getPrice() + p3.getPrice() * p3.getTax()));
		
		
	}

}
