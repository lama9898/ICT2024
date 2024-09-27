package abstraction06;

/*
 * 클래스명.java에 여러개의 class를 정의할 때는 main메소드가 있는 클래스에 public을 붙임
 * 그 외 클래스는 public 생략
 * ★ 원칙은 클래스명.java파일당 내가 정의한 클래스 하나만 선언
 */

// ■ 1. 학생 추상화
class Student{
	//fields
	Person person;
	Person another = new Person();	// 선언과 동시에 메모리 할당
	String stNumber;	// 학번
	
	
	//methods
	void study() {
		System.out.println(person.name+"가(이) 공부하는 중...");
	}
	
	void printStudent() {
		person.printPerson();
		System.out.println("학번: "+stNumber);
	}
	
}



public class StudentApp {

	public static void main(String[] args) {
		// ■ 2. Student 타입의 메모리 생성 = 객체화 = 인스턴스화
		Student student1 = new Student();
		System.out.println("student1 : " + student1);
		//student1.printStudent();		// java.lang.NullPointerException, "this.person" is null → person이 메모리 할당X
		System.out.println("student1.person : "+student1.person);
		
		// 2-1)a. 해결방법 1 Person타입의 메모리 생성해서 주소 대입
		student1.person = new Person();
		System.out.println("student1.person : "+student1.person);
		student1.printStudent();
		
		// 2-1)b.  초기화
		student1.stNumber = "2024학번";
		student1.person.age=20;
		student1.person.name="아스타리온";
		student1.person.weight=70.0;
		System.out.println("person이 참조하는 Person타입의 필드 값 할당 후 ");
		student1.printStudent();
		
		// 2-2)a. 해결방법 2 another의 주소값을 person에 대입
		student1.person = student1.another;	// 참조 끊김, 언젠가 가비지 콜렉터가 없앰
		student1.printStudent();
		student1.person.age=40;
		student1.person.name="할신";
		student1.person.weight=100;
		student1.printStudent();
		

	}	//main

}	//class
