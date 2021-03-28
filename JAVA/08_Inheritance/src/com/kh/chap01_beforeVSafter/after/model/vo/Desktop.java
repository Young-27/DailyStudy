package com.kh.chap01_beforeVSafter.after.model.vo;

		//		자식				부모
public class Desktop extends Product {
	
	private boolean allInOne;
	
	public Desktop() {}
	
	public Desktop(String brand, String pCode, String pName, 
									int price, boolean allInOne) {
		// brand, pCode, pName, price => 부모클래스인 Product에 있는 필드에 초기화
		
		// super.은 해당 부모주소를 담고 있다. (즉, super. 으로 부모에 접근 가능)
		// 단, 접근하고자 하는게 private일 경우 뭐가 됐든 외부에서는 직접 접근 불가
		
		// 해결방법1. 부모클래스의 필드를 자식까지는 접근 가능하게끔 protected로 하기
		/*
		super.brand = brand;
		super.pCode = pCode;
		super.pName = pName;
		super.price = price;
		*/
		
		// 해결방법2. 부모클래스에 있는 public접근제한자인 setter메소드 활용하기
		/*
		super.setBrand(brand);
		super.setpCode(pCode);
		super.setpName(pName);
		super.setPrice(price);
		*/
		
		// 해결방법3. 부모생성자 호출하기
		super(brand, pCode, pName, price);		
		this.allInOne = allInOne;
	}
	
	public boolean isAllInOne() {
		return allInOne;
	}
	
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	// 오버라이딩 (부모클래스의 메소드를 내 입맛대로 재정의함)
	public String information() {
		//return "brand : " + super.getBrand() + ", pCode : " + super.getpCode() + ~~~~~ +
		return super.information() + ", allInOne : " + allInOne;	
	}
	
	
}
