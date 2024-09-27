package inheritance16;

// 클래스 상속:
/*	- 단일 상속만 지원
 * 	- Is a 관계 성립해야함
 * 	- extends 키워드 사용
 * 	- private 접근 지정자가 붙은 부모의 멤버는 상속은 받으나 접근 불가
 * 
 * 형식 :
 * 	접근지정자 [지정자] class 자식클래스 extends 부모클래스{
 * 
 * 	}
 * 
 */

public class Person extends Object{
	// 모든 클래스는 특정 클래스를 상속받지 않으면 Object를 자동으로 상속받는다.
	 
	public Person() {
		super();
		System.out.println("Person의 기본생성자");
	}

	//멤버 변수(필드)
	String name;
	int age;
	String addr;
	
	//멤버 메소드
	String getPerson() {
		return String.format("이름: %s\t 나이:%s\t 주소:%s", name,age,addr);
	}
	
	void printPerson() {
		System.out.println(getPerson());
	}

}
