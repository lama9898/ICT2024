package console.academy;

public class Student extends Person {
	//field
	public String stNumber;	//student에서 확장한 멤버
	//생성자
	public Student(String name, int age, String strNumber) {
		super(name, age);
		this.stNumber = strNumber;
	}
	//method
	@Override
	public String get() {
		// TODO 학번 추가
		return String.format("%s, 학번: %s", super.get(),stNumber);
	}

	@Override
	public void print() {
		// TODO
		System.out.println(get());
	}
	

	
	
	
}
