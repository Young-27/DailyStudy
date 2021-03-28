package com.kh.chap02_inherit.run;

import com.kh.chap02_inherit.model.vo.Airplane;
import com.kh.chap02_inherit.model.vo.Car;
import com.kh.chap02_inherit.model.vo.Ship;
import com.kh.chap02_inherit.model.vo.Vehicle;

public class Run {

	public static void main(String[] args) {
		
		Car c = new Car("벤틀리", 12.5, "세단", 4);
		Ship s = new Ship("낚시배", 3, "어선", 1);
		Airplane p = new Airplane("보잉774", 0.02, "제트기", 16, 5);
		
		System.out.println(c.information());
		System.out.println(s.information());
		System.out.println(p.information());
		
		c.howToMove();
		s.howToMove();
		p.howToMove();
		
		// 다형성 : 상속구조라면 가능. 하나의 형태로 여러가가지 형태를 다룰 수 있는 ??
		Vehicle v = new Car();
		Vehicle v2 = new Ship();
		Vehicle v3 = new Airplane();
		
		Vehicle[] arr = new Vehicle[3];
		arr[0] = new Car();
		arr[1] = new Ship();
		arr[2] = new Airplane();
	}

}
