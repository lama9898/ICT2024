package inheritance16;

//Student is a Person

public class Student extends Person{
	//멤버 변수
	// 이름, 나이, 주소 재사용 가능 - person 상속 받았으니깐!
	String stdNumber;	// 학번, student 클래스에서 새롭게 추가(확장)한 멤버변수(필드)
	
	//생성자
	// 기본생성자
	public Student() {
		//super();	// 주석처리해도 정상작동, 자식의 모든 생성자는 부모의 기본 생성자를 자동호출
		System.out.println("student 기본 생성자");
	}
	// 인자생성자
	public Student(String name,int age, String addr,String stdNumber) {
		//super();	// 부모의 인자생성자는 호출 필요!
		this.name=name;
		this.age=age;
		this.addr=addr;
		this.stdNumber = stdNumber;
		System.out.println("student 인자 생성자");
	}
	
	
	
	//멤버 메소드
	//person에서 정의한 메소드 재사용
	void study() {	//student 클래스에서 새롭게 추가(확장)한 메소드
		System.out.println(String.format("나이가 %s인 %s가 공부한다.", age,this.name));
	}


	String getStudent() {
		return String.format("%s, 학번:%s",getPerson(),stdNumber);
	}
	
	void printStudent() {
		System.out.println(getStudent());
	}
}
