package abstraction06;

public class Person {
	
	// ■ 1. 멤버 변수 정의
	// 사람이라는 객체가 갖고 있는 속성(성질/상태) : 멤버변수 혹은 field (has a 관계)
	public String name;
	int age = 1;	// 접근지정자 생략됨. 기본이 package, 선언과 동시에 초기화
	double weight;
	// 여러 타입의 데이터를 정의 가능
	
	// ■ 2. 멤버 메소드 정의
	// 사람이라는 객체가 가지고 있는 행동(행위) = 멤버 메소드
	void sleep() {
		System.out.println(name+"가(이) 자다.");
	}
	
	void eat() {
		System.out.printf("나이가 %d살인 %s가(이) 먹다.\n그래서 몸무게가 %.2fKG이다.\n",age,name,weight);
	}
	
	String getPerson() {
		return "["+name+"의 정보]\r\n나이 : "+age+"\r\n몸무게 : "+weight;
	}
	
	void printPerson() {
		System.out.println(getPerson());
	}
	
	
	
	
	
	
}	// class Person
