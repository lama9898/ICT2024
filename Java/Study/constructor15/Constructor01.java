package constructor15;

// Constructor : 생성자

/*	: 객체가 생성될 때(인스턴스화) 최초로 실행되는 메소드를 의미
 * 	1. 생성자 특징
 * 		- 생성자 이름은 클래스명과 동일해야함
 * 		- 반환타입을 가져서는 안됨
 * 		- 생성자의 접근지정자로는 주로 public 속성 사용	(* SingleTone design pattern 의 경우 private)
 *  2. 생성자의 역할
 *  	- 멤버 변수 초기화
 *  	- 생성자를 정의하지 않았을 경우 컴파일러는 기본 생성자 제공해줌
 *  	- 인자 생성자를 하나라도 정의했다면, 그 때는 컴파일러가 default 생성자를 제공해주지 않는다.
 *  	- 생성자를 다양하게 오버로딩함으로써 다양한 초기값을 부여할 수 있음
 * 
 */

class Human{
	// 멤버변수 초기화용 메소드로 멤버변수 초기화
	String name;
	String lastJumin;
	
	// 멤버변수 초기화용 메소드
	void initialize(String name,String lastJumin) {
		this.name = name;
		this.lastJumin = lastJumin;
	}
	
	void print() {
		System.out.println(String.format("%s는 성별이 %s입니다",name,lastJumin.charAt(0)=='1'?"남성":"여성"));
	}
	
}

class Human2{
	String name;
	String lastJumin;
	
	// ◆ 기본 생성자 = default constructor
	public Human2() {
		name="Tomato";
		lastJumin="2222222";
		System.out.println("default constructor");
	}
	// ◆ 인자 생성자
	public Human2(String name) {
		this.name=name;
		this.lastJumin="2222222";
		System.out.println("with name constructor");
	}
	public Human2(String name,String lastJumin) {
		this.name=name;
		this.lastJumin=lastJumin;
		System.out.println("with name,IdNumber constructor");
	}
	void print() {
		System.out.println(String.format("%s는 성별이 %s입니다",name,lastJumin.charAt(0)=='1'?"남성":"여성"));
	}
	
	
}

public class Constructor01 {

	public static void main(String[] args) {
		// Human 객체화, 인스턴스화, 메모리 생성
		Human human = new Human();
//		human.print();	//nullPointerException
		human.initialize("Neil Newbon", "1111111");
		human.print();
		System.out.println("======== Constructor ========");
		Human2 human1 = new Human2();
		human1.print();
		Human2 human2 = new Human2("Karlac");
		human2.print();
		Human2 human3 = new Human2("Neil","1111111");
		human3.print();


	}

}
