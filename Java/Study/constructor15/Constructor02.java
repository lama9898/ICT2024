package constructor15;

public class Constructor02 {

	public static void main(String[] args) {
		// 기본 생성자로 객체 생성 - 생성자 오버로딩 전
		Person person1 = new Person();	// 현재 생성자 모두주석처리 -> Person()은 컴파일러가 제공
		person1.print();	// Person()만 주석처리하고, 인자생성자 주석해제 시 오류 발생! 
		// 기본 생성자로 객체 생성 - 인자 생성자 정의시 기본 생성자는 더 이상 제공X, Person() : Person() is undefined
		
		// 인자 생성자로 객체 생성
		Person person3 = new Person("Neil Newbon",40,"England");
		person3.print();

		// this() : 자신의 기본 생성자
	}

}
