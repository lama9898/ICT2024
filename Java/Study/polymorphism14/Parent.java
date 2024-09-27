package polymorphism14;

import java.util.Date;

/*
오버라이딩(Overriding)-재정의
상속시에 적용되는 개념 즉 부모로부터 상속 받은 메소드의 구현부를
재 정의해서 사용하는 것
    - 메소드명이 동일해야 한다.
    - 메소드의 매개변수 갯수, 데이터 타입 및 순서가 모두  같아야 한다.
    - 메소드의 반환타입도 같아야 한다.
    - 접근지정자는 부모와 같거나 부모보다 넓어야 한다

    - Exception의 경우 부모 클래스의 메소드와 동일하거나
      더 구체적인 Exception을
      발생시켜야 한다.
*/


public class Parent {
	String name;
	int age;
	
	public Parent() {}

	public Parent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private void eat() {
		System.out.println("부모님은 식사중");
	}
	
	String sleep(int age) {
		System.out.println("부모님은 수면중");
		return null;
	}
	protected int walk(Date date) {
		System.out.println("부모님은 산책중");
		return 0;
	}
	public void exercise() {
		System.out.println("부모님은 운동중");
	}
	
	static void staticMethod() {
		System.out.println("부모님의 정적 메소드");
	}
	
	String getParent() {
		return String.format("성함:%s, 연세:%s", name,age);
	}
	
	void printParent() {
		System.out.println(getParent());
	}
}
