package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_arrayList.mode.vo.Music;

public class ListRun {

	/*
	 * 	* 컬렉션(Collection)이 뭘까?
	 *	     자료구조가 내장되어 있는 클래스로 자바에서 제공하는 "자료구조"를 담당하는 "프레임워크"이다.
	 *
	 *	* 자료구조란?
	 *	     방대한 데이터들을 효율적(구조적)으로 다룰 때 필요한 개념
	 *
	 *	* 프레임워크란?
	 *	     효율적인 기능들이 이미 정의되어있는 틀
	 *
	 *	* 정리해보면 
	 *    데이터들이 새로이 추가되거나, 삭제가 되거나 수정이 되는 기능(알고리즘)들이 이미 정의되어있는 틀이 있다 == 컬렉션
	 *    
	 *    => 다량의 데이터들을 관리하고자 할 때 배열 가지고 충분히 사용했었음 !! => 단, 배열의 단점들을 보완한게 컬렉션!!
	 *    
	 *	* 배열과 컬렉션의 차이점
	 *  > 배열의 단점
	 *    1. 배열을 쓰고자 할 때 먼저 크기를 지정해야됨!
	 *       한 번 지정된 크기는 변경이 불가!! - 변경하려면 기존 배열을 복사해서 크기 변경해야함.
	 *       => 새로운값을 추가하고자 할 때 크기가 오버될 경우 새로운 크기의 배열을 만들고 기존의 내용들을 복사해주는 코드를 직접짜야됨!!
	 *    2. 배열 중간 위치에 새로운 데이터를 추가하거나 삭제하는 경우 기존의 값들을 땡겨주는 코드를 직접 짜야됨!!
	 *    3. 한 타입의 데이터들만 저장 가능
	 *  
	 *  > 컬렉션의 장점
	 *    1. 크기에 제약이 없다!!
	 *       크기지정을 해줄 필요도 없고 만일 크기지정을 한다고 해도 알아서 크기가 늘어나면서 새로운 데이터를 추가해주는 코드가 이미 정의되어있음!!
	 *    2. 중간에 값을 추가하거나 삭제하는 경우 값을 땡겨주는 코드가 이미 메소드로 정의되어있음!
	 *    3. 기본적으로 여러 타입의 데이터들을 저장할 수 있음 (단, 제네릭설정을 통해서  한 타입의 데이터만 들어올 수 있게끔도 가능)
	 *    
	 *	방대한 데이터들을 단지 담아만 두고 조회만 할 목적 => 배열
	 *	방대한 데이터들이 빈번하게 새로이 추가, 삭제, 수정 될 것 같다 => 컬렉션
	 *
	 *	컬렉션은 크게 세가지로 분류됨
	 *	
	 *	List계열 : 담고자하는 값(value)만 저장 / 값 저장시 순서유지(index개념있음) / 중복 값 허용됨
	 *           ex) **ArrayList**, Vector(거의안씀), LinkedList  
	 *	Set 계열 : 담고자하는 값(value)만 저장 / 값 저장시 순서유지x(index개념없음) / 중복 값 허용안됨
	 *           ex) HashSet, TreeSet  Set계열 거의 안씀
	 *	Map 계열 : 키(key)+담고자하는값(value)세트로 저장 / 값 저장시 순서유지x / key 중복 값 허용안됨
	 *           ex) **HashMap*, *Properties*, TreeMap
	 *    
	 */
	public static void main(String[] args) {
		
		//ArrayList List = new ArrayList(); // 내부적으로 크기 10짜리인 배열이 생성됨
		
		// 제네릭(<E>)
		// 별도의 제네릭 제시없이 컬렉션 객체 생성하면 (E == Object)
		// 해당 컬렉션에 다양한 타입의 데이터 값들이 담길 수 있음
		
		// 별도의 제네릭 설정으로 <Music>으로 하게 되면 (E == Music)
		
		/*
		 * 	* 제네릭을 설정 하는 이유
		 * 	1. 명시한 타입의 객체만 저장가능하도록 타입의 제한을 두기 위해서
		 * 	2. 컬렉션 저장된 객체를 꺼내서 사용할 때 매번 형변환하는 절차를 없애기 위해서
		 * 
		 */
		
		ArrayList<Music> list = new ArrayList<>(3); // 내부적으로 크기 3짜리인 배열이 생성됨
		
		System.out.println(list); // 안에 아무것도 없는 상태 (비어있는 상태)
		
		// E --> Element
		
		// 1. add(E e) : 리스트의 맨 끝에 해당 전달되는 e를 추가시켜주는 메소드
		list.add(new Music("Good Bye", "박효신"));
		list.add(new Music("이 밤", "양다일"));
		list.add(new Music("잊혀지다", "정키"));
		//list.add("끝");
		// 순서유지되면서 값 추가 (각 index에 담겨있음)
		// 크기에 제약이 없음
		// 다양한 타입의 값을 추가 가능
		
		System.out.println(list);
		
		// 2. add(int index, E e) : 리스트에 전달되는 index값 위치에 전달되는 e를 추가시켜주는 메소드
		list.add(1, new Music("진심이 담긴 노래", "케이시"));
		// 중간에 값 추가시 알아서 기존의 값들 뒤로 땡겨주는 작업이 내부적으로 진행됨
		
		System.out.println(list);
		
		// 3. set(int index, E e) : 리스트에 해당 인덱스의 값을 전달되는 e로 변경시켜주는 메소드
		list.set(0, new Music("술이 달다", "에픽하이"));
		
		System.out.println(list);
		
		// 4. remove(int index) : 리스트에 해당 인덱스의 값을 삭제시켜주는 메소드
		list.remove(1);
		
		System.out.println(list);
		
		// 5. size() : 리스트에 담겨있는 데이터 수 반환해주는 메소드
		System.out.println("리스트에 담긴 데이터 수 : " + list.size());
		System.out.println("리스트의 마지막 인덱스 : " + (list.size() - 1));
		
		// 6. get(int index) : E	=>	리스트에 해당 index위치의 데이터를 반환해주는 메소드
		/* 제네릭 설정 전
		Music m = (Music)list.get(1); // 기본적으로 object로 반환하기 때문에 강제형변환이 필요함
		System.out.println(m);
		System.out.println(m.getTitle());
		
		System.out.println(list.get(0));
		System.out.println(((Music) list.get(0)).getTitle());
		*/
		// 제네릭 설정 후
		Music m = list.get(1);
		System.out.println(m);
		System.out.println(m.getTitle());

		System.out.println(list.get(0));
		System.out.println(list.get(0).getTitle());
		
		System.out.println("=====================");
		// 0번 ~ 마지막인덱스까지의 데이터 출력
		// for loop문
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=====================");
		
		// for each문
		// for(Object o : list) { // 제네릭 설정 전
		for (Music o : list) { // 제네릭 설정 후
			System.out.println(o);
		}
		
		System.out.println("=====================");
		
		// 7. subList(int index1, int index2) : 해당 리스트로부터 index1에서부터 index2까지의 데이터 값들을 추출해서 새로운 List로 반환시켜주는 메소드
		List sub = list.subList(0, 2); // 0 <=	< 2
		System.out.println(sub);
		
		//8. addAll(Collection c) : 해당 리스트에 다른 컬렉션에 있는 데이터들을 통째로 추가해주는 메소드
		list.addAll(sub);
		System.out.println(list);
		
		// 9. isEmpty() : 해당 리스트가 비어있는지 묻는 메소드 (비어있으면 true/ 비어있지 않으면 false 반환)
		System.out.println(list.isEmpty());
		
		// 10. clear() : 해당리스트를 싹 비워주는 메소드
		list.clear();
		
		System.out.println(list);
		System.out.println(list.isEmpty());
			
		
	}

}
