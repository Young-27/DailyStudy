package com.kh.chap01_beforeVSafter.after.model.vo;
		//	 자식			     부모
		//	 후손			     조상
		//	 하위			     상위
public class Tv extends Product{
	
	private int inch;
	
	public Tv() {}
	
	public Tv(String brand, String pCode, String pName, int price, int inch) {
		
		super(brand, pCode, pName, price);
		this.inch = inch;
		
	}
	
	public int getInch() {
		return inch;
	}
	
	public void setInch(int inch) {
		this.inch = inch;
	}
	
	// 오버라이딩
	public String information() {
		return super.information() + ", inch : " + inch;
	}
	
	
}
