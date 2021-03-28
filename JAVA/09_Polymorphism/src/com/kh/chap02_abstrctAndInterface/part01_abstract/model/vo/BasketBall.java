package com.kh.chap02_abstrctAndInterface.part01_abstract.model.vo;

public class BasketBall extends Sports{ // 상속받는 순간 강제로 오버라이딩 해야됨
	
	
	
	@Override
	public void rule() {
		System.out.println("손으로 공을 던져 링에 넣어야된다.");
	}
	
	
	

}
