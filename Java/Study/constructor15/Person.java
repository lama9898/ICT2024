package constructor15;

// 생성자
/* 	기본 생성자
 * 	형식 :
 * 	public 클래스명(){
 * 		super();
 *  }
 *  - 반환타입 없음, 멤버변수 초기화에 사용
 *  - 기본 생성자 정의하지 않으면 컴파일러가 자동으로 제공
 */

public class Person {	// private Person() : 다른 클래스에서 인스턴스화 불가하도록 막음

	//field
	String name;
	int age;
	String address;
	
	//기본 생성자
	public Person() {
		//Constructor 3 : this();	// this()는 생성자 내 첫번째 문장이 되어야함, 기본 생성자에서 하면 recursive constructor 호출(재귀호출)
		this("고구마",2,"땅"); // Constructor 3 : 멤버변수 초기화 됨
//		name = "미상";
//		age = 1;
//		address = "부모님 주소";
		System.out.println("기본 생성자");
	}
	//인자 생성자	: 매개변수가 있는 생성자
	//인자 생성자를 정의하면 기본 생성자 자동생성X
//	
	public Person(String name) {
		// this(name);
		this.name =name;
		this.age = 1;
		this.address = "부모님 주소";
		System.out.println("인자 생성자:name");
	}
	
	public Person(String name,int age) {
		//this(name,age);
		this.name =name;
		this.age = age;
		this.address = "부모님 주소";
		System.out.println("인자 생성자:name,int");
	}
	
	public Person(String name,int age, String addr) {
		//this(name,age,addr);
		this.name =name;
		this.age = age;
		this.address = addr;
		System.out.println("인자 생성자:name,age,addr");
	}
	
	void print() {
		System.out.println(String.format("[%s님의 정보]\n나이: %s\n사는 곳: %s", name,age,address));
	}
	
	
}
