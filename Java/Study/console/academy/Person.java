package console.academy;

import java.io.Serializable;

public class Person implements Serializable{

	//field
	public String name;
	public int age;
	
	//생성자
	public Person(){	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//method
	String get() {
		return String.format("이름: %s, 나이: %s", name,age);
	}
	
	void print() {
		System.out.println(get());
	}
	
}
