package collection20;

// 다시 공부하기, 강사님 코드랑 비교

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import console.academy.Student;

// HashSet : Set(인터페이스)계열의 컬렉션 클래스
/*
 * - 중복 저장 불가, 순서 없이 저장
 * - 데이터 꺼내올때 : iterator()
 */



public class HashSetApp {
	public static void main(String[] args) {
		/*
		 * collection 클래스 : 'Generic Type' 에 속한다. 즉, 인스턴스화 할 때 타입 파라미터(<T> 또는 <E>)를 지정함
		 * 					예) HashSet<E> 형태
		 * 				* <E>를 지정하지 않은 타입을 'Raw Type' 이라고 한다.
		 */
		
		// 1. <T>타입 파라미터에 타입을 지정 안 한 경우 : 어느 타입의 객체여도 저장이 가능
		// 1-1) 컬렉션 생성
		// HashSet<String>	// String 객체만 저장가능
		HashSet set = new HashSet();	// Raw Type
		
		// 1-2) 컬렉션에 저장할 객체 생성
		String strObj1 = "Tomato";
		String strObj2 = new String("Astarion");
		java.sql.Date dateObj = new java.sql.Date(new Date().getTime());
		Integer intObj = 100;
		Student stuObj = new Student("가길동",20,"2024학번");
		
		// 1-3) 컬렉션에 객체 저장 : boolean add(Object)
		System.out.println(set.add(strObj1)?"저장성공":"저장실패");
		System.out.println(set.add(strObj2));
		System.out.println(set.add(dateObj));
		System.out.println(set.add(intObj));
		System.out.println(set.add(stuObj));
		
		// 1-4) 컬렉션에 저장된 객체수 얻기 : int size()
		System.out.println("중복 저장 전 저장된 객체 수 : "+set.size());
		
		// 1-5) 중복저장 - 에러는 안나지만 저장이 안됨. (add()메소드 false반환)
		System.out.println(set.add(strObj1)?"저장성공":"저장실패");
		System.out.println("중복 저장 전 저장된 객체 수 : "+set.size());
		
		
		System.out.println("반복기 사용");
		
		// 1-6)a.저장된 객체 꺼내오기 : 순서없이 저장됨(반복기를 통해서 꺼내오기)
		/*
		 * Iterator의 주요 추상 메소드
		 *  - 데이터가 순어 있게 저장된 자료구조 (List계열)나 순서 없이 저장된 자료구조 (Set계열)에서 데이터를 꺼내 올 때 사용하는 타입(인터페이스)
		 *  - 확장 for문 써도 상관없음
		 *   
		 */
		//iterator() 메소드로 Iterator타입의 인스턴스 얻기
		Iterator it = set.iterator();
		while(it.hasNext()) 	// hasNext()로 꺼내올 객체의 유무여부 판단
		{
			Object obj = it.next();
			if(obj instanceof String) System.out.println("String타입 "+ obj);
			else if(obj instanceof java.sql.Date) System.out.println("Date타입 "+obj);
			else if(obj instanceof Integer) System.out.println("Integer타입 "+obj);
			else if(obj instanceof Student) System.out.println("Student타입 "+((Student)obj).get());
		}	// 순서없이 출력
		
		// it.next();	//런타임 오류, 모든 객체를 꺼내온 후 next()호출 시 실행 오류발생. next()메소들 호출시마다 하나씩 꺼내옴.
		// 컬렉션에 꺼내올 남은 객체가 없는데 next()를 호출한다면 예외 발생
		
		/*  확장 for문
		 *  : 배열이나 컬렉션에 저장된 값(객체)을 꺼내올때 사용하는 for문의 확장형
		 *   for (자료형 객체담을변수 : 배열명이나 혹은 컬렉션명) {  }
		 */
		String[] mountains = {"불곡산","청계산","북한산","지리산"};
		for(String mountain:mountains) System.out.println(mountain);
		System.out.println("확장 for문 사용");
		for(Object obj:set) {
			if(obj instanceof String) System.out.println("String타입 "+ obj);
			else if(obj instanceof java.sql.Date) System.out.println("Date타입 "+obj);
			else if(obj instanceof Integer) System.out.println("Integer타입 "+obj);
			else if(obj instanceof Student) System.out.println("Student타입 "+((Student)obj).get());
		}
		
		// 1-7) 검색 : boolean contains(Object e)
		System.out.println(set.contains(strObj2)?"strObj2가 있다!!!!!!":"strObj2가 없다!!!!!!!!!!");
		System.out.println(set.contains(intObj));
		System.out.println(set.contains("Halsin")?"할신 있다!!!!":"할신 없다!!!!");
		
		// 1-8) 삭제 : boolean remove(Object e)
		System.out.println(set.remove(strObj1)?"삭제 성공":"삭제 실패");
		System.out.println(set.remove(strObj1)?"삭제 성공":"삭제 실패");
		System.out.println("삭제 후 저장된 객체 수 : "+set.size());
		
		// 1-9) 전체 삭제 : boolean removeAll(Collection c)
		// list,set 계열 모두 받을 수 잇음
		//set.removeAll(set);
		set.clear();
		System.out.println("삭제 후 저장된 객체 수 : "+set.size());
		System.out.println(set.isEmpty());
		
		// 2. <□> 타입 파라미터 사용 : 해당 타입만 저장가능
		// 컴파일 시 타입 체크 가능! "Type Safety"
		//HashSet<Student> set2 = new HashSet<Student>(); //E: element type
		// HashSet<Student> 제너릭 클래스, 제너릭 타입
		
		HashSet<Student> set2 = new HashSet<>();	// JDK 1.7부터 생성자의 타입 파라미터 생략가능
		// 2-1) 컬렉션에 저장할 객체 생성
		Student stu1 = new Student("A",20,"1990학번");
		Student stu2 = new Student("B",21,"1991학번");
		Student stu3 = new Student("C",22,"1992학번");
		Student stu4 = new Student("D",23,"1993학번");
		
		// 2-2) 객체 저장
		set2.add(stu1);
		set2.add(stu2);
		set2.add(stu3);
		set2.add(stu4);
		//set2.add(strObj2);
		//The method add(Student) in the type HashSet<Student> is not applicable for the arguments (String)
		//타입 파라미터에 지정한 타입만 저장 가능, 컴파일시 타입체크 됨
		
		// 2-3) 객체 꺼내오기
		System.out.println("[반복기 사용]");
		Iterator<Student> it2 = set2.iterator();
		while(it2.hasNext()) {
			/*
			System.out.println(String.format("이름: %s, 나이: %s, 학번: %s",
					it2.next().name, it2.next().age, it2.next().stNumber
					));//제너릭 타입 지정시 object->student, 형변환X
					*/
			// 한번꺼내올때 3개 꺼내오는데, 한번 꺼내와서 name만 쓰고, 또 꺼내와서 age만 쓰고, 또꺼내와서 stNumber만사용
			// next()메소드는 호출 할 때마다 객체를 무조건 하나씩 꺼내옴
			
			Student st = it2.next();
			/*
			System.out.println(String.format("이름: %s, 나이: %s, 학번: %s",
					st.name, st.age, st.stNumber
					));
					*/
			st.print();
		}
		
		System.out.println("[확장 for문 사용]");
		for(Student st :set2) st.print();
		
		// 2-4) 검색
		System.out.println(set2.contains(stu1));
		System.out.println(set2.contains(new Student(null,0,null)));
		
		// 2-5) 삭제
		//set2.remove(stu1);
		//System.out.println("삭제후 저장된 객체의 수 : "+set2.size());
		
		// 2-5')전체 삭제
		//set2.clear();
		//System.out.println("삭제후 저장된 객체의 수 : "+set2.size());
		
	
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름 입력 >>> ");
		String searchName = sc.nextLine().trim();
		
		// 문제1] 컬렉션 set2에 저장된 객체를 이름으로 검색하자. 있는 이름 검색, 없는 이름 검색
		// 있으면 해당 학생 정보 출력, 없으면 학생 없어요 출력
		boolean stExist = false;
		for(Student st:set2) {
			if(searchName.equals(st.name))	{ st.print(); stExist = true;}
		}
		if(!stExist) System.out.println(String.format("%s라는 이름의 학생이 없어요", searchName));

		/*
		 * boolean isExist = false;
		 * for(Student s:set2){
		 * 	if(searchName.equals(s.name)) {
		 * 		s.print();
		 * 		isExist = true;
		 * 		break;
		 * 	}
		 * }
		 * if(!isExist) System.out.println("해당 학생이 없어요");
		 */
		
	}

}
