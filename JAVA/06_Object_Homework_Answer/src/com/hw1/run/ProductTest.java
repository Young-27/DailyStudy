package com.hw1.run;

import com.hw1.model.vo.Product;

public class ProductTest {

	public static void main(String[] args) {

		// 1. 매개변수 생성자를 이용하여 3개의 객체 생성 후 출력
		Product pro1 = new Product("ssgnote9", "갤럭시노트9", "경기도 수원", 960000, 10.0);
		Product pro2 = new Product("lgxnote5", "LG스마트폰5", "경기도 평택", 780000, 0.7);
		Product pro3 = new Product("ktsnote3", "KT스마트폰3", "서울시 강남", 250000, 0.3);

		System.out.println(pro1.information());
		System.out.println(pro2.information());
		System.out.println(pro3.information());

		System.out.println("==============================================================");

		// 2. setter메소드를 이용하여 가격을 모두 120만원으로 수정, 부가세율도 모두 0.05로 수정 후 출력
		pro1.setPrice(1200000);
		pro2.setPrice(1200000);
		pro3.setPrice(1200000);

		pro1.setTax(0.05);
		pro2.setTax(0.05);
		pro3.setTax(0.05);

		System.out.println(pro1.information());
		System.out.println(pro2.information());
		System.out.println(pro3.information());

		System.out.println("==============================================================");

		// 3. getter 메소드를 이용하여 각 객체의 가격에 부가세율을 적용한 실제 가격을 계산해서 출력
		// 부가세 포함 가격 = 가격 + (가격 * 부가세율)
		System.out.println("상품명 = " + pro1.getProductName());
		System.out.println("부가세 포함 가격 = " + (int)(pro1.getPrice() + (pro1.getPrice() * pro1.getTax())) + "원");
		
		System.out.println("상품명 = " + pro2.getProductName());
		System.out.println("부가세 포함 가격 = " + (int)(pro2.getPrice() + (pro2.getPrice() * pro2.getTax())) + "원");
		
		System.out.println("상품명 = " + pro3.getProductName());
		System.out.println("부가세 포함 가격 = " + (int)(pro3.getPrice() + (pro3.getPrice() * pro3.getTax())) + "원");

	}

}
