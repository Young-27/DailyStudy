package com.kh.chap02_set.part01_hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;

public class SetRun {

	public static void main(String[] args) {
		
		HashSet hs1 = new HashSet();
		
		hs1.add("반갑습니다."); // 리터럴 => 상수풀 == 동일한 문자열 존재불가
		hs1.add(new String("반갑습니다.")); // => Heap영역 == 새로운 주소값 부여(동일문자열 존재가능)
		hs1.add(new String("여러분"));
		hs1.add(new String("안녕하세요"));
		hs1.add(new String("여러분"));
		//hs1.add(10);
		
		System.out.println(hs1); // [안녕하세요, 여러분, 반갑습니다.] 
		// 저장 순서 유지 안됨 (추가한 순서대로 출력안됨), 중복값 허용안됨
		
		// HashSet에 객체가 추가될때마다 기존에 담겨있는 객체들과 매번 equals비교, hashCode값 비교를 통해서 동일객체 판단함!!
		// String 클래스에서는 equals메소드, hashCode메소드가 오버라이딩 되어있음!! (주소값 기반이 아닌 실제담긴 문자열값 기반의 내용으로 수행되도록)
		
		
		HashSet<Student> hs2 = new HashSet<>();
		
		hs2.add(new Student("공유", 45, 100));
		hs2.add(new Student("김말똥", 20, 40));
		hs2.add(new Student("홍길동", 24, 20));
		hs2.add(new Student("공유", 45, 100));
		
		System.out.println(hs2);
		// 공유 학생 객체가 중복돼서 들어가있음 (왜? 동일한 객체로 판단이 안됐기 때문에!!) 
		// 주소값을 가지고 비교하고 있는 상태 (Object클래스에 있는 hashCode, equals메소드가 수행되고 있는 상태)
		
		// 주소값을 다 떠나서 각각의 필드값이 일치할 경우 동일한 객체로 판단이 되게끔 하고자 한다면 Student클래스에 오버라이딩 해주면됨!
		
		/*
		Student s1 = new Student("강보람", 10, 30);
		Student s2 = new Student("강보람", 10, 30);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s1.equals(s2));
		*/
		
		// 특정 하나만을 뽑아올 순 없음!!
		
		// 단, HashSet 공간에 담겨있는 객체들에 순차적으로 접근은 가능!!
		
		// 1. for문 사용가능 (단, 향상된 for문으로 밖에 안됨!!)
		for(Student s : hs2) {
			System.out.println(s);
		}
		
		System.out.println("==================");
		
		// 2. ArrayList에 담아준 다음에 ArrayList반복문 수행
		
		// 1) ArrayList생성 후 addAll 메소드를 통해서 통째로 추가하는 방법
		//ArrayList<Student> list = new ArrayList<>();
		//list.addAll(hs2);
		
		// 2) ArrayList 객체 생성과 동시에 통째로 추가하는 방법
		ArrayList<Student> list = new ArrayList<>(hs2);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("==================");
		
		// 3. Iterator 반복자를 이용하는 방법 (stringTokenizer와 비슷한 개념)
		Iterator<Student> it = hs2.iterator(); // hs2에 담겨있는 객체들을 --> Iterator(반복자)에 담는 과정
		// .iterator() 메소드는 List계열과 Set계열의 컬렉션에서만 호출가능한 메소드!!
		
		
		while(it.hasNext()) { // hasNext() : it로부터 다음에 읽어올것이 있으면 반복/ 없으면 멈춤
			System.out.println(it.next().getName()); 
		}
		
		//System.out.println(it.next()); // 다음 내용이 남아있지 않아서 오류남
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
