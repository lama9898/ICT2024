package polymorphism14;

/*
다형성:
1]오버로딩-  같은 이름의 메소드를 한 클래스안에서
           여러개 정의 가능(양념-매개변수)
2]오버라이딩 - 상속관계에서 부모의 메소드를
            리모델링(외관은 그대로 안에만 변경)
3]Heterogenious(이질화)
	전제조건:두 클래스 사이에 상속관계가 존재해야 함
			 부모타입 부모타입의인스턴스변수
			 = new  자식타입의 메모리 할당
   예]
   부모타입의 인스턴스 변수에 자식타입의 메모리 할당해서
   그 주소를 저장
   Person person = new Student();
   혹은
   Person person = new Person();
   Student student = new Student();
   person= student;
	부모타입의 인스턴스 변수가 접근 할 수 있는 범위
	1]부모로터 상속받는 멤버
	2]자식에서 오버라이딩한 메소드가 우선 호출됨.
	※자식에서 새롭게 정의한 멤버(변수,메소드등)는
 	접근 불가.(오버로딩한 메소드도 포함)	
	※잇점:메소드의 매개변수를 부모타입으로 정의시
      모든 자식타입을 저장할 수 있음으로
      자식 클래스 수만큼 메소드를 오버로딩 할 필요 없다
      예]Object클래스의 객체.equals(Object)
 -Homogenious(동질화)
	같은 타입의 인스턴스 변수에 같은 타입의
	메모리 주소를 저장
	예]
	Student st = new Student();
*/
class Person{
	String name;
	void personMethod() {
		System.out.println("부모의 메소드:personMethod()");
	}
}////////////////
class Student extends Person{
	String stNumber;//자식에서 새롭게 확장한 변수
	void study() {
		System.out.println("자식에서 새롭게 확장한 메소드:study()");
	}
	@Override
	void personMethod() {
		System.out.println("자식에서 오버라이딩한 메소드:personMethod()");
	}
	void personMethod(int num) {
		System.out.println("자식에서 새롭게 확장한 메소드(오버로딩):personMethod(int)");
	}
}//////////////


public class HeteroGeneous {

	public static void main(String[] args) {
		// 동질화
		// : 인스턴스 변수로 모든 멤버 접근가능, 오버라이딩한 메소드 존재시 부모의 메소드가 아니라 오버라이딩한 메소드가 무조건 호출
		Student st = new Student();
		//멤버 변수류
		System.out.print(st.name);
		System.out.println(st.stNumber);
		//멤버 메소드류
		st.personMethod();	// 오버라이딩
		st.study();
		st.personMethod(10); // 오버로딩(자식에서 새롭게 추가한 멤버이다)
		
		// 이질화
		// : 자식에서 새롭게 정의한 멤버(변수,메소드)
		/*
		 * 부모타입의 인스턴스 변수로 접근 불가
		 * 부모타입의 인스턴스 변수를 자식타입으로 형변환하면 자식에서 새롭게 정의한 멤버 접근가능
		 * 동질화든 이질화든 오버라이딩한 메소드가 우선
		 */

		Person p=st;
		System.out.print(p.name);	//상속받은것
		//System.out.println(p.stNumber);	//부모에는 없음 -> 접근불가
		p.personMethod();	// 오버라이딩
		//p.study();	//부모에는 없음 -> 접근불가
		//p.personMethod(10); // 오버로딩(자식에서 새롭게 추가한 멤버이다) //부모에는 없음 -> 접근불가
		
		System.out.println(((Student)p).stNumber);
		((Student)p).personMethod(10);
		
		// 방법 2 : 자식타입의 인스턴스 변수에 담아서 그 변수로 접근
		Student s= (Student)p;
		System.out.println(s.stNumber);
		s.personMethod(10);
		s.personMethod(0);
		s.study();
		
		
	}	//main

}	//class






