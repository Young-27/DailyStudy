package com.kh.chap02_abstrctAndInterface.part01_abstract.model.vo;

public abstract class Sports {
	
	private int people; // 참여하는 선수 숫자
	
	public Sports() {}

	public Sports(int people) {
		this.people = people;
	}
	
	public int getPeople() {
		return people;
	}
	
	public void setPeople(int people) {
		this.people = people;
	}
	
	// 어떤 스포츠던 간에 지켜야하는 룰이 있을 것임 (단, 각 스포츠마다 다른 룰을 출력할 수 있도록 추상메소드로 만들어둠)
	public abstract void rule(); // 몸통부가 없는 머리부만 존재하는 "미완성된 메소드"를 만들어두고자 한다면 "추상메소드"로 정의해야됨
	// 미완성된 추상메소드가 존재한다라는 소리는 이 클래스 또한 미완성된 상태!! => 즉, 추상클래스로 작업해야됨
	

}
