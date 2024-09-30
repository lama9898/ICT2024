package collection20;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import console.academy.Student;

// Vector : List 계열 컬렉션


public class VectorApp {

	public static void main(String[] args) {
		
		// 컬렉션 객체 생성
		Vector<Student> vec = new Vector<>();
		
		// 컬렉션에 저장할 객체 생성
		Student stu1 = new Student("A",20,"2024학번");
		Student stu2 = new Student("B",24,"2020학번");
		Student stu3 = new Student("C",19,"2025학번");
		Student stu4 = new Student("D",27,"2017학번");
		
		// 객체 저장
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
		
		// 출력
		System.out.println("--  일반 for문  --");
		for(int i=0;i<vec.size();i++) {
			vec.get(i).print();
		}
		
		System.out.println("--  확장 for문  --");
		for(Student s:vec) s.print();
		
		System.out.println("--   반 복 기   --");
		Iterator<Student> it = vec.iterator();
		while(it.hasNext()) it.next().print();
		
		// 열거형 : elements() 메소드로 Enumeration 타입 얻기
		// Enumeration 타입의 주요 메소드
		// hasMoreElements() : 저장된 객체가 있으면 true, 없으면 false 반환
		// nextElement() : 저장된 객체를 얻을 때
		
		System.out.println("--   열 거 형   --");
		Enumeration<Student> em = vec.elements();
		while(em.hasMoreElements()) em.nextElement().print();
		
		//삭제
		// 1) 인덱스로 삭제
		//System.out.println("삭제된 학생의 학번 : "+ vec.remove(2).stNumber);
		
		// 2) 인스턴스(주소)로 삭제
		//System.out.println(vec.remove(stu3)?"삭제 성공":"삭제 실패");	// boolean remove() : true/false 값만 나옴
		
		// 문제] vec컬렉션에 저장된 student 객체들을 나이가 높은 순으로 재 배치후 출력(나이순으로 내림차순 정렬)
		// 단, list계열의 get(인덱스) 및 set(인덱스, 객체)메소드 사용
		Student temp;
		for(int i=0;i<vec.size();i++) {
			for(int j=0;j<vec.size()-1;j++) {
				if(vec.get(i).age>=vec.get(j).age) {
					temp = vec.get(i);
					vec.set(i, vec.get(j));
					vec.set(j,temp);
				}
			}
		}
		
		System.out.println("나이 순으로 재배치 후 출력 :");
		for(Student s: vec) s.print();
		
	}

}















