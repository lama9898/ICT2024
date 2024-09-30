package innerclass22;

// zzZ

/*
	익명 클래스]
	-이름이 없는 클래스
	-GUI프로그래밍 시 주로 사용(이벤트 처리하기 위해서)
	-부모 클래스의 메소드를 오버라이딩하는 것이 주된 용도
	-메소드 안에 정의된 클래스
	-이름이 없어서 부모클래스의 생성자를 빌려서 인스턴스화 한다
	-외부클래스명$1.class,외부클래스명$2.class 등..즉 클래스명이 없기때문에 만들어진 순서대로
	 인덱스가 부여되서
	 내부클래스명이 된다
	 형식]
	 부모클래스명 인스턴스변수 = new 부모클래스명(){
	
	 };//반드시 ;을 붙여라
*/

class Person{
	private String name;

	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름: "+name;
	}
}	// class Person

// 이름(클래스명)이 있는 자식 클래스
class Student extends Person{
	String stNumber;
	
	public Student(String name,String stNumber) {
		super(name);
		this.stNumber =stNumber;
	}
	
	String get() {
		return String.format("%s, 학번: %s",super.toString(),stNumber);
	}
	
	@Override
	public String toString() {
		return get();
	}
	
}	// class Student



// 추상 클래스
abstract class AbstractClass{
	abstract void abstractMethod();
}	// abstract class AbstractClass



// 인터 페이스
interface MyInterface{
	void abstractMethod();
}	// interface MyInterface


public class InnerAnonymousClass {

	public static void main(String[] args) {
		// 이름이 있는 자식클래스(Student)의 일반적인 이질화 형태
		Person person = new Student("고길동","1980학번");
		System.out.println(person);
		
		// 자식에서 새롭게 확장한 멤버 접근은 형변환(다운캐스팅)을 통해 접근
		Student student = (Student)person;
		System.out.println(student.stNumber);
		
		System.out.println(student.get());
		
		//								 ↓ {} : 익명 클래스, Person을 상속받음
		Person anony = new Person("둘리") {		// 목적 : 부모클래스 오버라이딩, { : 익명클라스 시작
		// = Person anony = new ? extends Person("둘리"){};
		// 익명클래스 시작
			//field
			int newVar; // 익명클래스에서 새롭게 확장한 멤버
			void newMethod() {
				System.out.println("익명 클래스에서 새롭게 확장한 메소드");
			}
			@Override
				public String toString() {
					return super.toString()+",newVar: "+newVar;
				}
		}; // 익명 클래스 끝, {}은 Person을 상속받은 익명클래스
		
		System.out.println(anony.getClass().getName());	//innerClass 2. InnerAnonymousClass$1
		//System.out.println(anony);	//불가
		
		// 자식에서 새롭게 정의한 멤버접근
		/*
		 * 
		 */
		
		
		System.out.println(anony);
		// 추상 클래스를 상속받은 익명 클래스
		AbstractClass ac = new AbstractClass() {

			@Override
			void abstractMethod() {
				System.out.println("추상 메서드 오버라이등 : 추상 클래스");
				
			}
			
		};
		ac.abstractMethod();
		
		//인터페이스를 상속받은 익명 클래스
		MyInterface mi = new MyInterface() {

			@Override
			public void abstractMethod() {
				System.out.println("추상 메소드 오버라이딩:인터페이스");
				
			}
			
		};
		mi.abstractMethod();
		
		
		
		
		
	}	// main, } : 익맹클래스 끝

}	// class
