package inheritance16;

//Teacher is a Person

public class Teacher extends Person{
	//멤버 변수
	// 이름, 나이, 주소 재사용 가능 - person 상속 받았으니깐!
	String subject;	//과목 선생 클래스에서 새롭게 추가(확장)한 멤버변수(필드)
	
	//생성자
	// 인자생성자
	public Teacher(String name,int age, String addr,String subject) {
		super();
		this.name=name;
		this.age=age;
		this.addr=addr;
		this.subject = subject;
		System.out.println("teacher의 인자 생성자");
	}
	
	
	
	//멤버 메소드
	//person에서 정의한 메소드 재사용
	void teach() {	//student 클래스에서 새롭게 추가(확장)한 메소드
		System.out.println(String.format("%s선생님이 %s과목을 가르친다.", this.name,this.subject));
	}


	String getTeacher() {
		return String.format("%s, 과목:%s",getPerson(),subject);
	}
	
	void printTeacher() {
		System.out.println(getTeacher());
	}
	

}
