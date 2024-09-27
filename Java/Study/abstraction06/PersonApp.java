package abstraction06;

//클래스는 객체의 설계도다

/*	■ 1.클래스의 객체 생성
 * 	클래스명 인스턴스변수 = new 클래스명();	//클래스명() = 생성자
 * 	
 * 	//클래스 멤버 접근
 * 	인스턴스변수.멤버
 * 
 */

public class PersonApp {

	public static void main(String[] args) {
		// ● 1. Person타입의 인스턴스 변수 선언하기
		Person person1;
		
		person1 = new Person();
		
		System.out.println(person1);	//객체의 주소가 나옴
		person1.printPerson();	// 멤버변수는 초기화 하지 않으면 해당 자료형으로 초기화됨 : [null의 정보] 나이 : 1 몸무게 : 0.0
		// String은 참조형이기 때문에 null로 초기화됨

		// ● 2. 멤버 변수 초기화 하기
		person1.age=19;
		person1.name="이명헌";
		person1.weight=75;
		System.out.println("필드에 값 할당 후 :");
		System.out.println(person1.getPerson());
		
		// ● 3. 인스턴스 변수선언과 동시에 메모리 할당
		Person person2 = new Person();
		System.out.println(person2);
		System.out.println(person2.getPerson());
		
		person2.name="이밍힝";
		person2.weight=2.5;
		System.out.println("필드에 값 할당 후 :");
		System.out.println(person2.getPerson());
		
		person2 = new Person();	// 새로운 메모리 생성 → 이밍힝과 주소 다름 → heap 영역에 생긴 이밍힝은 참조가 끊김 → 가비지 컬렉터가 치워줌
								// C언어에서는 할당메모리 해제 필요가 있음
		System.out.println(person2);

	} // class main

} // class Person

/*	new연산자의 의미
 * 	- person클래스를 인스턴화 = 객체화 = 메모리를 heap영역에 생성
 */



