package collection20;

// 2번 코드 비교, 사유 : 졸음

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import console.academy.Student;

// ArrayList : List(인터페이스)계열의 컬렉션 클래스
/*
 *  - 중복 저장 가능, 순서 있게 저장
 *  - 데이터 꺼내올때 : iterator() / get(index)
 */


public class ArrayListApp {

	public static void main(String[] args) {
		// 1. List 계열 컬렉션 객체 생성(Raw Type)
		List list = new ArrayList();
		
		// 1-1) 객체 저장: add() 계열
		/*
		 * boolean add(Object element):계속 추가되면서 index는 0부터 자동 부여
		 * boolean add(int index,Object element) : 계속 추가되면서 저장시 인덱스 위치 부여 가능 -> 인덱스 번호 재배치됨
		 */
		
		System.out.println(list.add("가나라")?"저장성공":"저장실패");
		list.add("나나라");
		list.add("다나라");
		//list.add(5,"라나라");	//Runtime Error, 3,4 인덱스도 없는데 5번으로 지정하려고 하면 오류
		list.add(3,"라나라");//인덱스 지정시 순차적으로 다음 인덱스 지정 / 기존에 존재하는 인덱스로 지정
		list.add(list.size(),"마나라");
		list.add(list.size(),"바나라");
		System.out.println("중복 저장전 객체 수 : "+list.size());
		
		// 1-2) ArrayList는 중복 저장 허용
		System.out.println(list.add("가나라")?"저장성공":"저장실패");
		System.out.println("중복 저장전 객체 수 : "+list.size());
		
		// 1-3) 출력
		System.out.println("-- 일반 for문 : get(index) --");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i)); 
			Object obj = list.get(i);
		}
		System.out.println("-- 반복기 --");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		System.out.println("-- 확장 for문 : get(index) --");
		for(Object obj:list) System.out.println(obj);
		
		// 1-4) 특정 위치의 인덱스에 저장된 객체를 대체 : set(int index, Object obj)
		//  - 특정 인덱스 위치에 새로운 객체가 저장되고 기존객체는 삭제됨
		// * add: 추가, set: 대체
		
		list.set(4, "MANARA(SET)");
		System.out.println("[MANARA(SET)로 대체 후");
		for(Object obj:list) System.out.println(obj);
		list.add(4, "MANARA(SET)");
		System.out.println("[MANARA(ADD)로 추가 후"); //뒤에 있던 인덱스는 한자리씩 늘어남
		for(Object obj:list) System.out.println(obj);
		
		// 1-5) 검색
		System.out.println(list.contains("다나라"));
		System.out.println(list.contains("아나라"));
		
		// 1-6) 삭제
		// 삭제 후 자동으로 인덱스 다시 부여됨
		
		
		Object obj = list.remove(1);
		System.out.println("삭제된 객체 : "+obj);
		System.out.println(list.remove("MASAN(ADD)"));
		System.out.println(list.remove(3));
		System.out.println("삭제 후");
		
		list.remove("가나라");
		
		for(Object obj1 :list) System.out.println(obj1);
		//중복 객체 삭제 시, 인덱스가 작은 것(빠른것)부터 삭제
		
		
		// 전체 삭제 : list.clear()
		// removeAll(Collection<?>(COllection<?> col) / void claer()
		
		
		// 객체의 인덱스 찾기 ㅣ int indexOf(Object)
		//	: 주소로 인덱스를 찾을 때 해당 주소가 없는 경우 -1반환
		System.out.println("다나라의 인덱스:"+list.indexOf("다나라"));
		
		// 2. 타입 파라미터 지정 : <Student>
		// 2-1) 컬렉션에 저장할 객체 생성
		List<Student> list2 = new ArrayList();
		Student stu1 = new Student("A",20,"2024학번");
		Student stu2 = new Student("B",20,"2020학번");
		Student stu3 = new Student("C",20,"2088학번");
		Student stu4 = new Student("D",20,"2017학번");
		
		
		// 2-2) 객체 저장
		list2.add(stu1);
		list2.add(stu2);
		list2.add(stu3);
		list2.add(stu4);
		list2.add(stu2);	//중복
		
		System.out.println("-- 중복 저장 후 --");
		for(Student s:list2)s.print();
		
		list2.remove(stu2);
		System.out.println("-- 중복 저장된 객체 삭제 후 --");
		for(Student s:list2)s.print();
		
		
		// 2-3) 출력
		System.out.println("일반 for문:get(index)");
		for(int i=0;i<list2.size();i++) {
			list2.get(i).print();
		}
		// 2-3) + 확장 포문
		for(Student s:list2)s.print();
		list2.remove(stu2);
		
		System.out.println("-- 반복기 --");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
			it2.next().print();
		}
		
		// 2-3) 삭제
		// 인덱스로 삭제하기
		System.out.println("삭제된 객체(학생)의 이름: "+list2.remove(2).name);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 학생의 이름 입력 : ");
		String name = sc.nextLine().trim();
		
		// 문제] 사용자로부터 이름을 입력받아 그 이름으로 검색해서 인덱스 위치(indexOf사용)를 알아내서 해당 인덱스로 그 객체를 삭제
		// 삭제된 객체의 정보(이름,나이,학번)를 출력
		
//		if(list2.contains(name)) {
//			int index = list2.indexOf(name);
//			System.out.printf("삭제된 학생 : %s, %s, %s",
//					//list2.remove(index).name, list2.remove(index).age, list2.remove(index).stdNumber);
//		}
//		else System.out.println("해당 이름의 학생이 없습니다.");
		
		// 정답 :
		for(Student s:list2) {
			if(name.equals(s.name)) {
				int index=list2.indexOf(s);
				list2.remove(index).print();
				break;
			}
		}

	}
}










