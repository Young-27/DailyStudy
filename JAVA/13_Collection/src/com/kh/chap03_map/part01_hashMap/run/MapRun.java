package com.kh.chap03_map.part01_hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		
		HashMap<String, Snack> hm = new HashMap<>();
		
		// K --> Key
		// V --> Value
		
		
		// 1. put(K key, V value) : 해당 맵에 key, value 세트로 저장시켜주는 메소드
		hm.put("다이제", new Snack("초코맛", 1500));
		hm.put("칸초", new Snack("단맛", 600));
		hm.put("새우깡", new Snack("짠맛", 500));
		
		hm.put("포테이토칩", new Snack("짠맛", 500));
		
		System.out.println(hm); // 저장되는 순서 유지되지않음
		
		hm.put("새우깡", new Snack("매운맛", 800)); // 중복된 키값이 이미 존재할 경우 새로이 추가되는 value로 덮어씌워짐
		
		System.out.println(hm);
		
		
		// 2. get(Object key) : V	=> 해당 맵으로부터 전달되는 key에 해당하는 value 반환
		System.out.println(hm.get("다이제"));
		System.out.println(hm.get("다이제").getFlavor());
		
		
		// 3. size() : 해당 맵에 담긴 key+value 세트의 개수 반환
		System.out.println(hm.size());
		
		// 4. replace(K key, V value) : 해당 맵으로부터 전달된 key 찾아서 그에 해당하는 value값을 새로이 전달되는 value 변경시켜주는 메소드
		hm.replace("포테이토칩", new Snack("겁나짠맛", 1000));
		
		System.out.println(hm);
		
		// 5. remove(Object key) : 해당 맵으로부터 전달된 key값 찾아서 key+value 세트 제거해주는 메소드
		hm.remove("다이제");
		System.out.println(hm);
		
		
		// HashMap에 담겨있는 모든 것들에 순차적으로 접근하고자 할 때 쓰이는 방법
		// for문 안됨, ArrayList에 담아서 출력하는거 안됨
		//ArrayList list = new ArrayList(hm);
		
		// Iterator를 이용할 수 밖에 없음!!
		//hm.iterator();	=> 바로 호출 불가!! 왜? iterator()는 List계열 또는 Set계열에서만 쓸 수 있는 메소드!!
		
		// Map을 Set으로 바꿔주는 메소드 제공함!!
		// K+V 값을  keySet() 메소드로 K로 바꿀 수 있다.
		
		// 1) hm에 있는 키들만 Set에 담기
		Set<String> ks = hm.keySet();
		
		// 2) ks에 담겨있는 키들 Iterator에 담기
		Iterator<String> it = ks.iterator();
		
		// 3) 반복문을 이용해서 하나씩 뽑아내기
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("key : " + key);
			System.out.println("value : " + hm.get(key));
		}
		

		
		
	}

}
